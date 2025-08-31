package com.book.book.service.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "book")
public class Book {

	@Id
	private String id;
	private String name;
	private double price;
	private String Author;
	private Date publishedDate;
	
	public Book() {
		
	}

	public Book(String id, String name, double price, String author, Date publishedDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		Author = author;
		this.publishedDate = publishedDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	
}
