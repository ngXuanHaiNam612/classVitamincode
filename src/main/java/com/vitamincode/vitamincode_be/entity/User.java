package com.vitamincode.vitamincode_be.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "vitamincode_class", name = "user")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "id")
    private Integer userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "role_id")
    private Integer roleId;
}
