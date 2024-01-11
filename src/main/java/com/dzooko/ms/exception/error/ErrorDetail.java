package com.dzooko.ms.exception.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {

    private LocalDateTime timeStamp;
    private HttpStatus status;
    private String message;
    private String path;
}
