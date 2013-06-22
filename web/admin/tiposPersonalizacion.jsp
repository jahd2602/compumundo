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
                <div class="span2 offset9">
                    <a href="" class="btn btn-block">
                        Agregar Nuevo
                    </a>
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
                            <form action="/cm/admin/verTipoPersonalizacion.jsp" method="get">
                                <div class="row">
                                    <div class="span6 offset2" >
                                        <table class="table" align="center" cellspacing="5" cellpadding="5">
                                            <thead>
                                                <tr>
                                                    <th></th>
                                                    <th>Tipo Personalizaci&oacute;n</th>
                                                    <th>Variantes</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <jsp:useBean id="listaPersonalizacion" scope="application" class="upao.paw.compumundo.control.bean.BeanPersonalizacion"/>
                                                <c:forEach var="tp" items="${tiposPersonalizacion}">
                                                    <jsp:setProperty name="listaPersonalizacion" property="idTipoPersonalizacion" value="${tp.id}"/>
                                                    <tr>
                                                        <td>
                                                            <input type="radio" name="id" value="${tp.id}" />
                                                        </td>
                                                        <td>
                                                            ${tp.nombre}
                                                        </td>
                                                        <td>
                                                            ${listaPersonalizacion.cantidadPorTipo}
                                                        </td>
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
                                        <button type="submit" class="btn btn-block">Detalle</button>
                                        <a class="btn">Eliminar</a>
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