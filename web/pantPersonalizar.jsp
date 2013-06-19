
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>

        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuCliente.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Personalizar Producto</h3>
                </div>
            </div>
            <jsp:useBean id="listaConfiguracionInicial" scope="application" class="upao.paw.compumundo.control.bean.BeanConfiguracionInicial"/>
            <jsp:useBean id="listaProductos" scope="application" class="upao.paw.compumundo.control.bean.BeanProductos"/>
            <jsp:useBean id="listaPersonalizaciones" scope="application" class="upao.paw.compumundo.control.bean.BeanPersonalizacion"/>
            <jsp:useBean id="listaLineaPedidos" scope="application" class="upao.paw.compumundo.control.bean.BeanLineaPedidos"/>
            <jsp:setProperty name="listaLineaPedidos" property="idLineaPedido" param="id"/>
            <c:catch var="ex">
                <c:set var="producto" value="${listaLineaPedidos.productoPorIdLineaPedido}"/>
                <jsp:setProperty name="listaConfiguracionInicial" property="productoId" value="${producto.id}"/>
                <jsp:setProperty name="listaProductos" property="idProducto" value="${producto.id}"/>
                <c:set var="productoUnused" value="${listaProductos.productoPorId}"/>
                <c:set var="personalizacion" value="${listaConfiguracionInicial.personalizacionRefreshTipoPorProductoId}"/>
                <jsp:setProperty name="listaPersonalizaciones" property="idTipoPersonalizacion" value="${personalizacion.tipoPersonalizacion.id}"/>
                <c:set var="personalizaciones" value="${listaPersonalizaciones.personalizacionesPorTipo}"/>
            </c:catch>
            <c:choose>
                <c:when test="${ex != null}">
                    <div class="span10">
                        <div class="alert alert-danger">
                            No se pudo conectar a la base de datos. Excepcion: ${ex.message}
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${empty personalizacion}">
                            <div class="row">
                                <div class="span10 offset1 lead">
                                    No se encuentra personalizacion o producto
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="row">
                                <div class="well span8 offset2">
                                    <div class="span3">
                                        <strong>Producto: </strong> ${producto.descripcion}
                                    </div>
                                    <div class="span3 offset1">
                                        <strong>Precio Base: </strong>S/. ${producto.precio_base}
                                    </div>
                                </div>
                            </div>
                            <form method="get" action="/cm/servlet/Cambiar">
                                <div class="row">
                                    <div class="span2 offset2">${personalizacion.tipoPersonalizacion.nombre} </div>
                                    <div class="span2"> ${personalizacion.nombre} </div>
                                    <div class="span2">S/ ${personalizacion.precio} </div>
                                    <div class="span4">
                                        <select name="idCambio">
                                            <c:forEach var="per" items="${personalizaciones}">
                                                <option value="${per.id}">${per.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="span1 offset4"><strong>Total:</strong></div>

                                    <div class="span2 offset1"> S/ 999 </div>

                                </div>

                                    <div class="row" style="margin-top: 20px">

                                    <div class="span2 offset4">
                                        <a class="btn btn-primary">Agregar Al Carro</a>
                                    </div>

                                    <div class="span2 offset2">
                                        <button type="submit" class="span2 btn">Realizar Cambios</button>
                                    </div>
                                </div>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>


        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
