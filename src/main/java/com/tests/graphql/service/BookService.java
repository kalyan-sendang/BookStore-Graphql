package com.tests.graphql.service;

import com.tests.graphql.model.Book;
import com.tests.graphql.model.BookDto;
import com.tests.graphql.repository.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBook(){
        return bookRepo.findAll();
    }

    public Book getABook(Integer id) {
        Optional<Book> book = bookRepo.findById(id);
        return book.orElse(null);
    }

    public Book insertBook(BookDto bookDto){
        Book book = new Book(bookDto);
        return bookRepo.save(book);
    }
}
