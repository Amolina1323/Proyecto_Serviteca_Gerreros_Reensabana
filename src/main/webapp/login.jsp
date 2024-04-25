<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% session= request.getSession(false);
    if (session == null || session.getAttribute("Documento") != null) {
        response.sendRedirect(request.getContextPath() + "/jsp/index/indexAdministrador.jsp");
    }%>
<!doctype html>

<html lang="es"> 
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Title -->
    <title>Guerreros</title>
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="/Project-2687351-1.0-SNAPSHOT/css/Logins.css">
    <script src="https://kit.fontawesome.com/99d8705f49.js" crossorigin="anonymous"></script>
  </head>
  <body>
    <main class="main">
        <div class="container">
        
    <!-- Cabecera -->
    <header class="header">
    <br>
        <div class="container logo-busco-container">
            <a href=""><img src="img/logo.png" class="logo" ></a>
        </div>
                
            <div class="icons">
                <a href="login.jsp"><i class="fas fa-user"></i></a>
               
            </div>        
        </header>

<%
 String fallo= request.getParameter("fallo");
 if (fallo != null && fallo.equals("error")){ %>
            <script>
                alert('Usuario y/o contraseña erroneos, verifica y vuelve a iniciar. ')</script>
            <%
        }
        %>
           
    <br><br><br><br>
    <!-- Formulario -->
    
  <center>
    <form method="POST" action="Login">
     <br><br>
        <h2>Iniciar Sesion</h2>
        <br>   
    <label>Usuario :
             <input type="number" name="Documento" class="form-control" required pattern="[0-9]{10}">
        </label><br><br>
        <div class="campo">
    <label>Contrasena :</label>
            <input type="password" name="Contrasena" id="password" class="form-control" required >
            <span>mostrar</span><br>
        </div>




<br>
<div class="grupo boton animacion" >
<br>
<button><strong>INGRESAR</strong></button>
</div>
</form>
      <script>
          document.querySelector('.campo span').addEventListener('click', e => {
              const passwordInput = document.querySelector('#password');
              if (e.target.classList.contains('show')) {
                  e.target.classList.remove('show');
                  e.target.textContent = 'Ocultar';
                  passwordInput.type = 'text';
              } else {
                  e.target.classList.add('show');
                  e.target.textContent = 'Mostrar';
                  passwordInput.type = 'password';
              }
          });
      </script>
</center>
<br> <br>
            <br><br><br>
       
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