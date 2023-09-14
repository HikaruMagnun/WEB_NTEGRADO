<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Iniciar Sesion</title>
<link href="styles.css" rel="stylesheet">
</head>
   
    
<body>
    <div class="login-container">
        <h2>Iniciar Sesion</h2>
        <form action="procesar_login.php" method="POST">
            <div class="form-group">
                <label for="username">Usuario:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="login-button">Ingresar</button>
        </form>
        <p>No tienes una cuenta? <a href="registro.php">Registrarse</a></p>
    </div>
</body>
</html>
