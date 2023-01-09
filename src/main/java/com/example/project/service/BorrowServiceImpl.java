package com.example.project.service;

import com.example.project.entity.BookEntity;
import com.example.project.entity.BorrowEntity;
import com.example.project.entity.UserEntity;
import com.example.project.repository.BookRepository;
import com.example.project.repository.BorrowRepository;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService{

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BorrowEntity> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public void borrowBook(long bookId, long userId) {
        BookEntity book = bookRepository.findById(bookId).get();
        UserEntity user = userRepository.findById(userId);
        LocalDate currentDate = LocalDate.now();
        BorrowEntity borrowEntity1 = new BorrowEntity(book, user, "borrowed", currentDate, currentDate.plusMonths(1));
        borrowRepository.save(borrowEntity1);

    }

}
