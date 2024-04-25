package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.DServicio;
import co.edu.sena.project2687351.model.Venta;
import co.edu.sena.project2687351.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DServicioRepositoryImpl implements Repository<DServicio> {
    private String sql =null;
    public List<DServicio> listAllObj() throws SQLException {
        sql = "select IdDetalleServicio,PrecioDetalleServicio,Fecha, IdVehiculo, IdServicio,  IdUsuario, DescripcionServicio from detalleServicio ";
        List<DServicio> dServicio = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                DServicio s = createObj(rs);
                dServicio.add(s);
            }
        }
        return dServicio;
    }

    public DServicio byIdObj(Integer id) throws SQLException {
        sql = "select IdDetalleServicio,PrecioDetalleServicio,Fecha, IdVehiculo, IdServicio,  IdUsuario, DescripcionServicio " + "from detalleServicio  where IdDetalleServicio=?";
        DServicio dServicio = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    dServicio = createObj(rs);
                }
            }
        }
        return dServicio;
    }
    public List<DServicio>  byIdObjV(String id) throws SQLException {
        sql = "select IdDetalleServicio,PrecioDetalleServicio,Fecha, IdVehiculo, IdServicio,  IdUsuario, DescripcionServicio " + "from detalleServicio  where IdVehiculo=?";
        List<DServicio> dServicios = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, id);
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    DServicio s = createObj(rs);
                    dServicios.add(s);
                }
            }
        }
        return dServicios;
    }

    @Override
    public Integer saveObj(DServicio dServicio) throws SQLException {
        int rowsAffected = 0;
        if(dServicio.getIdDetalleServicio() != null && dServicio.getIdDetalleServicio() > 0) {
            sql = "update detalleServicio set PrecioDetalleServicio=?, Fecha =?,IdVehiculo =?,IdServicio=?,  IdUsuario=?, DescripcionServicio=? " + " where  IdDetalleServicio=? ";
        }
        else{
            sql= "insert into detalleServicio (PrecioDetalleServicio, Fecha, IdVehiculo, IdServicio, IdUsuario, DescripcionServicio) values ((?),(?),(?),(?),(?),(?))";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setDouble(1, dServicio.getPrecioDetalleServicio());
            ps.setDate(2, (Date) dServicio.getFecha());
            ps.setString(3, dServicio.getIdVehiculo());
            ps.setInt(4, dServicio.getIdServicio());
            ps.setInt(5,  dServicio.getIdUsuario());
            ps.setString(6, dServicio.getDescripcionServicio());

            if(dServicio.getIdDetalleServicio() != null && dServicio.getIdDetalleServicio() > 0){
                ps.setInt(7, dServicio.getIdDetalleServicio());
            }

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from detalleServicio where  IdDetalleServicio=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.execute();
        }
    }
    @Override
    public DServicio createObj(ResultSet rs) throws SQLException {
        DServicio dServicio = new DServicio();
        dServicio.setIdDetalleServicio(rs.getInt("IdDetalleServicio"));
        dServicio.setPrecioDetalleServicio(rs.getDouble("PrecioDetalleServicio"));
        dServicio.setFecha(rs.getDate("Fecha"));
        dServicio.setIdVehiculo(rs.getString("IdVehiculo"));
        dServicio.setIdServicio(rs.getInt("IdServicio"));
        dServicio.setIdUsuario(rs.getInt("IdUsuario"));
        dServicio.setDescripcionServicio(rs.getString("DescripcionServicio"));

        return dServicio;
    }
}


