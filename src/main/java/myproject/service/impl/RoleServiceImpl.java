package myproject.service.impl;

import lombok.AllArgsConstructor;
import myproject.domain.Role;
import myproject.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl {

    private final RoleRepository roleRepository;

    public void add(Role role) {
        roleRepository.save(role);
    }

    public Role getById(int id) {
        return roleRepository.findById(id).get();
    }

    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }
}

