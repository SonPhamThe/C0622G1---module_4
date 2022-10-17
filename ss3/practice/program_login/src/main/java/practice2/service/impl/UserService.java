package practice2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice2.model.Login;
import practice2.model.User;
import practice2.repository.IRepoUser;
import practice2.service.IServiceUser;

@Service
public class UserService implements IServiceUser {
    @Autowired
    private IRepoUser repoUser;

    @Override
    public User checkLogin(Login login) {
        return repoUser.checkLogin(login);
    }
}
