package model;

import model.User;
import view.DashboardManager;

public class Manager extends User {

    public Manager(String username, String password) {
        super(username, password, "Manager");
    }

    @Override
    public void openDashboard() {
        new DashboardManager().setVisible(true);
    }
}
