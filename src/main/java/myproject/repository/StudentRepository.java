package myproject.repository;

import myproject.domain.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);
    Student findByFirstName(String name);

    @EntityGraph(attributePaths = "phones")
    Student findByFirstNameAndEmail(String name, String email);

    @Query(value = "FROM Student st JOIN st.phones ph WHERE ph.id = :id")
    Student findByPhoneId(@Param("id") int phoneId);

    @Modifying
    void deleteById(int id);
}
