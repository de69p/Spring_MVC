package myproject.service.impl;

import lombok.AllArgsConstructor;
import myproject.domain.Phone;
import myproject.repository.PhoneRepository;
import myproject.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PhoneServiceImpl implements CrudService<Phone> {

    private final PhoneRepository phoneRepository;

    public void add(Phone entity) {
        phoneRepository.save(entity);
    }

    public Phone findById(int id) {
        return phoneRepository.findById(id);
    }

    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    public void update(Phone entity) {
        phoneRepository.save(entity);
    }

    public void deleteById(int id) {
        phoneRepository.deleteById(id);
    }
}
