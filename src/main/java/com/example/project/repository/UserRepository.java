package com.example.project.repository;

import com.example.project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String>
{
    @Override
    List<UserEntity> findAll();

    UserEntity findByEmailAndPassword(String email, String password);

    UserEntity save(UserEntity u);

}
