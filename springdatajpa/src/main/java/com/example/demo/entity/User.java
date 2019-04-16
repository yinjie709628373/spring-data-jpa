package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="user_")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char" )
    @Column(name="id_",length = 36)
    private UUID id;
    @Column(name="name_")
    private String name;
}
