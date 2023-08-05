package myproject.repository;

import myproject.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    Phone findById(int id);
}
