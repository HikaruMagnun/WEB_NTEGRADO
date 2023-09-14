<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="moviland.admin.model.Celular"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"
	rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar is-black" role="navigation"
		aria-label="main navigation">
		<div class="navbar-brand">
			<a class="navbar-item" href="https://bulma.io"> <img
				src="img/icon.png" />
			</a> <a role="button" class="navbar-burger" aria-label="menu"
				aria-expanded="false" data-target="navbarBasicExample"> <span
				aria-hidden="true"></span> <span aria-hidden="true"></span> <span
				aria-hidden="true"></span>
			</a>
		</div>

		<div id="navbarBasicExample" class="navbar-menu">
			<div class="navbar-start">
				<a class="navbar-item" href="index.jsp"> Inicio </a> <a
					class="navbar-item" href="AdminController?utilidad=mostrar">
					Catálogo </a>

				<div class="navbar-item has-dropdown is-hoverable">
					<a class="navbar-link"> Más </a>

					<div class="navbar-dropdown">
						<a class="navbar-item"> Nosotros </a> <a class="navbar-item">
							Jobs </a> <a class="navbar-item"> Contáctenos </a>
						<hr class="navbar-divider" />
						<a class="navbar-item"> Report an issue </a>
					</div>
				</div>
			</div>

			<div class="navbar-end">
				<div class="navbar-item">
					<div class="buttons">
						<a class="button is-primary"> <strong>Sign up</strong>
						</a> <a class="button is-light"> Log in </a>
					</div>
				</div>
			</div>
		</div>
	</nav>

	<table class="table">
		<thead>
			<tr>
				<th><abbr title="Position">ID</abbr></th>
				<th>MARCA</th>
				<th><abbr title="Played">Nombre</abbr></th>
				<th><abbr title="Won">Stock</abbr></th>
				<th><abbr title="Drawn">Pantalla</abbr></th>
				<th><abbr title="Lost">Batería</abbr></th>
				<th><abbr title="Goals for">S.O.</abbr></th>
				<th><abbr title="Goals against">Camara</abbr></th>
				<th><abbr title="Won">Almacenamiento</abbr></th>
				<th><abbr title="Goal difference">Imagen</abbr></th>
				<th><abbr title="Points">Precio</abbr></th>
				<th colspan="2"><abbr>Opciones</abbr></th>

			</tr>
		</thead>

		<tbody>
			<%
			List<Celular> celulares = (List) request.getSession().getAttribute("celulares");
			for (Celular cel : celulares) {
			%>s

			<tr>
				<td><%=cel.getID()%></td>
				<td><%=cel.getMarca()%></td>
				<td><%=cel.getNombre()%></td>
				<td><%=cel.getStock()%></td>
				<td><%=cel.getPantalla()%></td>
				<td><%=cel.getBateria()%></td>
				<td><%=cel.getSO()%></td>
				<td><%=cel.getCamara()%></td>
				<td><%=cel.getAlmacenamiento()%></td>
				<td><%=cel.getImgLink()%></td>
				<td><%=cel.getPrecio()%></td>
				
				<td><a class="btn btn-success" href="AdminController?utilidad=editar&codigo=<%=cel.getID()%>">Editar</a></td>
   				<td><a class="btn btn-danger" href="AdminController?utilidad=eliminar&codigo=<%=cel.getID()%>">Eliminar</a></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>
