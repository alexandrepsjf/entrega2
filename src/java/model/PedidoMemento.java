/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.PedidoMementoDAO;

/**
 *
 * @author negro
 */
public class PedidoMemento {

    private String historico;
    private int id;
    private int idPedido;
    private PedidoEstado estadoAnterior;

    public PedidoMemento(String historico) {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        this.historico = time + " - " + historico + "/n";

    }

    public PedidoMemento() {

    }

    public PedidoMemento(int idPedido, String historico) {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        this.historico = time + " - " + historico + "/n";
    }

    public PedidoMemento(int id, int idPedido, String historico) {
        this.id = id;
        this.idPedido = idPedido;
        Timestamp time = new Timestamp(System.currentTimeMillis());
        this.historico = time + " - " + historico + "/n";
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public PedidoEstado getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(PedidoEstado estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void updateMemento(String status)  {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        this.historico += time + " - " + status + "/n";
        try {
            PedidoMementoDAO.getInstance().load(this);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoMemento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoMemento.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            this.estadoAnterior = null;
        }
        if (!(objeto instanceof PedidoEstado)) {
            this.estadoAnterior = null;
        }
        pedidoEstado = (PedidoEstado) objeto;
        this.estadoAnterior = pedidoEstado;

    }
}
