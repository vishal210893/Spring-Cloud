package com.solum.spring.cloud.photoappaccountmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private Environment env;

    @Autowired
    private ServletWebServerApplicationContext server;

    private final LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

    @GetMapping("/status")
    public String status() {
        return env.getProperty("spring.application.name") + " started at " + localDateTime + " running at port = " + server.getWebServer().getPort();

    }

}
