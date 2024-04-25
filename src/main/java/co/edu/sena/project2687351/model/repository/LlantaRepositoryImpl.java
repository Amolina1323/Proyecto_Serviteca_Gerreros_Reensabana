package co.edu.sena.project2687351.model.repository;

import co.edu.sena.project2687351.model.Llanta;
import co.edu.sena.project2687351.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LlantaRepositoryImpl implements Repository<Llanta>{
    private String sql=null;
    @Override
    public List<Llanta> listAllObj() throws SQLException {
        sql="select IdLlanta, Marca, Tipo, Modelo, Dimension,Diseño,FechaLlanta,ProfundidadLlanta" +
                " from llanta ";
        List<Llanta> llanta =new ArrayList<>();
        try(Connection conn= ConnectionPool.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()){
                Llanta u = createObj(rs);
                llanta.add(u);
            }
        }
        return llanta;
    }

    @Override
    public Llanta byIdObj(Integer id) throws SQLException {
        sql = "select IdLlanta, Marca, Tipo, Modelo, Dimension,Diseño,FechaLlanta,ProfundidadLlanta"+
                " from llanta  where IdLlanta= ? ";
        Llanta llanta = null;

        try (Connection conn= ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    llanta = createObj(rs);
                }
            }
        }
        return llanta;
    }
    @Override
    public Integer saveObj(Llanta llanta) throws SQLException {
        int rowsAffected = 0;
        if(llanta.getIdLlanta() !=null && llanta.getIdLlanta()>0){
            sql = "update llanta set Marca = ?, Tipo = ?, Modelo = ?, Dimension = ?, Diseño = ?, FechaLlanta = ?,ProfundidadLlanta = ?" +
                    " WHERE IdLlanta = ?";
        }else {
            sql = "insert into llanta (Marca, Tipo, Modelo, Dimension,Diseño,FechaLlanta,ProfundidadLlanta)"+
                    "values ((?),(?),(?),(?),(?),(?),(?))";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, llanta.getMarca());
            ps.setString(2, llanta.getTipo());
            ps.setInt(3, llanta.getModelo());
            ps.setString(4, llanta.getDimension());
            ps.setString(5, llanta.getDiseno());
            ps.setDate(6, (Date) llanta.getFechaLlanta());
            ps.setDouble(7, llanta.getProfundidadLlanta());

            if (llanta.getIdLlanta() !=null && llanta.getIdLlanta()>0){
                ps.setInt(8, llanta.getIdLlanta());
            }
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from llanta where IdLlanta=?";
        try(Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
    }

    @Override
    public Llanta createObj(ResultSet rs) throws SQLException {
        Llanta llanta = new Llanta();
        llanta.setIdLlanta(rs.getInt("IdLlanta"));
        llanta.setMarca(rs.getString("Marca"));
        llanta.setTipo(rs.getString("Tipo"));
        llanta.setModelo(rs.getInt("Modelo"));
        llanta.setDimension(rs.getString("Dimension"));
        llanta.setDiseno(rs.getString("Diseño"));
        llanta.setFechaLlanta(rs.getDate("FechaLlanta"));
        llanta.setProfundidadLlanta(rs.getDouble("ProfundidadLlanta"));
        return llanta;
    }
}
