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

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>  
      
    </head>
    <body>
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
                        </li> <li>                             
                            <a href="FrontController?action=ConsultarCliente" class=""><h5>Clientes</h5></a>
                        </li>
                        <li>         
                            <a href="FrontController?action=ConsultarFuncionario" class=" "><h5>Funcionarios</h5></a>
                        </li>
                    </ul> 
                </div>
            </nav>
        </div> 
        <h1>Cadastro de Pedido</h1>        
      
        <form action="FrontController?action=GravarPedido" method="post">
            <table class=" highlight centered">
                <tr>  
                    <td>CLIENTE
                        <select name="idCliente" id="clientes" >
                            <option value="" >Selecione</option>
                            <c:forEach var="cliente" items="${clientes}">
                                <option value="${cliente.id}" <c:if test="${pedido.clienteId.id == cliente.id}"> selected</c:if> >  ${cliente.nome} </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>       

            <div class="center">
                <input type="submit"/>
            </div>
        </form>
        <div class="center">
            <a href="index.jsp" class="btn red">Voltar</a>
        </div>
    </body>
</html>
