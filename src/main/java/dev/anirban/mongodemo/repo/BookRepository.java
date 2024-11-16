package dev.anirban.mongodemo.repo;

import dev.anirban.mongodemo.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
