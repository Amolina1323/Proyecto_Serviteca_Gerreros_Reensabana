package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Usuario;
import co.edu.sena.project2687351.model.repository.UsuarioRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.sql.SQLException;

@WebServlet("/Usuario-Insert")
public class UsuarioInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo Collect all from data
        String Nombre = request.getParameter("Nombre");
        String Apellido = request.getParameter("Apellido");
        String Contrasena = request.getParameter("Contrasena");
        Integer Documento = Integer.valueOf(request.getParameter("Documento"));
        Integer Telefono = Integer.valueOf(request.getParameter("Telefono"));
        String Correo = request.getParameter("Correo");
        String Direccion = request.getParameter("Direccion");
        String Rol = String.valueOf(request.getParameter("Rol"));



        // fill it up in a user bean

        Usuario usuario= new Usuario();
        usuario.setNombre(Nombre);
        usuario.setApellido(Apellido);
        usuario.setContrasena(Contrasena);
        usuario.setDocumento(Documento);
        usuario.setTelefono(Telefono);
        usuario.setCorreo(Correo);
        usuario.setDireccion(Direccion);
        usuario.setRol(Rol);

        //todo call repository layer and save the user object to DB
        UsuarioRepositoryImpl repository = new UsuarioRepositoryImpl();
        int rows=0;
        try {
                rows=repository.insertUsuario(usuario);
            if(rows==0){
                System.out.println("No se realizo la insercion en la base de datos.");
                response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarUsuario.jsp?fallo=error");
            } else {
                System.out.println("Registro exitoso");
                response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarUsuario.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
