<%--
    Document   : index
    Created on : Jun 8, 2013, 1:25:09 PM
    Author     : jahd
--%>

<%@page import="upao.paw.compumundo.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>
        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuAdmin.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Administrar Base de Datos</h3>
                </div>
            </div>
            <div class="row">
                <div class="span4 offset2">
                    <div class="row">
                        <div class="btn-group btn-group-vertical">

                            <a href="/cm/servlet/CrearBD"class="span4 btn">Crear Tablas Vacias</a>
                            <a href="/cm/" class="span4 btn">Insertar Ejemplos</a>
                            <a href="/cm/servlet/EliminarBD" class="span4 btn">Eliminar Todas las Tablas</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
