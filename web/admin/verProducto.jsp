<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>
        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuAdmin.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Ver Producto</h3>
                </div>
            </div>
            <jsp:useBean id="listaProductos" scope="application" class="upao.paw.compumundo.control.bean.BeanProductos"/>
            <jsp:setProperty name="listaProductos" property="idProducto" param="id"/>
            <c:catch var="ex">
                <c:set var="producto" value="${listaProductos.productoPorId}"/>
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
                    <form action="/cm/servlet/GuardarProducto" method="get">
                        <input type="hidden" name="id" value="${producto.id}"/>
                        <div class="row">
                            <div class="span7 offset2">
                                <div class="well well-small">
                                    <div class="row">
                                        <div class="span3">
                                            <div class="pull-right">Descripcion: </div>
                                        </div>
                                        <div class="span2"><input type="text" name="descripcion" value="${producto.descripcion}" /></div>
                                    </div>

                                    <div class="row">
                                        <div class="span3">
                                            <div class="pull-right">Precio Base: </div>
                                        </div>
                                        <div class="span2 input-prepend">
                                            <span class="add-on">S/.</span>
                                            <input type="text" style="width:178px" name="precioBase" value="${producto.precio_base}" />
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="span3">
                                            <div class="pull-right">Categor&iacute;a: </div>
                                        </div>
                                        <div class="span2">
                                            <jsp:useBean id="listaCategorias" scope="application" class="upao.paw.compumundo.control.bean.BeanCategorias"/>
                                            <c:catch var="ex">
                                                <c:set var="categorias" value="${listaCategorias.categorias}"/>
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
                                                    <select name="categoria">
                                                        <c:forEach var="categoria" items="${categorias}">
                                                            <option ${categoria.id==producto.categoria.id?'selected':''} value="${categoria.id}">${categoria.nombre}</option>
                                                        </c:forEach>
                                                    </c:otherwise>
                                                </c:choose>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="span3">
                                            <div class="pull-right">Tipo Personalización: </div>
                                        </div>
                                        <div class="span2">
                                            <jsp:useBean id="listaTP" scope="application" class="upao.paw.compumundo.control.bean.BeanTiposPersonalizacion"/>
                                            <jsp:useBean id="listaCI" scope="application" class="upao.paw.compumundo.control.bean.BeanConfiguracionInicial"/>
                                            <jsp:setProperty name="listaCI" property="productoId" param="id"/>
                                            <c:set var="tiposPersonalizacion" value="${listaTP.tiposPersonalizacion}"/>
                                            <c:set var="tipoPerId" value="${0}"/>
                                            <c:catch>
                                                <c:set var="tipoPerId" value="${listaCI.personalizacionPorProductoId.tipoPersonalizacion.id}"/>
                                            </c:catch>

                                            <select name="tipoPersonalizacion">
                                                <c:forEach var="tp" items="${tiposPersonalizacion}">
                                                    <option ${tipoPerId!=tp.id?'':'selected'} value="${tp.id}">${tp.nombre}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="span2 offset4">
                                <button type="submit" class="btn btn-primary btn-block">Guardar</button>
                            </div>
                        </div>
                    </form>
                </c:otherwise>
            </c:choose>

        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
