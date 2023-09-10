package moviland.admin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import moviland.admin.db.Conexion;
import moviland.admin.model.Celular;

public class CelularDaoImplement implements CelularDao {
	private Connection db;

	public CelularDaoImplement() {
		db = Conexion.conectar();
		
	}
	@Override 
	public List<Celular> ListarCelulares(){
		List<Celular> = new ArrayList<>();
		try {
			String sql = "select * from \"Celulares\";";
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Celular cel = new Celular();
				cel.setID(rs.getInt("ID"));
				cel.setMarca(rs.getString("Marca"));
				cel.setNombre(rs.getString("Nombre"));
				cel.setStock(rs.getInt("Stock"));
				cel.setPantalla(rs.getFloat("Pantalla(In)"));
				cel.setBateria(rs.getFloat("Bateria(mAh)"));
				cel.setSO(rs.getString("S.O."));
				cel.setCamara(rs.getFloat("Camara(MP)"));
				cel.setAlmacenamiento(rs.getInt("Almacenamiento(GB)"));
				cel.setImgLink(rs.getString("img(link)"));
				cel.setPrecio(rs.getFloat("Precio"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
}
