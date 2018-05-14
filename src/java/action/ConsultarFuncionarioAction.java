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
import persistence.FuncionarioAtendenteDAO;

/**
 *
 * @author negro
 */
public class ConsultarFuncionarioAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.setAttribute("funcionarios", FuncionarioAtendenteDAO.getInstance().consultar());
            RequestDispatcher view = request.getRequestDispatcher("/consultarFuncionario.jsp");
            view.forward(request, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            response.sendRedirect("Error.jsp");
            ex.printStackTrace();
        } catch (ServletException ex) {
            Logger.getLogger(ConsultarFuncionarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
