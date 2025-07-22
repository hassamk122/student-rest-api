package com.example.RestApi.service;

import com.example.RestApi.dto.AddStudentRequestDTO;
import com.example.RestApi.dto.StudentDTO;

import java.net.URI;
import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO);

    void deleteAStudentById(Long id);

    StudentDTO updateStudent(Long id, AddStudentRequestDTO addStudentRequestDTO);

    StudentDTO updatePartialStudent(Long id, Map<String, Object> updates);
}
