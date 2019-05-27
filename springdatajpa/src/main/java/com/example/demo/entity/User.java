package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="user_")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name="id_",length = 36)
    private Long id;
    @Column(name="name_")
    private String name;
}
