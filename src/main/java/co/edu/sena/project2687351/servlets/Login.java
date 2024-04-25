package co.edu.sena.project2687351.servlets;

import co.edu.sena.project2687351.model.Llanta;
import co.edu.sena.project2687351.model.Usuario;
import co.edu.sena.project2687351.model.repository.LlantaRepositoryImpl;
import co.edu.sena.project2687351.model.repository.Repository;
import co.edu.sena.project2687351.model.repository.UsuarioRepositoryImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

import static javax.swing.JOptionPane.showMessageDialog;

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Collect all from data
        Integer documento = Integer.valueOf(request.getParameter("Documento"));
        String contrasena = request.getParameter("Contrasena");
        HttpSession session = request.getSession();

        // Aquí, llama al método login y pasa la sesión como un argumento
        try {
            Integer loginExitoso = new UsuarioRepositoryImpl().Login(documento, contrasena ,session);
            if (loginExitoso != null ) {
                if (loginExitoso == 1 || loginExitoso == 2 || loginExitoso == 3) {
                    response.sendRedirect(request.getContextPath() + "/jsp/index/indexAdministrador.jsp");
                    session.setAttribute("Documento", documento);
                    session.setAttribute("Rol", loginExitoso);
                } else{
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                }
            }else{
                response.sendRedirect(request.getContextPath() + "/login.jsp?fallo=error");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja la excepción de SQL
        }
    }

}
