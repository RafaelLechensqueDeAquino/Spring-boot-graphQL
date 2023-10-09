package com.lechensque.graphql.demo.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import com.lechensque.graphql.demo.entity.Book;
import com.lechensque.graphql.demo.service.BookService;

@Component
public class BookGraphQL {
    @Autowired
    private BookService bookService;

    @QueryMapping
    public Book findBook(Long id){
        return bookService.showBookById(id);
    }
}
