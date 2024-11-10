package com.runtally.runtally.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerVitalsController {

    @GetMapping("/")
    public String serverStatus() {
        return "Running";
    }
}
