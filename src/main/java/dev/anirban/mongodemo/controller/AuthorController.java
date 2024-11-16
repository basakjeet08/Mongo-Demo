package dev.anirban.mongodemo.controller;


import dev.anirban.mongodemo.entity.Author;
import dev.anirban.mongodemo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author) {
        return service.createAuthor(author);
    }

    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        return service.findAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public Author findAuthorById(@PathVariable String id) {
        return service.findAuthorById(id);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable String id) {
        service.deleteAuthor(id);
    }
}
