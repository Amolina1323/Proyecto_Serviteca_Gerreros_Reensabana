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

@WebServlet("/DeleteService")
public class ServiceDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  collect all form data
        Integer Id_Services = Integer.valueOf(request.getParameter("services_id"));

        //  fill it up in a User Bean
        Services services = new Services();
        services.setIdServicio(Id_Services);
        // call repository layer and save the user object to DB
        Repository<Services> repository = new ServicesRepositoryImpl();
        int rows = 0;
        try {
            repository.deleteObj(Id_Services);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //todo prepare message for user about success
        //String message = null

        if(rows==0){
            System.out.println("Ocurrio un error");
        }else{
            System.out.println("Registro exitoso");
        }
        response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Editar/editarServicio.jsp");
    }
}

