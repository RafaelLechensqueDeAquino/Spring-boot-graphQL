package com.lechensque.graphql.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lechensque.graphql.demo.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}