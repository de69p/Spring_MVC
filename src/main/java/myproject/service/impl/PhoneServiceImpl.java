package myproject.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import myproject.dao.CrudDao;
import myproject.domain.Phone;
import myproject.service.CrudService;
import java.util.List;

@Service
@AllArgsConstructor
public class PhoneServiceImpl implements CrudService<Phone> {

    private CrudDao<Phone> dao;

    @Override
    public void add(Phone entity) {
        dao.add(entity);
    }

    @Override
    public Phone findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Phone> findAll() {
        return dao.findAll();
    }

    @Override
    public void update(Phone entity) {
        dao.update(entity);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
