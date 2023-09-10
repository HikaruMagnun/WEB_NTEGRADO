package moviland.admin.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {
	protected static Connection db;
	
	public static Connection conectar() {
		
		if(db != null) {
			return db;
		}
		try {
			String rutadb = "jdbc:postgresql://db.zdzpvwbsiotzqbhehofi.supabase.co:5432/postgres?user=postgres&password=CsG6kXHfN4KVnktT";
			String driver = "org.postgresql.Driver";
			Class.forName(driver);
			db = DriverManager.getConnection(rutadb);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("Error en la 'BASE DE DATOS'");
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}
		return db;
	}
}
