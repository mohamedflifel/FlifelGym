
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDb {
    private static final String DB_NAME = "salle"; // used only insde this class
    private static final String URL = "jdbc:mysql://localhost:3306/"+ DB_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = "Flif2l123@2510";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}   