package com.example.project.service;

import com.example.project.entity.DomainEntity;
import com.example.project.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DomainService {
    @Autowired
    private DomainRepository domainRepository;

    public DomainEntity addDomain(DomainEntity domain) {
        return this.domainRepository.save(domain);
    }

    public DomainEntity findDomainByName(String name) {
        for (DomainEntity d : domainRepository.findAll()) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }
}
