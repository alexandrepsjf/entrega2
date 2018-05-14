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
public class PedidoEstadoProduzido implements PedidoEstado {
String nome="Produzido";

    @Override
    public String getEstado() {
        return "Produzido";
    }

    @Override
    public String cadastrar(Pedido pedido) {
        return "Pedido já Produzido";
    }

    @Override
    public String enviar(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoEnviado());
        return pedido.getEstado().getEstado();
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Pedido já Produzido";
    }

    @Override
    public String produzir(Pedido pedido) {
        return "Pedido já Produzido";
    }
}
