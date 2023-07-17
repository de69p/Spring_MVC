package myproject.controller;

import lombok.AllArgsConstructor;
import myproject.domain.Student;
import myproject.service.CrudService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    CrudService<Student> service;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Student findById(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @GetMapping
    @ResponseBody
    public List<Student> findAll() {
        return service.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.delete(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        service.add(student);
    }

    @PutMapping
    public void update(@RequestBody Student student) {
        service.add(student);
    }


}
