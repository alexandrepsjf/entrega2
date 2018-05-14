/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import model.PedidoEstadoProduzido;

/**
 *
 * @author negro
 */
public class FuncionarioCozinheiro extends Funcionario {

    public FuncionarioCozinheiro(String nome) {
        super(nome);
        this.codCargo = 2;
        this.pedidoEstado = new PedidoEstadoProduzido();
    }

    public FuncionarioCozinheiro() {
    }
  

    @Override
    public String getCargo() {
  return "Cozinheiro";
          }

}
