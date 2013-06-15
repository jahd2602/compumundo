

<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
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
            <%=upao.paw.compumundo.Constantes.MENU_ADMIN%>

            <%--Comienzo 2/3   mid--%>
           
            <div class="container">
                 <%--Una Vez Creada la DB Recibir datos y ponerlos en las sgts. Variables--%>
                <% double Monto=0;
                String Pedido="", usuario="";
                Date Fecha = new Date();
                %>
                
                <div class="row">
                    <div class="span4">Pedido </div>
                    <div class="span4"> Usuario </div>
                    <div class="span2">Fecha </div>
                    <div class="span2"> Monto</div>
                </div> <br>



 <%--Hacer un FOR para recibir los pedidos ir agregando--%>
 <%--
 for(int i=0; i<TablaPedidoBaseDatos.lenght; i++){;
 --%>
                <div class="row">
                    <div class="span4"><input type="radio" name="rbtnPedido" value="<%=Pedido%>" />  2 Articulos</div>
                    <div class="span4"> Mesta Ruben <%=usuario%></div>
                    <div class="span2"> 26/03/2013 <%=Fecha%></div>
                    <div class="span2"> S/ 100<%=Monto%> </div>               
                </div>
 <%--}--%>
 <%--Fin del FOR--%>
                


               
                <%--fin parte 2/3 mid--%>
<br>
            </div>  
            <%--parte mid--%>
            <%--Comienzo 1/3--%>
            <div class="row show-grid">
                <div class="span4"> Acciones: </div>
                <div class="span">

                    <div class="span2">
                        <a  class="btn">Detalle</a>
                    </div>  

                    <!se parteee>
                    <div class="span2"> 
                        <a   class="btn">Archivar</a>
                    </div></div>

                <div class="span4"></div>
            </div>
            <%--fin parte 1/3--%> 

        </div> 
    </body>
</html>