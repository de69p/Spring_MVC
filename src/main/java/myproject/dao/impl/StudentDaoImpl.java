package myproject.dao.impl;


import lombok.AllArgsConstructor;
import myproject.domain.Student;
import myproject.repository.StudentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import myproject.dao.CrudDao;

import java.util.List;

@Repository
@Transactional
@AllArgsConstructor
public class StudentDaoImpl implements CrudDao<Student> {

    PasswordEncoder passwordEncoder;

    StudentRepository repository;

    @Override
    public void add(Student entity) {
        String password = entity.getPassword();

        String encodedPassword = passwordEncoder.encode(password);

        entity.setPassword(encodedPassword);

        repository.save(entity);
    }

    @Override
    public Student findById(Integer id) {
       // return em.createQuery("FROM Student s JOIN FETCH s.phones", Student.class).getSingleResult();
        return null;
    }

    @Override
    public List<Student> findAll() {
       // return em.createQuery("FROM Student s JOIN FETCH s.phones", Student.class).getResultList();
        return null;
    }

    @Override
    public void update(Student entity) {
       // Student merge = em.merge(entity);
       // em.persist(merge);
    }

    @Override
    public void delete(Integer id) {
       /* Query query = em.createQuery("FROM Student s WHERE s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();*/
    }
}
