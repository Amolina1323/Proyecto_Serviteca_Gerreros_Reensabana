package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Rol;
import co.edu.sena.project2687351.util.ConnectionPool;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolRepositoryImpl implements Repository<Rol>{
    private String sql = null;

    @Override
    public List<Rol> listAllObj() throws SQLException {
        sql="select IdRol,NombreRol from rol ";
        List<Rol> rol = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Rol r = createObj(rs);
                rol.add(r);
            }
        }
        return rol;
    }

    @Override
    public Rol byIdObj(Integer id) throws SQLException {
        sql = "select NombreRol " + "from rol  where IdRol=?";
        Rol rol = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    rol = createObj(rs);
                }
            }
        }
        return rol;
    }

    @Override
    public Integer saveObj(Rol rol) throws SQLException {
        int rowsAffected = 0;
        if(rol.getIdRol() != null && rol.getIdRol() > 0) {
            sql = "update rol set NombreRol=?" + " where  IdRol=? ";
        }
        else{
            sql= "insert into rol (NombreRol) values ((?))";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,rol.getNombreRol());


            if(rol.getIdRol() != null && rol.getIdRol() > 0){
                ps.setInt(2,rol.getIdRol());
            }

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from rol where  IdRol=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.execute();
        }
    }

    @Override
    public Rol createObj(ResultSet rs) throws SQLException {
        Rol rol = new Rol();
        rol.setIdRol(rs.getInt("IdRol"));
        rol.setNombreRol(rs.getString("NombreRol"));

        return rol;
    }
}
