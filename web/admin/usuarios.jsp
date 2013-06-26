<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>
        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuAdmin.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Administrar Usuarios</h3>
                </div>
            </div>
            <form method="get" action="/cm/servlet/AccionesUsuario">
                <div class="row">
                    <div class="span6 offset2" >
                        <table class="table" align="center" cellspacing="5" cellpadding="5">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>Usuario</th>
                                    <th>Contraseña</th>
                                </tr>
                            </thead>
                            <tbody>
                                <jsp:useBean id="usuarios" scope="application" class="upao.paw.compumundo.control.bean.BeanUsuarios"/>
                                <c:forEach var="usuario" items="${usuarios.usuarios}">
                                    <tr>
                                        <td><input type="radio" name="id" value="${usuario.id}"/></td>
                                        <td${usuario.esAdmin?' style="font-weight: bold; color: red"':''}>${usuario.nombre}</td>
                                        <td>${usuario.pass}</td>
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
                        <input class="btn btn-block" type="submit" name="accion" value="Elevar"/>
                    </div>
                </div>
            </form>
        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
