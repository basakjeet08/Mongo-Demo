package dev.anirban.mongodemo.service;


import dev.anirban.mongodemo.entity.Author;
import dev.anirban.mongodemo.repo.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepo;

    public Author createAuthor(Author author) {
        return authorRepo.save(author);
    }

    public List<Author> findAllAuthors() {
        return authorRepo.findAll();
    }

    public Author findAuthorById(String id) {
        return authorRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found !!"));
    }

    public void deleteAuthor(String id) {
        if (!authorRepo.existsById(id))
            throw new RuntimeException("Author not found !!");

        authorRepo.deleteById(id);
    }
}
