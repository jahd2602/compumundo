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
                    <h3>Men&uacute; Administrativo</h3>
                </div>
            </div>
            <div class="row">
                <div class="span4 offset2">
                    <div class="row">
                        <div class="btn-group btn-group-vertical">

                            <a href="/cm/admin/baseDeDatos.jsp"class="span4 btn">Base de Datos</a>
                            <a href="/cm/" class="span4 btn">Pedidos</a>
                            <a href="/cm/" class="span4 btn">Artículos</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
