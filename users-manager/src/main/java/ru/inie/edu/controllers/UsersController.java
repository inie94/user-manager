package ru.inie.edu.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.inie.edu.services.UserService;
import ru.inie.edu.services.models.User;
import ru.inie.edu.services.models.mappers.UserMapper;
import ru.inie.edu.users.v1.api.UsersApi;
import ru.inie.edu.users.v1.models.UserDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersController implements UsersApi {

    private final UserService service;

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        User user = UserMapper.convertToModel(null, userDto);
        User createdUser = service.createUser(user);
        return ResponseEntity.ok(UserMapper.convertToDto(createdUser));
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        service.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserDto> getUserById(Long userId) {
        User user = service.getUserById(userId);
        return ResponseEntity.ok(UserMapper.convertToDto(user));
    }

    @Override
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users.stream().map(UserMapper::convertToDto).toList());
    }

    @Override
    public ResponseEntity<UserDto> updateUser(Long userId, UserDto userDto) {
        User user = UserMapper.convertToModel(userId, userDto);
        User updatedUser = service.updateUser(user);
        return ResponseEntity.ok(UserMapper.convertToDto(updatedUser));
    }
}
