<%-- 
    Document   : login
    Created on : 12/08/2021, 22:26:03
    Author     : bladimir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--JQUERY-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    
    <!-- FRAMEWORK BOOTSTRAP para el estilo de la pagina-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    
    <!-- Los iconos tipo Solid de Fontawesome-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
    <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>

    <!-- Nuestro css-->
    <link rel="stylesheet" type="text/css" href="CSS/login.css" th:href="@{/css/index.css}">
    </head>
    <body>
        <div class="modal-dialog text-center">
        <div class="col-sm-8 main-section">
            <div class="modal-content">
                <div class="col-12 user-img">
                    <img src="IMG/user.png" th:src="@{/user.png}"/>
                </div>
                <form name="registro" class="col-12" action="test" method="post">
                    <div>
                        <input type="text" name="nombre"/>
                    </div>
                    <div>
                        <input type="text" name="password"/>
                    </div>
                    <button type="submit" name="accion" value="datos"></i>  Ingresar </button>
                </form>
                
                <div class="col-12 forgot">
                    <a href="#">Recordar contrasena?</a>
                </div>
                <div th:if="${param.error}" class="alert alert-danger" role="alert">
		            Invalid username and password.
		        </div>
		        <div th:if="${param.logout}" class="alert alert-success" role="alert">
		            You have been logged out.
		        </div>
            </div>
        </div>
    </div>
    </body>
</html>
