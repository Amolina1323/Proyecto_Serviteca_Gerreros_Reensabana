package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Vehiculo;
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
import java.util.List;

@WebServlet("/VehiculoFlo-Consult")
public class VehiculoFlo_Consult extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect all from data
        String IdCliente =request.getParameter("IdVehiculo");

        Repository<Vehiculo> repository = new VehiculoRepositoryImpl();
        try {
            List<Vehiculo> vehiculos = ((VehiculoRepositoryImpl) repository).byIdObjf(IdCliente);

            if (vehiculos != null) {
                System.out.println(vehiculos);
                // Almacena el cliente en un atributo de solicitud
                request.setAttribute("vehiculo", vehiculos);
                // Redirige a un JSP para mostrar la información del cliente
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Editar/editarVehiculo.jsp");
                dispatcher.forward(request, response);
            }
            else {
                response.sendRedirect("/Editar/editarUsuario.jsp");
            }

        } catch (SQLException e) {
            response.sendRedirect("/Editar/editarUsuario.jsp");

            e.printStackTrace();
        }
    }
}
