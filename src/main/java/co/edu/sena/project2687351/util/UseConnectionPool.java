package co.edu.sena.project2687351.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UseConnectionPool {
    private static Connection getConnection() throws SQLException {
        return  ConnectionPool.getConnection();
    }
    public static void main(String[] args) throws SQLException{
        try (Connection conn = getConnection();
             Statement stmt= conn.createStatement();
             ResultSet rs =stmt.executeQuery("SELECT * FROM Guerreros_Reensabana.VentaResg")){
            while(rs.next()){
                System.out.print(rs.getInt("Serial_Llanta"));
                System.out.print(" | ");
                System.out.print(rs.getInt("Id_Venta"));
            }
        }
    }
}

