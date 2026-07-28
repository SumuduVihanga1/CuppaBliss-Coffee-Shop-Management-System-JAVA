package view;

import javax.swing.*;
import controller.UserController;
import java.awt.*;
import model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Barista;
import model.Manager;

public class CreateUserView extends JFrame {

    JTextField txtUser = new JTextField();
    JPasswordField txtPass = new JPasswordField();
    JComboBox<String> cmbRole = new JComboBox<>(new String[]{"Manager", "Barista"});

    JButton btnCreate = new JButton("Create User");
    JButton btnBack = new JButton("Back");

    UserController controller = new UserController();

    public CreateUserView() {
        setTitle("Create User Account");
        setSize(400, 320);
        setLayout(null);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 400, 320);

        JLabel title = new JLabel("Create User Account");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setBounds(80, 20, 240, 30);

        JLabel l1 = new JLabel("Username");
        JLabel l2 = new JLabel("Password");
        JLabel l3 = new JLabel("Role");

        l1.setBounds(70, 80, 100, 25);
        txtUser.setBounds(170, 80, 160, 30);

        l2.setBounds(70, 125, 100, 25);
        txtPass.setBounds(170, 125, 160, 30);

        l3.setBounds(70, 170, 100, 25);
        cmbRole.setBounds(170, 170, 160, 30);

        btnCreate.setBounds(70, 225, 120, 35);
        btnBack.setBounds(210, 225, 120, 35);

        panel.add(title);
        panel.add(l1);
        panel.add(txtUser);
        panel.add(l2);
        panel.add(txtPass);
        panel.add(l3);
        panel.add(cmbRole);
        panel.add(btnCreate);
        panel.add(btnBack);

        add(panel);

        btnBack.addActionListener(e -> this.dispose());

        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createUser();
            }
        });
        setVisible(true);

    }

    private void createUser() {
        String username = txtUser.getText().trim();
        String password = new String(txtPass.getPassword()).trim();
        String role = cmbRole.getSelectedItem().toString();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Username and password cannot be empty",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        User u = null;

        switch (role) {
            case "Manager":
                u = new Manager(username, password);
                break;
            case "Barista":
                u = new Barista(username, password);
                break;
        }

        controller.createUser(u);
        JOptionPane.showMessageDialog(this, "User Created Successfully");

        txtUser.setText("");
        txtPass.setText("");
        cmbRole.setSelectedIndex(0);
    }

}
