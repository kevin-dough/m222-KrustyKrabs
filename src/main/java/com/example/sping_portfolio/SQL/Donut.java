package com.example.sping_portfolio.SQL;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/*
Donut is a POJO, Plain Old Java Object.
First set of annotations add functionality to POJO
--- @Setter @Getter @ToString @NoArgsConstructor @RequiredArgsConstructor
The last annotation connect to database
--- @Entity
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name="donuts")
public class Donut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min=2, message = "What kind of donut?")
    private String donuttype;

    /*
    @NonNull: Places this in @RequiredArgsConstructor
    @Size(min=2, max=30): Allows names between 2 and 30 characters long.
     */
    @NotEmpty
    @Size(min = 2, max = 30, message = "Donut place (Required)!")
    private String place;

    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private Date date;

    @NotNull
    @Size(message = "Rate from 1 to 5!")
    private String rating;

    @NotEmpty
    @Size(max = 500, message = "Limit is 500 words!")
    private String comment;

    /* Initializer used when setting data from an API */
    public Donut(String donut, String place, Date date, String ratingInput, String comment) {
        this.donuttype = donut;
        this.place = place;
        this.date = date;
        this.rating = ratingInput;
        this.comment = comment;
    }

}