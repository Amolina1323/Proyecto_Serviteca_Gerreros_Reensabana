package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Usuario;
import co.edu.sena.project2687351.model.repository.Repository;
import co.edu.sena.project2687351.model.repository.UsuarioRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Usuario-Delete")
public class UsuarioDeleteServlet extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer Documento =Integer.valueOf(request.getParameter("Documento"));

        Usuario usuario = new Usuario();
        usuario.setDocumento(Documento);

        Repository<Usuario> repository = new UsuarioRepositoryImpl();
        int rows = 0;
        try {
            repository.deleteObj(Documento);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rows== 0){
            System.out.println("Ocurrio un error");
        }
        else{
            System.out.println("Registro exitoso");
        }
        response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Editar/editarUsuario.jsp");
    }
}
