package ru.inie.edu.services.models.mappers;

import ru.inie.edu.services.models.Error;
import ru.inie.edu.users.v1.models.ErrorDto;

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
