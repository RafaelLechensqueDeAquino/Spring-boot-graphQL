package com.lechensque.graphql.demo.service;

import java.util.List;

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

    public Book showBookById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public Book updateBook(Long id, BookRecordDto bookRequest) {
        Book bookFind = bookRepository.findById(id).orElseThrow();

        if (bookRequest.title() != null) {
            bookFind.setTitle(bookRequest.title());
        }

        if (bookRequest.author() != null) {
            bookFind.setAuthor(bookRequest.author());
        }

        return bookRepository.save(bookFind);
    }

    public void deleteBook(Long id){
        Book bookFind = bookRepository.findById(id).orElseThrow();

        bookRepository.delete(bookFind);
    }

    public Book createBook(BookRecordDto bookRequest){
        var bookModel = new Book();

        BeanUtils.copyProperties(bookRequest, bookModel);
        
        return bookRepository.save(bookModel);

        
    }
}
