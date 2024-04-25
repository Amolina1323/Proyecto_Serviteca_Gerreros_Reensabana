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

@WebServlet("/Vehiculo-Insert")
public class VehiculoInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo Collect all from data
        String Placa= request.getParameter("Placa");
        String Marca= request.getParameter("Marca");
        String Modelo= request.getParameter("Modelo");
        String Tipo= request.getParameter("Tipo");
        Double kiometraje = Double.valueOf(request.getParameter("Kilometraje"));
        Integer Num_Llantas = Integer.valueOf(request.getParameter("Num_Llantas"));
        String Linea= request.getParameter("linea");
        String IdCliente = request.getParameter("IdCliente");



        // fill it up in a user bean

        Vehiculo vehiculo= new Vehiculo();
        vehiculo.setPlaca(Placa);
        vehiculo.setMarca(Marca);
        vehiculo.setModelo(Modelo);
        vehiculo.setTipo(Tipo);
        vehiculo.setKiometraje(kiometraje);
        vehiculo.setNum_Llantas(Num_Llantas);
        vehiculo.setLinea(Linea);
        vehiculo.setIdCliente(IdCliente);
        //todo call repository layer and save the user object to DB
        VehiculoRepositoryImpl repository = new VehiculoRepositoryImpl();
        int rows=0;
        try {
            rows=repository.insertVehiculo(vehiculo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //todo procedure an information
        if (rows== 0){
            System.out.println("Ocurrio un error");
            response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarVehiculo.jsp?fallo=error");
        }
        else{
            System.out.println("Registro exitoso");
            response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarVehiculo.jsp");
        }

    }
}
