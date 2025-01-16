package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book-info")
public class Book {
    @Id
    private Integer isbn;
    private String title;
    private String author;
    private String publisher;
    private Integer pages;
    @Enumerated(EnumType.STRING)
    private Genre genre;

}
