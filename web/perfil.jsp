<jsp:useBean id="usuario" scope="session" class="modelo.Usuario" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Perfil</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/perfil.css"/>
        <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet'>
        <script src="js/scripts.js"></script>
    </head>
    <body>

    <% usuario.setRequest(request);%>
    <br>
    <div id="marco">
      <div id="mainpic"><img src=Files/${usuario.idUsuario}.jpg alt="Sin Fotografia" id="foto" ></div>  
      <div id="contexto">
          <table border=0 id="tabla1" >
              
              <tr>
                  <td></td>
                  <td colspan="2"><h3>DATOS</h3></td>
              </tr>
              <tr>
              <td colspan="4"><a>${usuario.nombre} ${usuario.apellidoPat} ${usuario.apellidoMat}</a></td>
              </tr>            
    <tr>
    	<td colspan="2"><h1>Id:</h1></td>
	<td colspan="2"><p>${usuario.idUsuario}</p></td>
	</tr>
	<tr>
    	<td colspan="2"><h1>Fecha de Nac:</h1></td>
    	<td colspan="2"><p> ${usuario.fechaNac}</p></td>
    </tr>
          </table>
      </div>
    <div id="contexto1">
    <table border=0 id="tabla1">
	<tr>
            <td></td>
            <td colspan="2"><h3>CONTACTOS</h3></td>
        </tr>
        <tr>
    	<td colspan="2"> <h1>Email:</h1></td>
    	<td colspan="2"><p>${usuario.correo} </p></td>
    </tr>
    <tr>
    	<td colspan="2"><h1>Facebook:</h1> </td>
    	<td colspan="2"><p>${usuario.fb}</p></td>
    </tr>		
   	<tr>
    	<td colspan="2"><h1>Twitter:</h1></td>
    	<td colspan="2"><p>${usuario.tweeter}</p></td>
    </tr>
   </table>									
    </div>
   </div>
    </body>
</html>