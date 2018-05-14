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
public interface PedidoEstado {

    public String getEstado();

    public String cadastrar(Pedido pedido);

    public String enviar(Pedido pedido);

    public String entregar(Pedido pedido);

    public String produzir(Pedido pedido);
}
