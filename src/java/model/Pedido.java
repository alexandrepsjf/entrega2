/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Observable;

/**
 *
 * @author Aluno
 */
public class Pedido extends Observable {

    private int id;
    private PedidoEstado estado;
    private String nomeEstado;
    private Cliente cliente;
    private int idCliente;
    private PedidoMemento pedidoMemento;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Pedido(Cliente observador) {
        this.estado = new PedidoEstadoCadastrado();
        this.addObserver(observador);
//        this.pedidoMemento= new PedidoMemento(this.getNomeEstado());
        this.idCliente = observador.getId();
    }
public Pedido(int id,Cliente observador) {
        this.addObserver(observador);
        this.idCliente = observador.getId();
        this.id = id;
    }
    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
//        this.pedidoMemento.updateMemento(this.getNomeEstado());
         setChanged();
        notifyObservers();
    }

    public Pedido() {
        this.setEstado(new PedidoEstadoCadastrado());        
    }

    public Pedido(int idCliente) {
        this.idCliente = idCliente;
        this.setEstado(new PedidoEstadoCadastrado());       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String cadastrar() {
        return estado.cadastrar(this);
    }

    public String enviar() {
        return estado.enviar(this);
    }

    public String entregar() {
        return estado.entregar(this);
    }

    public String produzir() {
        return estado.produzir(this);
    }
  
    public PedidoEstado criarEstado(String nomeEstado) {
        String nomeClasse = "model.PedidoEstado" + nomeEstado;
        Class classe = null;
        Object objeto = null;
        PedidoEstado pedidoEstado;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }
        if (!(objeto instanceof PedidoEstado)) {
            return null;
        }
        pedidoEstado = (PedidoEstado) objeto;
        return pedidoEstado;
    }
}
