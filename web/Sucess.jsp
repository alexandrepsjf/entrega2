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
    </head>
    <body>
        <h1>Realizado com sucesso </h1>
        <a href="index.jsp" class="btn red"><button>Voltar</button></a>
<script type="text/javascript">
    $(document).ready(function () {
        var form = $('#formCadastro');
        form.submit(function (e) {
            e.preventDefault();
            $.ajax({
                url: "./FrontController?action=MudarEstadoEntreguePedido",
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
