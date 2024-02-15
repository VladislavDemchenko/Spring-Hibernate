package com.example.demo.entity.exemple2;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address")
@Setter
@Getter
@NoArgsConstructor
@ToString(exclude = "user")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address")
    @SequenceGenerator(name = "address", sequenceName = "address_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String city;

    private String street;

    private String number;

    private String apartment;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
