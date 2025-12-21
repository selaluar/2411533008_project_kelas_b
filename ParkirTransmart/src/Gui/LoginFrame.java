package Gui;


import service.AuthService;

import javax.swing.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private AuthService authService = new AuthService();

    public LoginFrame() {
        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        p.add(new JLabel("Username"));
        txtUsername = new JTextField();
        p.add(txtUsername);

        p.add(new JLabel("Password"));
        txtPassword = new JPasswordField();
        p.add(txtPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> login());

        p.add(btnLogin);
        add(p);
    }

    private void login() {
        try {
            authService.login(
                    txtUsername.getText(),
                    new String(txtPassword.getPassword())
            );

            JOptionPane.showMessageDialog(this, "Login berhasil");
            new DashboardFrame().setVisible(true);
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
