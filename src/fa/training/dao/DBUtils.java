package fa.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/EmployeesManagement";
            String username = "root";
            String password = "toilamanh123";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
