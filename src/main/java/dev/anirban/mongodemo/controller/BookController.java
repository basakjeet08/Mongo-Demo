package dev.anirban.mongodemo.controller;

import dev.anirban.mongodemo.entity.Book;
import dev.anirban.mongodemo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping("/books/{authorId}")
    public Book createBook(@PathVariable String authorId, @RequestBody Book book) {
        return service.createBook(authorId, book);
    }

    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return service.findAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book findBookById(@PathVariable String id) {
        return service.findBookById(id);
    }

    @GetMapping("/books/author/{id}")
    public List<Book> findByAuthorId(@PathVariable String id){
        return service.findByAuthorId(id);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable String id) {
        service.deleteBook(id);
    }
}