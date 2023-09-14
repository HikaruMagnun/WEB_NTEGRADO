package moviland.admin.prueba;

import java.sql.Connection;

import moviland.admin.db.Conexion;

public class PruebaBD01 {

    public static void main(String[] args) {
        Conexion cn = new Conexion();
        // Realizar la conexion
        Connection cx = cn.conectar();
        // Evaluar si existe coneccion
        if (cx != null) {
            System.out.println("Conectado a 'PostgreSQL'");
            // Cerrar la coneccion
            // cn.desconectar();
        } else {
            System.out.println("No hay conección con 'PostgreSQL'");
        }
    }
}
