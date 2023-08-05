package myproject.service.impl;

import lombok.AllArgsConstructor;
import myproject.domain.Student;
import myproject.repository.StudentRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class MvcDetailsServiceImpl implements UserDetailsService {

    private StudentRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = repository.findByFirstName(username);

        return buildUserDetails(student);
    }

    private List<SimpleGrantedAuthority> convertRoles(Student student) {
        return student
                .getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .toList();
    }

    private UserDetails buildUserDetails(Student student) {
        List<SimpleGrantedAuthority> roles = convertRoles(student);

        return new User(student.getFirstName(), student.getPassword(),
                true,
                true, true, true, roles);
    }
}
