/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import model.PedidoEstado;

/**
 *
 * @author negro
 */
public abstract class Funcionario {

    protected int id;
    protected String nome;
    protected int codCargo;
    protected PedidoEstado pedidoEstado;
    private Funcionario proximoFuncionario;

    public  String getDescricao(){
            return this.getNome()+" " + this.getNome();
}
    public abstract String getCargo();

    public String assumirTarefa(PedidoEstado pedidoEstado) {
        
        if (this.pedidoEstado.getClass().equals(pedidoEstado.getClass())) {
            return getDescricao();
        } else {
            if (proximoFuncionario != null) {
                return proximoFuncionario.assumirTarefa(pedidoEstado);
            } else {
                return "Sem responsável";
            }
        }
    }

    public Funcionario() {
    }

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

    public PedidoEstado getPedidoEstado() {
        return pedidoEstado;
    }

    public void setPedidoEstado(PedidoEstado pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
    }

    public Funcionario getProximoFuncionario() {
        return proximoFuncionario;
    }

    public void setProximoFuncionario(Funcionario proximoFuncionario) {
        this.proximoFuncionario = proximoFuncionario;
    }
public static Funcionario criarFuncionario(String cargo){
 String nomeClasse = "funcionario.Funcionario" + cargo;
        Class classe = null;
        Object objeto = null;
        Funcionario funcionario;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }
        if (!(objeto instanceof Funcionario)) {
            return null;
        }
        funcionario = (Funcionario) objeto;
        return funcionario;

}
}
