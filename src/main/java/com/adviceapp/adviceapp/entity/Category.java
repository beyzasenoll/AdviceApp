package com.adviceapp.adviceapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String category_name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "platform_category",
            joinColumns = { @JoinColumn(name = "category_id") },
            inverseJoinColumns = { @JoinColumn(name = "platform_id") }
    )
    Set<Platform> platforms = new HashSet<>();

    @OneToMany(mappedBy="category")
    private Set<Content> contents;

}
