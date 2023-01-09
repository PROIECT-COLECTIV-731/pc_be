package com.example.project.service;

import com.example.project.dto.BookDTO;
import com.example.project.dto.DomainDto;
import com.example.project.entity.BookEntity;
import com.example.project.entity.DomainEntity;
import com.example.project.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DomainService {
    @Autowired
    private DomainRepository domainRepository;

    public DomainEntity addDomain(DomainEntity domain) {
        return this.domainRepository.save(domain);
    }
    public List<DomainEntity> findAll() {
        return this.domainRepository.findAll();
    }

    public DomainEntity findDomainByName(String name) {
        for (DomainEntity d : domainRepository.findAll()) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        return null;
    }


    public DomainDto convertDomainToDTO(DomainEntity domainEntity) {
        return DomainDto.builder().name(domainEntity.getName()).build();
    }
    public List<DomainDto> convertEntityListToDTOList(List<DomainEntity> domains) {
        List<DomainDto> domainsList = new ArrayList<>();
        if (domains != null) {
            domains.forEach(domainEntity -> domainsList.add(convertDomainToDTO(domainEntity)));
        }
        return domainsList;
    }
}
