
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>

        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuCliente.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Personalizar Producto</h3>
                </div>
            </div>
            <div class="container">
                <% double pricePantalla = 0, priceDisco = 0, priceMemoria = 0, priceBateria = 0;
                    double suma = priceBateria + priceDisco + priceMemoria + pricePantalla;
                %>
                <div class="row">
                    <div class="span2">Pantalla </div>
                    <div class="span4"> borrar una vez implementado<%String varPantalla;%> </div>
                    <div class="span2">S/ <%=pricePantalla%> </div>
                    <div class="span4"> <select name="cboxPerson1">
                            <option>LG 17 pulgadas</option>
                            <option>Samsung 19"</option>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="span2"> Disco </div>
                    <div class="span4">borrar una vez implementado<%String varDisco;%> </div>
                    <div class="span2"> S/ <%=priceDisco%></div>
                    <div class="span4"> <select name="cboxPersonal2">
                            <option> 2 teras</option>
                            <option> 1 tera</option>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="span2">Memoria</div>
                    <div class="span4"> borrar una vez implementado<%String varMemoria;%></div>
                    <div class="span2"> S/ <%=priceMemoria%></div>
                    <div class="span4">  <select name="cboxPersonal2">
                            <option> 1 GB</option>
                            <option> 1 GB</option>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="span2">Bateria</div>
                    <div class="span4"> borrar una vez implementado<%String varBateria;%></div>
                    <div class="span2"> S/ <%=priceBateria%></div>
                    <div class="span4">  <select name="cboxPersonal2">
                            <option> Litio 6 horas</option>
                            <option> Adamantium 80 horas :D</option>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="span3"><strong>Total</strong></div>

                    <div class="span2 offset5"> S/ <%=suma%> </div>

                </div>

            </div>
            <div class="row show-grid">
                <div class="span2"></div>
                <div class="span">

                    <div class="span2">
                        <a class="btn">Agregar Al Carro</a>
                    </div>

                    <!se parteee>
                    <div class="span2">
                        <a href="/cm/" class="btn">Cancelar</a>
                    </div></div>

                <div class="span2 offset2">
                    <a class="span2 btn">Realizar Cambios</a>
                </div>
            </div>

        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
