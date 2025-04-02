package MVC.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/konoha_db";
    private static final String USER = "root";
    private static final String PASSWORD = "campus2023";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection (URL, USER, PASSWORD);
    }
    
}
