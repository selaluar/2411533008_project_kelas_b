package Gui;


import javax.swing.*;

import ui.ParkirFrame;

import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {
        setTitle("Dashboard Parkir Transmart");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JLabel title = new JLabel(
                "Dashboard Sistem Parkir Transmart",
                SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnParkir = new JButton("Input Parkir");
        JButton btnLogout = new JButton("Logout");

        btnParkir.addActionListener(e ->
                new ParkirFrame().setVisible(true)
        );

        btnLogout.addActionListener(e -> {
            dispose();
            new RegisterFrame().setVisible(true);
        });

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(title);
        panel.add(btnParkir);
        panel.add(btnLogout);

        add(panel);
    }
}
