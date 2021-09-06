<%-- 
    Document   : RegistrarMueble
    Created on : 5/09/2021, 14:37:05
    Author     : bladimir
--%>

<%@page import="Controlador.FabricaTienda"%>
<%
    Controlador.FabricaTienda lista = new FabricaTienda();
    String texto="";
   texto=lista.getEnsambles();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>       
        
        <h1>Muebles!</h1>
        <%
        out.println(texto);
        %>
    </body>
</html>
