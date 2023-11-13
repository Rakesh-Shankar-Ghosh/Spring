package dev.rakesh.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import dev.rakesh.test.service.AppService;

public class Servicecontroller {
    

private final AppService appService;

    @Autowired
    public Servicecontroller(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/")
    public String checkDatabaseConnection() {
        boolean isConnected = appService.isDatabaseConnected();
        if (isConnected) {
            return "Database is connected!";
        } else {
            return "Database is not connected.";
        }
    }
}
