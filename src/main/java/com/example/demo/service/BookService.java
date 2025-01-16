package com.example.demo.service;


import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book addBook(Book book);
    List<Book> getAllBook();
    Book getBookId(long id);
    Book updateBook(Book book, long id);
    void deleteBook(long id);
}
