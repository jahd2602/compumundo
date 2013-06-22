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
                    <h3>Pagar Pedido</h3>
                </div>
            </div>
            <form action="/cm/servlet/RealizarPedido" method="get">
                <div class="row">
                    <div class="span8 offset2">

                        <div class="row" style="padding-bottom: 20px">
                            <div class="span3">
                                <b class="pull-right">Total:</b>
                            </div>
                            <jsp:useBean id="listaLineaPedidos" scope="application" class="upao.paw.compumundo.control.bean.BeanLineaPedidos"/>
                            <jsp:useBean id="carrito" scope="page" class="upao.paw.compumundo.Carrito"/>
                            <jsp:setProperty name="carrito" property="sesion" value="<%=session%>"/>
                            <c:set var="total" value="${0}" />
                            <c:forEach var="item" items="${carrito.items}">
                                <jsp:setProperty name="listaLineaPedidos" property="idLineaPedido" value="${item}"/>
                                <c:set var="monto" value="${listaLineaPedidos.montoPorIdLineaPedido}"/>
                                <c:set var="total" value="${total + monto}" />
                            </c:forEach>
                            <div class="span4"> S/. ${total}</div>
                        </div>
                        <div class="well well-small">
                            <div class="row">
                                <div class="span3"><div class="pull-right">Nombre: </div></div>
                                <div class="span4"><input type="text" name="nombre" value="" /></div>
                            </div>

                            <div class="row">
                                <div class="span3"><div class="pull-right">Apellido: </div></div>
                                <div class="span4"><input type="text" name="apellido" value="" /></div>
                            </div>

                            <div class="row">
                                <div class="span3"><div class="pull-right">Dirección: </div></div>
                                <div class="span4"><input type="text" name="direccion" value="" /></div>
                            </div>

                            <div class="row">
                                <div class="span3"><div class="pull-right">Ciudad: </div></div>
                                <div class="span4"><input type="text" name="ciudad" value="" /></div>
                            </div>

                            <div class="row">
                                <div class="span3"><div class="pull-right">Region: </div></div>
                                <div class="span4"><input type="text" name="region" value="" /></div>
                            </div>

                            <div class="row">
                                <div class="span3"><div class="pull-right">Tipo de Tarjeta: </div></div>
                                <div class="span4"> <select name="tipoTarjeta">
                                        <option value="MasterCard">MasterCard</option>
                                        <option value="Visa">Visa</option>
                                        <option value="Maestro">Maestro</option>
                                        <option value="American Express">American Express</option>
                                    </select></div>
                            </div>

                            <div class="row">
                                <div class="span3"><div class="pull-right">Numero Tarjeta: </div></div>
                                <div class="span4"><input type="text" name="numeroTarjeta" value="" /></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="span3 offset4">
                        <button type="submit" class="btn btn-primary btn-block">Realizar Pedido</button>
                    </div>
                </div>
            </form>
        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
