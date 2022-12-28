package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Business layer
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // For GET
    @GetMapping
    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }

    // For POST
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("This email is already exists!");
        }
        // save after
        studentRepository.save(student);
    }

    // For PUT
    @Transactional
    public void updateStudent(Long studentId, String name, String email)
    {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "Student with ID" + studentId + " does not exists.")
        );

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
        {
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email))
        {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent())
            {
                throw new IllegalStateException("This email is already exists!");
            }
            student.setEmail(email);
        }
    }

    // For DELETE
    public void deleteStudentId(Long studentId)
    {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists)
        {
            throw new IllegalStateException("This Student with ID" + studentId + " does not exists.");
        }
        else
        {
            studentRepository.deleteById(studentId);
        }
    }
}
