package com.example.mybatis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer instructorId;
    private String instructorName;
    private String instructorEmail;
    public void remove(Instructor instructor) {
    }
}

