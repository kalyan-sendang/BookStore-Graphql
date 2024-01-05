package com.tests.graphql.controller;

import com.tests.graphql.model.Book;
import com.tests.graphql.model.BookDto;
import com.tests.graphql.service.BookService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping("getAllBook")
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }

    @QueryMapping("getABook")
    public Book getABook(@Argument Integer bookId) {
        if(bookService.getABook(bookId) != null){
            return bookService.getABook(bookId);
        }else{
            throw new RuntimeException("Error");
        }

    }

    @MutationMapping("addBook")
    public Book addBook(@Argument BookDto book) {
        return bookService.insertBook(book);
    }

}
