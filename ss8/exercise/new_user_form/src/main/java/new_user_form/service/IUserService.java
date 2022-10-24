package new_user_form.service;

import new_user_form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    Page<User> displayAll(Pageable pageable);

    void save(User user);
}
