package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Services;
import co.edu.sena.project2687351.model.repository.Repository;
import co.edu.sena.project2687351.model.repository.ServicesRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UpdateService")
public class ServicesUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  collect all form data
        Integer Id_Services = Integer.valueOf(request.getParameter("services_id"));
        String NombreServicio = request.getParameter("NombreServicio");
        String Estado = request.getParameter("Estado");
        Double PrecioServicioLiviano = Double.valueOf(request.getParameter("PrecioServicioLiviano"));
        Double PrecioServicioMediano = Double.valueOf(request.getParameter("PrecioServicioMediano"));
        Double PrecioServicioPesado = Double.valueOf(request.getParameter("PrecioServicioPesado"));
        String DescripcionServicio = request.getParameter("DescripcionServicio");
        //  fill it up in a User Bean
        Services services = new Services();
        services.setIdServicio(Id_Services);
        services.setNombreServicio(NombreServicio);
        services.setEstado(Estado);
        services.setPrecioServicioLiviano(PrecioServicioLiviano);
        services.setPrecioServicioMediano(PrecioServicioMediano);
        services.setPrecioServicioPesado(PrecioServicioPesado);
        services.setDescripcionServicio(DescripcionServicio);
        // call repository layer and save the user object to DB
        Repository<Services> repository = new ServicesRepositoryImpl();
        int rows = 0;
        try {
            rows =repository.saveObj(services);
            if(rows==0){
                System.out.println("No se realizo la actualizacion en la base de datos.");
            } else {
                System.out.println("Registro exitoso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al interactuar con la base de datos: " + e.getMessage());
        }

        response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Editar/editarServicio.jsp");
    }
}

