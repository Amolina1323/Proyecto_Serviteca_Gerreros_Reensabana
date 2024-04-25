package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Cliente;
import co.edu.sena.project2687351.model.Llanta;
import co.edu.sena.project2687351.model.repository.ClienteRepositoryImpl;
import co.edu.sena.project2687351.model.repository.LlantaRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Llanta-Consult")
public class LlantaConsultServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect all from data
        Integer IdLlanta =Integer.valueOf(request.getParameter("IdLlanta"));

        Repository<Llanta> repository = new LlantaRepositoryImpl();
        try {
            Llanta llanta = repository.byIdObj(IdLlanta);

            if (llanta != null) {
                // Almacena el cliente en un atributo de solicitud
                request.setAttribute("llanta", llanta);
                // Redirige a un JSP para mostrar la información del cliente
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Editar/editarLlanta.jsp");
                dispatcher.forward(request, response);
            }
            else {
                response.sendRedirect("jsp/Editar/editarLlanta.jsp");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
