package practice2.repository;

import practice2.model.Login;
import practice2.model.User;

public interface IRepoUser {
    User checkLogin(Login login);
}
