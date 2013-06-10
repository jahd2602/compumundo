<%--
    Document   : index
    Created on : Jun 8, 2013, 1:25:09 PM
    Author     : jahd
--%>

<%@page import="upao.paw.compumundo.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compu Mundo</title>
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
        <div class="container">
            <%=Constantes.CABECERA%>
            <div class="row">
                <div class="span2 offset2">
                    Categorias:
                </div>
                <div class="span4">
                    <div class="row">
                        <div class="btn-group btn-group-vertical">

                            <button class="span4 btn">Desktop</button>
                            <button class="span4 btn">Laptop</button>
                            <button class="span4 btn">Tablet</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
