<%-- 
    Document   : contatoSucesso
    Created on : 29/03/2018, 09:14:53
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
        <script>
            function LancamentoPopUp( id, unidade, empreendimento ){
		window.open('Sucess2.jsp?idTeste=3');
}        </script>
    </head>
    <body>
        <h1>Realizado com sucesso</h1>
        <a href="#" onclick="LancamentoPopUp()" class="btn red"><button>Voltar</button></a>

    </body>
</html>