package com.anhdai.service;

import com.anhdai.model.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUser();

    UserEntity getUserById(long id);

    UserEntity createNewUser(UserEntity user);

    UserEntity updateUser(long id, UserEntity user);

    UserEntity getUserByUsername(String username);

    void deleteUser(long id);
}
