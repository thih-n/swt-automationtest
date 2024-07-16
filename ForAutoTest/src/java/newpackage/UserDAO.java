package newpackage;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO extends DBcontext1 {

    public void insertUser(String fullName, String gender, String hobbies, String job, String username, String password, String email, String phoneNumber) throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is null");
        }

        String sql = "INSERT INTO users (full_name, gender, hobbies, job, username, password, email, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, fullName);
            ps.setString(2, gender);
            ps.setString(3, hobbies);
            ps.setString(4, job);
            ps.setString(5, username);
            ps.setString(6, password);
            ps.setString(7, email);
            ps.setString(8, phoneNumber);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("No rows affected, insertion failed");
            }
        } catch (SQLException ex) {
            throw new SQLException("Error inserting user: " + ex.getMessage(), ex);
        }
    }
}
