<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Iniciar Sesion</title>

    <link href="styles.css" rel="stylesheet" />
     <script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="script\notifcaciones.js"></script>
  </head>

  <body>
    
    <div class="login-container">
      <h2>Iniciar Sesion</h2>
      <form method="POST" action="AdminController?form=login">
        <div class="form-group">
          <label for="username">Correo:</label>
          <input type="email" id="correo" name="correo" required />
        </div>
        <div class="form-group">
          <label for="password">Contraseña:</label>
          <input type="password" id="password" name="password" required />
        </div>
        <button type="submit" class="login-button">Ingresar</button>
      </form>
      <p>No tienes una cuenta? <a href="sign.jsp">Registrarse</a></p>
    </div>
   
  </body>
</html>
