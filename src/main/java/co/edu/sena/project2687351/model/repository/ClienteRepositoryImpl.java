package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Cliente;
import co.edu.sena.project2687351.model.Usuario;
import co.edu.sena.project2687351.util.ConnectionPool;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements Repository<Cliente>{
    private String sql =null;

    @Override
    public List<Cliente> listAllObj() throws SQLException {
        sql="select Nombre,Compania,Documento,Correo,Telefono,Direccion"+" from cliente";
        List<Cliente> clientes = new ArrayList<>();       
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente c = createObj(rs);
                clientes.add(c);
            }
        }
        return clientes;
    }
    public List<Cliente> listAllObjF() throws SQLException {
        sql="select Nombre,Compania,Documento,Correo,Telefono,Direccion  from cliente WHERE Compania='Si' ";
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente c = createObj(rs);
                clientes.add(c);
            }
        }
        return clientes;
    }

    @Override
    public Cliente byIdObj(Integer id) throws SQLException {
        sql = "select IdCliente,Nombre, Compania,Documento,Correo, Telefono, Direccion" + " from cliente  where IdCliente=?";
        Cliente cliente = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    cliente = createObj(rs);
                }
            }
        }
        return cliente;
    }

    @Override
    public Integer saveObj(Cliente cliente) throws SQLException {
        int rowsAffected = 0;
        if(cliente.getIdCliente() != null ) {
            sql = "update cliente set Nombre=?, Compania =?,Documento =?,Correo=?,  Telefono=?, Direccion=? " + " where  IdCliente=? ";
        }
        else{
            sql= "insert into cliente (Nombre, Compania, Documento, Correo, Telefono,  Direccion) values ((?),(?),(?),(?),(?),(?))";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,cliente.getNombre());
            ps.setString(2, cliente.getEmpresa());
            ps.setString(3, cliente.getDocumento());
            ps.setString(4, cliente.getCorreo());
            ps.setInt(5, cliente.getTelefono());
            ps.setString(6, cliente.getDireccion());



            if(cliente.getIdCliente() != null ){
                ps.setString(7,cliente.getIdCliente());
            }

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from cliente where  IdCliente=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.execute();
        }
    }

    @Override
    public Cliente createObj(ResultSet rs) throws SQLException {
        Cliente cliente =new Cliente();
        cliente.setNombre(rs.getString("Nombre"));
        cliente.setEmpresa(rs.getString("Compania"));
        cliente.setDocumento(rs.getString("Documento"));
        cliente.setCorreo(rs.getString("Correo"));
        cliente.setTelefono(rs.getInt("Telefono"));
        cliente.setDireccion(rs.getString("Direccion"));
     return cliente;
    }
    public Cliente byIdObjs(String id) throws SQLException {
        sql = "select Nombre, Compania,Documento,Correo, Telefono, Direccion" + " from cliente  where Documento=?";
        Cliente cliente = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    cliente = createObj(rs);
                }
            }
        }
        return cliente;
    }
    public Integer insertCliente(Cliente cliente) throws SQLException {
        int rowsAffected = 0;
        sql= "insert into cliente (Nombre, Compania, Documento, Correo, Telefono,  Direccion) values ((?),(?),(?),(?),(?),(?))";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,cliente.getNombre());
            ps.setString(2, cliente.getEmpresa());
            ps.setString(3, cliente.getDocumento());
            ps.setString(4, cliente.getCorreo());
            ps.setInt(5, cliente.getTelefono());
            ps.setString(6, cliente.getDireccion());
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }

    public Integer updateCliente(Cliente cliente) throws SQLException {
        int rowsAffected = 0;
        sql = "update cliente set Nombre=?, Compania =?,Correo=?,  Telefono=?, Direccion=? " + " where Documento =? ";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1,cliente.getNombre());
            ps.setString(2, cliente.getEmpresa());
            ps.setString(3, cliente.getCorreo());
            ps.setInt(4, cliente.getTelefono());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getDocumento());
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }
    public void deleteObjs(String id) throws SQLException {
        sql= "delete from cliente where  Documento=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, id);
            ps.execute();
        }
    }
}
