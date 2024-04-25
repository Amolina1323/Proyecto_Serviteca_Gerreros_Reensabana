package co.edu.sena.project2687351.model.repository;


import co.edu.sena.project2687351.model.Usuario;
import co.edu.sena.project2687351.util.ConnectionPool;
import jakarta.servlet.http.HttpSession;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImpl implements Repository<Usuario> {
    private String sql =null;

    public List<Usuario> listAllObj() throws SQLException {
        sql = "select Nombre,apellido, Contraseña, Documento, Telefono,Correo,Direccion, NombreRol from usuario as U inner join  rol as r on U.IdRol=r.IdRol ";
        List<Usuario> usuario = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario U = createObj(rs);
                usuario.add(U);
            }
        }
        return usuario;
    }

    @Override
    public Usuario byIdObj(Integer id) throws SQLException {
        sql = "select Nombre,apellido, Contraseña, Documento, Telefono,Correo,Direccion, NombreRol from usuario as U inner join  rol as r on U.IdRol=r.IdRol where Documento=?";
        Usuario usuario = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    usuario = createObj(rs);
                }
            }
        }
        return usuario;
    }

    @Override
    public Integer saveObj(Usuario usuario) throws SQLException {
        int rowsAffected = 0;
        if(usuario.getDocumento() != null ) {
            sql = "update usuario set  Nombre=?, apellido =?, Contraseña =?, Telefono=?, Correo=?, Direccion=?, IdRol=?  where  Documento=?";
            System.out.println("Actualizacion");
        }
        else{
            sql= "insert into usuario ( Nombre, Documento,  Contraseña, apellido, Telefono, Correo, Direccion, IdRol) values ((?),(?),(?),(?),(?),(?),(?),(?))";
            System.out.println("Insercion");
       }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            if (usuario.getDocumento() != null ) {
                ps.setString(1, usuario.getNombre());
                ps.setString(2, usuario.getApellido());
                ps.setString(3, usuario.getContrasena());
                ps.setInt(4, usuario.getTelefono());
                ps.setString(5, usuario.getCorreo());
                ps.setString(6, usuario.getDireccion());
                ps.setString(7, usuario.getRol());
                ps.setInt(8, usuario.getDocumento());
            } else {

                ps.setString(1, usuario.getNombre());
                ps.setInt(2, usuario.getDocumento());
                ps.setString(3, usuario.getContrasena());
                ps.setString(4, usuario.getApellido());
                ps.setInt(5, usuario.getTelefono());
                ps.setString(6, usuario.getCorreo());
                ps.setString(7, usuario.getDireccion());
                ps.setString(8, usuario.getRol());
           }

            rowsAffected = ps.executeUpdate();
        }

        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql= "delete from usuario where  Documento=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.execute();
        }
    }
    @Override
    public Usuario createObj(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setNombre(rs.getString("Nombre"));
        usuario.setApellido(rs.getString("apellido"));
        usuario.setContrasena(rs.getString("Contraseña"));
        usuario.setDocumento(rs.getInt("Documento"));
        usuario.setTelefono(rs.getInt("Telefono"));
        usuario.setCorreo(rs.getString("Correo"));
        usuario.setDireccion(rs.getString("Direccion"));
        usuario.setRol(rs.getString("NombreRol"));

        return usuario;
    }

    public Integer insertUsuario(Usuario usuario) throws SQLException {
        int rowsAffected = 0;
        sql = "insert into usuario ( Nombre, Documento,  Contraseña, apellido, Telefono, Correo, Direccion, IdRol) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getDocumento());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getApellido());
            ps.setInt(5, usuario.getTelefono());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getDireccion());
            ps.setString(8, usuario.getRol());
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }

    public Integer updateUsuario(Usuario usuario) throws SQLException {
        int rowsAffected = 0;
        sql = "update usuario set  Nombre=?, apellido=?, Contraseña=?, Telefono=?, Correo=?, Direccion=?, IdRol=?  where Documento=?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getContrasena());
            ps.setInt(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getDireccion());
            ps.setString(7, usuario.getRol());
            ps.setInt(8, usuario.getDocumento());
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }
    public Integer Login (Integer Documento, String Contrasena, HttpSession session ) throws SQLException {
        sql="SELECT * FROM usuario WHERE Documento = ? AND Contraseña = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, Documento);
            ps.setString(2, Contrasena);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {

                    // Se encontró al menos un resultado
                    // Puedes hacer algo con el usuario si es necesario
                    Integer rol = resultSet.getInt("IdRol"); // Asumiendo que el campo es 'Rol'
                    session.setAttribute("documento", Documento);
                    session.setAttribute("rol", rol);
                    System.out.println("Rol del usuario: " + rol);
                    return rol;
                } else {
                    // No se encontraron resultados
                    return null;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println( e.getMessage());
            return null;
        }

    }
    public Integer login (Integer Documento, String Contrasena ) throws SQLException {
        sql="SELECT * FROM usuario WHERE Documento = ? AND Contraseña = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, Documento);
            ps.setString(2, Contrasena);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {

                    Integer rol = resultSet.getInt("IdRol");
                    System.out.println("Rol del usuario: " + rol);
                    return rol;
                } else {
                    // No se encontraron resultados
                    return null;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println( e.getMessage());
            return null;
        }

    }
    /*public boolean Login (Integer Documento, String Contrasena) throws SQLException {
        sql="SELECT * FROM usuario WHERE Documento = ? AND Contraseña = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, Documento);
            ps.setString(2, Contrasena);
            try (ResultSet resultSet = ps.executeQuery()) {
                Integer rol = resultSet.getInt("IdRol");
                System.out.println( rol);
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println( e.getMessage());
            return false;
        }*/

    }



