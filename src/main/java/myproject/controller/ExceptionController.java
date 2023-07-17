package myproject.controller;

import lombok.AllArgsConstructor;
import myproject.domain.Student;
import myproject.service.CrudService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exception")
@AllArgsConstructor
public class ExceptionController {

    @GetMapping
    public void findById() {
        throw  new IllegalArgumentException("I'm new Exception");
    }

}
