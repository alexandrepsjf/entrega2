/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import funcionario.Funcionario;
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
    private int idFuncionario;
    private Funcionario funcionario;

    public Pedido() {
    }

    public Pedido(Cliente observador) {
        this.estado = new PedidoEstadoCadastrado();
        this.addObserver(observador);
        this.cliente = observador;
        this.idCliente = observador.getId();
        this.cliente.setMensagemPedido(this.getEstado().getEstado());
    }

    public Pedido(int id, Cliente observador) {
        this.cliente = observador;
        this.addObserver(observador);
        this.idCliente = observador.getId();
        this.id = id;
        this.cliente.setMensagemPedido(this.getEstado().getEstado());

    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public PedidoMemento getPedidoMemento() {
        return pedidoMemento;
    }

    public void setPedidoMemento(PedidoMemento pedidoMemento) {
        this.pedidoMemento = pedidoMemento;
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
        this.pedidoMemento.setEstadoAnterior(this.getEstado());
        this.estado = estado;        
     this.pedidoMemento.updateMemento("Seu pedido está "+estado.getEstado());
        setChanged();
        notifyObservers();
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public void criarEstado(String nomeEstado) {
        String nomeClasse = "model.PedidoEstado" + nomeEstado;
        Class classe = null;
        Object objeto = null;
        PedidoEstado pedidoEstado;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            this.estado = null;
        }
        if (!(objeto instanceof PedidoEstado)) {
            this.estado = null;
        }
        pedidoEstado = (PedidoEstado) objeto;
        this.estado = pedidoEstado;

    }
}
