package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Usuario;
import co.edu.sena.project2687351.model.Vehiculo;

import co.edu.sena.project2687351.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculoRepositoryImpl implements Repository<Vehiculo>{
    private String sql =null;
    public List<Vehiculo> listAllObj() throws SQLException {
        sql = "select Placa,Marca, Modelo, Tipo, Kilometraje,NumeroLLantas,Linea, IdCliente" + " from vehiculo ";
        List<Vehiculo> vehiculo = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vehiculo v = createObj(rs);
                vehiculo.add(v);
            }
        }
        return vehiculo;
    }


    @Override
    public Vehiculo byIdObj(Integer id) throws SQLException {
        sql = "select Placa,Marca, Modelo, Tipo, Kilometraje,NumeroLLantas,Linea, IdCliente from vehiculo where IdVehiculo=?";
        Vehiculo vehiculo = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    vehiculo = createObj(rs);
                }
            }
        }
        return vehiculo;
    }
    public List<Vehiculo> byIdObjf(String id) throws SQLException {
        sql = "select Placa,Marca, Modelo, Tipo, Kilometraje,NumeroLLantas,Linea, IdCliente from vehiculo where IdCliente=?";
        List<Vehiculo> vehiculos = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, id);
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    Vehiculo v = createObj(rs);
                    vehiculos.add(v);
                }
            }
        }
        return vehiculos;
    }
    @Override
    public Integer saveObj(Vehiculo vehiculo) throws SQLException {
        int rowsAffected = 0;
        if(vehiculo.getIdVehiculo() != null && vehiculo.getIdVehiculo() > 0) {
            sql = "update vehiculo set Placa=?, Marca =?,Modelo =?,Tipo=?, Kilometraje=?, NumeroLLantas=?,Linea=?,IdCliente=?  where  IdVehiculo=? ";
        }
        else{
            sql= "insert into vehiculo (Placa,Marca,Modelo,Tipo, Kilometraje, NumeroLLantas,Linea,IdCliente) values ((?),(?),(?),(?),(?),(?),(?),(?))";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setString(4, vehiculo.getTipo());
            ps.setDouble(5, vehiculo.getKiometraje());
            ps.setInt(6, vehiculo.getNum_Llantas());
            ps.setString(7, vehiculo.getLinea());
            ps.setString(8, vehiculo.getIdCliente());

            if(vehiculo.getIdVehiculo() != null && vehiculo.getIdVehiculo() > 0){
                ps.setInt(9,vehiculo.getIdVehiculo());
            }

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from vehiculo where  IdVehiculo=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.execute();
        }
    }
    @Override
    public Vehiculo createObj(ResultSet rs) throws SQLException {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPlaca(rs.getString("Placa"));
        vehiculo.setMarca(rs.getString("Marca"));
        vehiculo.setModelo(rs.getString("Modelo"));
        vehiculo.setTipo(rs.getString("Tipo"));
        vehiculo.setKiometraje(rs.getDouble("Kilometraje"));
        vehiculo.setNum_Llantas(rs.getInt("NumeroLLantas"));
        vehiculo.setLinea(rs.getString("Linea"));
        vehiculo.setIdCliente(rs.getString("IdCliente"));

        return vehiculo;
    }
    public Vehiculo byIdObjs(String id) throws SQLException {
        sql = "select Placa,Marca, Modelo, Tipo, Kilometraje,NumeroLLantas,Linea, IdCliente from vehiculo where Placa=?";
        Vehiculo vehiculo = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    vehiculo = createObj(rs);
                }
            }
        }
        return vehiculo;
    }
    public Integer insertVehiculo(Vehiculo vehiculo) throws SQLException {
        int rowsAffected = 0;
        sql= "insert into vehiculo (Placa,Marca,Modelo,Tipo, Kilometraje, NumeroLLantas,Linea,IdCliente) values ((?),(?),(?),(?),(?),(?),(?),(?))";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getMarca());
            ps.setString(3, vehiculo.getModelo());
            ps.setString(4, vehiculo.getTipo());
            ps.setDouble(5, vehiculo.getKiometraje());
            ps.setInt(6, vehiculo.getNum_Llantas());
            ps.setString(7, vehiculo.getLinea());
            ps.setString(8, vehiculo.getIdCliente());
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }

    public Integer updateVehiculo(Vehiculo vehiculo) throws SQLException {
        int rowsAffected = 0;
        sql = "update vehiculo set  Marca =?,Modelo =?,Tipo=?, Kilometraje=?, NumeroLLantas=?,Linea=?,IdCliente=?  where  Placa=? ";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getTipo());
            ps.setDouble(4, vehiculo.getKiometraje());
            ps.setInt(5, vehiculo.getNum_Llantas());
            ps.setString(6, vehiculo.getLinea());
            ps.setString(7, vehiculo.getIdCliente());
            ps.setString(8, vehiculo.getPlaca());
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }
    public void deleteObjs(String id) throws SQLException {
        sql= "delete from vehiculo where  Placa=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, id);
            ps.execute();
        }
    }
}
