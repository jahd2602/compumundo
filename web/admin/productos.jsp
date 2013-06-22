<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>
        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuAdmin.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Administrar Productos</h3>
                </div>
                <div class="span2 offset9">
                    <a href="/cm/servlet/CrearProducto" class="btn btn-block">
                        Agregar Nuevo
                    </a>
                </div>
            </div>

            <jsp:useBean id="listaProductos" scope="application" class="upao.paw.compumundo.control.bean.BeanProductos"/>
            <c:catch var="ex">
                <c:set var="productos" value="${listaProductos.productosRefreshCategoria}"/>
            </c:catch>
            <c:choose>
                <c:when test="${ex != null}">
                    <div class="row span12">
                        <div class="alert alert-danger">
                            No se pudo conectar a la base de datos
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${empty productos}">
                            <div class="row">
                                <div class="offset1 lead">
                                    No hay ningún Producto registrado
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <form method="get" action="/cm/servlet/AccionesProducto">
                                <div class="row">
                                    <div class="span9 offset2" >
                                        <table class="table" align="center" cellspacing="5" cellpadding="5">
                                            <thead>
                                                <tr>
                                                    <th></th>
                                                    <th>Producto</th>
                                                    <th>Categor&iacute;a</th>
                                                    <th>Precio Base</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="producto" items="${productos}">
                                                    <tr>
                                                        <td><input type="radio" name="id" value="${producto.id}"/></td>
                                                        <td>${producto.descripcion}</td>
                                                        <td>${producto.categoria.nombre}</td>
                                                        <td>S/. ${producto.precio_base}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="row" style="margin-top: 10px">
                                    <div class="span1 offset2"> Acciones: </div>
                                </div>
                                <div class="row offset2">
                                    <div class="span2 btn-group btn-group-vertical">
                                        <input class="btn btn-block" type="submit" name="accion" value="Detalle"/>
                                        <input class="btn btn-block" type="submit" name="accion" value="Eliminar"/>
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
