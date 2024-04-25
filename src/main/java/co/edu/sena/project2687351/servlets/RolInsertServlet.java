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

@WebServlet("/Rol-Insert")
public class RolInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo Collect all from data
        String Nombre = request.getParameter("Nombre");


        // fill it up in a user bean

        Rol rol= new Rol();
        rol.setNombreRol(Nombre);


        //todo call repository layer and save the user object to DB
        Repository<Rol> repository = new RolRepositoryImpl();
        int rows=0;
        try {
            repository.saveObj(rol);
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
    }
}
