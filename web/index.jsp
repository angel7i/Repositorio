
<jsp:useBean id="usuario" scope="session" class="modelo.Usuario" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Repositorio ESCOM</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/style.css"/>
        <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet'>
        <link rel="stylesheet" href="js/galleria/theme/galleria.classic.css">

        <script src="js/jquery-2.0.3.min.js"></script>
        <script src="js/galleria/galleria.js"></script>
        <script src="js/galleria/theme/galleria.classic.js"></script>
        <script>
        
            $(document).ready(function()
            {
                $('#wb_SlideShow1,#SlideShow1').galleria({});
            });
            
        </script>

    </head>
    <body>

        <% usuario.setRequest(request);%>

        <div id="login">
            <form name="log" method="post" action="login">
                <input type="text" id="Editbox1" name="usuario" placeholder=" Usuario" required> <!-- value="<jsp:getProperty name="usuario" property="cookie"/>" -->
                <input type="password" id="Editbox2" name="password" placeholder=" Contrase&#241;a" required>
                <input type="submit" id="Button1" value="Iniciar sesión">
                <h3 id="reg">¿No tienes cuenta? </h3><a id="reglink" href="registro.html">Registrate ahora</a>
                <h3 id="olv">¿Olvidaste tu contraseña? </h3><a id="olvlink" href="recupera.html">Recuperar contraseña</a>
                </form>
            <div id="tituloIndex" >
                <span>
                    <strong>Repositorio Digital <br><u>ESCOM</u></strong>
                </span>
            </div>

            <div id="imagenLogoESCOM" style="">
                <img src="styles/logos/escom.jpg" id="Image2" alt="ipn" />
            </div>
            <div id="imagenLogoIPN" style="">
                <img src="styles/logos/poli8.jpg" id="Image3" alt="ipn" />
            </div>

            <div id="textoPrincipal">
                <span>Repositorio Digital de la comunidad estudiantil de la Escuela Superior de Cómputo, donde podrás encontrar diversos archivos relacionados con las materias impartidas en el plan de estudios de la carrera de Ingeniería en Sistemas Computacionales. Aquí podrás encontrar presentaciones, ejercicios, problemarios, examenes pasados, prácticas, tareas y demás archivos compartidos por los usuarios de la comunidad estudiantil.</span>
            </div>
            <div id="SlideShow1" >
                <a href="styles/logos/escomview6.jpg" rel=""><img class="image" style="width:585px;height:280px;" src="styles/logos/escomview6.jpg" alt="" title=""></a>
                <a href="styles/logos/escomview5.JPG" rel=""><img class="image" style="width:585px;height:280px;display:none;" src="styles/logos/escomview5.JPG" alt="" title=""></a>
                <a href="styles/logos/escomview4.jpg" rel=""><img class="image" style="width:585px;height:280px;display:none;" src="styles/logos/escomview4.jpg" alt="" title=""></a>
                <a href="styles/logos/escomview3.jpg" rel=""><img class="image" style="width:585px;height:280px;display:none;" src="styles/logos/escomview3.jpg" alt="" title=""></a>
                <a href="styles/logos/escomview2.jpg" rel=""><img class="image" style="width:585px;height:280px;display:none;" src="styles/logos/escomview2.jpg" alt="" title=""></a>
                <div class="caption"><div class="caption_background"><div class="caption_text"></div></div></div>
            </div>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
        </div>
        <footer>
            <p>ESCOM</p>
        </footer>
    </body>
</html>