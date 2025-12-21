package Gui;

import service.AuthService;

import javax.swing.*;

public class RegisterFrame extends JFrame {

    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private AuthService authService = new AuthService();

    public RegisterFrame() {
        setTitle("Register User");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Username"));
        txtUsername = new JTextField();
        panel.add(txtUsername);

        panel.add(new JLabel("Password"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(e -> register());

        panel.add(Box.createVerticalStrut(10));
        panel.add(btnRegister);

        add(panel);
    }

    private void register() {
        try {
            authService.register(
                    txtUsername.getText(),
                    new String(txtPassword.getPassword())
            );

            JOptionPane.showMessageDialog(this, "Register berhasil!");

            // 🔥 MASUK DASHBOARD
            new DashboardFrame().setVisible(true);
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
