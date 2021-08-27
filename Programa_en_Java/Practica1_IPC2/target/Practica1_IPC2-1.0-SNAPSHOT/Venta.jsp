<%-- 
    Document   : Venta
    Created on : 12/08/2021, 22:42:49
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
        <h1>VENTA!</h1>
        <h2>Vender </h2>
        <br>
        <h2>Devolucion </h2>
        <br>
        <form method="POST" action="">
            <h2>Informe</h2>
            elija la opcion para ver el informe:
            <select name="caso1" required>
                <option value="comprasCliente">Ver Compras de un Cliente</option>
                <option value="devoluciones">Ver devoluciones</option>
                <option value="mueblesDisponibles">Ver Muebles Disponibles</option>
                <option value="facturaCliente">Ver Factura Cliente</option>
                <option value="consultaVentaDia">Ver Ventas del Dia</option>
            </select>
            <button>Aceptar</button>
        </form>
    </body>
</html>
