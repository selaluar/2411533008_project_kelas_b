package DAO;

import model.User;

public interface UserDAO {

    // register hanya untuk DAFTAR (sekali)
    void register(User user);

    // login BOLEH DIPANGGIL BERKALI-KALI
    User login(String username, String password);
}
