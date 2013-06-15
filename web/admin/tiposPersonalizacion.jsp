<%--
    Document   : TiposPersonalizacion
    Created on : 14-jun-2013, 16:36:42
    Author     : Carrillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>

        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuAdmin.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Administrar Tipos de Personalizaciones</h3>
                </div>
            </div>
            <jsp:useBean id="listaTP" scope="application" class="upao.paw.compumundo.control.bean.BeanTiposPersonalizacion"/>
            <c:catch var="ex">
                <c:set var="tiposPersonalizacion" value="${listaTP.tiposPersonalizacion}"/>
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
                        <c:when test="${empty tiposPersonalizacion}">
                            <div class="row">
                                <div class="span10 offset1 lead">
                                    No hay ningún tipo de personalización
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <jsp:useBean id="listaPersonalizacion" scope="application" class="upao.paw.compumundo.control.bean.BeanPersonalizacion"/>
                            <c:forEach var="tp" items="${tiposPersonalizacion}">
                                <c:set var="listaPersonalizacion.idTipoPersonalizacion" value="${tp.id}"/>
                                <div class="row">
                                    <div class="span4 offset1">
                                        <input type="radio" name="id" value="${tp.id}" />
                                        ${tp.nombre}
                                    </div>
                                    <div class="span4">${listaPersonalizacion.cantidadPorTipo} Variantes</div>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>

            <div class="row" style="margin-top: 20px">
                <div class="span1 offset1"> Acciones: </div>
            </div>

            <div class="row offset1">
                <div class="span2 btn-group btn-group-vertical">
                    <a class="btn">Modificar</a>
                    <a class="btn">Eliminar</a>
                </div>

                <div class="span4"></div>
            </div>

        </div>
    </body>
</html>