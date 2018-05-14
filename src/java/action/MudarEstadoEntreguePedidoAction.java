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

/**
 *
 * @author negro
 */
public class MudarEstadoEntreguePedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        String estado=request.getParameter("estado");
        try {
            Pedido pedido=PedidoDAO.getInstance().Buscar(id); 
            request.setAttribute("resposta", pedido.entregar());
            PedidoDAO.getInstance().load(pedido);            
            RequestDispatcher view = request.getRequestDispatcher("/resposta.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            response.sendRedirect("Error.jsp");
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(MudarEstadoEntreguePedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
