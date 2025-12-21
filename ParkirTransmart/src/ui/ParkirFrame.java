package ui;


import model.Parkir;
import service.ParkirService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalTime;

public class ParkirFrame extends JFrame {

    private JTextField txtPlat, txtMasuk, txtKeluar;
    private JComboBox<String> cbJenis;
    private JLabel lblTarif;
    private JTable table;
    private DefaultTableModel model;

    private ParkirService service = new ParkirService();

    public ParkirFrame() {
        setTitle("Input Parkir");
        setSize(600, 400);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel form = new JPanel(new GridLayout(6, 2, 5, 5));

        form.add(new JLabel("Plat Nomor"));
        txtPlat = new JTextField();
        form.add(txtPlat);

        form.add(new JLabel("Jenis Kendaraan"));
        cbJenis = new JComboBox<>(new String[]{"Mobil", "Motor"});
        form.add(cbJenis);

        form.add(new JLabel("Jam Masuk (HH:mm)"));
        txtMasuk = new JTextField();
        form.add(txtMasuk);

        form.add(new JLabel("Jam Keluar (HH:mm)"));
        txtKeluar = new JTextField();
        form.add(txtKeluar);

        form.add(new JLabel("Total Tarif"));
        lblTarif = new JLabel("Rp 0");
        form.add(lblTarif);

        JButton btnHitung = new JButton("Hitung Tarif");
        JButton btnSimpan = new JButton("Simpan");

        btnHitung.addActionListener(e -> hitungTarif());
        btnSimpan.addActionListener(e -> simpan());

        form.add(btnHitung);
        form.add(btnSimpan);

        // ===== TABLE =====
        model = new DefaultTableModel(
                new String[]{"Plat", "Jenis", "Tarif"}, 0
        );
        table = new JTable(model);

        JPanel main = new JPanel(new BorderLayout());
        main.add(form, BorderLayout.NORTH);
        main.add(new JScrollPane(table), BorderLayout.CENTER);

        add(main);
    }

    // ================= HITUNG TARIF =================
    private void hitungTarif() {
        try {
            Parkir p = service.hitungTarif(
                    txtPlat.getText(),
                    cbJenis.getSelectedItem().toString(),
                    LocalTime.parse(txtMasuk.getText()),
                    LocalTime.parse(txtKeluar.getText())
            );

            lblTarif.setText("Rp " + p.getTarif());

            model.addRow(new Object[]{
                    p.getPlat(),
                    p.getJenis(),
                    p.getTarif()
            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // ================= SIMPAN =================
    private void simpan() {
        try {
            service.simpanParkir();
            JOptionPane.showMessageDialog(this, "Data parkir berhasil disimpan");
            resetForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void resetForm() {
        txtPlat.setText("");
        txtMasuk.setText("");
        txtKeluar.setText("");
        lblTarif.setText("Rp 0");
    }
}
