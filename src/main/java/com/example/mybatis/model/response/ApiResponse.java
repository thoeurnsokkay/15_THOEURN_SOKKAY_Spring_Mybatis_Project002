package com.example.mybatis.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse <T>{
    private LocalDateTime timestamp;
    private String message;
    private HttpStatus status;

//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T payload;
}
