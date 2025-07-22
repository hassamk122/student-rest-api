package com.example.RestApi.service.Implementation;

import com.example.RestApi.dto.AddStudentRequestDTO;
import com.example.RestApi.dto.StudentDTO;
import com.example.RestApi.entity.Student;
import com.example.RestApi.repository.StudentRepository;
import com.example.RestApi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImplementation implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOList = students
                .stream().
                map(student -> modelMapper.map(student,StudentDTO.class))
                .toList();
        return studentDTOList;
    }

    @Override
    public StudentDTO getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found with ID :"+id));
        StudentDTO studentDTO = modelMapper.map(student,StudentDTO.class);
        return studentDTO;
    }

    @Override
    public StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO) {
        Student newStudent = modelMapper.map(addStudentRequestDTO,Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDTO.class);
    }

    @Override
    public void deleteAStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found with id : "+id);
        }else{
            studentRepository.deleteById(id);
        }
    }

    @Override
    public StudentDTO updateStudent(Long id, AddStudentRequestDTO addStudentRequestDTO) {
      Student student = studentRepository.findById(id)
              .orElseThrow(()-> new IllegalArgumentException("Student not found with ID :"+id));
      modelMapper.map(addStudentRequestDTO,student);
      student = studentRepository.save(student);

      return modelMapper.map(student,StudentDTO.class);
    }

    @Override
    public StudentDTO updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Student not found with ID :"+id));
        updates.forEach((field,value)->{
            switch (field){
                case "name":
                    student.setName((String) value);
                case "email":
                    student.setEmail((String) value);
                default:
                    throw new IllegalArgumentException("field does not exist!");
            }
        });
        Student saveStudent = studentRepository.save(student);

        return modelMapper.map(saveStudent,StudentDTO.class);
    }
}
