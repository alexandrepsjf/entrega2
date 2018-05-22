/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import model.PedidoEstadoEntregue;

/**
 *
 * @author negro
 */
public class FuncionarioEntregador extends Funcionario {

    public FuncionarioEntregador(String nome) {
        super(nome);
        this.pedidoEstado = new PedidoEstadoEntregue();
        this.codCargo = 4;
    }

    public FuncionarioEntregador() {
                this.pedidoEstado = new PedidoEstadoEntregue();

    }

    @Override
    public String getCargo() {
        return "Entregador";
    }

}
