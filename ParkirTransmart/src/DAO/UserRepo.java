package DAO;

import config.Database;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepo implements UserDAO {

    @Override
    public void register(User user) {
        try {
            String sql = "INSERT INTO users(username, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps =
                    Database.getInstance().getConnection().prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());

            ps.executeUpdate();

        } catch (Exception e) {
            // username duplicate
            throw new RuntimeException("Username sudah terdaftar");
        }
    }

    @Override
    public User login(String username, String password) {
        try {
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps =
                    Database.getInstance().getConnection().prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // login gagal
    }
}
