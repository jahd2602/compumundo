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
            </div>

            <div class="row">
                <div class="span8 offset2" >
                    <table  class="table" align="center" cellspacing="5" cellpadding="5">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Producto</th>
                                <th>Categoria</th>
                                <th>Precio Base</th>
                            </tr>
                        </thead>
                        <tbody>
                        <td><input type="radio" name="Productos" value="pc_software_libre"/></td>
                        <td>Pc Con Software Libre</td>
                        <td>Desktop</td>
                        <td>S/. 900</td>
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
        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
