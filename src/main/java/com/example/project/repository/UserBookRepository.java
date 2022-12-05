package com.example.project.repository;

import com.example.project.entity.BookEntity;
import com.example.project.entity.UserBookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookRepository extends CrudRepository<UserBookEntity,Long> {


}
