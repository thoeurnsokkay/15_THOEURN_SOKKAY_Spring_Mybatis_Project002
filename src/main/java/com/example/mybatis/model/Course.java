package com.example.mybatis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer courseId;
    private String courseName;
    private String message;
//    private T payload;
    private LocalDateTime timestamp;
    private String courseEmail;
}

