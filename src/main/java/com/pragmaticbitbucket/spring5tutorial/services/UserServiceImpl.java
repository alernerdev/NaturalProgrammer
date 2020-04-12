package com.pragmaticbitbucket.spring5tutorial.services;

import com.pragmaticbitbucket.spring5tutorial.commands.UserCommand;
import com.pragmaticbitbucket.spring5tutorial.domain.User;
import com.pragmaticbitbucket.spring5tutorial.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signup(UserCommand userCommand) {
        User user = userCommand.toUser();
        user.getRoles().add(User.Role.UNVERIFIED);
        userRepository.save(user);
    }
}
