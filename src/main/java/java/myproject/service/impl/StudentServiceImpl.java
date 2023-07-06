package java.myproject.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.myproject.dao.CrudDao;
import java.myproject.domain.Student;
import java.myproject.service.CrudService;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements CrudService<Student> {

    private CrudDao<Student> dao;

    @Override
    public void add(Student entity) {
        dao.add(entity);
    }

    @Override
    public Student findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public void update(Student entity) {

        dao.update(entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
