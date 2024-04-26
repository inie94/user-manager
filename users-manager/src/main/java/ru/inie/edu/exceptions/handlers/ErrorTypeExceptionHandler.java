package ru.inie.edu.exceptions.handlers;

import jakarta.validation.ConstraintViolationException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.MethodArgumentNotValidException;
import ru.inie.edu.exceptions.ExceptionMessage;
import ru.inie.edu.exceptions.UserNotFoundException;
import ru.inie.edu.services.models.Error;
import ru.inie.edu.services.models.enums.ErrorType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum ErrorTypeExceptionHandler {
    METHOD_ARGUMENT_NOT_VALID_EXCEPTION(MethodArgumentNotValidException.class,
            throwable -> {
                List<String> messages = ((MethodArgumentNotValidException) throwable).getBindingResult().getFieldErrors().stream()
                        .map(fieldError -> String.format(ExceptionMessage.FIELD_VALIDATION_FORMAT, fieldError.getField(), fieldError.getRejectedValue()))
                        .toList();
                return new Error(ErrorType.VALIDATION_ERROR, messages);
            }),
    CONSTRAINT_VIOLATION_EXCEPTION(ConstraintViolationException.class,
            throwable -> {
                List<String> messages = ((ConstraintViolationException) throwable).getConstraintViolations().stream()
                        .map(violation -> String.format(ExceptionMessage.FIELD_VALIDATION_FORMAT, violation.getPropertyPath(), violation.getInvalidValue()))
                        .toList();
                return new Error(ErrorType.VALIDATION_ERROR, messages);
            }),
    USER_NOT_FOUND_EXCEPTION(UserNotFoundException.class, throwable -> new Error(ErrorType.USER_NOT_FOUND_ERROR, List.of(throwable.getMessage()))),
    EXCEPTION(Exception.class, throwable -> new Error(ErrorType.INTERNAL_ERROR, List.of(throwable.getMessage())));

    private static final Map<Class<? extends Throwable>, ErrorTypeExceptionHandler> HANDLER_MAP = Arrays.stream(values())
            .collect(Collectors.toMap(ErrorTypeExceptionHandler::getEClass, Function.identity()));

    private final Class<? extends Throwable> eClass;
    private final Function<? super Throwable, Error> errorDtoSupplier;

    public static ErrorTypeExceptionHandler getByClass(Class<? extends Throwable> eClass) {
        return HANDLER_MAP.get(eClass);
    }
}
