/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import Controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistence.EntregadorDAO;

/**
 *
 * @author negro
 */
public class ConsultarEntregadorAction implements Action{
    

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
            try {
                request.setAttribute("entregadores", EntregadorDAO.getInstance().consultar());
        RequestDispatcher view = request.getRequestDispatcher("/consultarEntregador.jsp");
        view.forward(request, response);              
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("contatoerro.jsp");
                ex.printStackTrace();
            } catch (ServletException ex) {
            Logger.getLogger(ConsultarEntregadorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        }    }

