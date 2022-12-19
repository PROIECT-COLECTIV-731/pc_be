
package com.example.project.service;

import com.example.project.entity.BorrowEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BorrowService {
    List<BorrowEntity> findAll();

    void borrowBook(long book, long user);

}
