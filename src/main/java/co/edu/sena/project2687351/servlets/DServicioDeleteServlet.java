package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.DServicio;
import co.edu.sena.project2687351.model.repository.DServicioRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/DServicio-Delete")
public class DServicioDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect all from data
        Integer IdDetalleServicio = Integer.valueOf(request.getParameter("IdDetalleServicio"));


        // fill it up in a user bean

        DServicio dservicio = new DServicio();
        dservicio.setIdDetalleServicio(IdDetalleServicio);
        //call repository layer and save the user object to DB
        Repository<DServicio> repository = new DServicioRepositoryImpl();
        int rows=0;
        try {
            repository.deleteObj(IdDetalleServicio);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // procedure an information
        if (rows== 0){
            System.out.println("Ocurrio un error");
        }
        else{
            System.out.println("Registro exitoso");
        }
        response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Editar/editarDServicio.jsp");
    }
}
