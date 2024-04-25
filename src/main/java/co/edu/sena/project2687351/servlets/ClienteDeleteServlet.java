package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Cliente;
import co.edu.sena.project2687351.model.repository.ClienteRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Cliente-Delete")
public class ClienteDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // todo Collect all from data
        String IdCliente =request.getParameter("DocumentoC");



        // fill it up in a user bean

        Cliente cliente= new Cliente();
        cliente.setIdCliente(IdCliente);

        // call repository layer and save the user object to DB
        ClienteRepositoryImpl repository = new ClienteRepositoryImpl();
        int rows=0;
        try {
            repository.deleteObjs(IdCliente);
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
        response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Editar/editarCliente.jsp");
    }
}
