package moviland.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import moviland.admin.db.Conexion;
import moviland.admin.model.Celular;
import moviland.admin.model.Usuario;

public class UsuarioDaoImplement implements UsuarioDao {

	private Connection db;

	public UsuarioDaoImplement() {
		db = Conexion.conectar();

	}

	@Override
	public boolean registrar(Usuario usuario) {

		try {

			String sql = "INSERT INTO public.\"Usuario\" (\"Nombre\", \"Correo\", \"Contraseña\", \"tipo_usuario\") "
					+ "VALUES (?, ?, ?, ?)";

			PreparedStatement preparedStatement = db.prepareStatement(sql);

			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getCorreo());
			preparedStatement.setString(3, usuario.getContraseña());
			preparedStatement.setString(4, usuario.getTipo_usuario());
			int filasAfectadas = preparedStatement.executeUpdate();

			if (filasAfectadas > 0) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("ERROR en la insercio");
			return false;
		}
		return false;

	}

	@Override
	public Usuario validar(Usuario usuario) {
		try {
			String sql = "SELECT * FROM public.\"Usuario\" WHERE \"Correo\" = ? AND \"Contraseña\" = ?";
			PreparedStatement preparedStatement = db.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getCorreo());
			preparedStatement.setString(2, usuario.getContraseña());

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				usuario.setNombre(resultSet.getString("Nombre"));
				usuario.setTipo_usuario(resultSet.getString("tipo_usuario"));

				return usuario;
			}
			return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("ERROR en la validacion");
			return null;
		}
	}

}
