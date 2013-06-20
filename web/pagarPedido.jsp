<%--
    Document   : pagarPedido
    Created on : 19-jun-2013, 23:49:18
    Author     : Carrillo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compu Mundo</title>
        <link rel="stylesheet" href="/cm/css/bootstrap.css">
    </head>
    <body>

        <div class="container">

            <% %>

            <div class="row">
                <div class="span3 offset1">Total:</div>
                <div class="span5 offset1"> S/ 1655.00</div>
            </div><br>

            <div class="row">
                <div class="span3 offset1">nombre: </div>
                <div class="span5 offset1"><input type="text" name="txtNombre" value="" /></div>
            </div>

            <div class="row">
                <div class="span3 offset1">Apellido: </div>
                <div class="span5 offset1"><input type="text" name="txtApellido" value="" /></div>
            </div>

            <div class="row">
                <div class="span3 offset1">Dirección: </div>
                <div class="span5 offset1"><input type="text" name="txtDireccion" value="" /></div>
            </div>

            <div class="row">
                <div class="span3 offset1">Ciudad: </div>
                <div class="span5 offset1"><input type="text" name="txtCiudad" value="" /></div>
            </div>

            <div class="row">
                <div class="span3 offset1">Distrito: </div>
                <div class="span5 offset1"><input type="text" name="txtDistrito" value="" /></div>
            </div>

            <div class="row">
                <div class="span3 offset1">Region: </div>
                <div class="span5 offset1"><input type="text" name="txtRegion" value="" /></div>
            </div>

            <div class="row">
                <div class="span3 offset1">Tipo de Tarjeta: </div>
                <div class="span5 offset1"> <select name="cmbTipoTarjeta">
                        <option>MasterCard</option>
                        <option>Visa</option>
                        <option>Maestro</option>
                        <option>American Express</option>
                    </select></div>
            </div>

            <div class="row">
                <div class="span3 offset1">numero: </div>
                <div class="span5 offset1"><input type="text" name="txtNumero" value="" /></div>
            </div>


            <%--Inicio Parte 3--%>
            <br>
            <div class="row">


                <div class="span4 offset3">
                    <a class="btn">Agregar</a>
                </div>

                <!se parteee>
                <div class="span4">
                    <a class="btn">Seguir Comprando</a>
                </div>


            </div><br>


        </div>

    </body>
</html>
