package com.anhdai.serviceimpl;

import com.anhdai.model.UserEntity;
import com.anhdai.repository.UserRepository;
import com.anhdai.service.UserNotFoundException;
import com.anhdai.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User not exist with id " + id));
    }

    @Override
    public UserEntity createNewUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(long id, UserEntity user) {
        UserEntity userEntity = getUserById(id);

        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        UserEntity response = userRepository.save(userEntity);
        return response;
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.findUserEntityByUsername(username).orElseThrow(() ->
                new UserNotFoundException("User not found with username " + username));
    }

    @Override
    public void deleteUser(long id) {
        UserEntity user = getUserById(id);
        userRepository.delete(user);
    }
}
