package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Llanta;
import co.edu.sena.project2687351.model.repository.LlantaRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
@WebServlet("/Llanta-Update")
public class LlantaUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect all from data
        Integer IdLlanta = Integer.valueOf(request.getParameter("IdLlanta"));
        String Marca = request.getParameter("Marca");
        String Tipo = request.getParameter("Tipo");
        Integer Modelo = Integer.valueOf(request.getParameter("Modelo"));
        String Dimension =request.getParameter("Dimension");
        String Diseno = request.getParameter("Diseno");
        Date FechaLlanta = Date.valueOf(request.getParameter("FechaLlanta"));
        Double ProfundidadLlanta = Double.valueOf(request.getParameter("ProfundidadLlanta"));
        // fill it up in a user bean
        Llanta llanta = new Llanta();
        llanta.setIdLlanta(IdLlanta);
        llanta.setMarca(Marca);
        llanta.setTipo(Tipo);
        llanta.setModelo(Modelo);
        llanta.setDimension(Dimension);
        llanta.setDiseno(Diseno);
        llanta.setFechaLlanta(FechaLlanta);
        llanta.setProfundidadLlanta(ProfundidadLlanta);
        //call repository layer and save the user object to DB
        Repository<Llanta> repository = new LlantaRepositoryImpl();
        int rows=0;
        try {
            repository.saveObj(llanta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //procedure an information
        if (rows== 0){
            System.out.println("Ocurrio un error");
        }
        else{
            System.out.println("Registro exitoso");
        }
        response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Editar/editarLlanta.jsp");
    }
}
