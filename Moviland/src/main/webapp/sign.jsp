<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registrarse</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="registro-container">
        <h2>Registrarse</h2>
        <form method="POST" action="AdminController?form=sign">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>
            </div>
          
            <div class="form-group">
                <label for="email">Correo Electronico:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="contraseña">Contraseña:</label>
                <input type="password" id="contraseña" name="contraseña" required>
            </div>
             
            <button type="submit" class="registro-button">Registrarse</button>
        </form>
        <p>¿Ya tienes una cuenta? <a href="AdminController?utilidad=login">Iniciar Sesion</a></p>
    </div>
</body>
</html>
