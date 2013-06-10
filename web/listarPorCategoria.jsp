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
        <link rel="stylesheet" href="/cm/css/bootstrap.css">
    </head>
    <body>
        <div class="container">
            <%=Constantes.MENU_CLIENTE%>
            <div class="row">
                <div class="span2 offset2">
                    Categorias:
                </div>
                <div class="input-append">

                    <select class="span4">
                        <option>Desktop</option>
                        <option>Tablet</option>
                    </select>
                    <button class="btn" type="button">Ir</button>
                </div>
            </div>
        </div>
    </body>
</html>
