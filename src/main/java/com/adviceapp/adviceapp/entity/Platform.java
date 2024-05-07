package com.adviceapp.adviceapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Platform")
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long platform_id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "platform")
    private List<Category> categories;

  /*  @OneToMany(mappedBy = "platform")
    private List<Content> contents;*/
}
