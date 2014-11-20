

$(document).ready(function()
{
    var jQueryAccordion1Opts =
    {
        event: 'mouseover',
        animate: 'swing',
        icons: {header:'ui-icon-circle-arrow-e', activeHeader:'ui-icon-circle-arrow-n'},
        active: 9,
        collapsible: true,
        header: 'h3',
        heightStyle: 'fill'
    };

    $("#jQueryAccordion1_id").accordion(jQueryAccordion1Opts);

    files();
    $('#FileTable').jtable('load');


    $('.mat').click(function (e)
    {
        var parametro='';

        switch (Number(menuo.opcion))
        {
            case 0:
                parametro = 'controlFile?action=listByNivel&nivel=' + menuo.atributo;
                //alert('controlFile?action=listByNivel&nivel=' + menuo.atributo);
                break;
            case 1:
                //alert('controlFile?action=listByMateria&materia=' + menuo.atributo);
                parametro = 'controlFile?action=listByMateria&materia=' + menuo.atributo;
                break;
            case 2:
                //alert('controlFile?action=listByMaestro&maestro=' + menuo.atributo);
                parametro = 'controlFile?action=listByMaestro&maestro=' + menuo.atributo;
                break;
        }

        e.preventDefault();

        $('#FileTable').jtable('load', parametro);
//        $('#FileTable').jtable('reload');
    });

    $(".iframe").fancybox(
    {
        helpers :
        {
            overlay :
            {
                css :
                {
                    'background' : 'rgba(20, 20, 20, 0.80)'
                }
            }
        },
        iframe :
        {
            preload: false
        },
        maxWidth	: 1000,
        maxHeight	: 900,
        fitToView	: false,
        width		: '70%',
        height		: '70%',
        autoSize	: false,
        closeBtn    : true,
        closeClick	: true,
        openEffect	: 'none',
        closeEffect	: 'none'
    });

    $(".imageframe").fancybox(
    {
        helpers :
        {
            title:
            {
                type: 'inside'
            },
            overlay :
            {
                css :
                {
                    'background' : 'rgba(20, 20, 20, 0.80)'
                }
            }
        },
        maxWidth	: 900,
        maxHeight	: 700,
        fitToView	: false,
        width		: '70%',
        height		: '70%',
        autoSize	: false,
        closeClick	: false,
        closeBtn    : true,
        openEffect	: 'none',
        closeEffect	: 'none'
    });

});

