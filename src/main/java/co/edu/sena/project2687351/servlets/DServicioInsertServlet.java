package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.DServicio;
import co.edu.sena.project2687351.model.Venta;
import co.edu.sena.project2687351.model.repository.DServicioRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import co.edu.sena.project2687351.model.repository.VentaRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/registerDService")
public class DServicioInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect all from data
        Double PrecioDetalleServicio = Double.valueOf(request.getParameter("PrecioDetalleServicio"));
        Date Fecha = Date.valueOf(request.getParameter("Fecha"));
        String IdVehiculo= request.getParameter("IdVehiculo");
        Integer IdServicio = Integer.valueOf(request.getParameter("IdServicio"));
        Integer IdUsuario = Integer.valueOf(request.getParameter("IdUsuario"));
        String DescripcionServicio = request.getParameter("DescripcionServicio");

        // fill it up in a user bean
        DServicio dservicio = new DServicio();
        dservicio.setPrecioDetalleServicio(PrecioDetalleServicio);
        dservicio.setFecha(Fecha);
        dservicio.setIdVehiculo(IdVehiculo);
        dservicio.setIdServicio(IdServicio);
        dservicio.setIdUsuario(IdUsuario);
        dservicio.setDescripcionServicio(DescripcionServicio);
        //call repository layer and save the user object to DB
        Repository<DServicio> repository = new DServicioRepositoryImpl();
        int rows=0;
        try {
           rows = repository.saveObj(dservicio);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //procedure an information
        if (rows== 0){
            System.out.println("Ocurrio un error");
            response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarDServicio.jsp?fallo=error");
        }
        else{
            System.out.println("Registro exitoso");
            response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarDServicio.jsp");
        }

    }
}
