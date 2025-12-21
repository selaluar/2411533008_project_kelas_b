package table;

import javax.swing.table.DefaultTableModel;

public class TableParkir extends DefaultTableModel {

    public TableParkir() {
        super(new String[]{"Plat", "Jenis", "Tarif"}, 0);
    }

    @Override
    public boolean isCellEditable(int r, int c) {
        return false;
    }
}
