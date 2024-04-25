package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Services;
import co.edu.sena.project2687351.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicesRepositoryImpl implements Repository<Services> {
    private String sql =null;
    public List<Services> listAllObj() throws SQLException {
        sql = "select IdServicio, NombreServicio, Estado, PrecioServicioLiviano, PrecioServicioMediano,PrecioServicioPesado,DescripcionServicio" + " from servicio ";
        List<Services> services = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Services a = createObj(rs);
                services.add(a);
            }
        }
        return services;
    }
    @Override
    public Services byIdObj(Integer id) throws SQLException {
        sql = "select IdServicio, NombreServicio, Estado, PrecioServicioLiviano, PrecioServicioMediano,PrecioServicioPesado,DescripcionServicio " + "from servicio  where IdServicio=? ";
        Services services = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    services = createObj(rs);
                }
            }
        }
        return services;
    }

    @Override
    public Integer saveObj(Services services) throws SQLException {
        int rowsAffected = 0;
        if(services.getIdServicio() != null && services.getIdServicio() > 0) {
            sql = "update servicio set  NombreServicio =?,  Estado=?, PrecioServicioLiviano=?, PrecioServicioMediano=?,PrecioServicioPesado=?,DescripcionServicio=?" + " where  IdServicio =?";
        }
        else{
            sql= "insert into servicio (NombreServicio,  Estado, PrecioServicioLiviano, PrecioServicioMediano,PrecioServicioPesado,DescripcionServicio) values ((?),(?),(?),(?),(?),(?))";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, services.getNombreServicio());
            ps.setString(2, services.getEstado());
            ps.setDouble(3, services.getPrecioServicioLiviano());
            ps.setDouble(4, services.getPrecioServicioMediano());
            ps.setDouble(5, services.getPrecioServicioPesado());
            ps.setString(6, services.getDescripcionServicio());
            if(services.getIdServicio() != null && services.getIdServicio() > 0){
                ps.setInt(7, services.getIdServicio());
            }

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from servicio where IdServicio=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.execute();
        }
    }
    @Override
    public Services createObj(ResultSet rs) throws SQLException {
        Services services = new Services();
        services.setIdServicio(rs.getInt("IdServicio"));
        services.setNombreServicio(rs.getString("NombreServicio"));
        services.setEstado(rs.getString("Estado"));
        services.setPrecioServicioLiviano(rs.getDouble("PrecioServicioLiviano"));
        services.setPrecioServicioMediano(rs.getDouble("PrecioServicioMediano"));
        services.setPrecioServicioPesado(rs.getDouble("PrecioServicioPesado"));
        services.setDescripcionServicio(rs.getString("DescripcionServicio"));
        return services;
    }
}


