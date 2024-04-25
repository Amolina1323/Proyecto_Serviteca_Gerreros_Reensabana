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

@WebServlet("/Cliente-Insert")
public class ClienteInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html");
        String Nombre = request.getParameter("NombreC");
        String Empresa = request.getParameter("Compania");
        String Documento = request.getParameter("DocumentoC");
        String Correo = request.getParameter("CorreoC");
        Integer Telefono = Integer.valueOf(request.getParameter("TelefonoC"));
        String Direccion = request.getParameter("DireccionC");

        Cliente cliente = new Cliente();
        cliente.setNombre(Nombre);
        cliente.setEmpresa(Empresa);
        cliente.setDocumento(Documento);
        cliente.setCorreo(Correo);
        cliente.setTelefono(Telefono);
        cliente.setDireccion(Direccion);

        ClienteRepositoryImpl repository = new ClienteRepositoryImpl();
        int rows=0;
        try {
            rows=repository.insertCliente(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //procedure an information
        if (rows== 0){
            System.out.println("Ocurrio un error");
            response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarCliente.jsp?fallo=error");
        }
        else{
            System.out.println("Registro exitoso");
            response.sendRedirect("/Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarVehiculo.jsp");

        }
    }

}

