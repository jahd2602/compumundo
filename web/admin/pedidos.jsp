

<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>

        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuAdmin.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Administrar Pedidos</h3>
                </div>
            </div>
            <%--Una Vez Creada la DB Recibir datos y ponerlos en las sgts. Variables--%>
            <% double Monto = 0;
                String Pedido = "", usuario = "";
                Date Fecha = new Date();
            %>

            <div class="row">
                <div class="span3 offset1">Pedido </div>
                <div class="span3"> Usuario </div>
                <div class="span2">Fecha </div>
                <div class="span2"> Monto</div>
            </div> <br>



            <%--Hacer un FOR para recibir los pedidos ir agregando--%>
            <%--
            for(int i=0; i<TablaPedidoBaseDatos.lenght; i++){;
            --%>
            <div class="row">
                <div class="span3 offset1"><input type="radio" name="rbtnPedido" value="<%=Pedido%>" />  2 Articulos</div>
                <div class="span3"> Mesta Ruben <%=usuario%></div>
                <div class="span2"> 26/03/2013 <%=Fecha%></div>
                <div class="span2"> S/ 100<%=Monto%> </div>
            </div>
            <%--}--%>
            <%--Fin del FOR--%>

            <div class="row" style="margin-top: 20px">
                <div class="span4 offset1"> Acciones: </div>
                <div class="span">

                    <div class="span2">
                        <a href="/cm/admin/verPedido.jsp" class="btn">Detalle</a>
                    </div>

                    <!se parteee>
                    <div class="span2">
                        <a   class="btn">Archivar</a>
                    </div></div>

                <div class="span4"></div>
            </div>
        </div>
    </body>
</html>