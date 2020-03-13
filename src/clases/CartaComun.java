/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.Icon;


public class CartaComun extends Carta {

    private final int NUMERO;
    private final Palo PALO;
    
    public CartaComun(int numero, Palo palo, Icon carta) {
        super(carta);
        this.NUMERO=numero;
        this.PALO=palo;
    }
    public int getNUMERO() {
        return NUMERO;
    }

    public Palo getPALO() {
        return PALO;
    }
    
}
