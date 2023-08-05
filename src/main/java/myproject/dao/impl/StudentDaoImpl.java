//package myproject.dao.impl;
//
//import lombok.AllArgsConstructor;
//import myproject.domain.Student;
//import myproject.repository.StudentRepository;
//import myproject.service.PasswordService;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import myproject.dao.CrudDao;
//
//import java.util.List;
//
//@Repository
//@Transactional
//@AllArgsConstructor
//public class StudentDaoImpl implements CrudDao<Student> {
//
//    private final PasswordService passwordService;
//    private final StudentRepository repository;
//
//    @Override
//    public void add(Student entity) {
//        String password = entity.getPassword();
//        String encodedPassword = passwordService.encodePassword(password);
//        entity.setPassword(encodedPassword);
//        repository.save(entity);
//    }
//
//    @Override
//    public Student findById(Integer id) {
//        return null;
//    }
//
//    @Override
//    public List<Student> findAll() {
//        return null;
//    }
//
//    @Override
//    public void update(Student entity) {
//
//    }
//
//    @Override
//    public void delete(Integer id) {
//
//    }
//
//}
