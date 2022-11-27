package com.example.project.repository;

import com.example.project.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<AdminEntity, String>
{
    @Override
    List<AdminEntity> findAll();

    AdminEntity findByEmailAndPassword(String email, String password);

    AdminEntity save(AdminEntity u);

}
