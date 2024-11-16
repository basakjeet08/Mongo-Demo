package dev.anirban.mongodemo.repo;


import dev.anirban.mongodemo.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
