package com.example.project.repository;

import com.example.project.entity.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomainRepository extends JpaRepository<DomainEntity, String> {
    @Override
    List<DomainEntity> findAll();

    List<DomainEntity> findDomainEntityByName(String name);

    DomainEntity findDomainEntitiesById(int id);
}
