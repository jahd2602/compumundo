<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>
        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuAdmin.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Ver Tipo Personalizaci&oacute;n</h3>
                </div>
            </div>
            <jsp:useBean id="listaTP" scope="application" class="upao.paw.compumundo.control.bean.BeanTiposPersonalizacion"/>
            <jsp:setProperty name="listaTP" property="idTipoPersonalizacion" param="id"/>
            <jsp:useBean id="listaPersonalizaciones" scope="application" class="upao.paw.compumundo.control.bean.BeanPersonalizacion"/>
            <jsp:setProperty name="listaPersonalizaciones" property="idTipoPersonalizacion" param="id"/>
            <c:catch var="ex">
                <c:set var="tp" value="${listaTP.tipoPersonalizacionPorId}"/>
                <c:set var="personalizaciones" value="${listaPersonalizaciones.personalizacionesPorTipo}"/>
            </c:catch>
            <c:choose>
                <c:when test="${ex != null}">
                    <div class="row">
                        <div class="span10">
                            <div class="alert alert-danger">
                                No se pudo conectar a la base de datos
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row">
                        <div class="well well-small span6 offset2">
                            <h4>${tp.nombre}</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="span6 offset2" >
                            <table class="table" align="center" cellspacing="5" cellpadding="5">
                                <thead>
                                    <tr>
                                        <th>Personalizaci&oacute;n</th>
                                        <th>Precio Adicional</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="per" items="${personalizaciones}">
                                        <tr>
                                            <td>${per.nombre}</td>
                                            <td>S/. ${per.precio}</td>
                                        </tr>
                                    </c:forEach>
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
