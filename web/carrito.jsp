<%--
    Document : index
    Created on : Jun 8, 2013, 1:25:09 PM
    Author : jahd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>
        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuCliente.jspf"%>
            <%@include file="/WEB-INF/jspf/plantillaRequiereAutenticacion.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Carrito</h3>
                </div>
            </div>
            <form action="/cm/servlet/AccionesCarrito" method="get">
                <div class="row">
                    <div class="span9 offset1">
                        <table  class="table" align="center" cellspacing="5" cellpadding="5">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>Articulo</th>
                                    <th>Precio Base</th>
                                    <th>Sub Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <jsp:useBean id="listaLineaPedidos" scope="application" class="upao.paw.compumundo.control.bean.BeanLineaPedidos"/>
                                <jsp:useBean id="carrito" scope="page" class="upao.paw.compumundo.Carrito"/>
                                <jsp:setProperty name="carrito" property="sesion" value="<%=session%>"/>
                                <c:set var="total" value="${0}" />
                                <c:forEach var="item" items="${carrito.items}">
                                    <jsp:setProperty name="listaLineaPedidos" property="idLineaPedido" value="${item}"/>
                                    <c:set var="producto" value="${listaLineaPedidos.productoPorIdLineaPedido}"/>
                                    <c:set var="monto" value="${listaLineaPedidos.montoPorIdLineaPedido}"/>
                                    <c:set var="total" value="${total + monto}" />
                                    <tr>
                                        <td><input type="radio" name="id" value="${item}" /></td>
                                        <td>${producto.descripcion}</td>
                                        <td>S/. ${producto.precio_base}</td>
                                        <td>S/. ${monto}</td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td><strong>TOTAL:</strong></td>
                                    <td>S/. ${total}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="row" style="margin-top: 10px">
                    <div class="span1 offset1"> Acciones: </div>
                </div>

                <div class="row offset1">
                    <div class="span2 btn-group btn-group-vertical">
                        <input class="btn btn-block" type="submit" name="accion" value="Personalizar"/>
                        <input class="btn btn-block" type="submit" name="accion" value="Eliminar"/>
                    </div>
                    <div class="span3 offset2">
                        <c:if test="${total!=0}">
                            <a href="/cm/pagarPedido.jsp" class="btn btn-block btn-primary" >
                                Comprar
                            </a>
                        </c:if>
                    </div>
                </div>
            </form>
        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
