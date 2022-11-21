package com.example.project.service;

import com.example.project.entity.DomainEntity;
import com.example.project.entity.PublisherEntity;
import com.example.project.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public PublisherEntity addPublisher(PublisherEntity publisher){
        return publisherRepository.save(publisher);
    }

    public PublisherEntity findPublisherByName(String name) {
        for (PublisherEntity p : publisherRepository.findAll()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
