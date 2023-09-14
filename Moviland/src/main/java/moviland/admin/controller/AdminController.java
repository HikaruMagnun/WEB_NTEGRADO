package moviland.admin.controller;

import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import moviland.admin.dao.CelularDaoImplement;
import moviland.admin.model.Celular;


@WebServlet("/AdminController")

public class AdminController extends HttpServlet{
	
	public static final String catalogo = "catalogo.jsp";
	public static final String login = "login.jsp";
	public static final String sign = "sign.jsp";
	public static final String actualizar = "/actualizarAsignatura.jsp";
	HttpSession session;
	
	
	public AdminController() {
		super();
	}
	
	protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
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
			System.out.println("Eliminando "+id);
			celular.darBaja(id);
			redireccion = catalogo;
			session = solicitud.getSession();
			// productos se asocia a dao.findAll (listarTodos)
			session.setAttribute("asignaturas", celular.ListarCelulares());
		} else if (utilidad.equalsIgnoreCase("editar")) {
			int id = Integer.parseInt(solicitud.getParameter("codigo")) ;
			// hacer uso del método findId
			Celular cel = celular.BuscarCelulares(id);
			session = solicitud.getSession();
			session.setAttribute("asignatura", cel);
			redireccion = actualizar;
		} else if (utilidad.equalsIgnoreCase("insertar")) {
			System.out.println("insertar");
			session = solicitud.getSession();
			//sesion.setAttribute("asignatura", null); 
			// redireccion = insertar;
		} else if (utilidad.equalsIgnoreCase("listar")) {
			System.out.println("Listar");
			//resp.sendRedirect("hola.jsp");
			// redireccion = listarAsignatura;
			session = solicitud.getSession();
			// productos se asocia a dao.findAll (listarTodos)
			session.setAttribute("asignaturas", celular.ListarCelulares());
		} else if (utilidad.equalsIgnoreCase("login")) {
			redireccion = login;
		}else if (utilidad.equalsIgnoreCase("sign")) {
			redireccion = sign;
		}
		RequestDispatcher request = solicitud.getRequestDispatcher(redireccion);
		request.forward(solicitud, respuesta);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// IAsignaturaDao dao = new AsignaturaDaoImplement();
		// String accion = req.getParameter("accion");
		// Crear una instancia de la clase producto
		// Asignatura asig = new Asignatura();
		// asig.setCodigo(req.getParameter("codigo"));
		// asig.setNombre(req.getParameter("nombre"));
		// asig.setHoras(Integer.parseInt(req.getParameter("horas")));
		// asig.setTipo(req.getParameter("tipo"));
		// asig.setCreditos(Integer.parseInt(req.getParameter("creditos")));
		// if(accion.equals("guardar")) {
			// dao.insertar(asig);
		// }else {
			// dao.actualizar(asig);
		// }
		// sesion.setAttribute("asignaturas", dao.buscarTodos());
		// vista permite asociar a una redirección
		// RequestDispatcher vista = req.getRequestDispatcher(listarAsignatura);
		// Enviar a la redirección que se elige..
		// vista.forward(req, resp);
	}

	
}
