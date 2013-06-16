

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

            <jsp:useBean id="listaPedidos" scope="application" class="upao.paw.compumundo.control.bean.BeanPedidos"/>
            <c:catch var="ex">
                <c:set var="pedidos" value="${listaPedidos.pedidosRefreshComprador}"/>
            </c:catch>
            <c:choose>
                <c:when test="${ex != null}">
                    <div class="span10">
                        <div class="alert alert-danger">
                            No se pudo conectar a la base de datos
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${empty pedidos}">
                            <div class="span10 offset1 lead">
                                No hay ninguna Categoría
                            </div>
                        </c:when>
                        <c:otherwise>
                            <form action="/cm/AccionesPedido" method="get">
                                <div class="row">
                                    <div class="span10 offset1">

                                        <table  class="table" align="center" cellspacing="5" cellpadding="5">
                                            <thead>
                                                <tr>
                                                    <th></th>
                                                    <th>Pedido</th>
                                                    <th>Cliente</th>
                                                    <th>Fecha</th>
                                                    <th>Monto</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <jsp:useBean id="listaLineaPedido" scope="application" class="upao.paw.compumundo.control.bean.BeanLineaPedidos"/>
                                                <c:forEach var="pedido" items="${pedidos}">
                                                    <jsp:setProperty name="listaLineaPedido" property="idPedido" value="${pedido.id}"/>
                                                    <tr>
                                                        <td><input type="radio" name="id" value="${pedido.id}" /> </td>
                                                        <td>${listaLineaPedido.cantidadPorIdPedido} Productos</td>
                                                        <td>${pedido.comprador.nombre}</td>
                                                        <td>26/03/2013</td>
                                                        <td>S/. ${listaLineaPedido.montoTotalPorIdPedido}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <div class="row" style="margin-top: 10px">
                                    <div class="span1 offset1"> Acciones: </div>
                                </div>

                                <div class="row offset1">
                                    <div class="span2 btn-group btn-group-vertical">
                                        <input class="btn btn-block" type="submit" name="accion" value="Detalle"/>
                                        <input class="btn btn-block" type="submit" name="accion" value="Archivar"/>
                                    </div>
                                </div>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>