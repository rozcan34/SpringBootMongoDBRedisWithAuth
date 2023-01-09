package com.mwp.sbmdbr.controllers;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(TestController.class);

    @GetMapping
    public void logTestMessage() {
        log.info("This is a test log");
    }
}
