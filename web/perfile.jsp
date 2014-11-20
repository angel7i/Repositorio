<jsp:useBean id="usuario" scope="session" class="modelo.Usuario" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/perfil.css">
<title>
Vista
</title>
<script languaje="javascript">

	function limpiarJ()
	{
	
		
		document.getElementById("nombre").value="";
		document.getElementById("apellidop").value="";
		document.getElementById("apellidom").value="";
		document.getElementById("fecNac").value="";
		//document.getElementById("idUser").value="";
		document.getElementById("password").value="";
		document.getElementById("email").value="";
                document.getElementById("fb").value="";
                document.getElementById("tweeter").value="";
		document.getElementById("mensaje").innerHTML="";
		
	}
	
	
	function UsuarioJ(nombre, apellidop, apellidom, fecNac, idUser, password, email,fb,tweeter, accion)
	{
		this.nombre = nombre;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
		this.fecNac = fecNac;
		this.idUser = idUser;
		this.password= password;
		this.email = email;
                this.fb = fb;
                this.tweeter = tweeter;
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
      
		
      var usuario = new UsuarioJ(form01.nombre.value, form01.apellidop.value,form01.apellidom.value,form01.fecNac.value,form01.idUser.value,form01.password.value,form01.email.value,form01.fb.value,form01.tweeter.value, 1);
		
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
                                        document.getElementById("fb").value = jsonRespuesta.fb;
                                        document.getElementById("tweeter").value = jsonRespuesta.tweeter;
                    document.getElementById("mensaje").innerHTML = jsonRespuesta.Mensaje;
					

                }			
        }
     }

    
	
	
	function actualizaJ()
	{
		// Obtener el objeto AJAX
      
      var request =  get_XmlHttp();
      
      // Crear JSON
      

      var usuario = new UsuarioJ(form01.nombre.value, form01.apellidop.value,form01.apellidom.value,form01.fecNac.value,form01.idUser.value,form01.password.value,form01.email.value,form01.fb.value,form01.tweeter.value, 4);
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
                                        document.getElementById("fb").value = jsonRespuesta.fb;
                                        document.getElementById("tweeter").value = jsonRespuesta.tweeter;
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
			<input type="text"  id="nombre" value=${usuario.nombre}  /></td>
			<td ><label>Apellido Paterno </label>
			<input type="text"  id="apellidop" value=${usuario.apellidoPat}  /></td>
			<td ><label>Apellido Materno </label>
			<input type="text"  id="apellidom" value=${usuario.apellidoMat}  /></td>
  </tr>
  
    
  <tr>	
                        <td >	<label>Fecha Nac. </label>
			<input type="text"  id="fecNac" value=${usuario.fechaNac}  /></td>
                        <td><label>ID </label>
			<input type="text"  id="idUser" value=${usuario.idUsuario}  readonly/></td>
			<td >	<label>Password </label>
			<input type="text"  id="password" value=${usuario.password}  /></td>
  </tr>
  
   
  <tr>
    <td >               <label>Email </label>
			<input type="text"  id="email" value=${usuario.correo}  /></td>
                        <td><label>Facebook </label>
			<input type="text"  id="fb" value=${usuario.fb}  /></td>
                        <td><label>Tweeter </label>
			<input type="text"  id="tweeter" value=${usuario.tweeter}  /></td>
			
  </tr>
  
  <tr>
    	<td ><label id="mensaje" value='' > </label></td>
		
   </tr>
</table>
    <table>
    <tr>
    	<!--<td><input type="button"  class="btnLogin" value="Consulta" onClick="consultaJ()"/></td>-->
       	<td><input type="button"  class="btnLogin" value="Actualiza" onClick="actualizaJ()"/></td>
       	<td><input type="button"  class="btnLogin" value="limpiar" onClick="limpiarJ()"/></td>
  </tr>
  </table>
</fieldset>
</form>
    </div>
</body>
</html>