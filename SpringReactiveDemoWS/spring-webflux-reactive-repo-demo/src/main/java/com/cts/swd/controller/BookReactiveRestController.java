package com.cts.swd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.swd.entity.Book;
import com.cts.swd.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookReactiveRestController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public Flux<Book> getAllBooks(){
		return bookService.getAll();
	}
	
	@GetMapping("/{bookId}")
	public Mono<Book> getBookById(@PathVariable("bookId") long bookId,ServerHttpResponse response){
		Mono<Book> result = null;
		if(bookService.existsById(bookId))
			result =bookService.getById(bookId);
		else{
			response.setStatusCode(HttpStatus.NOT_FOUND);
			result = Mono.empty();
		}
		return result; 
	}
	
	@PostMapping
	public Mono<Book> add(@RequestBody Book book){
		return bookService.add(book);
	}
	
	@DeleteMapping("/{bookId}")
	public Mono<Void> deleteBook(@PathVariable("bookId") long bookId){
		return bookService.deleteById(bookId);
	}
}
