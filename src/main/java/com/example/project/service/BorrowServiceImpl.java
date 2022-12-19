package com.example.project.service;

import com.example.project.entity.BookEntity;
import com.example.project.entity.BorrowEntity;
import com.example.project.entity.UserEntity;
import com.example.project.repository.BorrowRepository;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService{

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BorrowEntity> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public void borrowBook(long book, long userId) {
        BookEntity book1 = new BookEntity();
        UserEntity user = userRepository.findById(userId);
        LocalDate currentDate = LocalDate.now();
        BorrowEntity borrowEntity1 = new BorrowEntity(book1, user, "borrowed", currentDate, currentDate.plusMonths(1));
        borrowRepository.save(borrowEntity1);
    }

}
