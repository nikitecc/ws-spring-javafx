package com.worldskills.wsapp.service.impl;

import com.worldskills.wsapp.entity.User;
import com.worldskills.wsapp.exception.UserNotFoundException;
import com.worldskills.wsapp.repository.UserRepository;
import com.worldskills.wsapp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImplements implements UserService {

    private static final Logger logger = LogManager.getLogger();

    private final UserRepository userRepository;

    public UserServiceImplements(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getRegisteredUser(String name, String password) {
        return userRepository.userByNameAndPassword(name, password).orElseThrow(() -> new UserNotFoundException("Такой пользователь не зарегистрирован."));
    }
}

