package com.example.project.service;

import com.example.project.entity.DomainEntity;
import com.example.project.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainService {
    @Autowired
    private DomainRepository domainRepository;

    public DomainEntity addDomain(DomainEntity domain){
        return this.domainRepository.save(domain);
    }
}
