/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.FuncionarioDAO;
import persistence.PedidoMementoDAO;

/**
 *
 * @author negro
 */
public class PedidoEstadoProduzido implements PedidoEstado {

    String nome = "Produzido";

    @Override
    public String getEstado() {
        return "Produzido";
    }

    @Override
    public String cadastrar(Pedido pedido) {
        return "Pedido já cadastrado e produzido ";
    }

    @Override
    public String enviar(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoEnviado());
          int idFuncionario=0;
        try {
            idFuncionario = pedido.getFuncionario().assumirTarefa(pedido.getEstado(),1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoEstadoCadastrado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoEstadoCadastrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pedido.setFuncionario(FuncionarioDAO.getInstance().Buscar(idFuncionario));
                        pedido.setIdFuncionario(idFuncionario);
                                    PedidoMementoDAO.getInstance().Buscar(pedido.getId()).updateMemento("Seu pedido foi " + pedido.getEstado().getEstado() + " pelo " + pedido.getFuncionario().getDescricao());

        } catch (SQLException ex) {
            Logger.getLogger(PedidoEstadoCadastrado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoEstadoCadastrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedido.getEstado().getEstado();
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Pedido apenas cadastrado e produzido ";
    }

    @Override
    public String produzir(Pedido pedido) {
        return "Pedido já Produzido";
    }
}
