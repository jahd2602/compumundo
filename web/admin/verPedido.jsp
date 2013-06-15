
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>

        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuCliente.jspf"%>

            <div class="container">
                <% Date Fecha = new Date();
                    String Cliente = "";
                    String varArticulo = "", varPersonalizacion = "";
                    double varMonto = 0;

                %>

                <div class="span4 offset2">Cliente:Cesar Quiste <%=Cliente%> </div> <div class="span5">Fecha: 26/03/2013 <%=Fecha%></div><br><br>

                <div class="row">

                    <div class="span12">


                        <table  class="table" align="center" cellspacing="5" cellpadding="5">
                            <thead>
                                <tr>
                                    <th>Articulo</th>
                                    <th>Personalizaciones</th>
                                    <th>Monto</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%--for para agregar Pedidos --%>
                                <tr>
                                    <td>Pc con softWare Libre <%=varArticulo%></td>
                                    <td>Pantalla 17"
                                        Memoria 8gb <%=varPersonalizacion%></td>
                                    <td>S/ 800<%=varMonto%></td>
                                </tr>
                                <%--fin del For para agregar Pedidos--%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <br>
            <div class="row show-grid">
                <div class="span4"></div>
                <div class="span">

                    <div class="span2">
                        <a class="btn">Aceptar</a>
                    </div>

                    <!se parteee>
                    <div class="span2">
                        <a class="btn">Archivar</a>
                    </div></div>

                <div class="span4"></div>
            </div>


        </div>
    </body>
</html>