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
public class Combo extends Produto {
    public Combo(){
        this.nome="Combo";
        this.promocao= new PromocaoFamily();
        this.impressao=new ImpressaoPDF();
        
    }
    
}
