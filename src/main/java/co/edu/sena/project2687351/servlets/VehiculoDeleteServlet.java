package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Vehiculo;
import co.edu.sena.project2687351.model.repository.VehiculoRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Vehiculo-Delete")
public class VehiculoDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo Collect all from data
        String IdVehiculo =request.getParameter("Placa");



        // fill it up in a user bean

        Vehiculo vehiculo= new Vehiculo();
        vehiculo.setPlaca(IdVehiculo);

        //todo call repository layer and save the user object to DB
        Repository<Vehiculo> repository = new VehiculoRepositoryImpl();
        int rows=0;
        try {
            ((VehiculoRepositoryImpl) repository).deleteObjs(IdVehiculo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //todo procedure an information
        if (rows== 0){
            System.out.println("Ocurrio un error");
        }
        else{
            System.out.println("Registro exitoso");
        }
        response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Editar/editarVehiculo.jsp");
    }
}
