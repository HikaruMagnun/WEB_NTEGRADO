<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="css\stilos.css">
</head>
<body>
	<nav class="navbar is-black" role="navigation"
		aria-label="main navigation">
		<div class="navbar-brand">
			<a class="navbar-item"> <img src="img/icon.png" />
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
					<%
					Cookie[] cookies = request.getCookies();
					String usuario = "";
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							if ("user".equals(cookie.getName())) {
						usuario = cookie.getValue();

						break;
							}
						}
					}
					if (!usuario.isEmpty()) {
					%>
					<span class="material-symbols-outlined"> account_circle </span>
					&nbsp;&nbsp;
					<h1>
						<%=usuario%></h1>
					&nbsp;&nbsp;&nbsp;
					<div class="buttons">
						</a> <a class="button is-light" href="AdminController?utilidad=deslogear">
							Cerrar Sesion </a>
					</div>
					<%
					} else {
					%>
					<div class="buttons">
						<a class="button is-primary" href="AdminController?utilidad=sign">
							<strong>Sign up</strong>
						</a> <a class="button is-light" href="AdminController?utilidad=login">
							Log in </a>
					</div>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</nav>
	
	<img alt="" src="https://www.apple.com/newsroom/images/product/app-store/Apple_App_Store_10th_anniversary_07102018_big.gif.large_2x.gif" class="image is-5by3 mgt-small	">
</body>
</html>
