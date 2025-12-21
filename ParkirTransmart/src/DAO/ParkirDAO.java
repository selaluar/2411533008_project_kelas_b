package DAO;

import model.Parkir;
import java.util.List;

public interface ParkirDAO {
    void save(Parkir p);
    void update(int id, Parkir p);
    void delete(int id);
    List<Object[]> findAll();
}
