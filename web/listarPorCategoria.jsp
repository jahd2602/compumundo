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
            <%@include file="/WEB-INF/jspf/plantillaMenuCliente.jspf"%>
            <div class="row">
                <div class="span3 offset1">
                    <h3>Desktop</h3>
                </div>
                <div class="offset2 input-append"  style="margin-top: 14px;">
                    <select class="span4">
                        <option>Desktop</option>
                        <option>Tablet</option>
                    </select>
                    <button class="btn" type="button">Ir</button>
                </div>
            </div>
            <div class="row">

            </div>
            <div class="row">
                <div class="span10 offset1 well well-small">
                    <div class="span2"><img src="/cm/img/nexus10conteclado.jpg" class="img-polaroid"></div>
                    <div class="span7">
                        <div class="row" style="margin-top: 40px;">
                            <div class="span5">
                                Computadora
                            </div>
                            <div class="span2">
                                S/.999
                            </div>
                        </div>
                        <div class="row">
                            <div class="span2 offset5">
                                <a href="/cm/pantPersonalizar.jsp" class="btn btn-primary btn-block">Personalizar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            // TODO aqui deben ir mas articulos de esta categoria
        </div>
    </body>
</html>
