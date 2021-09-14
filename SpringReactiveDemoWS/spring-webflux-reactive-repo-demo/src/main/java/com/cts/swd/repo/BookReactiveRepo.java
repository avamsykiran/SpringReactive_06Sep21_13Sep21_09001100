package com.cts.swd.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.swd.entity.Book;

@Repository
public interface BookReactiveRepo extends ReactiveCrudRepository<Book, Long>{

}
