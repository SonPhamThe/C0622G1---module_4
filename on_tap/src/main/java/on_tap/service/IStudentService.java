package on_tap.service;

import on_tap.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
    Page<Student> displayAll(Pageable pageable);
}
