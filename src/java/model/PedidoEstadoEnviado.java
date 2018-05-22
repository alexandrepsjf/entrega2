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
public class PedidoEstadoEnviado implements PedidoEstado {

    String nome = "Enviado";

    @Override
    public String getEstado() {
        return "Enviado";
    }

    @Override
    public String cadastrar(Pedido pedido) {
        return "Pedido já cadastrado, produzido e enviado";
    }

    @Override
    public String enviar(Pedido pedido) {
        return "Pedido já cadastrado, produzido e enviado";
    }

    @Override
    public String entregar(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoEntregue());
        int idFuncionario = 0;
        try {
            idFuncionario = pedido.getFuncionario().assumirTarefa(pedido.getEstado(), 1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoEstadoCadastrado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoEstadoCadastrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pedido.setFuncionario(FuncionarioDAO.getInstance().Buscar(idFuncionario));
            pedido.setIdFuncionario(idFuncionario);
pedido.getPedidoMemento().updateMemento("Seu pedido foi " + pedido.getEstado().getEstado() + " pelo " + pedido.getFuncionario().getDescricao() + " com entrega " + pedido.getCliente().getEstrategiaEntrega());

        } catch (SQLException ex) {
            Logger.getLogger(PedidoEstadoCadastrado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoEstadoCadastrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedido.getEstado().getEstado();
    }

    @Override
    public String produzir(Pedido pedido) {
        return "Pedido já cadastrado, produzido e enviado";
    }

}
