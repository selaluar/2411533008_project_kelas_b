package Gui;

import DAO.ParkirRepo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DataParkirFrame extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private ParkirRepo repo = new ParkirRepo();

    public DataParkirFrame() {
        setTitle("Data Parkir");
        setSize(600, 300);

        model = new DefaultTableModel(
                new String[]{"ID","Plat","Jenis","Masuk","Keluar","Tarif"},0);

        table = new JTable(model);
        load();

        JButton btnHapus = new JButton("Hapus");
        btnHapus.addActionListener(e -> hapus());

        add(new JScrollPane(table), "Center");
        add(btnHapus, "South");
    }

    private void load() {
        model.setRowCount(0);
        for (Object[] o : repo.findAll()) {
            model.addRow(o);
        }
    }

    private void hapus() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            int id = (int) model.getValueAt(row, 0);
            repo.delete(id);
            load();
        }
    }
}
