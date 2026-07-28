package view;

import controller.LoginController;
import java.awt.*;
import model.User;
import javax.swing.*;

public class LoginForm extends JFrame {

    private JTextField txtUser = new JTextField();
    private JPasswordField txtPass = new JPasswordField();
    private JButton btnLogin = new JButton("Login");

    private LoginController controller = new LoginController();

    public LoginForm() {
        setTitle("Cuppabliss 40");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel title = new JLabel("---Cuppabliss 40---");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setBounds(80, 20, 240, 30);

        JLabel l1 = new JLabel("Username");
        JLabel l2 = new JLabel("Password");

        l1.setBounds(60, 80, 100, 25);
        l2.setBounds(60, 120, 100, 25);

        txtUser.setBounds(160, 80, 160, 30);
        txtPass.setBounds(160, 120, 160, 30);

        btnLogin.setBounds(120, 180, 120, 35);

        panel.add(title);
        panel.add(l1);
        panel.add(txtUser);
        panel.add(l2);
        panel.add(txtPass);
        panel.add(btnLogin);

        add(panel);

        btnLogin.addActionListener(e -> login());
        txtUser.addActionListener(e -> login());
        txtPass.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {
        String username = txtUser.getText().trim();
        String password = new String(txtPass.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter username and password", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        User user = controller.authenticate(username, password);

        if (user == null || user.getRole() == null || user.getRole().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid login or role not set", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Welcome " + user.getUsername());

        if (user.getRole().equalsIgnoreCase("Manager")) {
            new DashboardManager().setVisible(true);
        } else {
            new DashboardBarista().setVisible(true);
        }

        dispose();
    }
}
