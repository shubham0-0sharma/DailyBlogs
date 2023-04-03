package com.noobdev.dailyblog.dailyblog.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name", nullable = false, length = 100)

    private String name;
    @Column(name = "user_email")

    private String email;
    @Column(name = "user_password")
    private String password;

    @Column(name = "user_about")
    private String about;
}
