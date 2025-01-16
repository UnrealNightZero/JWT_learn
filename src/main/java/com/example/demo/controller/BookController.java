package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.BookRepository;
import com.example.demo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }
    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") long id) {
        return new ResponseEntity<Book>(bookService.getBookId(id), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.updateBook(book, id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
    }
}
