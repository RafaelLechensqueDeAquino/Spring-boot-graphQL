package com.lechensque.graphql.demo.graphql;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.lechensque.graphql.demo.entity.Book;
import com.lechensque.graphql.demo.service.BookService;

@Controller
public class BookGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {
    @Autowired
    private BookService bookService;
 
    @QueryMapping
    public Optional<Book> findBook(@Argument Long id){
        return bookService.findBook(id);
    }

    @MutationMapping
    public Book createBook(@Argument Book book) {
        return bookService.createBook(book);
        
    }
}
