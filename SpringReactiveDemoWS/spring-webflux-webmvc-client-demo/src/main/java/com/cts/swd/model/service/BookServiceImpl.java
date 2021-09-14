package com.cts.swd.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.cts.swd.model.Book;

import reactor.core.publisher.Mono;

public class BookServiceImpl implements BookService{

	@Autowired
	private WebClient client;
	
	@Override
	public Book add(Book book) {
		return client.post().body(book, Book.class).exchangeToMono(response -> {
			return response.bodyToMono(Book.class);
		}).block();
	}

	@Override
	public void deleteById(long bookId) {
		client.delete().uri("/{bookId}", bookId).exchangeToMono(response -> {
			if(response.rawStatusCode()!=200) {
				return Mono.error(() -> new Exception("Could not delete"));
			}else {
				return Mono.empty();
			}
		}).then();
	}

	@Override
	public List<Book> getAll() {
		return client.get().exchangeToFlux(response -> {
			return response.bodyToFlux(Book.class);
		}).buffer().blockFirst();
	}

	@Override
	public Book getById(long bookId) {
		return client.get().uri("/{bookId}", bookId).exchangeToMono(response -> {
			return response.bodyToMono(Book.class);
		}).block();
	}

}