function get_XmlHttp()
{
    var xmlHttp = null;

    if(window.XMLHttpRequest)
    {       // para Forefox, IE7+, Opera, Safari, ...
        xmlHttp = new XMLHttpRequest();
    }
    else if(window.ActiveXObject)
    {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    return xmlHttp;
}

function MenuO(opcion,atributo)
{
    this.opcion = ""+opcion;
    this.atributo=""+atributo;

    if(this.opcion==="1")
    {
        // alert("case 1");
        switch(this.atributo)
        {
            case "1":
            this.atributo="Analisis Vectorial";
            break;
            case "2":
            this.atributo="Calculo";

            break;
            case "3":
            this.atributo="Matematicas Discretas";
            break;
            case "4":
            this.atributo="Algoritmia y Programacion Estructurada";
            break;
            case "5":
            this.atributo="Fisica";

            break;
            case "6":
            this.atributo="Ingenieria Etica y Sociedad";
            break;
            case "7":
            this.atributo="Ecuaciones Diferenciales";
            break;
            case "8":
            this.atributo="Algebra Lineal";
            break;
            case "9":
            this.atributo="Calculo Aplicado";
            break;
            case "10":
            this.atributo="Estructura de Datos";
            break;
            case "11":
            this.atributo="Comunicacion Oral y Escrita";
            break;
            case "12":
            this.atributo="Analisis Fundamental de Circuitos";
            break;
            case "13":
            this.atributo="Matematicas Avanzadas para la Ingenieria";
            break;
            case "14":
            this.atributo="Fundamentos Economicos";
            break;
            case "15":
            this.atributo="Fundamentos de Diseno Digital";
            break;
            case "16":
            this.atributo="Teoria Computacional";
            break;
            case "17":
            this.atributo="Bases de Datos";

            break;
            case "18":
            this.atributo="Programacion Orientada a Objetos";
            break;
            case "19":
            this.atributo="Electronica Analogica";
            break;

            case "20":
            this.atributo="Redes de Computadoras";
            break;


            case "21":
            this.atributo="Diseño de Sistemas Digitales";
            break;

            case "22":
            this.atributo="Sistemas Operativos";
            break;

            case "23":
            this.atributo="Analisis y Diseno Orientado a Objetos";
            break;

            case "24":
            this.atributo="Tecnologias Web";
            break;

            case "25":
            this.atributo="Administracion Financiera";
            break;

            case "26":
            this.atributo="Arquitectura de Computadoras";
            break;

            case "27":
            this.atributo="Analisis de Algoritmos";
            break;

            case "28":
            this.atributo="Ingenieria de Software";
            break;

            case "29":
            this.atributo="Administracion de Proyectos";
            break;

            case "30":
            this.atributo="Instrumentacion";
            break;

            case "31":
            this.atributo="Teoria de Comunicaciones y Senales";
            break;

            case "32":
            this.atributo="Aplicaciones para Comunicaciones en Red";
            break;

            case "33":
            this.atributo="Metodos Cuantitativos para la Toma de Decisiones";
            break;

            case "34":
            this.atributo="Introduccion a los Microcontroladores";
            break;

            case "35":
            this.atributo="Compiladores";
            break;

            case "36":
            this.atributo="Desarrollo de Sistemas Distribuidos";
            break;

            case "37":
            this.atributo="Administracion de Servicios en Red";
            break;

            case "38":
            this.atributo="Gestion Empresarial";
            break;

            case "39":
            this.atributo="Liderazgo y Desarrollo Profesional";
            break;

            case "40":
            this.atributo="Trabajo Terminal 1";
            break;

            case "41":
            this.atributo="Servicio Social";
            break;

            case "42":
            this.atributo="Electiva";
            break;

            case "43":
            this.atributo="Trabajo Terminal 2";
            break;
        }
    }
    else if(this.opcion==="2")
    {
        //alert("case 2");
        switch(this.atributo)
        {
            case "1":
            this.atributo="Rocio Resendiz Munoz";
            break;
            case "2":
            this.atributo="Manuel Carballo Jimenez";
            break;
            case "3":
            this.atributo="Patricia Jimenez Villanueva";
            break;

            case "4":
            this.atributo="Florencio Guzman Aguilar";
            break;

            case "5":
            this.atributo="Gumersindo Vera Hernandez";
            break;

            case "6":
            this.atributo="Mosso Garcia Garcia";
            break;

            case "7":
            this.atributo="Eduardo Rodriguez Flores ";
            break;

            case "8":
            this.atributo="Juan Martinez Diaz";
            break;

            case "9":
            this.atributo="Fernando Aguilar Sanchez";
            break;

            case "10":
            this.atributo="Ignacio Rios delaTorre";
            break;

            case "11":
            this.atributo="Yaxkin Flores Mendoza";
            break;

            case "12":
            this.atributo="Quintanilla Sanchez Sanchez";
            break;

            case "13":
            this.atributo="Joel Juarez Gambino";
            break;

            case "14":
            this.atributo="Gelacio Castillo Cabrera";
            break;

            case "15":
            this.atributo="Rafael Saucedo Delgado";
            break;

            case "16":
            this.atributo="Angel Morales Gonzales";
            break;

            case "17":
            this.atributo="Ruben Ortega Gonzales";
            break;

            case "18":
            this.atributo="Miguel Maldonado Munoz";
            break;

            case "19":
            this.atributo="Hugo Puebla Lomas";
            break;

            case "20":
            this.atributo="Sigfrido Cifuentes Alvares";
            break;

            case "21":
            this.atributo="Jose Jaime Lopez Rabadan";
            break;

            case "22":
            this.atributo="Macario Hernandez Cruz";
            break;

            case "23":
            this.atributo="Alejandro Botello Castillo";
            break;
        }

    }
    else
    {
        //alert("case 0");
        switch(this.atributo)
        {
            case "1":
            this.atributo="1";
            break;
            case "2":
            this.atributo="2";
            break;
            case "3":
            this.atributo="3";
            break;
            case "4":
            this.atributo="4";
            break;
        }
    }
}

var menuo = null;

function cargaMenu(opcion,atributo)
{
    menuo = new MenuO(opcion,atributo);
}

 function files()
 {
     $('#FileTable').jtable(
     {
         title: 'Archivos',
         paging: true,
         showFilterButton: true,
         actions:
         {
             listAction: 'controlFile?action=listFiles',
             createAction:'controlFile?action=create'
         },
         fields:
         {
             idArchivo:
             {
                 title: 'ID',
                 key: true,
                 list: true,
                 visibility: 'hidden',
                 edit: false,
                 create: false
             },
             ruta:
             {
                 title: 'Archivo',
                 create: true,
                 edit: false,
                 visibility: 'hidden',
                 input: function (data)
                 {
                     return  '<form name="fileInfo" id="fileInfo" method="post">' +
                                 '<select id="nivel">' +
                                     '<option value="nivel1">Nivel 1</option>' +
                                     '<option value="nivel2">Nivel 2</option>' +
                                     '<option value="nivel3">Nivel 3</option>' +
                                     '<option value="nivel4">Nivel 4</option>' +
                                 '</select>' +
                                 '<select id="mat">' +
                                     '<option value="1001">Estructuras de Datos</option>' +
                                     '<option value="1002">Analisis Vectorial</option>' +
                                     '<option value="1003">Calculo</option>' +
                                     '<option value="1004">Matematicas Discretas</option>' +
                                     '<option value="1005">Algoritmia y Programacion Estructurada</option>' +
                                     '<option value="1006">Fisica</option>' +
                                     '<option value="1007">Ingenieria Etica y Sociedad</option>' +
                                     '<option value="1008">Ecuaciones Diferenciales</option>' +
                                     '<option value="1009">Algebra Lineal</option>' +
                                     '<option value="1010">Calculo Aplicado</option>' +
                                     '<option value="1011">Estructura de Datos</option>' +
                                     '<option value="1012">Comunicacion Oral y Escrita</option>' +
                                     '<option value="1013">Analisis Fundamental de Circuitos</option>' +
                                     '<option value="2001">Matematicas Avanzadas para la Ingenieria</option>' +
                                     '<option value="2002">Fundamentos Economicos</option>' +
                                     '<option value="2003">Fundamentos de Diseno Digital</option>' +
                                     '<option value="2004">Teoria Computacional</option>' +
                                     '<option value="2005">Bases de Datos</option>' +
                                     '<option value="2006">Programacion Orientada a Objetos</option>' +
                                     '<option value="2007">Electronica Analogica</option>' +
                                     '<option value="2008">Redes de Computadoras</option>' +
                                     '<option value="2009">Diseno de Sistemas Digitales</option>' +
                                     '<option value="2010">Sistemas Operativos</option>' +
                                     '<option value="2011">Analisis y Diseno Orientado a Objetos</option>' +
                                     '<option value="2012">Tecnologias Web</option>' +
                                     '<option value="2013">Administracion Financiera</option>' +
                                     '<option value="3001">Arquitectura de Computadoras</option>' +
                                     '<option value="3002">Analisis de Algoritmos</option>' +
                                     '<option value="3003">Ingenieria de Software</option>' +
                                     '<option value="3004">Administracion de Proyectos</option>' +
                                     '<option value="3005">Instrumentacion</option>' +
                                     '<option value="3006">Teoria de Comunicaciones y Senales</option>' +
                                     '<option value="3007">Aplicaciones para Comunicaciones en Red</option>' +
                                     '<option value="3008">Metodos Cuantitativos</option>' +
                                     '<option value="3009">Introduccion a los Microcontroladores</option>' +
                                     '<option value="3010">Compiladores</option>' +
                                     '<option value="3011">Bases de Datos Distribuidas</option>' +
                                     '<option value="3012">Desarrollo de Sistemas Distribuidos</option>' +
                                     '<option value="3013">Administracion de Servicios en Red</option>' +
                                     '<option value="4001">Gestion Empresarial</option>' +
                                     '<option value="4002">Liderazgo y Desarrollo Profesional</option>' +
                                     '<option value="4003">Trabajo Terminal I</option>' +
                                     '<option value="4004">Trabajo Terminal II</option>' +
                                 '</select>' +
                            '</form>'+
                             '<form name="uploadForm" id="uploadForm" method="post" onclick="handleFileSelect(this.files)" enctype="multipart/form-data">' +
                                 '<input type="file" id="files" name="files[]" />' +
                                 '<input type="button" value="Cargar" class="validate[required]">' +
                                 '<div id="info"></div>' +
                             '</form>';
                 }
             },
             nombre:
             {
                 title:'Nombre',
                 list: true,
                 edit: false,
                 create:true,
                 filter:true,
                 display: function (data)
                 {
                     if (data.record.idTipo == 1 || data.record.idTipo == 2 || data.record.idTipo == 3)
                     {
                         return '<p><a class="imageframe" href=' + data.record.ruta + '>' + data.record.nombre  +'</a></p>';
                     }

                     return '<p><a class="iframe" data-fancybox-type="iframe" href=' + data.record.ruta + '>' + data.record.nombre  +'</a></p>';
                 }
             },
             idTipo:
             {
                 title: "Tipo",
                 create: false,
                 list: true,
                 edit: false,
                 visibility: 'hidden'
             },
             idUsuario:
             {
                 visibility: 'hidden',
                 edit: false,
                 create: false
             },
             idMaestro:
             {
                 title: 'Maestro',
                 edit:false,
                 options:
                 {
                     1953000002: 'Rocio Resendiz Munoz',
                     1951000001: 'Manuel Carballo Jimenez',
                     1952000001: 'Patricia Jimenez Villanueva',
                     1953000001: 'Florencio Guzman Aguilar',
                     1961000001: 'Gumersindo Vera Hernandez',
                     1962000001: 'Mosso Garcia Garcia',
                     1963000001: 'Eduardo Rodriguez Flores',
                     1971000001: 'Juan Martinez Diaz',
                     1972000001: 'Fernando Aguilar Sanchez',
                     1973000001: 'Ignacio Rios delaTorre',
                     1983000001: 'Yaxkin Flores Mendoza',
                     1981000001: 'Quintanilla Sanchez Sanchez',
                     1982000001: 'Joel Juarez Gambino',
                     1971000002: 'Gelacio Castillo Cabrera',
                     1972000002: 'Rafael Saucedo Norman',
                     1973000002: 'Angel Morales Gonzales',
                     1961000002: 'Ruben Ortega Gonzales',
                     1962000002: 'Miguel Maldonado Munoz',
                     1963000002: 'Hugo Puebla Lomas',
                     1981000002: 'Sigfrido Cifuentes Alvares',
                     1982000002: 'Jose Jaime Lopez',
                     1983000002: 'Macario Hernandez Cruz',
                     1975000001: 'Alejandro Botello Castillo',
                     1952000002: 'Hector Rojas Luna'
                 }
             },
             materia:
             {
                 title: 'Materia',
                 list:true,
                 create: false,
                 edit: false
             },
             grupo:
             {
                 title: 'Grupo',
                 edit: false,
                 create: true,
                 width: '5%'
             },
             fecha:
             {
                 title: 'Fecha',
                 type: 'date',
                 edit: false,
                 displayFormat: 'dd-mm-yy',
                 width: '5%'
             },
             descripcion:
             {
                 title: 'Descripcion',
                 edit: false,
                 type: 'textarea'
             },
             parcial:
             {
                 title: 'Parcial',
                 create: true,
                 edit: false,
                 width: '4%'
             },
             peso:
             {
                 visibility: 'hidden',
                 create: false,
                 edit:false
             }
         },
         formCreated: function (event, data)
         {
             data.form.find('input[name="ruta"]').addClass('validate[required]');
             data.form.find('input[name="nombre"]').addClass('validate[required]');
             data.form.find('input[name="idTipo"]').addClass('validate[required]');
             data.form.find('input[name="idMaestro"]').addClass('validate[required]');
             data.form.find('input[name="grupo"]').addClass('validate[required]');
             data.form.find('input[name="fecha"]').addClass('validate[required]');
             data.form.validationEngine();
         },
         //Validate form when it is being submitted
         formSubmitting: function (event, data)
         {
             return data.form.validationEngine('validate');
         },
         //Dispose validation logic when form is closed
         formClosed: function (event, data)
         {
             data.form.validationEngine('hide');
             data.form.validationEngine('detach');
         }
     });
 }


function handleFileSelect(evt)
{
    try
    {
        var files = evt.files; // FileList object
    }
    catch (e)
    {
        alert(e.message);

        return;
    }

    // files is a FileList of File objects. List some properties.
    var output = [];
    for (var i = 0, f; f = files[i]; i++)
    {
        output.push('<li><strong>', escape(f.name), '</strong> (', f.type || 'n/a', ') - ',
            f.size, ' bytes', '</li>');
        //f.lastModifiedDate ? f.lastModifiedDate.toLocaleDateString() : 'n/a',
    }
    document.getElementById('info').innerHTML = '<ul>' + output.join('') + '</ul>';
    var formData = null;

    if (output[0] != null)
    {
        var str = new Info($('#nivel').val(), $('#mat').val());
        infoFile(JSON.stringify(str));
        formData = new FormData();

        jQuery.each(files, function(i, file)
        {
            formData.append('file-'+i, file);
        });

        uploadFile(formData);
    }
}

function Info(nivel, materia)
{
    this.nivel = nivel;
    this.materia = materia;
}

function infoFile(atr)
{
    // Enviamos el formulario usando AJAX
    var request = $.ajax(
        {
            type: 'POST',
            url: 'upload?info=' + atr,
            success: function(data, textStatus, jqXHR )
            {
                //alert('Ok ' + textStatus);
            },
            error: function(jqXHR, textStatus, errorThrown)
            {
                //alert('Error: ' + errorThrown + ' -  ' + textStatus);
                console.log(errorThrown + ' : ' + textStatus);
            }
        });

    request.done(function(msg)
    {
        console.log(msg);
    });
    request.fail(function( jqXHR, textStatus )
    {
        console.log( "Request failed: " + textStatus );
    });
}

function uploadFile(file)
{
    // Enviamos el formulario usando AJAX
    var request = $.ajax(
        {
            type: 'POST',
            url: 'upload',
            data: file,
            processData : false,
            contentType : false,
            success: function(data, textStatus, jqXHR )
            {
                console.log(textStatus);
            },
            error: function(jqXHR, textStatus, errorThrown)
            {
                //alert('Error: ' + errorThrown + ' -  ' + textStatus);
                console.log(errorThrown + ' : ' + textStatus);
            }
        });

    request.done(function(msg)
    {
        console.log(msg);
    });
    request.fail(function( jqXHR, textStatus )
    {
        console.log( "Request failed: " + textStatus );
    });
}