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
public class PedidoEstadoEntregue implements PedidoEstado {

    String nome = "Entregue";

    @Override
    public String getEstado() {
        return "Entregue";
    }

    @Override
    public String cadastrar(Pedido pedido) {
        return "Pedido já  entregue";
    }

    @Override
    public String enviar(Pedido pedido) {
        return "Pedido já entregue";
    }

    @Override
    public String entregar(Pedido pedido) {
        return "Pedido já entregue";
    }

    @Override
    public String produzir(Pedido pedido) {
        return "Pedido já entregue";
    }

}
