package dev.rakesh.test.repositories;



import dev.rakesh.test.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, String> {
}
