package on_tap.repository;

import on_tap.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student, Integer> {
}
