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
public class Sanduiche extends Produto {

    public Sanduiche() {
        this.nome = "Sanduiche";
        this.promocao = new PromocaoBig();
        this.impressao = new ImpressaoImpressora();
    }
}
