package Ui;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Dashboard");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblWelcome = new JLabel("Selamat Datang di LaundryApp");
        lblWelcome.setBounds(30,70,250,30);
        add(lblWelcome);
    }
}
