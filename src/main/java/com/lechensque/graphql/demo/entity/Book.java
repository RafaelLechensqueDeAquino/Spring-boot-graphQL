package com.lechensque.graphql.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private Long id;

    private String title;

    private Author author;
    
    
    public Book(){}

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public Author getAuthor() {
        return author;
    }



    public void setAuthor(Author author) {
        this.author = author;
    }




   
   

   

}