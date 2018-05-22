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
import model.Pedido;
import model.PedidoMemento;
import persistence.PedidoDAO;
import persistence.PedidoMementoDAO;

/**
 *
 * @author negro
 */
public class VoltarPedidoMementoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        try {
            Pedido pedido = PedidoDAO.getInstance().Buscar(idPedido);
            pedido.setEstado(pedido.getPedidoMemento().getEstadoAnterior());           
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
