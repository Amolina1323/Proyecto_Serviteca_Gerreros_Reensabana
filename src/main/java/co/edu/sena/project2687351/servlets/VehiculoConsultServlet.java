package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Cliente;
import co.edu.sena.project2687351.model.Vehiculo;
import co.edu.sena.project2687351.model.repository.ClienteRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import co.edu.sena.project2687351.model.repository.VehiculoRepositoryImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Vehiculo-Consult")
public class VehiculoConsultServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo Collect all from data
        String IdVehiculo =request.getParameter("IdVehiculo");

        Repository<Vehiculo> repository = new VehiculoRepositoryImpl();
        try {
            Vehiculo vehiculo = ((VehiculoRepositoryImpl) repository).byIdObjs(IdVehiculo);

            if (vehiculo != null) {
                // Almacena el cliente en un atributo de solicitud
                request.setAttribute("vehiculo", vehiculo);
                // Redirige a un JSP para mostrar la información del cliente
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Editar/editarVehiculo.jsp");
                dispatcher.forward(request, response);
            }
            else {
                response.sendRedirect("jsp/Editar/editarVehiculo.jsp");
            }

        } catch (SQLException e) {
            response.sendRedirect("/Editar/editarUsuario.jsp");

            e.printStackTrace();
        }
    }
}
