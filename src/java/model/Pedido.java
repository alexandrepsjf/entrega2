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
    private String nome;
    private String cliente;
    
    public Pedido(){}
    
    public Pedido(String nome, String cliente){
        this.nome = nome;
        this.cliente = cliente;
    }
 public Pedido(int id,String nome, String cliente){
        this.id=id;
        this.nome = nome;
        this.cliente = cliente;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    
}
