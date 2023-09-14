package moviland.admin.prueba;

import moviland.admin.dao.UsuarioDaoImplement;
import moviland.admin.model.Usuario;
public class PruebaDB04 {

	public static void main(String[] args) {
		UsuarioDaoImplement usuarioDao = new UsuarioDaoImplement(); // Debes inicializar tu DAO aquí
		Usuario usuario = new Usuario(); 
        // Supongamos que tienes un usuario de prueba en la base de datos con correo y contraseña válidos
        usuario.setCorreo("correo@example.com");
        usuario.setContraseña("contraseña123");
        // Intenta validar el usuario y la contraseña
        usuarioDao.validar(usuario);

        System.out.println(usuario.getCorreo());
       System.out.println(usuario.getNombre());

	}

}
