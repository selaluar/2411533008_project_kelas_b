package service;

import DAO.UserDAO;
import DAO.UserRepo;
import error.ValidationException;
import model.User;

public class AuthService {

    private final UserDAO userDAO = new UserRepo();

    // ===== REGISTER =====
    public void register(String username, String password) {

        if (username == null || username.isEmpty()) {
            throw new ValidationException("Username wajib diisi");
        }
        if (password == null || password.isEmpty()) {
            throw new ValidationException("Password wajib diisi");
        }

        userDAO.register(new User(username, password, "ADMIN"));
    }

    // ===== LOGIN (BISA ULANG) =====
    public User login(String username, String password) {

        if (username == null || username.isEmpty()) {
            throw new ValidationException("Username wajib diisi");
        }
        if (password == null || password.isEmpty()) {
            throw new ValidationException("Password wajib diisi");
        }

        User user = userDAO.login(username, password);
        if (user == null) {
            throw new ValidationException("Username atau password salah");
        }

        return user; // LOGIN SUKSES
    }
}

