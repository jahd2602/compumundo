<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jspf/plantillaHead.jspf" %>
    <body>
        <div class="container">
            <%@include file="/WEB-INF/jspf/plantillaMenuAdmin.jspf"%>
            <div class="row">
                <div class="span11 offset1">
                    <h3>Ver Producto</h3>
                </div>
            </div>
            <div class="row">
                <div class="span7 offset2">
                    <div class="well well-small">
                        <div class="row">
                            <div class="span3">
                                <div class="pull-right">Nombre: </div>
                            </div>
                            <div class="span2"><input type="text" name="txtNombre" value="" /></div>
                        </div>

                        <div class="row">
                            <div class="span3">
                                <div class="pull-right">Precio Base: </div>
                            </div>
                            <div class="span2 input-prepend">
                                <span class="add-on">S/.</span>
                                <input type="text" style="width:178px" name="txtBasePrecio" value="" />
                            </div>
                        </div>

                        <div class="row">
                            <div class="span3">
                                <div class="pull-right">Categoria: </div>
                            </div>
                            <div class="span2"><select name="categoria">
                                    <option>PC</option>
                                    <option>Memoria USB</option>
                                    <option>Otras cosas</option>
                                </select></div>
                        </div>

                        <div class="row">
                            <div class="span3">
                                <div class="pull-right">Personalización: </div>
                            </div>
                            <div class="span2">
                                <select name="personalizacion">
                                    <option>Pantalla</option>
                                    <option>Disco Duro</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="span2 offset4">
                    <a class="btn btn-primary btn-block">Guardar</a>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/plantillaFooter.jspf" %>
    </body>
</html>
