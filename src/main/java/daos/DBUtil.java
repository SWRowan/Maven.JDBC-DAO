package daos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static String username = "root";
    private static String password = "";
    private static String dbURL = "jdbc:mysql://localhost:3306/Car?autoReconnect=true&useSSL=false";

    public static Connection getConnection() throws SQLException {
          Connection connection = DriverManager.getConnection(dbURL, username, password);
        return connection;
    }

    public static void showErrorMessage(SQLException e){
        System.err.println("Error :" + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
    }


}
