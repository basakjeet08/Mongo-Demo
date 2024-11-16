package dev.anirban.mongodemo.repo;

import dev.anirban.mongodemo.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findByAuthor_Id(String authorId);
}
