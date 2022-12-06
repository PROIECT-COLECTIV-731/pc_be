package com.example.project.repository;


import com.example.project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Override
    List<UserEntity> findAll();

    UserEntity findByEmailAndPassword(String email, String password);

    UserEntity findByEmail(String email);
}
