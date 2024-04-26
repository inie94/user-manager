package ru.inie.edu.services.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.inie.edu.exceptions.UserNotFoundException;
import ru.inie.edu.services.UserService;
import ru.inie.edu.services.models.User;
import ru.inie.edu.services.models.mappers.UserMapper;
import ru.inie.edu.storages.entities.UserEntity;
import ru.inie.edu.storages.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<User> getAllUsers() {
        return repository.findAll().stream()
                .map(UserMapper::convertToModel)
                .toList();
    }

    @Override
    public User getUserById(Long id) {
        return UserMapper.convertToModel(getUserEntityById(id));
    }

    @Override
    public User createUser(User user) {
        UserEntity convertedEntity = UserMapper.convertToEntity(user);
        UserEntity savedEntity = repository.save(convertedEntity);
        return UserMapper.convertToModel(savedEntity);
    }

    @Override
    public User updateUser(User user) {
        UserEntity entity = getUserEntityById(user.getId());
        UserEntity updatedEntity = entity.updated(user);
        UserEntity savedEntity = repository.save(updatedEntity);
        return UserMapper.convertToModel(savedEntity);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    private UserEntity getUserEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("Пользователь с идентификатором %d не найден", id)));
    }
}
