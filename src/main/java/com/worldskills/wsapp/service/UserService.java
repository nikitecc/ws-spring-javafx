package com.worldskills.wsapp.service;

import com.worldskills.wsapp.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserById(Long id);

    void deleteUser(Long id);

    void saveUser(User user);
}
