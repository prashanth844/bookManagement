package com.book.book.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.book.service.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
