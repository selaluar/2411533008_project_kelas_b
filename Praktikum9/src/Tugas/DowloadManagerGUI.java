package Tugas;

import javax.swing.*;
import java.awt.*;

public class DowloadManagerGUI {

   
    private static final Color BLUE = new Color(66, 133, 244);     
    private static final Color LIGHT_GRAY = new Color(218, 220, 224); 
    private static final Color WHITE = Color.WHITE;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DowloadManagerGUI().showUI());
    }

    private void showUI() {
        JFrame frame = new JFrame("Download Manager App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 360);
        frame.setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(WHITE);
        root.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel("Download Manager App", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 0));
        root.add(title, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridBagLayout());
        center.setBackground(WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 10, 12, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel l1 = new JLabel("File 1");
        JLabel l2 = new JLabel("File 2");
        JLabel l3 = new JLabel("File 3");
        l1.setFont(new Font("SansSerif", Font.PLAIN, 14));
        l2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        l3.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JProgressBar bar1 = makeBar();
        JProgressBar bar2 = makeBar();
        JProgressBar bar3 = makeBar();

     
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.1;
        center.add(l1, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.9;
        center.add(bar1, gbc);

    
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.1;
        center.add(l2, gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.9;
        center.add(bar2, gbc);

       
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.1;
        center.add(l3, gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.9;
        center.add(bar3, gbc);

        root.add(center, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        bottom.setBackground(WHITE);

        JButton btn = new JButton("Downloading");
        btn.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btn.setPreferredSize(new Dimension(140, 36));
        bottom.add(btn);
        root.add(bottom, BorderLayout.SOUTH);

        btn.addActionListener(e -> {
            bar1.setValue(0);
            bar2.setValue(0);
            bar3.setValue(0);
            btn.setEnabled(false);

            
            Thread t1 = new Thread(() -> download(bar1, "File-1", 450));
            Thread t2 = new Thread(() -> download(bar2, "File-2", 300));
            Thread t3 = new Thread(() -> download(bar3, "File-3", 650));

            t1.start();
            t2.start();
            t3.start();

            new Thread(() -> {
                try { t1.join(); t2.join(); t3.join(); }
                catch (InterruptedException ex) { ex.printStackTrace(); }

                SwingUtilities.invokeLater(() -> {
                    btn.setEnabled(true);
                    JOptionPane.showMessageDialog(frame,
                            "Semua file selesai diunduh!");
                });
            }).start();
        });

        frame.setContentPane(root);
        frame.setVisible(true);
    }

    private JProgressBar makeBar() {
        JProgressBar bar = new JProgressBar(0, 100);
        bar.setValue(0);
        bar.setStringPainted(false);
        bar.setPreferredSize(new Dimension(460, 22));

       
        bar.setForeground(BLUE);          
        bar.setBackground(LIGHT_GRAY);    
        bar.setOpaque(true);
        bar.setBorder(BorderFactory.createEmptyBorder()); 

        return bar;
    }

    private void download(JProgressBar bar, String filename, int delayMs) {
        for (int p = 10; p <= 100; p += 10) {
            try { Thread.sleep(delayMs); }
            catch (InterruptedException e) { return; }

            int val = p;
            SwingUtilities.invokeLater(() -> bar.setValue(val));
        }
        System.out.println(filename + " selesai diunduh!");
    }
}
