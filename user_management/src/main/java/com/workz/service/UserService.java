package com.workz.service;

import java.util.List;
import java.util.Optional;

import com.workz.model.User;

public interface UserService {

	User saveUser(User user);

    Optional<User> getUserById(String id);

    Optional<User> updateUser(User user);

    void deleteUser(String id);

    boolean isUserExist(String id);

    boolean isUserExistByEmail(String email);

    List<User> getAllUsers();

    User getUserByEmail(String email);
}
