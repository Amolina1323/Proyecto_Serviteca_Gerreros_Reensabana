package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Cliente;
import co.edu.sena.project2687351.model.DServicio;
import co.edu.sena.project2687351.model.repository.ClienteRepositoryImpl;
import co.edu.sena.project2687351.model.repository.DServicioRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DServicio-Consult")
public class DServicioConsultServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  Collect all from data
        Integer IdDService =Integer.valueOf(request.getParameter("IdDService"));

        Repository<DServicio> repository = new DServicioRepositoryImpl();
        try {
            DServicio dservice = repository.byIdObj(IdDService);

            if (dservice != null) {
                // Almacena el cliente en un atributo de solicitud
                request.setAttribute("dservice", dservice);
                // Redirige a un JSP para mostrar la información del cliente
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Editar/editarDServicio.jsp");
                dispatcher.forward(request, response);
            }
            else {
                response.sendRedirect("jsp/Editar/editarDServicio.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
