package dev.anirban.mongodemo.controller;


import dev.anirban.mongodemo.entity.Author;
import dev.anirban.mongodemo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author) {

        Author newAuthor = Author
                .builder()
                .age(author.getAge())
                .name(author.getName())
                .books(new ArrayList<>())
                .build();

        return service.createAuthor(newAuthor);
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
