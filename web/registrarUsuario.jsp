<%--
    Document   : pagarPedido
    Created on : 19-jun-2013, 23:49:18
    Author     : Carrillo
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
                    <h3>Registrar Usuario</h3>
                </div>
            </div>
            <form action="/cm/servlet/AgregarUsuario" method="get">
                <div class="row">
                    <div class="span8 offset2">
                        <div class="well">
                            <div class="row">
                                <div class="span3"><div class="pull-right">Nombre de usuario: </div></div>
                                <div class="span4"><input type="text" name="user" value="" /></div>
                            </div>

                            <div class="row">
                                <div class="span3"><div class="pull-right">Contraseña: </div></div>
                                <div class="span4"><input type="password" name="pass" value="" /></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span3 offset4">
                        <button type="submit" class="btn btn-primary btn-block">Registrarse</button>
                    </div>
                </div>
            </form>
        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
