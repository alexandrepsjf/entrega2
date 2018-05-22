<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@page contentType="text/html" pageEncoding="utf-8"%>
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
        <div class="center "><h3>Pesquisa de pedidos</h3></div>
        <table class=" highlight centered">            
            <thead>                 
                <tr> 
                    <th>Código pedido</th>
                    <th>Cliente do pedido</th>
                    <th>Estado do pedido</th>
                    <th colspan="3">Mudar estado do pedido</th>
                    <th colspan="2">Ação</th> 
                    <th colspan="2">Voltar estado</th> 
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${pedidos}" var="pedido">
                    <tr>
                        <td > <c:out value=" ${pedido.id}" /> </td>
                        <td > <c:out value=" ${pedido.cliente.nome}" /> </td>
                        <td > <c:out value=" ${pedido.nomeEstado} " /> </td>
                        <td colspan="2">  
                            <a href="FrontController?action=MudarEstadoProduzidoPedido&estado='Produzido'&id=<c:out value='${pedido.id}' /> " id="formCadastro"> Produzir </a>
                            <a href="FrontController?action=MudarEstadoEnviadoPedido&estado='Enviado'&id=<c:out value='${pedido.id}' /> " > Enviar </a>
                            <a href="FrontController?action=MudarEstadoEntreguePedido&estado='Entregue'&id=<c:out value='${pedido.id}' /> " > Entregar </a>
                        </td>
                        <td >
                            <a href="FrontController?action=PrepararEditarPedido&id=<c:out value='${pedido.id}' /> " ><i class="material-icons right">edit</i></a>
                        </td>
                        <td >
                            <a href="FrontController?action=ApagarPedido&id=<c:out value='${pedido.id}' /> " ><i class="material-icons right">delete</i></a>
                        </td>
                        <td colspan="2">
                            <a href="FrontController?action=GravarPedidoMemento&idPedido=<c:out value='${pedido.id}' /> " ><i class="material-icons right">save</i>
                            </a>                        
                            <a href="FrontController?action=VoltarPedidoMemento&idPedido=<c:out value='${pedido.id}' /> " ><i class="material-icons right">settings_backup_restore</i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody> 
        </table>
        <form action="FrontController?action=PrepararGravarPedido" method="POST" class="center" >
            <div class="input-field col s1 btn waves-effect waves-light">
                <input id="submit" type="submit" class="submit" name="btnIncluir" value="Incluir">                 
                <i class="material-icons right">add_circle</i>            
            </div>
        </form>
        <script type="text/javascript">
            $(document).ready(function () {
                var form = $('#formCadastro');
                form.submit(function (e) {
                    e.preventDefault();
                    $.ajax({
                        url: "./FrontController?action=MudarEstadoProduzidoPedido",
                        type: 'post',
                        context: document.body,
                        data: form.serialize(),
                        success: function (data) {
                            if (data.substring(0, 4) === 'erro') {
                                var cabecalho = 'Erro!';
                                var tipo = 'error';
                                var mensagem = data.substring(4, 1000);
                                var time = 10000;
                            } else {
                                var cabecalho = 'Sucesso!';
                                var tipo = 'success';
                                var mensagem = data.substring(4, 1000);
                                var time = 3000;
                            }
                            $.toast({
                                text: mensagem, // Text that is to be shown in the toast
                                heading: cabecalho, // Optional heading to be shown on the toast
                                icon: tipo, // Type of toast icon
                                showHideTransition: 'fade', // fade, slide or plain
                                allowToastClose: true, // Boolean value true or false
                                hideAfter: time, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
                                stack: 5, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
                                position: {left: 'auto', right: 30, top: 30, bottom: 'auto'}, // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values
                                textAlign: 'left', // Text alignment i.e. left, right or center
                                loader: true, // Whether to show loader or not. True by default
                                loaderBg: '#9EC600', // Background color of the toast loader
                                beforeShow: function () {}, // will be triggered before the toast is shown
                                afterShown: function () {}, // will be triggered after the toat has been shown
                                beforeHide: function () {}, // will be triggered before the toast gets hidden
                                afterHidden: function () {
                                    location.reload();
                                }  // will be triggered after the toast has been hidden
                            });
                        },
                        error: function (xhr, ajaxOptions, thrownError) {
                            //what to do in error
                        }
                    });
                });
            });
        </script>
    </body>    
</html>
