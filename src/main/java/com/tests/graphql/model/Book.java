package com.tests.graphql.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String desc;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private Double price;

    @Column(name = "pages")
    private Integer pages;

    public Book(BookDto bookDto){
        this.title = bookDto.getTitle();
        this.desc = bookDto.getDesc();
        this.author = bookDto.getAuthor();
        this.price = bookDto.getPrice();
        this.pages = bookDto.getPages();
    }

}
