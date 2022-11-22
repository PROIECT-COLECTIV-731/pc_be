package com.example.project.repository;

import com.example.project.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity, String> {
    @Override
    List<PublisherEntity> findAll();

    List<PublisherEntity> findPublisherEntityByName(String name);

    PublisherEntity findPublisherEntitiesById(int id);
}
