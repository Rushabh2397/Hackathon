package com.app.daos;

import java.util.List;

import com.app.pojos.Books;

public interface IBookDao {
	Books addBooks(Books u);
	List<Books> findByName(String subject);
	List<Books> getAllBooks();
}
