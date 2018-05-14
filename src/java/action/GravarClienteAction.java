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
import persistence.ClienteDAO;

/**
 *
 * @author negro
 */
public class GravarClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("textNome");
        if (nome.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Cliente cliente = new Cliente(nome);
                ClienteDAO.getInstance().save(cliente);
                response.sendRedirect("Sucess.jsp");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                response.sendRedirect("Error.jsp");
                ex.printStackTrace();
            }
        }
    }
}
