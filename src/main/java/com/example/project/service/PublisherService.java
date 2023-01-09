package com.example.project.service;

import com.example.project.dto.DomainDto;
import com.example.project.dto.PublisherDto;
import com.example.project.entity.DomainEntity;
import com.example.project.entity.PublisherEntity;
import com.example.project.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public PublisherEntity addPublisher(PublisherEntity publisher){
        return publisherRepository.save(publisher);
    }

    public List<PublisherEntity> findAll() {
        return this.publisherRepository.findAll();
    }

    public PublisherEntity findPublisherByName(String name) {
        for (PublisherEntity p : publisherRepository.findAll()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    public PublisherDto convertPublisherToDTO(PublisherEntity publisherEntity) {
        return PublisherDto.builder()
                .name(publisherEntity.getName())
                .build();
    }
    public List<PublisherDto> convertEntityListToDTOList(List<PublisherEntity> publishers) {
        List<PublisherDto> publishersList = new ArrayList<>();
        if (publishers != null) {
            publishers.forEach(domainEntity -> publishersList.add(convertPublisherToDTO(domainEntity)));
        }
        return publishersList;
    }
}
