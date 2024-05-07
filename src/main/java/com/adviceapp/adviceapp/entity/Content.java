package com.adviceapp.adviceapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long content_id;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "content_name")
    private String contentName;
    @Column(name = "content_duration")
    private Double contentDuration;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;

}
