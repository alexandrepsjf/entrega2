<%-- 
    Document   : apagarCadastro
    Created on : 10/04/2018, 09:26:53
    Author     : negro
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
    <link href="css/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="css/style.min.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    </head>
    <body>
        <div class="navbar-fixed">
    <nav class="  darken-4 " role="navigation">
        <div class="nav-wrapper  ">
            <ul class="  ">
                <li> <a href="cadContato.jsp" class="">Contatos</a></li>
                                <li>         <a href="cadDepartamento.jsp" class=" ">Departamentos</a>
</li>

            </ul>      
          
        </div>
    </nav>
</div>
                 <h1>Apagar de Pedido</h1>
 <form action="FrontController?action=ApagarPedido" method="post">
      Entre com o id para apagar<br/>
      <input type="text" class="s1" name="textId"/><br/> 
      
      <input type="submit"/>      
    </form>
                 <div class="center">  <a href="index.jsp" class="btn red center">Voltar</a></div>
        
            
    </body>
</html>
