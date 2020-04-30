package com.pragmaticbitbucket.spring5tutorial.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name="usr", indexes = {
        @Index(columnList = "email", unique=true)
})
public class User {
    public static enum Role {
        UNVERIFIED,
        ADMIN,
        BLOCKED
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false, length=250)
    private String email;

    @Column(nullable=false, length=100)
    private String name;

    @Column(nullable=false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Collection<Role> roles = new HashSet<Role>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
