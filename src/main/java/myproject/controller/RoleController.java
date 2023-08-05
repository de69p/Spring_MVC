package myproject.controller;

import lombok.AllArgsConstructor;
import myproject.domain.Role;
import myproject.domain.Student;
import myproject.service.impl.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
@AllArgsConstructor
public class RoleController {

    private RoleServiceImpl roleServiceImpl;

//    @GetMapping(value = "/{id}")
//    public Student findById(@PathVariable("id") int id) {
//        return roleServiceImpl.getById(id);
//    }

//    @GetMapping
//    public List<Role> findAll() {
//        return roleServiceImpl.findAll();
//    }

//    @DeleteMapping(value = "/{id}")
//    public void deleteById(@PathVariable("id") int id) {
//        roleServiceImpl.delete(id);
//    }

    @PostMapping("/save")
    public void save(@RequestBody Role role) {
        roleServiceImpl.add(role);
    }

//    @PutMapping
//    public void update(@RequestBody Student student) {
//        roleServiceImpl.(student);
//    }

}
