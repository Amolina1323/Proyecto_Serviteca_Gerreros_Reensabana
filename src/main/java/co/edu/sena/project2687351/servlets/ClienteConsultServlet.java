package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Cliente;
import co.edu.sena.project2687351.model.repository.ClienteRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Cliente-Consult")
public class ClienteConsultServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Collect all from data
        String IdCliente =request.getParameter("IdCliente");
        //Crear un objeto del repositorio cliente
        Repository<Cliente> repository = new ClienteRepositoryImpl();
        try {

            Cliente cliente = ((ClienteRepositoryImpl) repository).byIdObjs(IdCliente);

            if (cliente != null) {
                // Almacena el cliente en un atributo de solicitud
                request.setAttribute("cliente", cliente);
                // Redirige a un JSP para mostrar la información del cliente
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Editar/editarCliente.jsp");
                dispatcher.forward(request, response);
            }
            else {
                response.sendRedirect("jsp/Editar/editarCliente.jsp");
            }

        } catch (SQLException e) {
            response.sendRedirect("/Editar/editarUsuario.jsp");

            e.printStackTrace();
        }
    }
}
