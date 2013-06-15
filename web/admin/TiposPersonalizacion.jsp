<%--
    Document   : TiposPersonalizacion
    Created on : 14-jun-2013, 16:36:42
    Author     : Carrillo
--%>

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
            <%=upao.paw.compumundo.Constantes.MENU_ADMIN%>

            <%--Comienzo 2/3   mid--%>
            <%--Modificar Fecha con la de la creación, tambien enlazar los sgts atributos a la BD--%>
            <div class="container">
                <%   String tipoPersonalizar = "";
                    int numVariantes = 0;%>


                <div class="row">

                    <%--Hacer un FOR para Cargar los Tipos de personalizacion--%>
                    <div class="span6">
                        <input type="radio" name="rbtnPersonal" value="<%=tipoPersonalizar%>" /> Color <%=tipoPersonalizar%>
                    </div>

                    <div class="span6"><%=numVariantes%> Variantes</div>

                    <%--Lo de abajo borrar, es para que se va más bonito con más datos--%>
                </div>
                <div class="row">
                    <div class="span6">
                        <input type="radio" name="rbtnPersonal" value="<%=tipoPersonalizar%>" /> Capacidad <%=tipoPersonalizar%>
                    </div>
                    <div class="span6"><%=numVariantes%>1 Variantes</div>
                </div>
                <div class="row">  
                    <div class="span6">
                        <input type="radio" name="rbtnPersonal" value="<%=tipoPersonalizar%>" /> Tamaño <%=tipoPersonalizar%>
                    </div>
                    <div class="span6"><%=numVariantes%>3 Variantes</div>
                    <%--Fin del For--%>

                </div>
            </div>
            <%--fin parte 2/3 mid--%>
            <%--parte mid--%>
            <%--Comienzo 1/3--%>
            <br>
            <div class="row show-grid">
                <div class="span4"> Acciones: </div>
                <div class="span">

                    <div class="span2">
                        <a class="btn">Modificar</a>
                    </div>

                    <!se parteee>
                    <div class="span2">
                        <a class="btn">Eliminar</a>
                    </div></div>

                <div class="span4"></div>
            </div>
            <%--fin parte 1/3--%>



        </div>
    </body>
</html>