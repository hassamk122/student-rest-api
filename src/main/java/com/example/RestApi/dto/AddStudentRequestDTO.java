package com.example.RestApi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

public class AddStudentRequestDTO {

    @NotBlank(message = "Name is Required")
    private String name;

    @Email
    @NotBlank(message = "Email is required")
    private String email;
}

