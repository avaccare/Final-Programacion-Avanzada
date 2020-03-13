/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.Icon;

/**
 *
 * @author agust
 */
public abstract class Carta {
    
    private final Icon CARTA;

    public Carta(Icon carta){
        this.CARTA = carta;
    }

    public Icon getCARTA() {
        return CARTA;
    }
   
    
}
