<%--
    Document   : index
    Created on : Jun 8, 2013, 1:25:09 PM
    Author     : jahd
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
                    <h3>Categor&iacute;as</h3>
                </div>
            </div>
            <div class="row">
                <div class="span4 offset2">
                    <div class="row">

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
                                <c:choose>
                                    <c:when test="${empty categorias}">
                                        <div class="row">
                                            <div class="span10 offset1 lead">
                                                No hay ninguna Categoría
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="btn-group btn-group-vertical">
                                            <c:forEach var="categoria" items="${categorias}">
                                                <a href="/cm/listarPorCategoria.jsp?id=${categoria.id}" class="span4 btn">${categoria.nombre}</a>
                                            </c:forEach>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>

                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
