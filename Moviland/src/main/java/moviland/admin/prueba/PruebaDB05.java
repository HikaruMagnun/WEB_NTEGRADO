package moviland.admin.prueba;

import moviland.admin.dao.CelularDaoImplement;
import moviland.admin.model.Celular;

public class PruebaDB05 {

	public static void main(String[] args) {
		try {
			CelularDaoImplement cel = new CelularDaoImplement();

	        // Crear un objeto de prueba de Celular
	        Celular celular = new Celular();
	        celular.setID(1);
	        celular.setMarca("Samsung");
	        celular.setNombre("Galaxy S21");
	        celular.setStock(10);
	        celular.setPantalla(6);
	        celular.setBateria(4000);
	        celular.setSO("Android");
	        celular.setCamara(12);
	        celular.setAlmacenamiento(128);
	        celular.setImgLink("imagen.jpg");
	        celular.setPrecio(799);

	        cel.insertarCelular(celular);

	        System.out.println("Inserción de celular completada.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		    
		


	}

}
