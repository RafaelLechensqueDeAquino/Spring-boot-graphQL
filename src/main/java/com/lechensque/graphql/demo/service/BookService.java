package com.lechensque.graphql.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lechensque.graphql.demo.dtos.BookRecordDto;
import com.lechensque.graphql.demo.entity.Book;
import com.lechensque.graphql.demo.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> listBook() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBook(Long id) {
        return bookRepository.findById(id);
    }

    public Book updateBook(Long id, BookRecordDto bookRequest) {
        Book bookFind = bookRepository.findById(id).orElseThrow();

        if (bookRequest.title() != null) {
            bookFind.setTitle(bookRequest.title());
        }
        if (bookRequest.subString() != null) {
            bookFind.setTitle(bookRequest.subString());
        }

       

        return bookRepository.save(bookFind);
    }

    public void deleteBook(Long id){
        Book bookFind = bookRepository.findById(id).orElseThrow();

        bookRepository.delete(bookFind);
    }

    public Book createBook(Book book){
        
        
        return bookRepository.save(book);

        
    }
}
