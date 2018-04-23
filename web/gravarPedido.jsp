<%-- 
    Document   : gravarCadastro
    Created on : 10/04/2018, 09:26:22
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
<script src="js/materialize.min.js"></script>
<script src="js/init.js"></script>
    </head>
    <body>
        <div class="navbar-fixed">
            <nav class="  darken-4 " role="navigation">
                <div class="nav-wrapper  ">
                    <ul class="  ">
                        <li> 
                            <a href="cadPedido.jsp" class="">Pedidos</a>
                        </li>
                        <li>         
                            <a href="cadEntregadores.jsp" class=" ">Entregadores</a>
                        </li>
                    </ul> 
                </div>
            </nav>
        </div>    
 <h1>Cadastro de Pedido</h1>
    <form action="FrontController?action=GravarPedido" method="post">
      Entre com seu nome<br/>
      <input type="text" name="textNome"/><br/>
      Entre com seu cliente<br/>
      <input type="text" name="textCliente"/><br/>
      <input type="submit"/>
    </form> 
         <a href="index.jsp" class="btn red"><button>Voltar</button></a>
</body>
</html>
