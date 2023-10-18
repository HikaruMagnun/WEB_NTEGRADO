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
	
	public List<Celular> ListarCelulares() {
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

	private String obtenerMarcaOriginal(int id) {
		String marcaOriginal = null;
		try {
			String sql = "SELECT \"Marca\" FROM public.\"Celulares\" WHERE \"ID\" = ? ;";
			PreparedStatement ps = db.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				marcaOriginal = rs.getString("Marca");
			}

			rs.close();
			ps.close();
		} catch (Exception e) {
			System.out.println("Error al obtener la marca original: " + e.getMessage());
		}

		return marcaOriginal;
	}

	@Override
	public void insertarCelular(Celular celular) {
		try {

			String sql = "INSERT INTO \"Celulares\" (\"ID\", \"Marca\", \"Nombre\", \"Stock\",\"Pantalla(In)\",\"Bateria(mAh)\",\"S.O.\",\"Camara(MP)\",\"Almacenamiento(GB)\",\"img(link)\",\"Precio\")"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = db.prepareStatement(sql);
			ps.setInt(1, celular.getID());
			ps.setString(2, celular.getMarca());
			ps.setString(3, celular.getNombre());
			ps.setInt(4, celular.getStock());
			ps.setFloat(5, celular.getPantalla());
			ps.setFloat(6, celular.getBateria());
			ps.setString(7, celular.getSO());
			ps.setFloat(8, celular.getCamara());
			ps.setInt(9, celular.getAlmacenamiento());
			ps.setString(10, celular.getImgLink());
			ps.setFloat(11, celular.getPrecio());
			ps.execute();
			ps.close();
		} catch (Exception e) {
			System.out.println("Error al insertar los datos... " + e.getMessage());
		}
	}

	@Override
	public void actualizar(Celular celular) {
		try {
			String sql = "UPDATE \"Celulares\" SET \"Marca\" = ?, \"Nombre\" = ?, \"Stock\" = ?,\"Pantalla(In)\" = ?,\"Bateria(mAh)\" = ?,\"S.O.\" = ?,\"Camara(MP)\" = ?,\"Almacenamiento(GB)\" = ?,\"img(link)\" = ?,\"Precio\" = ? WHERE \"ID\" = ? ;";

			PreparedStatement ps = db.prepareStatement(sql);

			ps.setString(1, celular.getMarca());
			ps.setString(2, celular.getNombre());
			ps.setInt(3, celular.getStock());
			ps.setFloat(4, celular.getPantalla());
			ps.setFloat(5, celular.getBateria());
			ps.setString(6, celular.getSO());
			ps.setFloat(7, celular.getCamara());
			ps.setInt(8, celular.getAlmacenamiento());
			ps.setString(9, celular.getImgLink());
			ps.setFloat(10, celular.getPrecio());
			ps.setInt(11, celular.getID());
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			System.out.println("Error al actualizar los datos... " + e.getMessage());
		}
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
		Celular cel = new Celular();

		try {
			String sql = "select * from \"Celulares\" where \"ID\" = ? ;";
			PreparedStatement ps = db.prepareStatement(sql);

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
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
			System.err.println("Error al buscar datos mediante la ID: " + e.getMessage());
		}

		return cel;
	}

	@Override
	public void darBaja(int id) {
		// TODO Auto-generated method stub
		try {
			String sql = "DELETE FROM \"Celulares\" WHERE \"ID\" = ? ;";
			// Preparar para procesar la sentencia sql
			PreparedStatement ps = db.prepareStatement(sql);

			ps.setInt(1, id);
			// Ejecutar la sentencia sql
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			System.err.println("Error al eliminar datos: " + e.getMessage());
		}
	}

}
