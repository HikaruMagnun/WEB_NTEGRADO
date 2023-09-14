<%@ page import="moviland.admin.model.Celular"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html;
charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Actualizar Productos</title>
<link href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"
	rel="stylesheet" />
</head>
<body>
	<nav class="navbar is-black" role="navigation"
		aria-label="main navigation">
		<div class="navbar-brand">
			<a class="navbar-item"> <img src="img/icon.png" />
			</a> <a role="button" class="navbar-burger" aria-label="menu"
				aria-expanded="false" data-target="navbarBasicExample">
				<span aria-hidden="true"></span> <span aria-hidden="true"></span> <span
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
						<a class="button is-primary" href="AdminController?utilidad=sign">
							<strong>Sign up</strong>
						</a> <a class="button is-light" href="AdminController?utilidad=login">
							Log in </a>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<%
	Celular celu = (Celular) request.getSession().getAttribute("celular");
	%>
	<br />
	<h1 class="title has-text-centered">Actualizar asignatura</h1>
	<nav class="formulario" style="margin: 5%">
		<form action="AdminController?form=actualizar" method="post">
			<div>
				<label for="idCelular">ID del Celular</label> <input
					class="input is-primary" type="number" id="idCelular"
					name="idCelular" placeholder="ID" value="<%=celu.getID()%>"
					readonly /> <input type="hidden" name="idCelular"
					value="<%=celu.getID()%>" />
			</div>
			<br />
			<div>
				<label for="marca">Marca del Celular</label> <input
					class="input is-primary" type="text" id="marca" name="marca" placeholder="MARCA"
					value="<%=celu.getMarca()%>" />
			</div>
			<br />
			<div>
				<label for="nombre">Nombre del Celular</label> <input
					class="input is-primary" type="text" id="nombre" name="nombre" placeholder="NOMBRE / MODELO"
					value="<%=celu.getNombre()%>" />
			</div>
			<br />
			<div>
				<label for="stockcel">Stock del Celular</label> <input
					class="input is-primary" type="number" id="stockcel" name="stockcel"
					placeholder="STOCK" value="<%=celu.getStock()%>" />
			</div>
			<br />
			<div>
				<label for="pantallacel">Pantalla del Celular</label> <input
					class="input is-primary" type="number" id="pantallacel" name="pantallacel" placeholder="PANTALLA (In)"
					value="<%=celu.getPantalla()%>" />
			</div>
			<br />
			<div>
				<label for="bateriacel">Batería del Celular</label> <input
					class="input is-primary" type="number" id="bateriacel" name="bateriacel" placeholder="BATERÍA (mAh)"
					value="<%=celu.getBateria()%>" />
			</div>
			<br />
			<div>
				<label for="socel">Sistema Operativo del Celular</label> <input
					class="input is-primary" type="text" id="socel" name="socel"
					placeholder="SISTEMA OPERATIVO" value="<%=celu.getSO()%>" />
			</div>
			<br />
			<div>
				<label for="camaracel">Camara del Celular</label> <input
					class="input is-primary" type="number" id="camaracel" name="camaracel" placeholder="CAMARA (MP)"
					value="<%=celu.getCamara()%>" />
			</div>
			<br />
			<div>
				<label for="almacenamientocel">Almacenamiento del Celular</label> <input
					class="input is-primary" type="number" id="almacenamientocel" name="almacenamientocel"
					placeholder="ALMACENAMIENTO (GB)"
					value="<%=celu.getAlmacenamiento()%>" />
			</div>
			<br />
			<div>
				<label for="imagencel">Imagen para el Celular</label> <input
					class="input is-primary" type="text" id="imagencel" name="imagencel"
					placeholder="LINK DE LA IMAGEN" value="<%=celu.getImgLink()%>" />
			</div>
			<br />
			<div>
				<label for="preciocel">Precio del Celular</label> <input
					class="input is-primary" type="number" id="preciocel" name="preciocel" placeholder="PRECIO S/."
					value="<%=celu.getPrecio()%>" />
			</div>
			<br />
			<div class="buttons">
				<button class="button is-success" type="submit">Actualizar!</button>
			</div>
		</form>
	</nav>
</body>
</html>
