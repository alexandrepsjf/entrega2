/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import model.PedidoEstadoEnviado;

/**
 *
 * @author negro
 */
public class FuncionarioEmbalador extends Funcionario {

    public FuncionarioEmbalador(String nome) {
        super(nome);
        this.pedidoEstado = new PedidoEstadoEnviado();
        this.codCargo = 3;
    }

    public FuncionarioEmbalador() {
                this.pedidoEstado = new PedidoEstadoEnviado();

    }

    @Override
    public String getCargo() {
        return "Embalador";
    }

}
