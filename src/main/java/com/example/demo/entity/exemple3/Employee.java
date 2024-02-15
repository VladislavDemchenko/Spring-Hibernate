package com.example.demo.entity.exemple3;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "employes")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany
    @JoinTable(
            name = "guilds_employes",
            joinColumns = @JoinColumn(name = "employe_id"),
            inverseJoinColumns = @JoinColumn(name = "guild_id")
    )
    private List<Guild> guild;


}
