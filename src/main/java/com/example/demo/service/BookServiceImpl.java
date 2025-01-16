package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookId(long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Override
    public Book updateBook(Book book, long id) {
       Book existingBook = bookRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Not Found"));
       existingBook.setTitle(book.getTitle());
       existingBook.setAuthor(book.getAuthor());
       existingBook.setPublisher(book.getPublisher());
       existingBook.setGenre(book.getGenre());
       existingBook.setPages(book.getPages());
       bookRepository.save(existingBook);
       return existingBook;
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        bookRepository.deleteById(id);
    }

}
