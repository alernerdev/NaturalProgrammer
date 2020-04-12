package com.pragmaticbitbucket.spring5tutorial.services;

import com.pragmaticbitbucket.spring5tutorial.commands.UserCommand;

public interface UserService {
    void signup(UserCommand userCommand);
}
