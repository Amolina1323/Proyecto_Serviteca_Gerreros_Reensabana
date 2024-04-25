<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session= request.getSession(false);
    if (session == null || session.getAttribute("Documento") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }int rol = (int) session.getAttribute("Rol");%>
<!doctype html>
<html lang="es"> 
  <head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
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
                  <a href="../Consultas/CatalogoServicio.jsp"><img src="../../../Project-2687351-1.0-SNAPSHOT/img/logo.png" class="logo" ></a>
              </div>

              <div class="icons">
                  <a href="../Consultas/consultaUsuario.jsp"><i class="fas fa-user"></i></a>
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
    
  <center>
    <form method="POST" action="../../Vehiculo-Insert">
     
        <h2> REGISTRO DE VEHICULOS</h2>
    <label>Placa :
        <input type="text" name="Placa" class="form-control" required>
        </label><br><br>
    <label>Marca  :
             <input type="text" name="Marca" class="form-control" required>
        </label><br><br>
    <label>Modelo   :
            <input type="text" name="Modelo" class="form-control" required>
       </label><br><br>
        <label>Tipo :
            <br> <br>
            <select name="Tipo" >
                <option value="Liviano">Liviano</option>
                <option value="Mediano">Mediano</option>
                <option value="Pesado">Pesado</option>
            </select>
        </label><br><br>
    <label>Kilometraje  :
        <input type="number" name="Kilometraje" class="form-control" required>
        </label><br><br>
    <label>Numero de Llantas  :
        <br><br>
        <select name="Num_Llantas" >
            <option value=4>4 llantas</option>
            <option value=6>6 llantas</option>
            <option value=8>8 llantas</option>
            <option value=12>12 llantas</option>
            <option value=16>16 llantas</option>
        </select>
    </label><br><br>
    <label>Linea   :
        <input type="text" name="linea" class="form-control" required>
        </label><br><br>
    <label>IdCliente    :
        <input type="text" name="IdCliente" class="form-control" required>
        </label><br><br>

       
<br>
<div class="grupo boton animacion" >
<br>
<button><a href=""><strong>REGISTRAR</strong></a></button>
</div>
</form>  
</center>
<br> <br>
          <%
              String fallo= request.getParameter("fallo");
              if (fallo != null && fallo.equals("error")){ %>
          <script>
              alert('No se pudo realizar el Registro, verifique sus datos. ')</script>
          <%
              }
          %>
       
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