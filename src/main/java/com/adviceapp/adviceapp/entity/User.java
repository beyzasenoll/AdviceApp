package com.adviceapp.adviceapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Specifies that this field will be automatically created in ascending order (identity).
    private Long id;
    @Column(name = "user_name", nullable = false, unique = true)
    //Specifies that column won't be empty,and it should be unique value.
    private String user_name;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_num")
    private String phone_num;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_content",
            joinColumns = {@JoinColumn(name = "user_id") },
            inverseJoinColumns = {@JoinColumn(name = "content_id") }
    )
    Set<Content> contents = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job-id", referencedColumnName = "id")
    private Job job ;
}
