package moviland.admin.prueba;

import moviland.admin.dao.UsuarioDaoImplement;
import moviland.admin.model.Usuario;

public class PruebaDB03 {
	public static void main(String[] args) {
		UsuarioDaoImplement usuarioDao = new UsuarioDaoImplement(); // Debes inicializar tu DAO aquí

		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setNombre("Nuevo Usuario");
		nuevoUsuario.setCorreo("nuevo@example.com");
		nuevoUsuario.setContraseña("nuevaContraseña");
		nuevoUsuario.setTipo_usuario("administrador");

		boolean resultado = usuarioDao.registrar(nuevoUsuario);

		if (resultado) {
			System.out.println("Registro exitoso.");
		} else {
			System.out.println("Fallo en el registro.");
		}
	}

}
