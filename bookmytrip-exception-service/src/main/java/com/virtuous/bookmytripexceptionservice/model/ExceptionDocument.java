package com.virtuous.bookmytripexceptionservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "exceptions")
public class ExceptionDocument {
    @Id
    private String id;
    private String message;
    private LocalDateTime timestamp;

    public ExceptionDocument(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
