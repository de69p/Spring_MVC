package myproject.controller;

import lombok.AllArgsConstructor;
import myproject.domain.Student;
//import myproject.service.CrudService;
import myproject.service.impl.RoleServiceImpl;
import myproject.service.impl.StudentServiceImpl;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private StudentServiceImpl studentServiceImpl;

    private RoleServiceImpl roleServiceImpl;

    @GetMapping(value = "/{id}")
    @Secured({"ROLE_USER"})
    public Student findById(@PathVariable("id") int id) {
        return studentServiceImpl.findById(id);
    }

    @GetMapping
    @Secured({"ROLE_ADMIN"})
    public List<Student> findAll() {
        return studentServiceImpl.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") int id) {
        studentServiceImpl.delete(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        studentServiceImpl.add(student);
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        studentServiceImpl.update(student);
    }

}
