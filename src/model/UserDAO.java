package model;

import database.*;
import model.User;
import java.sql.*;

public class UserDAO {

    public User login(String username, String password) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(rs.getString("username"), rs.getString("role"), true) {
                    @Override
                    public void openDashboard() {
                    }

                };

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(User user) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO users(username, password, role) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
