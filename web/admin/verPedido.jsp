
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
            <%--Modificar Fecha con la de la creación, tambien enlazar los sgts atributos a la BD--%>
            <div class="container">
                <% Date Fecha = new Date();
                    String Cliente = "";
                String varArticulo="", varPersonalizacion="";         
                double varMonto=0;
                
                %>

                <div class="span4 offset2">Cliente:Cesar Quiste <%=Cliente%> </div> <div class="span5">Fecha: 26/03/2013 <%=Fecha%></div><br><br>

                <div class="row"> 

                    <div class="span12">


                        <table  align="center" border="5" cellspacing="5" cellpadding="5">
                            <thead>
                                <tr>
                                    <th>Articulo</th>
                                    <th>Personalizaciones</th>
                                    <th>Monto</th>
                                </tr>
                            </thead>
                            <tbody>
                                 <%--for para agregar Pedidos --%>
                                <tr>
                                    <td>Pc con softWare Libre <%=varArticulo%></td>
                                    <td>Pantalla 17"
                                        Memoria 8gb <%=varPersonalizacion%></td>
                                    <td>S/ 800<%=varMonto%></td>
                                </tr>
                                 <%--fin del For para agregar Pedidos--%>
                            </tbody>
                        </table>
                    </div> 
                </div>
            </div>  
            <%--fin parte 2/3 mid--%>
            <%--parte mid--%>
            <%--Comienzo 1/3--%>
            <br>
            <div class="row show-grid">
                <div class="span4"></div>
                <div class="span">

                    <div class="span2">
                        <a class="btn">Aceptar</a>
                    </div>  

                    <!se parteee>
                    <div class="span2"> 
                        <a class="btn">Archivar</a>
                    </div></div>

                <div class="span4"></div>
            </div>
            <%--fin parte 1/3--%> 



        </div> 
    </body>
</html>