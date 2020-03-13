/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.Icon;


public class CartaComodin extends Carta{
    
    private final Color COLOR;
    
    public CartaComodin(Color color,Icon carta) {
        super(carta);
        this.COLOR = color;
    }
    
}
