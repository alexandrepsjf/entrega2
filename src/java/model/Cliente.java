/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author negro
 */
public class Cliente implements Observer {

    private int id;
    private String nome;
    private String categoria;
    private Observable pedido;
    private String mensagemPedido;
    private EstrategiaEntrega estrategiaEntrega;

    public String getCategoria() {
        return categoria;
    }

    public String getEstrategiaEntrega() {
        return estrategiaEntrega.valorEntrega();
    }

    public void setEstrategiaEntrega(EstrategiaEntrega estrategiaEntrega) {
        this.estrategiaEntrega = estrategiaEntrega;
    }

    public void setCategoria(String categoria) {

        if (categoria.equalsIgnoreCase("Basico")){
            this.categoria = "Basico";
            this.estrategiaEntrega = new EstrategiaEntregaBasico();
        } else if (categoria.equalsIgnoreCase("Vip")) {
            this.estrategiaEntrega = new EstrategiaEntregaVip();
            this.categoria = "Vip";
        } else {
            this.estrategiaEntrega = new EstrategiaEntregaTop();
            this.categoria = "Top";
        }
    }

    public Observable getPedido() {
        return pedido;
    }

    public String getMensagemPedido() {
        return mensagemPedido;

    }

    public void setMensagemPedido(String mensagemPedido) {
        this.mensagemPedido = mensagemPedido;

    }

    public void setPedido(Observable pedido) {
        this.pedido = pedido;

    }

    public Cliente(int id, String nome, int categoria) {
        this.nome = nome;
        this.setCodCategoria(categoria);
        this.mensagemPedido = "Sem pedido";
    }

    public Cliente(String nome, int categoria) {
        this.nome = nome;
        this.setCodCategoria(categoria);
        this.mensagemPedido = "Sem pedido";
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

    public Cliente() {
    }

    @Override
    public void update(Observable o, Object arg) {
        Pedido pedido = (Pedido) o;
        this.setPedido(pedido);
//     
    }

    private void setCodCategoria(int categoria) {
        if (categoria == 1) {
            this.categoria = "Basico";
            this.estrategiaEntrega = new EstrategiaEntregaBasico();
        } else if (categoria == 2) {
            this.categoria = "Vip";
            this.estrategiaEntrega = new EstrategiaEntregaVip();

        } else {
            this.categoria = "Top";
            this.estrategiaEntrega = new EstrategiaEntregaTop();

        }
    }

}
