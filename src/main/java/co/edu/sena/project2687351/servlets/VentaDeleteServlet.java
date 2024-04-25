package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Venta;
import co.edu.sena.project2687351.model.repository.VentaRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Venta-Delete")
public class VentaDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo Collect all from data
        Integer IdVenta = Integer.valueOf(request.getParameter("IdVenta"));

        // fill it up in a user bean

        Venta venta = new Venta();
        venta.setIdVenta(IdVenta);

        //todo call repository layer and save the user object to DB
        Repository<Venta> repository = new VentaRepositoryImpl();
        int rows=0;
        try {
            repository.deleteObj(IdVenta);
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
        response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Editar/editarVenta.jsp");
    }
}


