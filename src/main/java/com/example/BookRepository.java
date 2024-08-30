package com.example;

import com.oracle.nosql.spring.data.repository.NosqlRepository;


public interface BookRepository extends NosqlRepository<Book, Long> {
    Iterable<Book> findByAuthor(String author);
    Iterable<Book> findByTitle(String title);
}
