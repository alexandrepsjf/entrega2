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
public class PromocaoLight implements Promocao {

    @Override
    public int obterDesconto() {
return 10;    }

    @Override
    public String obterPromocao() {
return "PromoçaoLight";    }
    
}
