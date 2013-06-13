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
                <div class="span2 offset2">
                    Categorías:
                </div>
                <div class="span4">
                    <div class="row">
                        <div class="btn-group btn-group-vertical">

                            <a href="/cm/listarPorCategoria.jsp" class="span4 btn">Desktop</a>
                            <a href="/cm/listarPorCategoria.jsp" class="span4 btn">Laptop</a>
                            <a href="/cm/listarPorCategoria.jsp" class="span4 btn">Tablet</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
