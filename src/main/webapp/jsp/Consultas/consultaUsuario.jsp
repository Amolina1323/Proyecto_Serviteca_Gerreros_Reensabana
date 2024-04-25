<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="co.edu.sena.project2687351.model.Usuario" %>
<%@ page import="co.edu.sena.project2687351.model.repository.UsuarioRepositoryImpl" %>
<%@ page import="co.edu.sena.project2687351.model.repository.Repository" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%
session= request.getSession(false);
    if (session == null || session.getAttribute("Documento") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }  int rol = (int) session.getAttribute("Rol");
%>
<!doctype html>
<html lang="es"> 
  <head>
    <!-- Required meta tags -->
      <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Title -->
    <title>Guerreros</title>
    <!-- CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
      <link rel="stylesheet" type="text/css" href="../../../Project-2687351-1.0-SNAPSHOT/css/editarLlantass.css">
      <script src="https://kit.fontawesome.com/99d8705f49.js" crossorigin="anonymous"></script>
  </head>
  <body>
  <main class="main">
      <div class="container">

          <!-- Cabecera -->
          <header class="header">
              <br>
              <div class="container logo-busco-container">
                  <a href="../Consultas/CatalogoServicio.jsp"><img src="../../../Project-2687351-1.0-SNAPSHOT/img/logo.png" class="logo" ></a>
              </div>

              <div class="icons">
                  <a href="consultaUsuario.jsp"><i class="fas fa-user"></i></a>
                  <a href="../../../Project-2687351-1.0-SNAPSHOT/Logout"><i class="fas fa-sign-out-alt"></i></a>
              </div>
          </header>
          <br>
          <center>
              <nav class="nav">
                      <ul>
                          <li class="nav-item">
                              <a class="nav-link active" aria-current="page" href="#"><strong>Cliente</strong></a>
                              <ul>
                                  <li class=""><a class="nav-link active" aria-current="page" href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarCliente.jsp"><strong>Registrar</strong></a></li>
                                  <br>
                                  <li class=""><a class="nav-link active" aria-current="page" href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Consultas/consultaCliente.jsp"><strong>Consultar</strong></a></li>
                              </ul>
                          </li>
                          <li class="nav-item">
                              <a class="nav-link" href="#"><strong>Vehiculo</strong></a>
                              <ul>
                                  <li class=""><a class="nav-link active" aria-current="page" href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarVehiculo.jsp"><strong>Registrar</strong></a></li>
                                  <br>
                                  <li class=""><a class="nav-link active" aria-current="page" href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Consultas/consultaVehiculo.jsp"><strong>Consultar</strong></a></li>
                              </ul>
                          </li>
                          <%if ( rol == 1 || rol == 2) {%>
                          <li class="nav-item">
                              <a class="nav-link" href="#"><strong>Servicio</strong></a>
                              <ul>
                                  <li class=""><a class="nav-link active" aria-current="page" href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarServicio.jsp"><strong>Crear</strong></a></li>
                                  <br>
                                  <li class=""><a class="nav-link active" aria-current="page" href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Consultas/consultaServicio.jsp"><strong>Consultar</strong></a></li>
                                  <br>
                              </ul>
                          </li>
                          <% }%>
                          <%if ( rol == 1 || rol == 2) {%>
                          <li class="nav-item">
                              <a class="nav-link" href="#"><strong>Llanta</strong></a>
                              <ul>
                                  <li class=""><a class="nav-link active" aria-current="page" href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarLlanta.jsp"><strong>Registrar</strong></a></li>
                                  <br>
                                  <li class=""><a class="nav-link active" aria-current="page" href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Consultas/consultaLlanta.jsp"><strong>Consultar</strong></a></li>
                              </ul>
                          </li>
                          <% }%>
                          <li class="nav-item">
                              <a class="nav-link" href="#"><strong>Orden De Servicio</strong></a>
                              <ul>
                                  <li class=""><a class="nav-link active" aria-current="page" href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarDServicio.jsp"><strong>Registrar</strong></a></li>
                                  <br>
                                  <li class=""><a class="nav-link active" aria-current="page" href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Consultas/consultaDServicio.jsp"><strong>Consultar</strong></a></li>
                              </ul>
                          </li>
                          <%if ( rol == 1 || rol == 2) {%>
                          <li class="nav-item">
                              <a class="nav-link" href="#"><strong>Venta</strong></a>
                              <ul>
                                  <li class=""><a class="nav-link active" aria-current="page" href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Registros/registrarVenta.jsp"><strong>Registrar</strong></a></li>
                                  <br>
                                  <li class=""><a class="nav-link active" aria-current="page" href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Consultas/consultaVenta.jsp"><strong>Consultar</strong></a></li>
                              </ul>
                          </li>
                          <% }%>

                      </ul>

              </nav>
          </center>
          <!-- Formulario -->
            <h1>USUARIOS</h1>
          <button><a href="../Editar/editarUsuario.jsp">CONSULTA ESPECIFICA</a> <br></button><br>
          <%if ( rol == 1) {%>
              <button><a href="../Registros/registrarUsuario.jsp">REGISTRAR USUARIO</a></button>
          <% }%>
            <center>
                <table class="table table-dark table-striped">

                    <tr>
                        <td class="cabezacon">NOMBRE</td>
                        <td class="cabezacon">APELLIDO</td>
                        <td class="cabezacon">CONTRASENA</td>
                        <td class="cabezacon">DOCUMENTO</td>
                        <td class="cabezacon">TELEFONO</td>
                        <td class="cabezacon">CORREO</td>
                        <td class="cabezacon">DIRECCION</td>
                        <td class="cabezacon">ROL</td>
                    </tr>

                    <%    Repository<Usuario> repository = new UsuarioRepositoryImpl();
                        try {
                            List<Usuario> Usuarios = repository.listAllObj();
                            for (Usuario usuario : Usuarios) {


                    %>
                    <tr>
                        <td><%=usuario.getNombre()%></td>
                        <td><%=usuario.getApellido()%></td>
                        <td><%=usuario.getContrasena()%></td>
                        <td><%=usuario.getDocumento()%></td>
                        <td><%=usuario.getTelefono()%></td>
                        <td><%=usuario.getCorreo()%></td>
                        <td><%=usuario.getDireccion()%></td>
                        <td><%=usuario.getRol()%></td>
                    </tr>
                    <% }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    %>
                </table>
            </center>
            <br> <br>
                    <!-- Footer -->

          <footer class="bg-dark text-center text-white">
              <!-- Copyright -->
              <section class="foo">
                  <center>
                      <p class="copyright">
                          <strong>
                              <p>&copy; <span id="currentYear"></span> Grupo Guerreros Gonzales</p>
                              <p>Creado por: Guerreros</p>
                          </strong>
                      </p>
                  </center>
              </section>
          </footer>
          <script>
              // Obtenemos el año actual y lo asignamos al span con id "currentYear"
              document.getElementById("currentYear").textContent = new Date().getFullYear();
          </script>
        </div>
    </main>
  </body>
</html>