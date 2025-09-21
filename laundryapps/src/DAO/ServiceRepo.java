package DAO;

import confg.Database;
import model.Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceRepo implements ServiceDAO {

    private final Connection connection;
    private static final String INSERT = "INSERT INTO service (id, jenis, harga, status) VALUES (?,?,?,?)";
    private static final String SELECT = "SELECT * FROM service";
    private static final String UPDATE = "UPDATE service SET jenis=?, harga=?, status=? WHERE id=?";
    private static final String DELETE = "DELETE FROM service WHERE id=?";

    public ServiceRepo() {
        connection = Database.koneksi();
    }

    @Override
    public void save(Service service) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(INSERT);
            st.setString(1, service.getId());
            st.setString(2, service.getJenis());
            st.setDouble(3, service.getHarga());
            st.setString(4, service.getStatus());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Service> show() {
        List<Service> list = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(SELECT);
            while (rs.next()) {
                Service service = new Service();
                service.setId(rs.getString("id"));
                service.setJenis(rs.getString("jenis"));
                service.setHarga(rs.getDouble("harga"));
                service.setStatus(rs.getString("status"));
                list.add(service);
            }
        } catch (SQLException e) {
            Logger.getLogger(ServiceRepo.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public void update(Service service) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(UPDATE);
            st.setString(1, service.getJenis());
            st.setDouble(2, service.getHarga());
            st.setString(3, service.getStatus());
            st.setString(4, service.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String id) {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(DELETE);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}