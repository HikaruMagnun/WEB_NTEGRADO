package moviland.admin.model;

public class Usuario {
	String nombre;
	 String correo;
	 String Contraseña;
	 String tipo_usuario;
	public Usuario() {
	}
	public Usuario(int iD, String nombre, String correo, String contraseña, String tipo_usuario) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		Contraseña = contraseña;
		this.tipo_usuario = tipo_usuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	public String getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	
	
	 
	 
}
