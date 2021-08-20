package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {
    
    private static final String DATABASE_LOCATION = "C:\\Users\\julia\\OneDrive\\Escritorio\\UNIVERSIDAD\\PROGRAMACION\\DOCUMENTOS CICLO 2\\UNIDAD 3\\ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:"+DATABASE_LOCATION;

        return DriverManager.getConnection(url);
    }
}
