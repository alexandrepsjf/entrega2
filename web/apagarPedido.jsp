<%-- 
    Document   : apagarCadastro
    Created on : 10/04/2018, 09:26:53
    Author     : negro
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
                 <h1>Apagar de Contatos</h1>
<form action="FrontController?action=ApagarPedido" method="post">
      Entre com o id para apagar<br/>
      <input type="text" name="textId"/><br/>       
      <input type="submit"/>
    </form>
          <a href="index.jsp" class="btn red"><button>Voltar</button></a>
            
    </body>
</html>
