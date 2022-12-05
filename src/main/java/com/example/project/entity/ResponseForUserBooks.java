package com.example.project.entity;

import com.example.project.dto.BookDTO;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseForUserBooks {
    private List<BookDTO>userBooks;
    private List<String> expiredBookTitles;
    private String message;
}
