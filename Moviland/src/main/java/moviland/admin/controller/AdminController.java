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
	public static final String actualizar = "/ActualizarCatalogo.jsp";
	HttpSession session;

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
			session = solicitud.getSession();
			session.setAttribute("celulares", celular.ListarCelulares());

		} else if (utilidad.equalsIgnoreCase("eliminar")) {
			// Capturar el codigo del objeto a eliminar
			int id = Integer.parseInt(solicitud.getParameter("codigo"));
			// Hacer uso del método dar baja
			System.out.println("Eliminando " + id);
			celular.darBaja(id);
			redireccion = catalogo;
			session = solicitud.getSession();
			// productos se asocia a dao.findAll (listarTodos)
			session.setAttribute("asignaturas", celular.ListarCelulares());
		} else if (utilidad.equalsIgnoreCase("editar")) {
			int id = Integer.parseInt(solicitud.getParameter("codigo"));
			// hacer uso del método findId
			Celular cel = celular.BuscarCelulares(id);
			session = solicitud.getSession();
			session.setAttribute("asignatura", cel);
			redireccion = actualizar;
		} else if (utilidad.equalsIgnoreCase("insertar")) {
			System.out.println("insertar");
			session = solicitud.getSession();
			// sesion.setAttribute("asignatura", null);
			// redireccion = insertar;
		} else if (utilidad.equalsIgnoreCase("listar")) {
			System.out.println("Listar");
			// resp.sendRedirect("hola.jsp");
			// redireccion = listarAsignatura;
			session = solicitud.getSession();
			// productos se asocia a dao.findAll (listarTodos)
			session.setAttribute("asignaturas", celular.ListarCelulares());
		} else if (utilidad.equalsIgnoreCase("login")) {
			redireccion = login;
		} else if (utilidad.equalsIgnoreCase("sign")) {
			redireccion = sign;
		}
		RequestDispatcher request = solicitud.getRequestDispatcher(redireccion);
		request.forward(solicitud, respuesta);
	}

	protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta)
			throws ServletException, IOException {
		UsuarioDao dao = new UsuarioDaoImplement();
		String form = solicitud.getParameter("form");
		Usuario usuario = new Usuario();
		String redireccion = "";
		if (form.equals("login")) {
			usuario.setCorreo(solicitud.getParameter("correo"));
			usuario.setContraseña(solicitud.getParameter("password"));
			usuario = dao.validar(usuario);
			if (usuario != null) {
				Cookie cookie = new Cookie("user", usuario.getNombre());
				System.out.println(cookie.getValue());
				redireccion = index;
				RequestDispatcher request = solicitud.getRequestDispatcher(redireccion);
				request.forward(solicitud, respuesta);
			} else {

				String mensajeDeError = "<script>\r\n"
						+ "      mostrarError();\r\n"
						+ "    </script>";
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
		}

	}

}
