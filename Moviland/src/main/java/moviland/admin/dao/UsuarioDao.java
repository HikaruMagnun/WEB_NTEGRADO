package moviland.admin.dao;

import moviland.admin.model.Usuario;

public interface UsuarioDao {
	public boolean registrar(Usuario usuario);

	public Usuario validar(Usuario usuario);

}
