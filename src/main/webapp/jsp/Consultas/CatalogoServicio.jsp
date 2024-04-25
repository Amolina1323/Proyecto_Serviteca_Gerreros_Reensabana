<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session= request.getSession(false);
  if (session == null || session.getAttribute("Documento") == null) {
    response.sendRedirect(request.getContextPath() + "/login.jsp");
  }int rol = (int) session.getAttribute("Rol");%>
<!doctype html>
<meta charset="UTF-8">
<html lang="es">
<head>
  <!-- Required meta tags -->

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Title -->
  <title>Guerreros</title>
  <!-- CSS -->
  <link rel="stylesheet" type="text/css" href="../../css/catalogo.css">
  <script src="https://kit.fontawesome.com/99d8705f49.js" crossorigin="anonymous"></script>
</head>
<body>
<main class="main">
  <div class="container">

    <!-- Cabecera -->
    <header class="header">
      <br>
      <div class="container logo-busco-container">
        <a href="../index/indexAdministrador.jsp"><img src="../../img/logo.png" class="logo" ></a>
      </div>

      <div class="icons">
        <a href=""><i class="fas fa-user"></i></a>
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


    <div class="products-container">

      <div class="product" data-name="p-1">
        <img src="../../img/reencauche.png" alt="">
        <h3>Reencauche</h3>
        <div class="price">50.000</div>
      </div>

      <div class="product" data-name="p-2">
        <img src="../../img/rotacion.png" alt="">
        <h3>Rotación</h3>
        <div class="price">$50.000</div>
      </div>

      <div class="product" data-name="p-3">
        <img src="../../img/alineacion.png" alt="">
        <h3>Alineación</h3>
        <div class="price">$50.000</div>
      </div>

      <div class="product" data-name="p-4">
        <img src="../../img/montaje.png" alt="">
        <h3>Montaje</h3>
        <div class="price">$200.000</div>
      </div>

      <div class="product" data-name="p-5">
        <img src="../../img/cambio-aceite.png" alt="">
        <h3>Cambio de aceite</h3>
        <div class="price">$25.000</div>
      </div>

      <div class="product" data-name="p-6">
        <img src="../../img/despinche.png" alt="">
        <h3>Despinche</h3>
        <div class="price">$50.000</div>
      </div>

    </div>

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