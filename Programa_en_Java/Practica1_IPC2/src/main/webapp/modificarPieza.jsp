<%-- 
    Document   : modificarPieza
    Created on : 23/08/2021, 23:25:04
    Author     : bladimir
--%>

<%@page import="java.util.List"%>
<%@page import="Clases.Pieza"%>
<%@page import="DAO.PiezaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar Pieza!</h1>
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
                <br/>ingrese el codigo del producto campo obligatorio
                <br/><input required type="number" size="30" name="codigo" />
                <br/> <input type=»text» type="number" value="modificar" name="caso" disabled=""/>
                <br/>
                <button type="submit" name="accion" value="ServerPieza">Aceptar</button>
            </fieldset>
        </form>
        <%
            DAO.PiezaDAO info = new PiezaDAO();
        List<Pieza> lista = info.datos();
        
        for (int i = 0; i < lista.size(); i++) {
            out.println(""+lista.get(i).getId()+" "+lista.get(i).getNombre()+" Q"+lista.get(i).getPrecio()+" "+lista.get(i).getCantidad()+"\n");
            %>
            <br>
        <%
        }
        %>
    </body>
</html>
