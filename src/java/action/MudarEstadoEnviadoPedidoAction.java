/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pedido;
import persistence.ClienteDAO;
import persistence.PedidoDAO;
import persistence.PedidoMementoDAO;

/**
 *
 * @author negro
 */
public class MudarEstadoEnviadoPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        String estado=request.getParameter("estado");
        try {
            Pedido pedido = PedidoDAO.getInstance().Buscar(id);
            request.setAttribute("resposta", pedido.enviar());
            PedidoDAO.getInstance().atualizarMensagem(pedido);
            PedidoDAO.getInstance().load(pedido);
//                        PedidoMementoDAO.getInstance().Buscar(id).updateMemento("Seu pedido est� "+pedido.getEstado().getEstado()+" pelo "+pedido.getFuncionario().getDescricao());

            RequestDispatcher view = request.getRequestDispatcher("/resposta.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            response.sendRedirect("Error.jsp");
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(MudarEstadoEnviadoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
