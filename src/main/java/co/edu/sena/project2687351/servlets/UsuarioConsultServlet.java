package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Services;
import co.edu.sena.project2687351.model.Usuario;
import co.edu.sena.project2687351.model.repository.Repository;
import co.edu.sena.project2687351.model.repository.ServicesRepositoryImpl;
import co.edu.sena.project2687351.model.repository.UsuarioRepositoryImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Usuario-Consult")
public class UsuarioConsultServlet extends HttpServlet {
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer IdUsuario =Integer.valueOf(request.getParameter("IdUsuario"));

        Repository<Usuario> repository = new UsuarioRepositoryImpl();
        try {
            Usuario usuario = repository.byIdObj(IdUsuario);

            if (usuario != null) {
                // Almacena el cliente en un atributo de solicitud
                request.setAttribute("usuario", usuario);
                // Redirige a un JSP para mostrar la información del cliente
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Editar/editarUsuario.jsp");
                dispatcher.forward(request, response);
            }
            else {
                response.sendRedirect("jsp/Editar/editarUsuario.jsp");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
