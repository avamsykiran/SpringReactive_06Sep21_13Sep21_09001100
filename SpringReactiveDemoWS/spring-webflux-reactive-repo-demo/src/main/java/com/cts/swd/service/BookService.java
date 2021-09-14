package com.cts.swd.service;

import com.cts.swd.entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookService {
	Mono<Book> add(Book book);
	Mono<Void> deleteById(long bookId);
	Flux<Book> getAll();
	Mono<Book> getById(long bookId);
	boolean existsById(long bookId);
}
