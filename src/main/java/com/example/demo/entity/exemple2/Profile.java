package com.example.demo.entity.exemple2;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "user")
public class Profile {
    @Id //shared pk, optimization logic when Profile can`t be without User
    private Long id;

    private boolean active;

    private String photoUrl;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
