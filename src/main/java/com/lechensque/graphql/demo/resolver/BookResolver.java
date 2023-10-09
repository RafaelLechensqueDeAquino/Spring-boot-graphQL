package com.lechensque.graphql.demo.resolver;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lechensque.graphql.demo.entity.Author;
import com.lechensque.graphql.demo.entity.Book;
import com.lechensque.graphql.demo.repository.AuthorRepository;
import com.lechensque.graphql.demo.repository.BookRepository;

import graphql.schema.GraphQLFieldDefinition;
import graphql.servlet.GraphQLMutationProvider;
import graphql.servlet.GraphQLQueryProvider;

@Component
public class BookResolver implements GraphQLQueryProvider, GraphQLMutationProvider {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Book addBook(String title, Long authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author == null) {
            throw new IllegalArgumentException("Invalid author ID");
        }

        Book book = new Book();
        book.setTitle(title);
        // book.setAuthor(author);

        return bookRepository.save(book);
    }

    public boolean deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid book ID");
        }

        bookRepository.deleteById(id);
        return true;
    }

    @Override
    public Collection<GraphQLFieldDefinition> getMutations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMutations'");
    }

    @Override
    public Collection<GraphQLFieldDefinition> getQueries() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQueries'");
    }
}

