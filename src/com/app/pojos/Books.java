package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "books" )
public class Books {
	
	private Integer book_id;
	private String name,author,subject,isbn;
	private double price;
	private List<Copies> copy ;
	public Books() {
		// TODO Auto-generated constructor stub
	}

	public Books(String name, String author, String subject, String isbn, double price) {
		super();
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.isbn = isbn;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@OneToMany(mappedBy ="book",cascade = CascadeType.ALL  )
	public List<Copies> getCopy() {
		return copy;
	}

	public void setCopy(List<Copies> copy) {
		this.copy = copy;
	}

	@Override
	public String toString() {
		return "Books [book_id=" + book_id + ", name=" + name + ", author=" + author + ", subject=" + subject
				+ ", isbn=" + isbn + ", price=" + price + "]";
	}
	
	

}
