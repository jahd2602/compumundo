

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


            <div class="row">
                <div class="span4 offset1">nombre: </div>
                <div class="span5 offset1"><input type="text" name="txtNombre" value="" /></div>
            </div>

            <div class="row">
                <div class="span4 offset1">Precio Base: S/.</div>
                <div class="span5 offset1"><input type="text" name="txtBasePrecio" value="" /></div>
            </div>

            <div class="row">
                <div class="span4 offset1">Categoria: </div>
                <div class="span5 offset1"><select name="categoria">
                        <option>PC</option>
                        <option>Memoria USB</option>
                        <option>Otras cosas</option>
                    </select></div>
            </div>


            <div class="row">
                <div class="span3 offset1">Personalizaciones: </div>

                <%--Hacer Un for para agregar personalizaciones--%>
                <div class="span4 offset1"> <input type="checkbox" name="cbxPersonalizacion" value="OFF" /> Pantalla</div>

            </div>
            <%--fin del for para agregar personalizaciones--%>

            <div class="row">
                <div class="span4 offset3"> <input type="checkbox" name="cbxPersonalizacion" value="OFF" /> Memoria</div>

            </div>

            <div class="row">
                <div class="span4 offset3"> <input type="checkbox" name="cbxPersonalizacion" value="OFF" /> Disco</div>

            </div>

            <%--Inicio Parte 3--%>
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
    </body>
</html>
