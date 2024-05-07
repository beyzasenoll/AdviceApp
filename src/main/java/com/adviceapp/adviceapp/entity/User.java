package com.adviceapp.adviceapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    // bu alanın otomatik olarak artan bir şekilde (identity) oluşturulacağını belirtir.
    private Long user_id;
    @Column(name="user_name",nullable = false,unique = true)
    //bu sütunun boş bırakılamayacağını ve benzersiz olması gerektiğini belirtir
    private String user_name;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    @Column(name="password")
    private String password;

    @Column(name="phone_num")
    private String phone_num;

}
