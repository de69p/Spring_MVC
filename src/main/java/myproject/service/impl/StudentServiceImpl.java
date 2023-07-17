package myproject.service.impl;

import lombok.AllArgsConstructor;
import myproject.domain.Phone;
import org.springframework.stereotype.Service;

import myproject.dao.CrudDao;
import myproject.domain.Student;
import myproject.service.CrudService;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements CrudService<Student> {

    private CrudDao<Student> studentDao;

    private CrudDao<Phone> phoneDao;

    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentDao.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void delete(Integer id) {
        studentDao.delete(id);
    }
}
