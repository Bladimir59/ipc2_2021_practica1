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
            <hr>
            <form action="CargaArchivo" method="post" enctype="multipart/form-data">
                <div>
                    seleccione archivo
                    <input type="file" name="archivo">
                </div>
                <button type="submit" name="accion" value="enviar"> Aceptar </button>
            </form>    
            <input type="file" id="archivoTexto">
            <p id="mensajes"></p>
            <script>
                function abrirArchivo(evento){
                    let archivo = evento.target.files[0];
                    
                    if(archivo){
                        let read = new FileRead();
                        read.onload=function(e){
                            let contenido=e.target.result;
                            document.getElementById('contenido').innerText=contenido;
                        };
                        read.readAsText(archivo);
                        
                    }else{
                        document.getElementById('mensajes').innerText='no se a encontrado archivo';
                    }
                }
                window.addEventListener('load', ()=>{
                   document.getElementById('archivoTexto').addEventListener('change', abrirArchivo); 
                });
                
            </script>
        </div>
       <%@include file="JavaScript.html"%> 
    </body>
</html>
