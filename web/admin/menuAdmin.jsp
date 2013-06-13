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
            <!--Inicio Plantilla Alerta-->
            <div class="alert">
                <a href="#" class="close" data-dismiss="alert">&times;</a>
                <strong>Warning!</strong> Best check yo self, you're not looking too good.
            </div>
            <!--Fin Plantilla Alerta-->
            <div class="row">
                <div class="span2 offset2">
                    Administrar:
                </div>
                <div class="span4">
                    <div class="row">
                        <div class="btn-group btn-group-vertical">

                            <a href="/cm/servlet/admin/CrearBD"class="span4 btn">Base de Datos</a>
                            <a href="/cm/" class="span4 btn">Pedidos</a>
                            <a href="/cm/" class="span4 btn">Artículos</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
