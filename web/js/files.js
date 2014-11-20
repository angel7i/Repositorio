
$(document).ready(function ()
{
    $('#FileTableContainer').jtable(
    {
        title: 'Mis Archivos',
        paging: true,
        actions:
        {
            listAction: 'controlFile?action=listByUser',
            createAction:'controlFile?action=create',
            updateAction: 'controlFile?action=update',
            deleteAction: 'controlFile?action=delete'
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
                edit: true,
                create:true,
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
                edit: true,
                create: true,
                width: '5%'
            },
            fecha:
            {
                title: 'Fecha',
                type: 'date',
                displayFormat: 'dd-mm-yy',
                width: '5%'
            },
            descripcion:
            {
                title: 'Descripcion',
                edit: true,
                type: 'textarea'
            },
            parcial:
            {
                title: 'Parcial',
                create: true,
                edit: true,
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
    $('#FileTableContainer').jtable('load');

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
//        afterLoad: function()
//        {
//            this.title = '<a href="' + this.href + '">Descargar</a> ' + this.title;
//        },
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

//Re-load records when user click 'load records' button.
$('#LoadFiles').click(function (e)
{
    e.preventDefault();

    $('#FileTableContainer').jtable('load',
    {
        nombre: $('#filter').val()
    });
});

//Load all records when page is first shown
//$('#LoadFiles').click();


if (window.File && window.FileReader && window.FileList)
{
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
}
else
{
    alert('The File APIs are not fully supported in this browser.');
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