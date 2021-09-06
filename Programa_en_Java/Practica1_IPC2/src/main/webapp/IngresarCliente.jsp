<%-- 
    Document   : IngresarCliente
    Created on : 6/09/2021, 07:24:12
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
        <h1>Datos Nuevo Cliente!</h1>
        <form name="registro" method="post" action="NuevoCliente">
            Nit:
            <br>
            <input type="text" name="nit"/>
            <br>
            Nombre:
            <br>
            <input type="text" name="nombre"/>
            <br>
            Direccion:
            <br>
            <input type="text" name="direccion"/>
            <br>
            Municipio:
            <br>
            <input type="text" name="municipio"/>
            <br>
            Departamento:
            <br>
            <input type="text" name="departamento"/>
            <br>
            <button type="submit" name="accion" value="datos">Aceptar</button>
        </form>
    </body>
</html>
