package com.example.project.repository;

import com.example.project.entity.CategoryEntity;
import com.example.project.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {
    @Query("SELECT p FROM PublisherEntity p WHERE p.name =?1")
    PublisherEntity findByName(String name);
}
