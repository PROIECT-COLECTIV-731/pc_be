package com.example.project.repository;

import com.example.project.entity.CategoryEntity;
import com.example.project.entity.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRepository extends JpaRepository<DomainEntity, Long> {
    @Query("SELECT d FROM DomainEntity d WHERE d.name =?1")
    DomainEntity findByName(String name);
}
