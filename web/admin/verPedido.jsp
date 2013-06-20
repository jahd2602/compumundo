
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>

        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuAdmin.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Ver Pedido</h3>
                </div>
            </div>
            <jsp:useBean id="listaPedidos" scope="application" class="upao.paw.compumundo.control.bean.BeanPedidos"/>
            <jsp:useBean id="listaLineaPedidos" scope="application" class="upao.paw.compumundo.control.bean.BeanLineaPedidos"/>
            <jsp:setProperty name="listaPedidos" property="idPedido" param="id"/>
            <jsp:setProperty name="listaLineaPedidos" property="idPedido" param="id"/>
            <c:catch var="ex">
                <c:set var="pedido" value="${listaPedidos.pedidoRefreshComprador}"/>
                <c:set var="lineasPedido" value="${listaLineaPedidos.lineasPedidoRefreshProductoPorIdPedido}"/>
            </c:catch>
            <c:choose>
                <c:when test="${ex != null}">
                    <div class="row">
                        <div class="span10 offset1">
                            <div class="alert alert-danger">
                                <strong>No se pudo obtener pedido</strong>
                                No se pudo conectar a la base de datos o no se pudo encontrar Pedido
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row">
                        <div class="span3 offset2">
                            <strong>Estado:</strong>
                            <c:choose>
                                <c:when test="${pedido.estado eq 0}">
                                    Activo <a href="/cm/AccionesPedido?accion=Archivar&id=${pedido.id}" class="btn btn-mini">Archivar</a>
                                </c:when>
                                <c:when test="${pedido.estado eq 1}">
                                    Cancelado
                                </c:when>
                                <c:when test="${pedido.estado eq 2}">
                                    Archivado <a href="/cm/AccionesPedido?accion=Activar&id=${pedido.id}" class="btn btn-mini">Activar</a>
                                </c:when>
                                <c:otherwise>
                                    Desconocido
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="span3">
                            <strong>Fecha:</strong> ${pedido.fecha}
                        </div>
                    </div>
                    <div class="row" style="padding-top: 20px">
                        <div class="well well-small span6 offset2">
                            <h4>Datos del Comprador</h4>
                            <ul>
                                <li>
                                    <strong>Nombre:</strong>
                                    ${pedido.comprador.nombre}
                                </li>
                                <li>
                                    <strong>Apellido:</strong>
                                    ${pedido.comprador.apellido}
                                </li>
                                <li>
                                    <strong>Direccion:</strong>
                                    ${pedido.comprador.direccion}
                                </li>
                                <li>
                                    <strong>Ciudad:</strong>
                                    ${pedido.comprador.ciudad}
                                </li>
                                <li>
                                    <strong>Region:</strong>
                                    ${pedido.comprador.region}
                                </li>
                                <li>
                                    <strong>Tipo Tarjeta:</strong>
                                    ${pedido.comprador.tipoTarjeta}
                                </li>
                                <li>
                                    <strong>Numero Tarjeta:</strong>
                                    ${pedido.comprador.numeroTarjeta}
                                </li>

                            </ul>

                        </div>
                    </div>
                    <div class="row">
                        <div class="span10 offset1">
                            <table  class="table" align="center" cellspacing="5" cellpadding="5">
                                <thead>
                                    <tr>
                                        <th>Producto (Precio Base)</th>
                                        <th>Personalización (Adicional)</th>
                                        <th>Monto</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <jsp:useBean id="listaConfiguracion" scope="application" class="upao.paw.compumundo.control.bean.BeanConfiguracion"/>
                                    <c:forEach var="lineaPedido" items="${lineasPedido}">
                                        <tr>
                                            <td>
                                                ${lineaPedido.producto.descripcion} (S/. ${lineaPedido.producto.precio_base})
                                            </td>
                                            <td>
                                                <ul>

                                                    <jsp:setProperty name="listaConfiguracion" property="lineaPedidoId" value="${lineaPedido.id}"/>
                                                    <c:catch var="exx">
                                                        <c:set var="personalizacion" value="${listaConfiguracion.personalizacionRefreshTipoPorLineaPedidoId}"/>
                                                    </c:catch>
                                                    <c:choose>
                                                        <c:when test="${exx != null}">
                                                            <div class="alert alert-danger">
                                                                No se pudo conectar a la base de datos (Personalizacion)
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <li>${personalizacion.tipoPersonalizacion.nombre}: ${personalizacion.nombre} (S/. ${personalizacion.precio})</li>
                                                            </c:otherwise>
                                                        </c:choose>

                                                </ul>
                                            </td>
                                            <td>
                                                <jsp:setProperty name="listaLineaPedidos" property="idLineaPedido" value="${lineaPedido.id}"/>
                                                <c:catch var="exxx">
                                                    <c:set var="monto" value="${listaLineaPedidos.montoPorIdLineaPedido}"/>
                                                </c:catch>
                                                <c:choose>
                                                    <c:when test="${exxx != null}">
                                                        <div class="alert alert-danger">
                                                            No se pudo conectar a la base de datos (LineaPedido)
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>
                                                        S/. ${monto}
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <div  class="pull-right">
                                                <strong>TOTAL:</strong>
                                            </div>
                                        </td>
                                        <td>
                                            S/. ${listaLineaPedidos.montoTotalPorIdPedido}
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>