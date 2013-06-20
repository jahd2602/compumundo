<%--
    Document   : index
    Created on : Jun 8, 2013, 1:25:09 PM
    Author     : jahd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>
        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuCliente.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Carrito</h3>
                </div>
            </div>
            <div class="row">
                <jsp:useBean id="carrito" scope="page" class="upao.paw.compumundo.Carrito"/>
                <%
                    carrito.setSesion(session);
                %>
                items: ${carrito.items}
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
