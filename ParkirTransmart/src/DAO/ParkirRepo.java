package DAO;

import config.Database;
import model.Parkir;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ParkirRepo implements ParkirDAO {

    @Override
    public void save(Parkir p) {
        try {
            String sql = "INSERT INTO parkir(plat, jenis, masuk, keluar, tarif) VALUES (?,?,?,?,?)";
            PreparedStatement ps =
                    Database.getInstance().getConnection().prepareStatement(sql);

            ps.setString(1, p.getPlat());
            ps.setString(2, p.getJenis());
            ps.setString(3, p.getMasuk().toString());
            ps.setString(4, p.getKeluar().toString());
            ps.setInt(5, p.getTarif());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Parkir p) {
        try {
            String sql = "UPDATE parkir SET masuk=?, keluar=?, tarif=? WHERE id=?";
            PreparedStatement ps =
                    Database.getInstance().getConnection().prepareStatement(sql);

            ps.setString(1, p.getMasuk().toString());
            ps.setString(2, p.getKeluar().toString());
            ps.setInt(3, p.getTarif());
            ps.setInt(4, id); // 🔥 INI YANG KURANG DI KODE KAMU

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM parkir WHERE id=?";
            PreparedStatement ps =
                    Database.getInstance().getConnection().prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Object[]> findAll() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = Database.getInstance().getConnection()
                    .createStatement().executeQuery("SELECT * FROM parkir");

            while (rs.next()) {
                list.add(new Object[]{
                        rs.getInt("id"),
                        rs.getString("plat"),
                        rs.getString("jenis"),
                        rs.getString("masuk"),
                        rs.getString("keluar"),
                        rs.getInt("tarif")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
