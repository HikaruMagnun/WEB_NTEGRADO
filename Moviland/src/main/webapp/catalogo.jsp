<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link
      href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css"
      rel="stylesheet"
    />
    <title>Insert title here</title>
  </head>
  <body>
    <nav class="navbar is-black" role="navigation" aria-label="main navigation">
      <div class="navbar-brand">
        <a class="navbar-item" href="https://bulma.io">
          <img
            src="https://lh3.googleusercontent.com/u/0/drive-viewer/AITFw-xLWDpYDbkZbHXLiDfFX-PSMOMPaMj8JPZhpSIA7XPIMMQsAReVmn_KxgffDZtKONWPXHvxZrHeMCCwxqjIkRECF3nowA=w1366-h653"
          />
        </a>

        <a
          role="button"
          class="navbar-burger"
          aria-label="menu"
          aria-expanded="false"
          data-target="navbarBasicExample"
        >
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
          <span aria-hidden="true"></span>
        </a>
      </div>

      <div id="navbarBasicExample" class="navbar-menu">
        <div class="navbar-start">
          <a class="navbar-item" href="index.jsp"> Inicio </a>

          <a class="navbar-item" href="AdminController?utilidad=mostrar">
            Catálogo
          </a>

          <div class="navbar-item has-dropdown is-hoverable">
            <a class="navbar-link"> Más </a>

            <div class="navbar-dropdown">
              <a class="navbar-item"> Nosotros </a>
              <a class="navbar-item"> Jobs </a>
              <a class="navbar-item"> Contáctenos </a>
              <hr class="navbar-divider" />
              <a class="navbar-item"> Report an issue </a>
            </div>
          </div>
        </div>

        <div class="navbar-end">
          <div class="navbar-item">
            <div class="buttons">
              <a class="button is-primary">
                <strong>Sign up</strong>
              </a>
              <a class="button is-light"> Log in </a>
            </div>
          </div>
        </div>
      </div>
    </nav>

    <table class="table">
      <thead>
        <tr>
          <th><abbr title="Position">Pos</abbr></th>
          <th>ID</th>
          <th><abbr title="Played">Marca</abbr></th>
          <th><abbr title="Won">Nombre</abbr></th>
          <th><abbr title="Drawn">D</abbr></th>
          <th><abbr title="Lost">Stock</abbr></th>
          <th><abbr title="Goals for">Pantalla(In)</abbr></th>
          <th><abbr title="Goals against">Bateria(mAh)</abbr></th>
          <th><abbr title="Goal difference">S.O.</abbr></th>
          <th><abbr title="Points">Camara (MP)</abbr></th>
          <th>Almacnamiento</th>
          <th>img(link)</th>
          <th>Precio</th>
        </tr>
      </thead>

      <tbody>
        <tr>
          <th>1</th>
          <td>
            <a
              href="https://en.wikipedia.org/wiki/Leicester_City_F.C."
              title="Leicester City F.C."
              >Leicester City</a
            >
            <strong>(C)</strong>
          </td>
          <td>38</td>
          <td>23</td>
          <td>12</td>
          <td>3</td>
          <td>68</td>
          <td>36</td>
          <td>+32</td>
          <td>81</td>
          <td>
            Qualification for the
            <a
              href="https://en.wikipedia.org/wiki/2016%E2%80%9317_UEFA_Champions_League#Group_stage"
              title="2016–17 UEFA Champions League"
              >Champions League group stage</a
            >
          </td>
        </tr>
      </tbody>
    </table>
  </body>
</html>
