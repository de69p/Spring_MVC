package java.myproject.dao.impl;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.myproject.dao.CrudDao;
import java.myproject.domain.Student;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements CrudDao<Student> {

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Student entity) {
        em.persist(entity);
    }

    @Override
    public Student findById(Integer id) {
        return em.createQuery("FROM Student s JOIN FETCH s.phones", Student.class).getSingleResult();
    }

    @Override
    public List<Student> findAll() {
        return em.createQuery("FROM Student s JOIN FETCH s.phones", Student.class).getResultList();
    }

    @Override
    public void update(Student entity) {
        Student merge = em.merge(entity);
        em.persist(merge);
    }

    @Override
    public void delete(Integer id) {
        Query query = em.createQuery("FROM Student s WHERE s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
