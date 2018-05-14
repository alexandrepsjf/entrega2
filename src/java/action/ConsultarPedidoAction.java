/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.ClienteDAO;
import persistence.PedidoDAO;

/**
 *
 * @author negro
 */
public class ConsultarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            PrintWriter writer = response.getWriter();
writer.println("<h1>testre enviado com sucesso</h1>");
            request.setAttribute("pedidos", PedidoDAO.getInstance().consultar());
                        request.setAttribute("clientes", ClienteDAO.getInstance().consultar());
            RequestDispatcher view = request.getRequestDispatcher("/consultarPedido.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            response.sendRedirect("Error.jsp");
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(ConsultarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
