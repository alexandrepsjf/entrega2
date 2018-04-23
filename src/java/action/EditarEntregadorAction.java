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
import model.Entregador;
import persistence.EntregadorDAO;

/**
 *
 * @author negro
 */
public class EditarEntregadorAction implements Action{
    

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
String nome = request.getParameter("textNome");
int id= Integer.parseInt(request.getParameter("textId"));
        if (nome.equals("") ) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Entregador entregador = new Entregador(id,nome);
                EntregadorDAO.getInstance().load(entregador);
               response.sendRedirect("Sucess.jsp");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("Error.jsp");
                ex.printStackTrace();
            }
        }    }
}
