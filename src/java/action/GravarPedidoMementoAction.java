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
import model.PedidoMemento;
import persistence.ClienteDAO;
import persistence.PedidoDAO;
import persistence.PedidoMementoDAO;

/**
 *
 * @author negro
 */
public class GravarPedidoMementoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        try {
            Pedido pedido = PedidoDAO.getInstance().Buscar(idPedido);
            String Historico = "Seu pedido foi " + pedido.getEstado().getEstado()+" Pelo "+pedido.getFuncionario().getDescricao();
            String estado = pedido.getEstado().getEstado();
            PedidoMemento pedidoMemento = new PedidoMemento(idPedido, idPedido, Historico);
            pedidoMemento.criarEstado(estado);
            PedidoMementoDAO.getInstance().save(pedidoMemento);
            response.sendRedirect("Sucess.jsp");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            response.sendRedirect("Error.jsp");
            ex.printStackTrace();
        }
    }
}
