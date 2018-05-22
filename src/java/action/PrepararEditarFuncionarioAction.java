/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Entregador;
import persistence.EntregadorDAO;
import persistence.FuncionarioCozinheiroDAO;

/**
 *
 * @author negro
 */
public class PrepararEditarFuncionarioAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            request.setAttribute("funcionario", FuncionarioCozinheiroDAO.getInstance().Buscar(id));
            RequestDispatcher view = request.getRequestDispatcher("/prepararEditarFuncionario.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            response.sendRedirect("Error.jsp");
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(PrepararEditarFuncionarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
