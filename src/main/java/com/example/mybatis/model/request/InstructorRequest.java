package com.example.mybatis.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InstructorRequest {
    private String instructorName;
    private String instructorEmail;
}
