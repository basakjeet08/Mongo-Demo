package dev.anirban.mongodemo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "authors")
public class Author {

    @Id
    private String id;
    private String name;
    private Integer age;

    @JsonIgnore
    @DBRef
    private List<Book> books;

    public void addBooks(Book book) {
        books.add(book);
        book.setAuthor(this);
    }
}