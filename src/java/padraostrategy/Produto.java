/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padraostrategy;

/**
 *
 * @author negro
 */
public abstract class Produto {

    protected Promocao promocao;
    protected String nome;
    protected Impressao impressao;

    public String getPromocao() {
        return promocao.obterPromocao();
    }

    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Impressao getImpressao() {
        return impressao;
    }

    public String getTipoImpressao() {
        return impressao.imprimir();
    }

    public int desconto() {
        return promocao.obterDesconto();
    }

}
