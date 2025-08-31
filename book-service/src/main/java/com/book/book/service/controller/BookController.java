package com.book.book.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.book.book.service.entity.Book;
import com.book.book.service.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/register")
	public ResponseEntity<Book> registerBook(@RequestBody Book book) {
		Book b = bookService.registerBook(book);
		return new ResponseEntity<>(b, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		return ResponseEntity.ok(books);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getBookById(@PathVariable String id) {
		Optional<Book> book = bookService.getBookById(id);
		return book.isPresent() ? ResponseEntity.ok(book.get())
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found with id " + id);
	}

	@PutMapping("/updateBook/{id}")
	public ResponseEntity<?> updateBook(@PathVariable String id, @RequestBody Book book) {
		Book updatedBook = bookService.updateBook(book, id);
		return updatedBook != null ? new ResponseEntity<>(updatedBook, HttpStatus.ACCEPTED)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found with id " + id);
	}

	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable String id) {
		bookService.deleteBook(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
