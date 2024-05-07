package com.adviceapp.adviceapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(name = "category_name")
    private String category_name;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

   /* @OneToMany(mappedBy = "category")
    private Set<Content> contents;*/
}
