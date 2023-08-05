//package myproject;
//
//import myproject.config.ConfigApp;
//import myproject.domain.Student;
//import myproject.service.StudentDataService;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class Main {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
//
//       /* CrudService<Student> studentService = context.getBean(StudentServiceImpl.class);
//        CrudService<Phone> phoneService = context.getBean(PhoneServiceImpl.class);*/
//
//        StudentDataService dataService = context.getBean(StudentDataService.class);
//
//        Student keanu = dataService.findByFirstNameAndEmail("Keanu", "reaves@icloud.com");
//        System.out.println(keanu);
//
////        Phone phone = Phone.builder()
////                .number("+1-212-213-2122")
////                .build();
////        Phone phone1 = Phone.builder().number("+1-212-213-4441").build();
//
////        Student student = Student.builder()
////                .firstName("Keanu")
////                .lastName("Reaves")
////                .phones(List.of(phone1, phone)).build();
//
////        Student student = studentService.findById(1);
////        Student student1 = studentService.findById(6);
//
////        phone.setStudent(student);
////        phone1.setStudent(student);
////
////        studentService.update(student);
//
////        phoneService.update(phone);
////        phoneService.update(phone1);
//
//
//
//    }
//}
