package com.example.demo.entity.exemple4;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Setter
@Getter
@NoArgsConstructor
@ToString(exclude = "books")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author")
    @SequenceGenerator(name = "author", sequenceName = "author_seq", allocationSize = 1)
    private Long id;

    private String firstName;

    private String lastName;

    private Integer age;

    @OneToMany(cascade = CascadeType.ALL) // self-join one-to-many
    @JoinColumn(name = "anotherAuthor_id")
    private List<Author> authors = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST) // self-join many-to-many
    @JoinTable(
            name = "authors_frend",
            joinColumns = @JoinColumn(name = "authors_id"),
            inverseJoinColumns = @JoinColumn(name = "frends_id")
    )
    private List<Author> friends = new ArrayList<>();

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        book.setAuthor(this);
        books.add(book);
    }

    public Author(String firstName) {
        this.firstName = firstName;
    }
}
