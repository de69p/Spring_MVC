package myproject.dao.impl;

import myproject.domain.Phone;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import myproject.dao.CrudDao;

import java.util.List;

@Repository
@Transactional
public class PhoneDaoImpl implements CrudDao<Phone> {

    @PersistenceContext
    EntityManager em;

    @Override
    public void add(Phone entity) {
        em.persist(entity);
    }

    @Override
    public Phone findById(Integer id) {
        return em.find(Phone.class, id);
    }

    @Override
    public List<Phone> findAll() {
        return em.createQuery("FROM Phone p", Phone.class).getResultList();
    }

    @Override
    public void update(Phone entity) {
        Phone merge = em.merge(entity);
        em.persist(merge);
    }

    @Override
    public void delete(Integer id) {
        Phone phone = em.find(Phone.class, id);
        em.remove(phone);
    }
}
