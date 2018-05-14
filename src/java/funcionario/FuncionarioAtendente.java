/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import model.PedidoEstadoCadastrado;

/**
 *
 * @author negro
 */
public class FuncionarioAtendente extends Funcionario {

    public FuncionarioAtendente(String nome) {
        super(nome);
        this.codCargo = 1;
        this.pedidoEstado = new PedidoEstadoCadastrado();
    }

    public FuncionarioAtendente() {
        super();
    }
    @Override

public String getCargo(){
    return "Atendente";
}

   
}
