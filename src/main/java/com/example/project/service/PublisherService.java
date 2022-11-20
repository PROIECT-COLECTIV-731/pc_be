package com.example.project.service;

import com.example.project.entity.DomainEntity;
import com.example.project.entity.PublisherEntity;
import com.example.project.repository.DomainRepository;
import com.example.project.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public PublisherEntity addPublisher(PublisherEntity publisher){
        return publisherRepository.save(publisher);
    }
}
