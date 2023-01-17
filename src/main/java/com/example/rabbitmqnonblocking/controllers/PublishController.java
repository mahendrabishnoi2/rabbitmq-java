package com.example.rabbitmqnonblocking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmqnonblocking.services.PublishService;

@RestController
public class PublishController {

    private final PublishService publishService;

    @Autowired
    public PublishController(PublishService publishService) {
        this.publishService = publishService;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish() {
        this.publishService.publish();
        return ResponseEntity.ok().body("ok");
    }
}
