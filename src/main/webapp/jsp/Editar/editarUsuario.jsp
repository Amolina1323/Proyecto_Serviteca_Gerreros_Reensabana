<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="co.edu.sena.project2687351.model.Usuario" %>
<%@ page import="co.edu.sena.project2687351.model.repository.Repository" %>
<%@ page import="co.edu.sena.project2687351.model.repository.UsuarioRepositoryImpl" %>
<%@ page import="java.util.List" %>
<%
    session= request.getSession(false);
    if (session == null || session.getAttribute("Documento") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }int rol = (int) session.getAttribute("Rol");%>
<!doctype html>
<html lang="es"> 
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Title -->
    <title>Guerreros</title>
    <!-- CSS -->
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
                    <a href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Consultas/CatalogoServicio.jsp"><img src="../../../Project-2687351-1.0-SNAPSHOT/img/logo.png" class="logo" ></a>
                </div>

                <div class="icons">
                    <a href="../../../Project-2687351-1.0-SNAPSHOT/jsp/Consultas/consultaUsuario.jsp"><i class="fas fa-user"></i></a>
                    <a href="../../../Project-2687351-1.0-SNAPSHOT/Logout"><i class="fas fa-sign-out-alt"></i></a>
                </div>
            </header>


            <!-- Menu -->
            <center>

                <nav class="nav">
                    <center>
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
                    </center>
                </nav>
            </center>
            <br>
            <!-- Formulario -->
    
 
    <h1>Consulta Especifica</h1>
    
</div>

        <div class="content">
            <center>
            <form method="POST" action="../../../Project-2687351-1.0-SNAPSHOT/Usuario-Consult">
                <BR>
                <label> Id Usuario:
                <input type="number" name="IdUsuario" class="form-control"><br>
                </label>
                <div class="grupo boton animacion" >
                    <br>
                    <button><strong>CONSULTAR</strong></button>
                </div>

            </form><br><br>
            </center>
            <% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
            <!--FORMULARIO DONDE SE MOTRARÁN LOS DATOS ASOCIADOS AL CODIGO DIGITADO-->
            <% if (request.getAttribute("usuario") != null) { %>

<!--FORMULARIO DONDE SE MOTRARÁN LOS DATOS ASOCIADOS AL CODIGO DIGITADO-->
            <br>
            <center>
                <form method="POST" id="Formulario">
                <BR><BR>
                    <label>Nombre :
                        <input type="text" name="Nombre" class="form-control" value="<%= usuario.getNombre()  %>" required>
                   </label><br><br>
               <label>Apellido :
                       <input type="text" name="Apellido" class="form-control" value="<%= usuario.getApellido()  %>" required>
                  </label><br><br>
               <label>Documento :
                   <input type="number" name="Documento" class="form-control" value="<%= usuario.getDocumento()  %>" required>
                   </label><br><br>
                <label>Telefono  :
                   <input type="number" name="Telefono" class="form-control" value="<%= usuario.getTelefono()  %>" required>
                   </label><br><br>
               <label>Direccion   :
                   <input type="text" name="Direccion" class="form-control" value="<%= usuario.getDireccion()  %>" required>
                   </label><br><br>
                    <label>Rol   : <br><br>
                        <select name="Rol">
                            <option value=1 <%= usuario.getRol() == "Administrador" ? "selected" : "" %>>Administrador</option>
                            <option value=2 <%= usuario.getRol() == "Coordinador" ? "selected" : "" %>>Coordinador</option>
                            <option value=3 <%= usuario.getRol() == "Serviteca" ? "selected" : "" %>>Serviteca</option>
                        </select>
                    </label><br><br>
               <label>Correo   :
                   <input type="email" name="Correo" class="form-control" value="<%= usuario.getCorreo()  %>" required pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}" title="Ingrese una dirección de correo electrónico válida">
                   </label><br><br>
               <label>Contraseña :
                   <input type="password" name="Contrasena" class="form-control" value="<%= usuario.getContrasena()  %>" required pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$">
              </label><br><br>
                    <% if (rol == 1 || rol == 2) {%>
                    <div class="grupo boton animacion" >
                        <br>
                        <button onclick="editar()" ><strong>EDITAR</strong></button>
                    </div>
                    <% }%>
                    <% if (rol == 1) {%>
                    <div class="grupo boton animacion" >
                        <button onclick="eliminar()"><strong>ELIMINAR</strong></button>
                    </div>
                    <br><% }%>

            </form>
            </center>
            <script>
                function editar() {
                    var rest =window.confirm('¿Estas completamente seguro de que deseas modificar esta informacion?')
                    if(rest == true){
                        document.getElementById("Formulario").action = "../../../Project-2687351-1.0-SNAPSHOT/Usuario-Update";
                        document.getElementById("Formulario").submit();
                    }else {
                        alert('Se ha cancelado la modificacion de la informacion. ')
                    }
                }

                function eliminar() {
                    var rest =window.confirm('¿Estás completamente seguro de que deseas eliminar esta informacion?')
                    if(rest == true){
                        document.getElementById("Formulario").action = "../../../Project-2687351-1.0-SNAPSHOT/Usuario-Delete";
                        document.getElementById("Formulario").submit();
                    }else {
                        alert('La eliminacion de la informacion ha sido cancelada.')
                    }
                }
            </script>
            <% } %>
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