package com.adviceapp.adviceapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content_type")
    private String type;
    @Column(name = "content_name")
    private String title;
    @Column(name = "content_duration")
    private Double duration;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "platform_id", referencedColumnName = "platform_id")
    private Platform platform;

    @ManyToMany(mappedBy = "contents")
    private List<User> users;


}
