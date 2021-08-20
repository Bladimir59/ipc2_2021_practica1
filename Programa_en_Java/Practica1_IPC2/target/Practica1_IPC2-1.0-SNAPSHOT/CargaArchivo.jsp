<%-- 
    Document   : CargaArchivo
    Created on : 17/08/2021, 12:04:07
    Author     : bladimir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carga de Archivo</title>
    </head>
    <body>
        <div>
            <h3>Carga de Datos</h3>
        </div>
        <div>
            <form action="ControlS" method="post" enctype="multipart/form-data">
                <div>
                    <input type="file" accept=".xml" name="opcion">
                </div>
                <button type="submit" name="accion" value="enviar"> Aceptar </button>
            </form>                  
        </div>
        <%@include file="JavaScript.html"%> 
    </body>
</html>
