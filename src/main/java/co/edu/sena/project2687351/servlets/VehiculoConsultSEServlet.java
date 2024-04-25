package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.DServicio;
import co.edu.sena.project2687351.model.Services;
import co.edu.sena.project2687351.model.Vehiculo;
import co.edu.sena.project2687351.model.repository.DServicioRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import co.edu.sena.project2687351.model.repository.ServicesRepositoryImpl;
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

@WebServlet("/VehiculoSer-Consult")
public class VehiculoConsultSEServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo Collect all from data
        String IdVehiculo =request.getParameter("IdVehiculo");

        Repository<DServicio> repository = new DServicioRepositoryImpl();
        try {
            List<DServicio> dServicios = ((DServicioRepositoryImpl) repository).byIdObjV(IdVehiculo);

            if (dServicios != null) {
                System.out.println(dServicios);
                // Almacena el cliente en un atributo de solicitud
                request.setAttribute("dServicio", dServicios);
                // Redirige a un JSP para mostrar la información del cliente
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Consultas/consultarServiciosVehi.jsp");
                dispatcher.forward(request, response);
            }
            else {
                response.sendRedirect("/Editar/editarUsuario.jsp");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
