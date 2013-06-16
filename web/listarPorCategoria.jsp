<%--
    Document   : index
    Created on : Jun 8, 2013, 1:25:09 PM
    Author     : jahd
--%>

<%@page import="upao.paw.compumundo.Constantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>
        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuCliente.jspf"%>
            <div class="row">

                <jsp:useBean id="listaCategorias" scope="application" class="upao.paw.compumundo.control.bean.BeanCategorias"/>
                <c:catch var="ex">
                    <c:set var="categorias" value="${listaCategorias.categorias}"/>
                </c:catch>
                <c:choose>
                    <c:when test="${ex != null}">
                        <div class="span12">
                            <div class="alert alert-danger">
                                No se pudo conectar a la base de datos
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${empty categorias}">
                                <div class="row">
                                    <div class="offset1 lead">
                                        No hay ninguna Categoría
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="span3 offset1">
                                    <h3>
                                        <c:forEach var="categoria" items="${categorias}">
                                            ${categoria.id==param.id?categoria.nombre:''}
                                        </c:forEach>
                                    </h3>
                                </div>
                                <div class="offset2 input-append"  style="margin-top: 14px;">
                                    <form action="" method="get">
                                        <select class="span4" name="id">
                                            <c:forEach var="categoria" items="${categorias}">
                                                <option ${categoria.id==param.id?'selected':''} value="${categoria.id}">
                                                    ${categoria.nombre}
                                                </option>
                                            </c:forEach>
                                        </select>
                                        <button class="btn" type="submit">Ir</button>
                                    </form>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>

            </div>
            <div class="row">
                <jsp:useBean id="lista" scope="application" class="upao.paw.compumundo.control.bean.BeanProductos"/>
                <jsp:setProperty name="lista" property="idCategoria" param="id"/>

                <c:catch var="ex">
                    <c:set var="productos" value="${lista.productosPorIdCategoria}"/>
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
                                        No hay ningún Producto en esta categoría
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="producto" items="${productos}">
                                    <div class="row">
                                        <div class="span10 offset1 well well-small">
                                            <div class="span2"><img src="/cm/img/nexus10conteclado.jpg" class="img-polaroid"></div>
                                            <div class="span7">
                                                <div class="row lead" style="margin-top: 40px;">
                                                    <div class="span5">
                                                        ${producto.descripcion}
                                                    </div>
                                                    <div class="span2">
                                                        S/. ${producto.precio_base}
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="span2 offset5">
                                                        <a href="/cm/pantPersonalizar.jsp?id=${producto.id}" class="btn btn-primary btn-block">Personalizar</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
