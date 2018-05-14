/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author negro
 */
public class PedidoEstadoCadastrado implements PedidoEstado {
String nome="Cadastrado";
    @Override
    public String getEstado() {
        return " Cadastrado";
    }

    @Override
    public String cadastrar(Pedido pedido) {
        return "Pedido já Cadastrado";
    }

    @Override
    public String enviar(Pedido pedido) {
        return "Pedido ainda em produção";
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Pedido ainda em produção";
    }

    @Override
    public String produzir(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoProduzido());
return pedido.getEstado().getEstado();
    }

}
