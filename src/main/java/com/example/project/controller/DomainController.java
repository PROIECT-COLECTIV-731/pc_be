package com.example.project.controller;

import com.example.project.dto.BookDTO;
import com.example.project.dto.DomainDto;
import com.example.project.entity.DomainEntity;
import com.example.project.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    private DomainService domainService;

    @PostMapping("/add")
    public ResponseEntity addDomain(@RequestBody DomainEntity domain) {
        if (domainService.findDomainByName(domain.getName()) != null)
            return ResponseEntity.badRequest().body("Error! Domain with name " + domain.getName() + " already exists!");
        return ResponseEntity.ok(this.domainService.addDomain(domain));
    }
    @GetMapping("/domains")
    public ResponseEntity<List<DomainDto>> getAllDomains() {
        return ResponseEntity.ok(this.domainService.convertEntityListToDTOList(this.domainService.findAll()));
    }
}
