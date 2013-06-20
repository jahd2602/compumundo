<%--
    Document : index
    Created on : Jun 8, 2013, 1:25:09 PM
    Author : jahd
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
                    <h3>Carrito</h3>
                </div>
            </div>
            <div class="row">
                <jsp:useBean id="carrito" scope="page" class="upao.paw.compumundo.Carrito"/>
                <jsp:setProperty name="carrito" property="sesion" value="<%=session%>"/>
                <c:forEach var="item" items="${carrito.items}">
                    <a href="/cm/pantPersonalizar.jsp?id=${item}">${item}</a> |
                </c:forEach>
            </div>

            <div class="row">
                <div class="span4" align="center">Articulo</div>
                <div class="span4" align="center">Precio Base</div>
                <div class="span4" align="center">Precio Final</div>
            </div> <br>


            <div class="row">
                <div class="span4" align="center"> <input type="radio" name="articulo" value="pc_software_libre"  />Pc con Software Libre</div>
                <div class="span4" align="center"> s/. 500.00 </div>
                <div class="span4" align="center"> s/. 650.00 </div>
            </div>

            <div class="row">
                <div class="span4" align="center"> <input type="radio" name="articulo" value="pc_software_privativo" />Pc con Software Privativo</div>
                <div class="span4" align="center"> s/. 800.00</div>
                <div class="span4" align="center"> s/. 900.00 </div>
            </div>

            <br>  <div class="row">
                <div class="span4" align="center">acciones: </div>
                <div class="span4" align="center">total</div>
                <div class="span4" align="center">S/. 1600.00 </div>
            </div>






            <br>
            <div class="row">


                <div class="span2 offset3">
                    <a class="btn">Modificar</a>
                </div>

                <!se parteee>
                <div class="span2">
                    <a class="btn">Eliminar</a>
                </div>

                <div class="span2">
                    <a class="btn">Comprar</a>
                </div>
            </div>

            <div class="span4"></div>
        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
