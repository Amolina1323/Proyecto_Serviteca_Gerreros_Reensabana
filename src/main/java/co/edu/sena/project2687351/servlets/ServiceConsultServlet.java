package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Cliente;
import co.edu.sena.project2687351.model.Services;
import co.edu.sena.project2687351.model.repository.ClienteRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import co.edu.sena.project2687351.model.repository.ServicesRepositoryImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Servicio-Consult")
public class ServiceConsultServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo Collect all from data
        Integer IdServicio =Integer.valueOf(request.getParameter("IdServicio"));

        Repository<Services> repository = new ServicesRepositoryImpl();
        try {
            Services services = repository.byIdObj(IdServicio);

            if (services != null) {
                // Almacena el cliente en un atributo de solicitud
                request.setAttribute("services", services);
                // Redirige a un JSP para mostrar la información del cliente
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Editar/editarServicio.jsp");
                dispatcher.forward(request, response);
            }
            else {
                response.sendRedirect("jsp/Editar/editarServicio.jsp");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
