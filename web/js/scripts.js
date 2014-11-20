
$(document).ready(function()
{
    menu();
});

function menu()
{
    $("#menuUsuario > ul > li").hide();

    $("#menuUsuario ul").click(function()
    {
        $(this).removeClass('sliding');
        if ($(this).parent().find('li').is(':hidden'))
        {
            $("#menuUsuario > ul > li").slideUp();
            $(this).parent().find('li').slideDown();
        }
        else
        {
            $(this).parent().find('li').slideUp();
        }
    });

//    $(".menuFolder div").click(function()
//    {
//        $(this).removeClass('sliding');
//        if ($(this).parent().find('ul').is(':hidden'))
//        {
//            $("#menu > ul > li > ul").slideUp();
//            $(this).parent().find('ul').slideDown();
//        }
//        else
//        {
//            $(this).parent().find('ul').slideUp();
//        }
//    });
//    $(".menuFolder div").hover(function()
//    {
//        $(this).addClass('sliding');
//        setTimeout(function()
//        {
//            $('#menu .sliding').click().removeClass('sliding');
//        }, 400);
//    }, function()
//    {
//        $('#menu .sliding').removeClass('sliding');
//    });

    $("#menuUsuario").mouseleave(function()
    {
        $('#menuUsuario .sliding').removeClass('sliding');
        $("#menuUsuario > ul > li").slideUp();
    });
}

function Carga(url)
{
    document.getElementById("window").src = url;
}

function CargaPerfil(url)
{
    document.getElementById("windowUser").src = url;
}

function get_XmlHttp()
{
    // Crea la variable que contendrá la instancia del objeto  XMLHttpRequest (inicialmente con un valor nulo)
    var xmlHttp = null;

    if (window.XMLHttpRequest)
    {       // para Forefox, IE7+, Opera, Safari, ...
        xmlHttp = new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {  // para Internet Explorer 5 or 6
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    return xmlHttp;
}

function Usuario(nombre, apellidop, apellidom, fecNac, idUser, password, email, accion)
{
    this.nombre = nombre;
    this.apellidop = apellidop;
    this.apellidom = apellidom;
    this.fecNac = fecNac;
    this.idUser = idUser;
    this.password = password;
    this.email = email;
    this.accion = accion;
}

function insertUsuario()
{
    // Obtener el objeto AJAX
    var request =  get_XmlHttp();

    // Crear JSON
    // Antes hay que validar los datos

    var usuario = new Usuario(registro.nombre.value, registro.apellidop.value,  registro.apellidom.value,
        registro.fecNac.value, registro.idUsuario.value, registro.password2.value, registro.correo.value, 0);
    var jsonUsuario = JSON.stringify(usuario);

    request.open("POST", "controlador", true);
    request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

    var parametro = "jsonUser=" + encodeURIComponent(jsonUsuario);
    request.send(parametro);

    request.onreadystatechange = function()
    {
        if (request.readyState == 4)
        {
            var ex_ajsn = request.responseText;
        }
    }
}
