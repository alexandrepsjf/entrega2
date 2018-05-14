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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Entregador;
import persistence.ClienteDAO;
import persistence.EntregadorDAO;

/**
 *
 * @author negro
 */
public class EditarClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("textId"));
        String nome = request.getParameter("textNome");
        try {
            Cliente   cliente = new Cliente(id, nome);
              ClienteDAO.getInstance().load(cliente);
            response.sendRedirect("Sucess.jsp");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            response.sendRedirect("Error.jsp");
            ex.printStackTrace();
        }
    }
}
