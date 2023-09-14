package moviland.admin.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import moviland.admin.dao.CelularDaoImplement;
import moviland.admin.dao.CelularDao;
import moviland.admin.model.Celular;
import moviland.admin.dao.UsuarioDao;
import moviland.admin.dao.UsuarioDaoImplement;
import moviland.admin.model.Usuario;

@WebServlet("/AdminController")

public class AdminController extends HttpServlet {

	public static final String catalogo = "catalogo.jsp";
	public static final String login = "login.jsp";
	public static final String sign = "sign.jsp";
	public static final String index = "index.jsp";
	public static final String actualizar = "ActualizarCatalogo.jsp";
	HttpSession sesion;

	public AdminController() {
		super();
	}

	protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta)
			throws ServletException, IOException {
		CelularDaoImplement celular = new CelularDaoImplement();
		String redireccion = "";
		String utilidad = solicitud.getParameter("utilidad");
		if (utilidad.equalsIgnoreCase("mostrar")) {
			redireccion = catalogo;
			sesion = solicitud.getSession();
			sesion.setAttribute("celulares", celular.ListarCelulares());

		} else if (utilidad.equalsIgnoreCase("eliminar")) {
			// Capturar el codigo del objeto a eliminar
			int id = Integer.parseInt(solicitud.getParameter("codigo"));
			// Hacer uso del método dar baja
			System.out.println("Eliminando " + id);
			celular.darBaja(id);
			redireccion = catalogo;
			sesion = solicitud.getSession();
			// productos se asocia a dao.findAll (listarTodos)
			sesion.setAttribute("celulares", celular.ListarCelulares());
		} else if (utilidad.equalsIgnoreCase("editar")) {
			int id = Integer.parseInt(solicitud.getParameter("codigo"));
			// hacer uso del método findId
			Celular cel = celular.BuscarCelulares(id);
			sesion = solicitud.getSession();
			sesion.setAttribute("celular", cel);
			redireccion = actualizar;
		} else if (utilidad.equalsIgnoreCase("insertar")) {
			System.out.println("insertar");
			sesion = solicitud.getSession();
			// sesion.setAttribute("asignatura", null);
			// redireccion = insertar;
		} else if (utilidad.equalsIgnoreCase("listar")) {
			System.out.println("Listar");
			// resp.sendRedirect("hola.jsp");
			// redireccion = listarAsignatura;
			sesion = solicitud.getSession();
			// productos se asocia a dao.findAll (listarTodos)
			sesion.setAttribute("asignaturas", celular.ListarCelulares());
		} else if (utilidad.equalsIgnoreCase("login")) {
			redireccion = login;
		} else if (utilidad.equalsIgnoreCase("sign")) {
			redireccion = sign;
		}else if ((utilidad.equalsIgnoreCase("deslogear"))) {

			String nombreCookie = "user";

			Cookie cookieEliminar = new Cookie(nombreCookie, "");
			cookieEliminar.setMaxAge(0);

			respuesta.addCookie(cookieEliminar);
			 try {
				Thread.sleep(1000);
				redireccion = index;
				RequestDispatcher request = solicitud.getRequestDispatcher(redireccion);
				request.forward(solicitud, respuesta);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		RequestDispatcher request = solicitud.getRequestDispatcher(redireccion);
		request.forward(solicitud, respuesta);
	}

	protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta)
			throws ServletException, IOException {
		CelularDao celular = new CelularDaoImplement();
		String utilidad = solicitud.getParameter("utilidad");
		

		
		UsuarioDao dao = new UsuarioDaoImplement();
		String form = solicitud.getParameter("form");
		Usuario usuario = new Usuario();
		String redireccion = "";
		if (form.equalsIgnoreCase("login")) {
			usuario.setCorreo(solicitud.getParameter("correo"));
			usuario.setContraseña(solicitud.getParameter("password"));
			usuario = dao.validar(usuario);
			if (usuario != null) {
				String nombreUsuario = usuario.getNombre().replace(" ", ""); // Eliminar espacios en blanco
				Cookie cookie = new Cookie("user", nombreUsuario);
				System.out.println(cookie.getValue());
				respuesta.addCookie(cookie);
				redireccion = index;
				RequestDispatcher request = solicitud.getRequestDispatcher(redireccion);
				request.forward(solicitud, respuesta);
			} else {

				String mensajeDeError = "<script>\r\n" + "      mostrarError();\r\n" + "    </script>";
				respuesta.getWriter().write(mensajeDeError);

				redireccion = login;
				RequestDispatcher request = solicitud.getRequestDispatcher(redireccion);
				request.forward(solicitud, respuesta);

			}
		} else if ((form.equals("sign"))) {
			usuario.setNombre(solicitud.getParameter("nombre"));
			usuario.setCorreo(solicitud.getParameter("email"));
			usuario.setContraseña(solicitud.getParameter("contraseña"));
			usuario.setTipo_usuario("administrador");

			boolean bol = dao.registrar(usuario);
			if (bol) {
				redireccion = login;
				RequestDispatcher request = solicitud.getRequestDispatcher(redireccion);
				request.forward(solicitud, respuesta);
			} else {
				redireccion = sign;
				RequestDispatcher request = solicitud.getRequestDispatcher(redireccion);
				request.forward(solicitud, respuesta);
			}
		} else if ((form.equals("actualizar"))) {
			Celular cel = new Celular();
			cel.setID(Integer.parseInt(solicitud.getParameter("idCelular")));
			cel.setMarca(solicitud.getParameter("marca"));
			cel.setNombre(solicitud.getParameter("nombre"));
			cel.setStock(Integer.parseInt(solicitud.getParameter("stockcel")));
			cel.setPantalla(Float.parseFloat(solicitud.getParameter("pantallacel")));
			cel.setBateria(Float.parseFloat(solicitud.getParameter("bateriacel")));
			cel.setSO(solicitud.getParameter("socel"));
			cel.setCamara(Float.parseFloat(solicitud.getParameter("camaracel")));
			cel.setAlmacenamiento(Integer.parseInt(solicitud.getParameter("almacenamientocel")));
			cel.setImgLink(solicitud.getParameter("imagencel"));
			cel.setPrecio(Float.parseFloat(solicitud.getParameter("preciocel")));
			
			celular.actualizar(cel);
			redireccion = catalogo;
			RequestDispatcher request = solicitud.getRequestDispatcher(redireccion);
			request.forward(solicitud, respuesta);
		} 
	}

}
