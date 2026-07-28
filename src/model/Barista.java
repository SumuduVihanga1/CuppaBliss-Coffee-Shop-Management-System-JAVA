package model;

import model.User;
import view.DashboardBarista;

public class Barista extends User {

    public Barista(String username, String password) {
        super(username, password, "Barista");
    }

    @Override
    public void openDashboard() {
        new DashboardBarista().setVisible(true);
    }
}
