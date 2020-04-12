package com.pragmaticbitbucket.spring5tutorial.commands;

import com.pragmaticbitbucket.spring5tutorial.validation.UniqueEmail;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.pragmaticbitbucket.spring5tutorial.domain.User;
import com.pragmaticbitbucket.spring5tutorial.validation.UniqueEmail;

public class UserCommand {
    @UniqueEmail
    private String email;

    @NotBlank
    @Size(min=1,max=64)
    private String name;

    @NotBlank
    @Size(min=6,max=32)
    private String password;

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

    public User toUser() {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);

        return user;
    }
}
