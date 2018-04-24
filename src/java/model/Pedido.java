/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Aluno
 */
public class Pedido {
    private int id;
    private String cliente;
    private PedidoEstado estado;

    public Pedido(int id, String cliente) {
        this.cliente = cliente;
        this.id=id;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }
    
    public Pedido(){}
    
    public Pedido( String cliente){
        this.cliente = cliente;
        this.setEstado(new PedidoEstadoCadastrado());
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    
}
