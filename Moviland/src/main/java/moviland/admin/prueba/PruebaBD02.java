package moviland.admin.prueba;

import java.util.List;

import moviland.admin.dao.CelularDaoImplement;
import moviland.admin.model.Celular;


public class PruebaBD02 {
	
	public static void main(String[]args) {
		CelularDaoImplement celular = new CelularDaoImplement();
		List<Celular> celulares = celular.ListarCelulares();
		for(Celular celu:celulares) {
			System.out.println(celu.getID()+", "+celu.getMarca()+", "+celu.getPrecio());
		}
	}
	
}
