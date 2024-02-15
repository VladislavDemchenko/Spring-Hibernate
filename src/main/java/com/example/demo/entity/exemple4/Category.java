package com.example.demo.entity.exemple4;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Setter
@Getter
@NoArgsConstructor
@ToString(exclude = "books")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category")
    @SequenceGenerator(name = "category", sequenceName = "category_seq", initialValue = 1)
    private Long id;

    private String nameOfCategory;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "categories", cascade = CascadeType.PERSIST)
    private List<Book> books = new ArrayList<>();






}
