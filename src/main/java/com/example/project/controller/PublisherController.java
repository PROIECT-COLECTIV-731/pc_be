package com.example.project.controller;

import com.example.project.dto.DomainDto;
import com.example.project.dto.PublisherDto;
import com.example.project.entity.PublisherEntity;
import com.example.project.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
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
    @GetMapping("/publishers")
    public ResponseEntity<List<PublisherDto>> getAllPublishers() {
        return ResponseEntity.ok(this.publisherService.convertEntityListToDTOList(this.publisherService.findAll()));
    }
}
