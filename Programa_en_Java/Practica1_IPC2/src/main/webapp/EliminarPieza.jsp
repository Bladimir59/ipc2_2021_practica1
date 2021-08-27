<%-- 
    Document   : EliminarPieza
    Created on : 24/08/2021, 21:05:53
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
        <h1>Eliminar Pieza!</h1>
        <form name="formulario1" action="ServerPieza" method="post">
            <fieldset>
                <legend>
                    <h1>Pieza:</h1>
                </legend>
                <br/>ingrese el codigo del producto campo obligatorio
                <br/><input required type="number" size="30" name="codigo" />
                <br/> <input type=»text» value="eliminar" name="caso"/>
                <br/>
                <button type="submit" name="accion" value="ServerPieza">Aceptar</button>
            </fieldset>
        </form>
    </body>
</html>
