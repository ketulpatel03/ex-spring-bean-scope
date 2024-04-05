package com.java.controller;

import com.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<String>> welcomeMsg() throws InterruptedException {

        String weatherDetails1 = userService.getWeatherDetails();
        Thread.sleep(2000);
        String weatherDetails2 = userService.getWeatherDetails();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Arrays.asList(weatherDetails1, weatherDetails2));
    }

}
