package controller;

import model.UserDAO;
import model.User;

public class UserController {

    private UserDAO dao = new UserDAO();

    public void createUser(User u) {
        dao.addUser(u);
    }
}
