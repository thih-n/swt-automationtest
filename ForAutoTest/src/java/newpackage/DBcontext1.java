package newpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcontext1 {
    protected Connection connection;

    public DBcontext1() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://NguyenDucThinh\\SQLEXPRESS:9803;databaseName=user_data;encrypt=false;trustServerCertificate=true";
            String username = "thinh1";
            String pass = "123";
            this.connection = DriverManager.getConnection(url, username, pass);
            if (this.connection != null) {
                System.out.println("Connection to database established successfully!");
            } else {
                System.out.println("Failed to establish connection to the database.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DBcontext1();
    }
}
