package com.java.rds;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository repository;

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping
    public List<Book> findBooks() {
        return repository.findAll();
    }


    @SneakyThrows
    @GetMapping("/{id}")
    public Book findBook(@PathVariable int id) {
        Book book = repository.findById(id).orElseThrow(() -> new Exception("Book not available"));
        return book;
    }
}