package com.example.project.controller;

import com.example.project.entity.DomainEntity;
import com.example.project.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    private DomainService domainService;

    @PostMapping("/add")
    public ResponseEntity<DomainEntity> addDomain(@RequestBody DomainEntity domain){
        return ResponseEntity.ok(this.domainService.addDomain(domain));
    }
}
