package ru.inie.edu.services.models.mappers;

import ru.inie.edu.services.models.User;
import ru.inie.edu.storages.entities.UserEntity;
import ru.inie.edu.users.v1.models.UserDto;

import java.sql.Date;

public final class UserMapper {

    private UserMapper() {

    }

    public static User convertToModel(UserEntity entity) {
        if(entity == null) {
            return null;
        }
        return User.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .birthDate(entity.getBirthDate())
                .build();
    }

    public static User convertToModel(Long id, UserDto dto) {
        if(dto == null) {
            return null;
        }
        return User.builder()
                .id(id)
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthDate(dto.getBirthDate())
                .build();
    }

    public static UserDto convertToDto(User model) {
        if(model == null) {
            return null;
        }
        return new UserDto(model.getFirstName(), model.getLastName(), model.getEmail(), model.getBirthDate()).id(model.getId());
    }


    public static UserEntity convertToEntity(User user) {
        if(user == null) {
            return null;
        }
        return UserEntity.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .birthDate(new Date(user.getBirthDate().getTime()))
                .build();
    }
}
