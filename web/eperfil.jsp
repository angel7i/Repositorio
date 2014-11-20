
<jsp:useBean id="usuario" scope="session" class="modelo.Usuario" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" type="text/css" href="styles/perfil.css">
    <title>
    Vista
    </title>
    <script>

        function limpiarJ()
        {


            document.getElementById("nombre").value="";
            document.getElementById("apellidop").value="";
            document.getElementById("apellidom").value="";
            document.getElementById("fecNac").value="";
            document.getElementById("idUser").value="";
            document.getElementById("password").value="";
            document.getElementById("email").value="";
            document.getElementById("mensaje").innerHTML="";

        }


        function UsuarioJ(nombre, apellidop, apellidom, fecNac, idUser, password, email, accion)
        {
            this.nombre = nombre;
            this.apellidop = apellidop;
            this.apellidom = apellidom;
            this.fecNac = fecNac;
            this.idUser = idUser;
            this.password= password;
            this.email = email;
            this.accion = accion;
        }


        function get_XmlHttp()
        {
            // Crea la variable que contendr� la instancia del objeto  XMLHttpRequest (inicialmente con un valor nulo)
            var xmlHttp = null;

            if(window.XMLHttpRequest)
            {       // para Forefox, IE7+, Opera, Safari, ...
                    xmlHttp = new XMLHttpRequest();
            }
            else if(window.ActiveXObject)
                 {  // para Internet Explorer 5 or 6
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }

            return xmlHttp;
        }

        function consultaJ()
        {
          // Obtener el objeto AJAX


          var request =  get_XmlHttp();


          // Crear JSON


          var usuario = new UsuarioJ(document.getElementById("nombre").value,document.getElementById("apellidop").value,document.getElementById("apellidom").value,document.getElementById("fecNac").value,document.getElementById("idUser").value,document.getElementById("password").value,document.getElementById("email").value, 1);

         var jsonUsuario = JSON.stringify(usuario);

          request.open("POST", "Ucontrolador", true);
          request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

          var parametro='jsonUsuario='+encodeURIComponent(jsonUsuario);
          request.send(parametro);




          request.onreadystatechange = function()
            {

              if (request.readyState == 4)
                    {
                        var ex_ajsn = request.responseText;

                        var jsonRespuesta = eval("(" + ex_ajsn + ")");

                        limpiarJ();

                        document.getElementById("nombre").value = jsonRespuesta.nombre;
                        document.getElementById("apellidop").value = jsonRespuesta.apellidop;
                        document.getElementById("apellidom").value = jsonRespuesta.apellidom;
                        document.getElementById("fecNac").value = jsonRespuesta.fecNac;
                        document.getElementById("idUser").value = jsonRespuesta.idUser;
                        document.getElementById("password").value = jsonRespuesta.password;
                        document.getElementById("email").value = jsonRespuesta.email;
                        document.getElementById("mensaje").innerHTML = jsonRespuesta.Mensaje;


                    }




            }
         }




        function actualizaJ()
        {
            // Obtener el objeto AJAX

          var request =  get_XmlHttp();

          // Crear JSON


          var usuario = new UsuarioJ(document.getElementById("nombre").value,document.getElementById("apellidop").value,document.getElementById("apellidom").value,document.getElementById("fecNac").value,document.getElementById("idUser").value,document.getElementById("password").value,document.getElementById("email").value, 4);
          var jsonUsuario = JSON.stringify(usuario);

          request.open("POST", "Ucontrolador", true);
          request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

          var parametro='jsonUsuario='+encodeURIComponent(jsonUsuario);
          request.send(parametro);

          request.onreadystatechange = function()
            {

              if (request.readyState == 4)
                    {
                        var ex_ajsn = request.responseText;
                        var jsonRespuesta = eval("(" + ex_ajsn + ")");
                        limpiarJ();
                        document.getElementById("nombre").value = jsonRespuesta.nombre;
                        document.getElementById("apellidom").value = jsonRespuesta.apellidop;
                        document.getElementById("apellidop").value = jsonRespuesta.apellidom;
                        document.getElementById("fecNac").value = jsonRespuesta.fecNac;
                        document.getElementById("idUser").value = jsonRespuesta.idUser;
                        document.getElementById("password").value = jsonRespuesta.password;
                        document.getElementById("email").value = jsonRespuesta.email;
                        document.getElementById("mensaje").innerHTML = jsonRespuesta.Mensaje;

                    }
            }

        }

    </script>
    </head>
    <body>
        <div id="marco">
    <div id="mainpic"><img src=Files/${usuario.idUsuario}.jpg alt="Sin Fotografia" id="foto" ></div>

    <form name="form01" class="box login">
    <fieldset class="boxBody">
    <table border=0>
      <tr>
                <td ><label>Nombre </label>
                <input type="text"  id="nombre" value=''  /></td>
                <td ><label>Apellido Paterno </label>
                <input type="text"  id="apellidop" value=''  /></td>
                <td ><label>Apellido Materno </label>
                <input type="text"  id="apellidom" value=''  /></td>
      </tr>


      <tr>
        <td >	<label>ID </label>
                <input type="text"  id="idUser" value=''  /></td>
                <td >	<label>Fecha Nac. </label>
                <input type="text"  id="fecNac" value=''  /></td>
      </tr>


      <tr>
        <td >	<label>Email </label>
                <input type="text"  id="email" value=''  /></td>
                <td >	<label>Password </label>
                <input type="text"  id="password" value=''  /></td>
      </tr>

      <tr>
            <td ><label id="mensaje" value='' > </label></td>

       </tr>
    </table>
        <table>
        <tr>
            <td><input type="button"  class="btnLogin" value="Consulta" onClick="consultaJ()"/></td>
            <td><input type="button"  class="btnLogin" value="Actualiza" onClick="actualizaJ()"/></td>
            <td><input type="button"  class="btnLogin" value="limpiar" onClick="limpiarJ()"/></td>

      </tr>
      </table>
    </fieldset>
    </form>
        </div>
    </body>
</html>