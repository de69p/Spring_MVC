package java.myproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.myproject.config.ConfigApp;
import java.myproject.domain.Phone;
import java.myproject.domain.Student;
import java.myproject.service.CrudService;
import java.myproject.service.impl.PhoneServiceImpl;
import java.myproject.service.impl.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        CrudService<Student> studentService = context.getBean(StudentServiceImpl.class);
        CrudService<Phone> phoneService = context.getBean(PhoneServiceImpl.class);

//        Phone phone = Phone.builder()
//                .number("+1-212-213-2122")
//                .build();
//        Phone phone1 = Phone.builder().number("+1-212-213-4441").build();

//        Student student = Student.builder()
//                .firstName("Keanu")
//                .lastName("Reaves")
//                .phones(List.of(phone1, phone)).build();

//        Student student = studentService.findById(1);
//        Student student1 = studentService.findById(6);

//        phone.setStudent(student);
//        phone1.setStudent(student);
//
//        studentService.update(student);

//        phoneService.update(phone);
//        phoneService.update(phone1);



    }
}
