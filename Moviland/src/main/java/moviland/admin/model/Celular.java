package moviland.admin.model;

public class Celular {
	int ID;

	
	String Marca;
	String Nombre;
	int Stock;
	float Pantalla;
	float Bateria;
	String SO;
	float Camara;
	int Almacenamiento;
	String imgLink;
	float Precio;
	
	public Celular(int iD, String marca, String nombre, int stock, float pantalla, float bateria, String sO,
			float camara, int almacenamiento, String imgLink, float precio) {
		super();
		ID = iD;
		Marca = marca;
		Nombre = nombre;
		Stock = stock;
		Pantalla = pantalla;
		Bateria = bateria;
		SO = sO;
		Camara = camara;
		Almacenamiento = almacenamiento;
		this.imgLink = imgLink;
		Precio = precio;
	}
	
	public Celular() {
	};
	

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public float getPantalla() {
		return Pantalla;
	}
	public void setPantalla(float pantalla) {
		Pantalla = pantalla;
	}
	public float getBateria() {
		return Bateria;
	}
	public void setBateria(float bateria) {
		Bateria = bateria;
	}
	public String getSO() {
		return SO;
	}
	public void setSO(String sO) {
		SO = sO;
	}
	public float getCamara() {
		return Camara;
	}
	public void setCamara(float camara) {
		Camara = camara;
	}
	public int getAlmacenamiento() {
		return Almacenamiento;
	}
	public void setAlmacenamiento(int almacenamiento) {
		Almacenamiento = almacenamiento;
	}
	public String getImgLink() {
		return imgLink;
	}
	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
	public float getPrecio() {
		return Precio;
	}
	public void setPrecio(float precio) {
		Precio = precio;
	}
}
