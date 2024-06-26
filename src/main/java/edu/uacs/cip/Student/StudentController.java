package edu.uacs.cip.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student)
    {
        studentService.addNewStudent(student);
    }

    @GetMapping
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email)
    {
        studentService.updateStudent(studentId, name, email);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId)
    {
        studentService.deleteStudent(studentId);
    }
}


