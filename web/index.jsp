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
    <body class="home" style="background-image: url('entrega.jpg'); background-repeat: no-repeat;background-position: center;    background-attachment: fixed;
">
        <div class="navbar-fixed">
            <nav class="  darken-4 " role="navigation">
                <div class="nav-wrapper  ">
                    <ul class="  ">
                        <li>                             
                            <a href="index.jsp" class=""><h5>HOME</h5></a>
                        </li>
                        <li>                             
                            <a href="FrontController?action=ConsultarPedido" class=""><h5>Pedidos</h5></a>
                        </li>
                        <li>         
                            <a href="FrontController?action=ConsultarEntregador" class=" "><h5>Entregadores</h5></a>
                        </li>
                    </ul> 
                </div>
            </nav>
        </div>    
    </body>    
</html>
