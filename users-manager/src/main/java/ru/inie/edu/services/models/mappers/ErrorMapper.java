package ru.inie.edu.services.models.mappers;

import ru.inie.edu.services.models.Error;
import ru.inie.edu.services.models.User;
import ru.inie.edu.storages.entities.UserEntity;
import ru.inie.edu.users.v1.models.ErrorDto;
import ru.inie.edu.users.v1.models.UserDto;

import java.sql.Date;

public final class ErrorMapper {

    private ErrorMapper() {

    }

    public static ErrorDto convertToDto(Error model) {
        if(model == null) {
            return null;
        }
        return new ErrorDto(model.getType().name(), model.getMessages());
    }
}
