<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%-- The taglib directive below imports the JSTL library. If you uncomment it,
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
        <script>
            $(document).ready(function () {
                M.updateTextFields();
                $('.dropdown-trigger').dropdown();
            });
        </script>
    </head>
    <body>
       <div class="navbar-fixed">
            <nav class="  darken-4 " role="navigation">
                <div class="nav-wrapper  ">
                    <ul class="  ">
                        <li>                             
                            <a href="index.jsp" class=""><h5>Home</h5></a>
                        </li>
                        <li>                             
                            <a href="FrontController?action=ConsultarPedido" class=""><h5>Pedidos</h5></a>
                        </li>                         
                        <li>                             
                            <a href="FrontController?action=ConsultarCliente" class=""><h5>Clientes</h5></a>
                        </li>
                        <li>         
                            <a href="FrontController?action=ConsultarFuncionario" class=" "><h5>Funcionarios</h5></a>
                        </li>
                    </ul> 
                </div>
            </nav>
        </div> 
        <h1>Cadastro de Funcionarios</h1>



        <form action="FrontController?action=GravarFuncionarioAtendente" method="post">
            <table class=" highlight centered">            
                <div class="input-field col s3">
                    <input placeholder="Nome" id="first_name" type="text" class="validate" name="textNome">
                </div>
                <div>
                    <input id="submit" type="submit" class="submit" name="btnIncluir" value="Atendente">                </div>            

            </table>
        </form>

        <form action="FrontController?action=GravarFuncionarioCozinheiro" method="post">
            <table class=" highlight centered">            
                <div class="input-field col s3">
                    <input placeholder="Nome" id="first_name" type="text" class="validate" name="textNome">
                </div>
                <div>
                    <input id="submit" type="submit" class="submit" name="btnIncluir" value="Cozinheiro">                </div>            
                </div>            

            </table>
        </form>

        <form action="FrontController?action=GravarFuncionarioEmbalador" method="post">
            <table class=" highlight centered">            
                <div class="input-field col s3">
                    <input placeholder="Nome" id="first_name" type="text" class="validate" name="textNome">
                </div>
                <div>
                    <input id="submit" type="submit" class="submit" name="btnIncluir" value="Embalador">                </div>            
                </div>            

            </table>
        </form>

        <form action="FrontController?action=GravarFuncionarioEntregador" method="post">
            <table class=" highlight centered">            
                <div class="input-field col s3">
                    <input placeholder="Nome" id="first_name" type="text" class="validate" name="textNome">
                </div>
                <div>
                    <input id="submit" type="submit" class="submit" name="btnIncluir" value="Entregador">                </div>            
                </div>            

            </table>
        </form>
        <div class="center">
            <a href="index.jsp" class="btn red">Voltar</a>
        </div>
    </body>
</html>
