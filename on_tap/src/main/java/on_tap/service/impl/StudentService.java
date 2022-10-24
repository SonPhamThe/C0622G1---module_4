package on_tap.service.impl;

import on_tap.model.Student;
import on_tap.repository.IStudentRepo;
import on_tap.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepo studentRepo;

    @Override
    public Page<Student> displayAll(Pageable pageable) {
        return studentRepo.findAll(pageable);
    }
}
