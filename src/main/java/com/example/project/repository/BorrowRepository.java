package com.example.project.repository;

import com.example.project.entity.BorrowEntity;
import com.example.project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BorrowRepository extends JpaRepository<BorrowEntity, String>{

    @Override
    List<BorrowEntity> findAll();
}

