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
import java.sql.SQLException;
@WebServlet("/Llanta-Delete")
public class LlantaDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect all from data
        Integer IdLlanta = Integer.valueOf(request.getParameter("IdLlanta"));

        // fill it up in a user bean
        Llanta llanta = new Llanta();
        llanta.setIdLlanta(IdLlanta);

        //call repository layer and save the user object to DB
        Repository<Llanta> repository = new LlantaRepositoryImpl();
        int rows=0;
        try {
            repository.deleteObj(IdLlanta);
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
