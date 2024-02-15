package com.example.demo.entity.exemple3;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "guilds")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Guild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "guild", cascade ={ CascadeType.PERSIST, CascadeType.MERGE })
    private List<Employee> employee;
}
