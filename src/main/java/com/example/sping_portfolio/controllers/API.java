package com.example.sping_portfolio.controllers;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.io.IOException;

@Controller
public class API {
    @GetMapping("/api")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String api(Model model) throws IOException, InterruptedException, ParseException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://twitterfetch.p.rapidapi.com/hashtag/Krispykreme"))
                .header("x-rapidapi-host", "twitterfetch.p.rapidapi.com")
                .header("x-rapidapi-key", "845637a39cmshcd1cb3388e6f02ap15ffd5jsne437b834d421")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        Object object = new JSONParser().parse(response.body());
        JSONArray tweets = (JSONArray) object;

        model.addAttribute("tweets", tweets);



        return "api";
    }
}
