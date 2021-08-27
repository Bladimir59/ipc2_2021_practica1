<%-- 
    Document   : pieza
    Created on : 23/08/2021, 22:49:23
    Author     : bladimir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear Nueva Pieza!</h1>
        <form name="formulario1" action="ServerPieza" method="post">
            <fieldset>
                <legend>
                    <h1>Pieza:</h1>
                </legend>
                Nombre: <br/>
                <input required type="text" size="30" name="nombre" />
                <br/> Precio: 
                <br/><input required type="number" size="30" name="precio" />
                <br/> Cantidad: 
                <br/><input required type="number" size="30" name="cantidad" />
                <br>
                <input type=»text» type="number" value="crear" name="caso"/>
                <br/>
                <button type="submit" name="accion" value="ServerPieza">Aceptar</button>
            </fieldset>
        </form>
    </body>
</html>
