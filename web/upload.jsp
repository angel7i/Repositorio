
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Upload</title>
        <link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet'>

        <link href="styles/style.css" rel="stylesheet">
        <link href="styles/site.css" rel="stylesheet">
        <link href="styles/themes/metroblue/jquery-ui.css" rel="stylesheet"/>
        <link href="styles/themes/metro/blue/jtable.css" rel="stylesheet"/>
        <link href="styles/validationEngine.jquery.css" rel="stylesheet"/>

        <link rel="stylesheet" href="styles/jquery.fancybox.css?v=2.1.5"  media="screen" />
        <link rel="stylesheet" href="styles/jquery.fancybox-buttons.css?v=1.0.5"  media="screen" />

        <script src="js/jquery-2.0.3.min.js"></script>
        <script src="js/jquery-ui-1.9.2.min.js"></script>
        <script src="js/jtable/jquery.jtable.js"></script>
        <script src="js/jtable/localization/jquery.jtable.es.js"></script>

        <script type="text/javascript" src="js/jquery.fancybox.pack.js?v=2.1.5"></script>

        <script type="text/javascript" src="js/jquery.fancybox-buttons.js?v=1.0.5"></script>
        <%--<script type="text/javascript" src="js/jquery.fancybox-media.js?v=1.0.6"></script>--%>

        <script src="js/files.js"></script>
        <script src="js/jquery.validationEngine.js"></script>
        <script src="js/jquery.validationEngine-es.js"></script>
    </head>
    <body>

        <section id="table">
            <%--<div class="filtering">--%>
                <%--<form>--%>
                    <%--Nombre del archivo: <input type="text" name="filter" id="filter" />--%>
                    <%--<button type="submit" id="LoadFiles">Buscar archivos</button>--%>
                <%--</form>--%>
            <%--</div>--%>
            <div id="FileTableContainer"></div>
        </section>
    </body>
</html>