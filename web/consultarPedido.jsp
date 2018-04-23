<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

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
         <div class="center "><h3>Pesquisa de entregadores</h3></div>
        <table class=" highlight centered">            
             <thead>                  <tr> 
                <th>Código entregador</th>
                <th>Nome entregador</th>
                <th colspan="2">Ação</th>                
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pedidos}" var="pedido">
                <tr>
                    <td ><c:out value="${pedido.id}" /> </td>
                    <td ><c:out value="${pedido.nome}" /> </td>
                    <td ><a href="EditarPedido?acao=EditarPedido&id=<c:out value='${pedido.id}' /> " >Editar</a></td>
                    <td ><a href="ApagarPedido?acao=EditarPedido&id=<c:out value='${pedido.id}' /> " >Excluir</a></td>
                </tr>
            </c:forEach>
                 </tbody>
        </table>
       
            <form action="gravarPedido.jsp" method="POST">
                <div class="input-field col s12 btn waves-effect waves-light">
                    <input id="submit" type="submit" class="submit" name="btnIncluir" value="Incluir">                 
                    <i class="material-icons right">send</i>
                </div>
            </form>
    </body>    
</html>
