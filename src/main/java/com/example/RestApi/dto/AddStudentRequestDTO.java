package com.example.RestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

public class AddStudentRequestDTO {
    private String name;
    private String email;
}

