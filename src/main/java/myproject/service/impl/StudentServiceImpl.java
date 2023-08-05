package myproject.service.impl;

import lombok.AllArgsConstructor;
import myproject.repository.StudentRepository;
import myproject.service.PasswordService;
import org.springframework.stereotype.Service;

import myproject.domain.Student;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl {

    private final PasswordService passwordService;
    private final StudentRepository studentRepository;

    public void add(Student student) {
        String password = student.getPassword();
        student.getPhones().forEach(ph -> ph.setStudent(student));
        String encodedPassword = passwordService.encodePassword(password);
        student.setPassword(encodedPassword);
        studentRepository.save(student);
    }

    public Student findById(Integer id) {
        return studentRepository.findStudentById(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void update(Student student) {
        studentRepository.save(student);
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public Student findByFirstNameAndEmail(String firstName, String email) {
        return studentRepository.findByFirstNameAndEmail(firstName, email);
    }

}
