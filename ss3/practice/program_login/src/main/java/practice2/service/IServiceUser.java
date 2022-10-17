package practice2.service;

import practice2.model.Login;
import practice2.model.User;

public interface IServiceUser {
    User checkLogin(Login login);
}
