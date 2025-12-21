package Gui;

import service.AuthService;

import javax.swing.*;

public class LoginRunner {

    public static void main(String[] args) {

        AuthService authService = new AuthService();

        String username = JOptionPane.showInputDialog(null, "Masukkan Username");
        String password = JOptionPane.showInputDialog(null, "Masukkan Password");

        try {
            authService.login(username, password);

            JOptionPane.showMessageDialog(
                    null,
                    "Login berhasil sebagai: " + username
            );

            // 🔥 SETELAH LOGIN SUKSES, BUKA DASHBOARD / PARKIR
            new DashboardFrame().setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Login gagal: " + e.getMessage()
            );
        }
    }
}
