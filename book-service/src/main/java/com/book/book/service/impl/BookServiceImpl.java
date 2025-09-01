package com.book.book.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.book.service.entity.Book;
import com.book.book.service.exception.BookNotFoundException;
import com.book.book.service.repository.BookRepository;
import com.book.book.service.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book registerBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id)
                .or(() -> { throw new BookNotFoundException("Book not found with the given id: " + id); });
    }

    @Override
    public Book updateBook(Book book, String id) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with the given id: " + id));

        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        existingBook.setPublishedDate(book.getPublishedDate());

        return bookRepository.save(existingBook);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(String id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found with the given id: " + id);
        }
        bookRepository.deleteById(id);
    }

}
