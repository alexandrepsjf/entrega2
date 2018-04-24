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
public class PedidoEstadoEnviado implements PedidoEstado{

    @Override
    public String getEstado() {
return "Enviado";    }

    @Override
    public String cadastrar(Pedido pedido) {
return "Não permitido";    }

    @Override
    public String enviar(Pedido pedido) {
        return "Não permitido";
    }

    @Override
    public String entregar(Pedido pedido) {
 pedido.setEstado(new PedidoEstadoEntregue());
return pedido.getEstado().getEstado();        }

    @Override
    public String cancelar(Pedido pedido) {
 pedido.setEstado(new PedidoEstadoCancelado());
return pedido.getEstado().getEstado();        }

    @Override
    public String produzir(Pedido pedido) {
return "Não permitido";
    }
    
}
