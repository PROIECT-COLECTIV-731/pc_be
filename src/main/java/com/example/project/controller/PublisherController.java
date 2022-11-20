package com.example.project.controller;

import com.example.project.entity.PublisherEntity;
import com.example.project.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/add")
    public ResponseEntity<PublisherEntity> addPublisher(@RequestBody PublisherEntity publisher){
        return ResponseEntity.ok(this.publisherService.addPublisher(publisher));
    }
}
