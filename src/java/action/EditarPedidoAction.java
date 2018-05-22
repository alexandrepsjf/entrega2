/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Pedido;
import persistence.ClienteDAO;
import persistence.PedidoDAO;

/**
 *
 * @author negro
 */
public class EditarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int id = Integer.parseInt(request.getParameter("textId"));
        try {
            Cliente cliente = ClienteDAO.getInstance().Buscar(idCliente);
            Pedido pedido = new Pedido(id, cliente);
            PedidoDAO.getInstance().load(pedido);
            response.sendRedirect("Sucess.jsp");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            response.sendRedirect("Error.jsp");
            ex.printStackTrace();
        }
    }
}
