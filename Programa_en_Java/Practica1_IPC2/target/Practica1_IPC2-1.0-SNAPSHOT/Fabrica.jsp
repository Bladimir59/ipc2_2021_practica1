<%-- 
    Document   : Fabrica
    Created on : 12/08/2021, 22:42:08
    Author     : bladimir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Fabrica!</h1>
        <%--formulario para la funcion de las piezas --%>
        <form method="POST" action="ServerFabrica">
            <h2>Piezas</h2>
            elija la opcion para ver que necesita hacer con las piezas
            <label for="caso1">Operacion:</label>
            <select name="caso1" required>
                <option value="Crear">Crear Pieza</option>
                <option value="Modificar">Modificar Pieza</option>
                <option value="Eliminar">Eliminar Pieza</option>
            </select>
            <button type="sumit">Aceptar</button>
        </form>
        <br>
        <%--para ver las funciones que puede hacer con los muebles --%>
        <form method="POST" action="">
            <h2>Muebles</h2>
            elija la opcion para ver que necesita hacer con las piezas
            <select name="caso2" required>
                <option value="Ensamblar">Ensamblar Mueble</option>
                <option value="Registrar">Registrar Mueble</option>
            </select>
            <button>Aceptar</button>            
        </form>        
        <br>
        <form method="POST" action="">
            <h2>Informe</h2>
            elija la opcion para ver que necesita hacer con las piezas
            <select name="caso3" required>
                <option value="verPieza">Ver Piezas</option>
                <option value="verMueble">Ver Muebles</option>
            </select>
            <button>Aceptar</button>
        </form>
    </body>
</html>
