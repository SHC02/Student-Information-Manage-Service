package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// API layer
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    // GET = get resource from the system
    @GetMapping
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }

    // POST = new resource on the system
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) // take requestbody
    {
        studentService.addNewStudent(student);
    }

    // PUT = update resource on the system
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email)
        {
            studentService.updateStudent(studentId, name, email);
        }
    // DELETE = delete resource from the system(in this case, studentId)
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId)
    {
        studentService.deleteStudentId(studentId);
    }
}
