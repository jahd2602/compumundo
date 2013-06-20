<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>
        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuCliente.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Administrar Productos</h3>
                </div>
            </div>

            <div class="row">
                <div class="span5 offset2" ><input type="radio" name="Productos" value="pc_software_libre"/> Pc Con Software Libre</div>
            </div>

            <div class="row">
                <div class="span5 offset2" ><input type="radio" name="Productos" value="pc_software_privativo" /> Pc Con Software Privativo</div>
            </div>

            <div class="row">
                <div class="span5 offset2" ><input type="radio" name="Productos" value="memoria_usb" />  Memoria Usb</div>
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
