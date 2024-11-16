package dev.anirban.mongodemo.service;


import dev.anirban.mongodemo.entity.Author;
import dev.anirban.mongodemo.entity.Book;
import dev.anirban.mongodemo.repo.AuthorRepository;
import dev.anirban.mongodemo.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;

    public Book createBook(String authorId, Book book) {

        Author author = authorRepo
                .findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found !!"));


        author.addBooks(book);
        book = bookRepo.save(book);

        authorRepo.save(author);
        return book;
    }

    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    public Book findBookById(String id) {
        return bookRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found !!"));
    }

    public void deleteBook(String id) {
        if (!bookRepo.existsById(id))
            throw new RuntimeException("Book not found !!");

        bookRepo.deleteById(id);
    }
}
