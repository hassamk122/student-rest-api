package com.example.RestApi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// lombok data to replace boiler plate getter and setters
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {  // DTO stands for data transfer object
    private long id;
    private String name;
    private String email;
}
