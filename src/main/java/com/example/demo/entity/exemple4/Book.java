package com.example.demo.entity.exemple4;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book")
    @SequenceGenerator(name = "book", sequenceName = "book_seq", allocationSize = 1)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "book_fk"))
    private Author author;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(
            name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", foreignKey = @ForeignKey(name = "book_fk")),
            inverseJoinColumns = @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "category_fk"))
    )
    private List<Category> categories = new ArrayList<>();

    public void addCategory(Category category){
        categories.add(category);
        category.getBooks().add(this);
    }
}
