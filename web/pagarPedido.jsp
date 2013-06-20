<%--
    Document   : pagarPedido
    Created on : 19-jun-2013, 23:49:18
    Author     : Carrillo
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
                    <h3>Pagar Pedido</h3>
                </div>
            </div>
            <div class="row">
                <div class="span8 offset2">

                    <div class="row" style="padding-bottom: 20px">
                        <div class="span3"><b class="pull-right">Total:</b></div>
                        <div class="span4"> S/ 1655.00</div>
                    </div>
                    <div class="well well-small">
                        <div class="row">
                            <div class="span3"><div class="pull-right">nombre: </div></div>
                            <div class="span4"><input type="text" name="txtNombre" value="" /></div>
                        </div>

                        <div class="row">
                            <div class="span3"><div class="pull-right">Apellido: </div></div>
                            <div class="span4"><input type="text" name="txtApellido" value="" /></div>
                        </div>

                        <div class="row">
                            <div class="span3"><div class="pull-right">Dirección: </div></div>
                            <div class="span4"><input type="text" name="txtDireccion" value="" /></div>
                        </div>

                        <div class="row">
                            <div class="span3"><div class="pull-right">Ciudad: </div></div>
                            <div class="span4"><input type="text" name="txtCiudad" value="" /></div>
                        </div>

                        <div class="row">
                            <div class="span3"><div class="pull-right">Region: </div></div>
                            <div class="span4"><input type="text" name="txtRegion" value="" /></div>
                        </div>

                        <div class="row">
                            <div class="span3"><div class="pull-right">Tipo de Tarjeta: </div></div>
                            <div class="span4"> <select name="cmbTipoTarjeta">
                                    <option>MasterCard</option>
                                    <option>Visa</option>
                                    <option>Maestro</option>
                                    <option>American Express</option>
                                </select></div>
                        </div>

                        <div class="row">
                            <div class="span3"><div class="pull-right">numero: </div></div>
                            <div class="span4"><input type="text" name="txtNumero" value="" /></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">


                <div class="span3 offset4">
                    <a class="btn btn-primary btn-block">Realizar Pedido</a>
                </div>


            </div><br>


        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
