package com.cts.swd.model.service;

import java.util.List;

import com.cts.swd.model.Book;

public interface BookService {
	Book add(Book book);
	void deleteById(long bookId);
	List<Book> getAll();
	Book getById(long bookId);
}