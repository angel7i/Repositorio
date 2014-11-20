
<jsp:useBean id="usuario" scope="session" class="modelo.Usuario" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/style.css">
        <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet'>

        <script src="js/jquery-2.0.3.min.js"></script>
        <script src="js/scripts.js"></script>
    </head>
    <body>

        <% usuario.setRequest(request);%>

        <header>
            <div><a id="logo" href="home.jsp"><img id="imgHome" src="styles/images/box.png"></a></div>
            <div id="menuUsuario">
                <%String user = usuario.getNombre() + " " + usuario.getApellidoPat();%>
                <ul><a id="user"><%out.println(user);%></a>
                    <li><div><a href="javascript:Carga('menuperfil.html')">Configuración</a></div></li>
                    <li><div><a href="salir">Salir</a></div></li>
                </ul>
            </div>
        </header>

        <section id="page">
            <iframe id="window" src="menu.html"></iframe>
        </section>

    </body>
</html>