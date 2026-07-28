package controller;

import model.UserDAO;
import model.User;

public class LoginController {

    private UserDAO userDAO = new UserDAO();

    public User authenticate(String username, String password) {
        return userDAO.login(username, password);
    }

    public void createUser(User user) {
        userDAO.addUser(user);
    }
}
