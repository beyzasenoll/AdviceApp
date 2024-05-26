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

    @Column(name = "icon")
    private String icon;

    @OneToMany(mappedBy="category",cascade = CascadeType.ALL)
    private Set<Content> contents;

}
