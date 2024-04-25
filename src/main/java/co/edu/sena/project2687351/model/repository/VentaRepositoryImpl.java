package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Venta;
import co.edu.sena.project2687351.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaRepositoryImpl implements Repository<Venta> {
    private String sql =null;
    public List<Venta> listAllObj() throws SQLException {
        sql = "select IdDetalleVenta,PrecioDetalleVenta,fecha_Inicio, fecha_Fin_garantia, IdLlanta,  IdUsuario, c.Nombre,  DescripcionVenta from Venta as v inner join cliente as c on v.idCliente=c.Documento inner join  usuario as U on U.Documento=v.IdUsuario";
        List<Venta> ventas = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Venta s = createObj(rs);
                ventas.add(s);
            }
        }
        return ventas;
    }

    @Override
    public Venta byIdObj(Integer id) throws SQLException {
        sql = "select IdDetalleVenta,PrecioDetalleVenta,fecha_Inicio, fecha_Fin_garantia, IdLlanta,  IdUsuario, c.Nombre,  DescripcionVenta from Venta as v inner join cliente as c on v.idCliente=c.Documento inner join  usuario as U on U.Documento=v.IdUsuario  where IdDetalleVenta=?";
        Venta venta = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    venta = createObj(rs);
                }
            }
        }
        return venta;
    }

    @Override
    public Integer saveObj(Venta venta) throws SQLException {
        int rowsAffected = 0;
        if(venta.getIdVenta() != null && venta.getIdVenta() > 0) {
            sql = "update Venta set PrecioDetalleVenta=?, fecha_Inicio =?,fecha_Fin_garantia =?,IdLlanta=?,  IdUsuario=?, IdCliente=?, DescripcionVenta=?  where  IdDetalleVenta=? ";
        }
        else{
            sql= "insert into Venta (PrecioDetalleVenta, fecha_Inicio, fecha_Fin_garantia, IdLlanta, IdUsuario, IdCliente,  DescripcionVenta) values ((?),(?),(?),(?),(?),(?),(?)) ";

        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setDouble(1, venta.getPrecioDetalleVenta());
            ps.setDate(2, (Date) venta.getFechaInicio());
            ps.setDate(3, (Date) venta.getFechaFin());
            ps.setInt(4, venta.getIdLlanta());
            ps.setInt(5, venta.getIdUsuario());
            ps.setString(6,  venta.getIdCliente());
            ps.setString(7, venta.getDescripcionVenta());

            if(venta.getIdVenta() != null && venta.getIdVenta() > 0){
                ps.setInt(8, venta.getIdVenta());
            }

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from Venta where  IdDetalleVenta=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.execute();
        }
    }
    @Override
    public Venta createObj(ResultSet rs) throws SQLException {
        Venta venta = new Venta();
        venta.setIdVenta(rs.getInt("IdDetalleVenta"));
        venta.setPrecioDetalleVenta(rs.getDouble("PrecioDetalleVenta"));
        venta.setFechaInicio(rs.getDate("fecha_Inicio"));
        venta.setFechaFin(rs.getDate("fecha_Fin_garantia"));
        venta.setIdLlanta(rs.getInt("IdLlanta"));
        venta.setIdUsuario(rs.getInt("IdUsuario"));
        venta.setIdCliente(rs.getString("Nombre"));
        venta.setDescripcionVenta(rs.getString("DescripcionVenta"));

        return venta;
    }
}


