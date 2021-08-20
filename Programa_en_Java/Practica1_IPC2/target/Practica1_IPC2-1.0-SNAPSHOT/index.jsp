<%-- 
    Document   : index
    Created on : 12/08/2021, 22:18:21
    Author     : bladimir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practica1</title>
        
    </head>
    <body>
        <%
            if(manejador.Verificar.siExiste()){
                %>
                <%@include file="login.jsp"%>
                <%
                    }else{
                %>
                <%@include file="CargaArchivo.jsp" %>
        <%           
                }
                %>
    </body>
</html>
