package on_tap.repository;

import on_tap.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
}
