package myproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exception")
@AllArgsConstructor
public class ExceptionController {

    @GetMapping
    public void findById() {
        throw  new IllegalArgumentException("I'm new Exception");
    }

}
