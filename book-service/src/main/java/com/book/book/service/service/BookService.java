package com.book.book.service.service;

import java.util.List;
import java.util.Optional;
import com.book.book.service.entity.Book;

public interface BookService {

	public Book registerBook(Book book);
	
	public List<Book> getAllBooks();
	
	public Optional<Book> getBookById(String id);
	
	public Book updateBook( Book book,String id );
	
	void deleteBook(String id);
	
}