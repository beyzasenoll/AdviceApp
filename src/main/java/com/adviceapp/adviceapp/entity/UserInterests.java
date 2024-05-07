package com.adviceapp.adviceapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="UserInterests")
public class UserInterests {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long interest_id;

    @ManyToMany
    @JoinColumn(name = "user_id")
    private User User;

}
