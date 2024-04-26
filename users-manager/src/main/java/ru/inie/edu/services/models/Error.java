package ru.inie.edu.services.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.inie.edu.services.models.enums.ErrorType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Error {
    private ErrorType type;
    private List<String> messages;
}
