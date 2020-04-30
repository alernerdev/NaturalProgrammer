package com.pragmaticbitbucket.spring5tutorial.services;

import com.pragmaticbitbucket.spring5tutorial.commands.UserCommand;
import org.springframework.boot.context.event.ApplicationReadyEvent;

public interface UserService {
    void signup(UserCommand userCommand);
    void afterApplicationReady(ApplicationReadyEvent e);
}
