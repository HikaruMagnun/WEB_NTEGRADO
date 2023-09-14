package moviland.admin.dao;

import java.util.List;

import moviland.admin.model.Celular;

public interface CelularDao {

	
	public List<Celular> ListarCelulares();
		
	public void insertarCelular(Celular celular);
	public void eliminarCelular(Celular celular);
	public void editarCelular(Celular celular);
	public Celular BuscarCelulares(int id);
	public void darBaja(int id);

	public void actualizar(Celular celular);
	
	
}
