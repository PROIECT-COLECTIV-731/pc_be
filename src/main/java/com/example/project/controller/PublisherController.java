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
    public ResponseEntity addPublisher(@RequestBody PublisherEntity publisher){
        if(publisherService.findPublisherByName(publisher.getName()) != null){
            return ResponseEntity.badRequest().body("Error! Publisher with name " + publisher.getName() + " already exists!");
        }
        return ResponseEntity.ok(this.publisherService.addPublisher(publisher));
    }
}
