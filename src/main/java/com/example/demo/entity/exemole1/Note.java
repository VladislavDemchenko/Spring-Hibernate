package com.example.demo.entity.exemole1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "notes")
@ToString(exclude = "person")
@Setter
@Getter
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note")
    @SequenceGenerator(name = "note", sequenceName = "note_seq", allocationSize = 1)
    private Long id;

    private String body;

    @ManyToOne()
    @JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "notes_persons_fk"))
    private Person person;
    public Note(String body) {
        this.body = body;
    }
}
