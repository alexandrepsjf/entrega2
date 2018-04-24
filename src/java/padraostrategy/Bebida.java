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
public class Bebida extends Produto {
    public Bebida(){
        this.nome="Bebida";
        this.promocao= new PromocaoLight();
        this.impressao=new ImpressaoPDF();
        
    }
}
