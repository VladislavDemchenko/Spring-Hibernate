package com.example.demo.entity.exemple2;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user")
    @SequenceGenerator(name = "user", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String userName;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    public User(String userName) {
        this.userName = userName;
    }

    public void setAddress(Address address){
        address.setUser(this);
        this.address = address;
    }

    public void setProfile(Profile profile){
        profile.setUser(this);
        this.profile = profile;
    }
}
