package com.cts.swd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.swd.entity.Book;
import com.cts.swd.repo.BookReactiveRepo;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookReactiveRepo bookRepo;
	
	private Logger logger;
	
	public BookServiceImpl() {
		logger = LoggerFactory.getLogger(this.getClass());
	}
	
	@Override
	public Mono<Book> add(Book book) {
		return bookRepo.save(book).onErrorMap(err -> {
			logger.error(err.getMessage());
			return new Exception("Data Save Failed");
		});
	}

	@Override
	public Mono<Void> deleteById(long bookId) {
		return bookRepo.deleteById(bookId).onErrorMap(err -> {
			logger.error(err.getMessage());
			return new Exception("Data Deletion Failed");
		});
	}

	@Override
	public Flux<Book> getAll() {
		return bookRepo.findAll().onErrorMap(err -> {
			logger.error(err.getMessage());
			return new Exception("Data Retrival Failed");
		});
	}

	@Override
	public Mono<Book> getById(long bookId) {
		return bookRepo.findById(bookId).onErrorMap(err -> {
			logger.error(err.getMessage());
			return new Exception("Data Retrival Failed");
		});
	}

	@Override
	public boolean existsById(long bookId) {
		return bookRepo.existsById(bookId).block();
	}

}
