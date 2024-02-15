package com.example.demo.entity.exemole1;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
@ToString
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person")
    @SequenceGenerator(name = "person", sequenceName = "person_seq", allocationSize = 1)
    private Long id;

    @NotNull(message = "firstName cant be null")
    @NotEmpty(message = "firstName cant be empty")
    private String firstName;

    @NotNull(message = "lastName cant be null")
    @NotEmpty(message = "lastName cant be empty")
    private String lastName;


    @Email(message = "its not email")
    @NotEmpty(message = "email is empty")
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    private List<Note> notes = new ArrayList<>();

    public void addNote(Note note){
        note.setPerson(this);
        notes.add(note);
    }
}

