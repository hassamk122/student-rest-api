package com.example.RestApi.controller;


import com.example.RestApi.dto.AddStudentRequestDTO;
import com.example.RestApi.dto.StudentDTO;
import com.example.RestApi.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController // can't use rest controller without spring-web dependency
@RequiredArgsConstructor // so we don't to create constructor for studentService
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>>  getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents()) ;
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody @Valid AddStudentRequestDTO addStudentRequestDTO){
        return  ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDTO));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<StudentDTO> deleteAStudentById(@PathVariable Long id){
        studentService.deleteAStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id ,@RequestBody @Valid AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(id,addStudentRequestDTO));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentDTO> updatePartialStudent(@PathVariable Long id ,@RequestBody @Valid Map<String,Object> updates){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updatePartialStudent(id,updates));
    }

}










