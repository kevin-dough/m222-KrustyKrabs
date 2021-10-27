package com.example.sping_portfolio.SQL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// Built using article: https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html
// or similar: https://asbnotebook.com/2020/04/11/spring-boot-thymeleaf-form-validation-example/
@Controller
public class DonutSqlMvcController implements WebMvcConfigurer {

    // Autowired enables Control to connect HTML and POJO Object to Database easily for CRUD
    @Autowired
    private DonutSqlRepository repository;

    @GetMapping("/sql/donut")
    public String donut(Model model) {
        List<Donut> list = repository.listAll();
        model.addAttribute("list", list);
        return "sql/donut";
    }

    /*  The HTML template Forms and donutForm attributes are bound
        @return - template for donut form
        @param - donut Class
    */
    @GetMapping("/sql/donutcreate")
    public String donutAdd(Donut donut) {
        return "sql/donutcreate";
    }

    /* Gathers the attributes filled out in the form, tests for and retrieves validation error
    @param - donut object with @Valid
    @param - BindingResult object
     */
    @PostMapping("/sql/donutcreate")
    public String donutSave(@Valid Donut donut, BindingResult bindingResult) {
        // Validation of Decorated donutForm attributes
        if (bindingResult.hasErrors()) {
            return "sql/donutcreate";
        }
        repository.save(donut);
        // Redirect to next step
        return "redirect:/sql/donut";
    }

    @GetMapping("/sql/donutupdate/{id}")
    public String donutUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("donut", repository.get(id));
        return "sql/donutupdate";
    }

    @PostMapping("/sql/donutupdate")
    public String donutUpdateSave(@Valid Donut donut, BindingResult bindingResult) {
        // Validation of Decorated donutForm attributes
        if (bindingResult.hasErrors()) {
            return "sql/donutupdate";
        }
        repository.save(donut);
        // Redirect to next step
        return "redirect:/sql/donut";
    }

    @GetMapping("/sql/donutdelete/{id}")
    public String donutDelete(@PathVariable("id") long id) {
        repository.delete(id);
        return "redirect:/sql/donut";
    }

    /*
    #### RESTful API section ####
    Resource: https://spring.io/guides/gs/rest-service/
    */

    /*
    GET List of People
     */
    @RequestMapping(value = "/sql/people/get")
    public ResponseEntity<List<Donut>> getPeople() {
        return new ResponseEntity<>( repository.listAll(), HttpStatus.OK);
    }

    /*
    GET individual donut using ID
     */
    @RequestMapping(value = "/sql/donut/get/{id}")
    public ResponseEntity<Donut> getdonut(@PathVariable long id) {
        return new ResponseEntity<>( repository.get(id), HttpStatus.OK);
    }

    /*
    DELETE individual donut using ID
     */
    @RequestMapping(value = "/sql/donut/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletedonut(@PathVariable long id) {
        repository.delete(id);
        return new ResponseEntity<>( ""+ id +" deleted", HttpStatus.OK);
    }


    /*
    POST Aa record by Requesting Parameters from URI
     */
    @RequestMapping(value = "/sql/donut/post", method = RequestMethod.POST)
    public ResponseEntity<Object> postdonut(@RequestParam("email") String email,
                                             @RequestParam("name") String name,
                                             @RequestParam("dob") String dobString) {
        Date dob;
        try {
            dob = new SimpleDateFormat("MM-dd-yyyy").parse(dobString);
        } catch (Exception e) {
            return new ResponseEntity<>(dobString +" error; try MM-dd-yyyy", HttpStatus.BAD_REQUEST);
        }
        // A donut object WITHOUT ID will create a new record
        Donut donut = new Donut(email, name, dob);
        repository.save(donut);
        return new ResponseEntity<>(email +" is created successfully", HttpStatus.CREATED);
    }

}