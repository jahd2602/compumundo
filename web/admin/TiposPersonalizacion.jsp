<%--
    Document   : TiposPersonalizacion
    Created on : 14-jun-2013, 16:36:42
    Author     : Carrillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>

        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuCliente.jspf"%>
            <div class="container">
                <%   String tipoPersonalizar = "";
                    int numVariantes = 0;%>


                <div class="row">
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

        </div>
    </body>
</html>