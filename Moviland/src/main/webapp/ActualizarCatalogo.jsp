<%@page import="moviland.admin.model.Celular" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"
	rel="stylesheet">
</head>
<body>

	<nav class="navbar is-black" role="navigation"
		aria-label="main navigation">
		<div class="navbar-brand">
			<a class="navbar-item"> <img src="img/icon.png">
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
						<hr class="navbar-divider">
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
				Celular celu=(Celular)request.getSession().getAttribute("celular");
			%>

	<h1 class="text-center">Actualizar asignatura</h1>
	<form action="CursoController?accion=actualizar" method="post">
		
		<!--  
		<div class="form-group">
			<div>
				<label for="codigo">Código</label>
				<input class="form-control" type="text" id="codigo" name="codigo" value="<%=curso.getCodigo()%>" readonly>
				<input class="form-control" type="hidden" id="codigo" name="codigo" value="<%=curso.getCodigo()%>" >
			</div>
			<div>
				<label for="nombre">Nombre</label>
				<input class="form-control" type="text" id="nombre" name="nombre" value="<%=curso.getNombre()%>" >
			</div>
			<div>
				<label for="horas">Horas</label>
				<input class="form-control" type="number" id="horas" name="horas" value="<%=curso.getHoras()%>" >
			</div>
			<div>
				<label for="tipo">Tipo de curso</label>
				<input class="form-control" type="text" id="tipo" name="tipo" value="<%=curso.getTipo()%>" >
			</div>
			<div>
				<label for="creditos">Creditos</label>
				<input class="form-control" type="number" id="creditos" name="creditos" value="<%=curso.getCreditos()%>" >
			</div>
			<div>
				<input class="btn btn-primary" type="submit" value="Actualizar">
			</div>
		</div>	
		-->
	</form>
</body>
</html>