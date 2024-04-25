package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Rol;
import co.edu.sena.project2687351.model.repository.Repository;
import co.edu.sena.project2687351.model.repository.RolRepositoryImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Rol-Delete")
public class RolDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer IdRol =Integer.valueOf(request.getParameter("IdRol"));

        Rol rol = new Rol();
        rol.setIdRol(IdRol);

        Repository<Rol> repository = new RolRepositoryImpl();
        int rows = 0;
        try {
            repository.deleteObj(IdRol);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rows== 0){
            System.out.println("Ocurrio un error");
        }
        else{
            System.out.println("Registro exitoso");
        }
    }
}
