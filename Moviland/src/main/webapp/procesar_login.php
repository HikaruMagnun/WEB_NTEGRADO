<?php
// Configura la información de conexión a la base de datos en XAMPP
$servername = "localhost"; // El servidor MySQL suele estar en localhost
$username = "root"; // Usuario de MySQL (reemplaza con tu nombre de usuario)
$password = ""; // Contraseña de MySQL (reemplaza con tu contraseña)
$dbname = "usuariospag"; // Nombre de la base de datos

// Crea una conexión a la base de datos
$conn = new mysqli($servername, $username, $password, $dbname);

// Verifica la conexión
if ($conn->connect_error) {
    die("La conexión a la base de datos falló: " . $conn->connect_error);
}

// Comprueba si se ha enviado el formulario de inicio de sesión
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Obtiene los valores del formulario de inicio de sesión
    $usuario = $_POST['username'];
    $contraseña = $_POST['password'];

    // Realiza una consulta para verificar si el usuario existe
    $sql = "SELECT * FROM usuariospag WHERE usuario = '$usuario' AND contraseña = '$contraseña'";
    $resultado = $conn->query($sql);

    if ($resultado->num_rows == 1) {
        // El usuario existe, puedes redirigirlo a la página "inicio_exitoso.html"
        header("Location: inicio_exitoso.php");
    } else {
        // El usuario no existe, muestra un mensaje de error o redirige a otra página
        echo '<script>alert("El usuario no existe.");</script>';
        // Puedes redirigir al usuario a una página de error aquí
    }
}

// Cierra la conexión a la base de datos cuando hayas terminado de usarla
$conn->close();
?>
