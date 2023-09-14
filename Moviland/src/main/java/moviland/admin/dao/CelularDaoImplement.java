package moviland.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		List<Celular> celulares = new ArrayList<>();
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
				celulares.add(cel);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("ERROR en la tabla 'Celulares'");
		}
		return celulares;
	}
	@Override
	public void insertarCelular(Celular celular) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void eliminarCelular(Celular celular) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editarCelular(Celular celular) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Celular BuscarCelulares(int id) {
		// TODO Auto-generated method stub
		Celular cel=new Celular();
		return cel;
	}
	@Override
	public void darBaja(int id) {
		// TODO Auto-generated method stub
		try {
	   		 String sql="DELETE FROM \"Celulares\" WHERE \"ID\" = ? ;";
	   		 //Preparar para procesar la sentencia sql
	   		 PreparedStatement ps = db.prepareStatement(sql);

	   		 ps.setInt(1,id);
	   		 //Ejecutar la sentencia sql
	   		 ps.executeUpdate();
	   		 ps.close();
	   	 } catch (Exception e) {
	   		 System.err.println("Error al eliminar datos: "+e.getMessage());
	   	 }
	}

}
	
	
	

