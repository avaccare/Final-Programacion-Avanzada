/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 *
 * @author agust
 */
public class Mazo {
    
    private  ArrayList<Carta> mazo;
    public static int puntos = 0;
    private final String CARPETA = "/img/";
    private final String PNG = ".png";
    private final int CANT_CARTA_MAX = 12;
    private  Palo[] palos = Palo.values();
    public Mazo(){
         
         this.mazo = new ArrayList<>();
         generarMazo();
       
    }
 
    public int puntos()
    {
        Carta carta = this.mazo.get(0); 
        if (carta instanceof CartaComun) 
        {
            CartaComun carComun = (CartaComun) carta;
            if (carComun.getNUMERO()!=1 || !carComun.getPALO().equals(Palo.ORO)) 
            {
                puntos++;
            }
        }
         return puntos;
    }
   
    public Icon carta(){
        Carta carta = this.mazo.get(0); 
        return carta.getCARTA();
    }
   
    public boolean juegoTermina(){
        Carta carta = this.mazo.get(0); 
        if (carta instanceof CartaComun) 
        {
	CartaComun carComun = (CartaComun) carta;
            if (carComun.getNUMERO()==1 && carComun.getPALO().equals(Palo.ORO)) 
            {
             return true;
            }
        }
            this.mazo.remove(carta);
            return false;   
    }
  

    ///////////// GENERAR MAZO /////////////////
    private void generarMazo(){
       
        for(int i = 0; i < CANT_CARTA_MAX ; i++){
            for(int j=0; j<palos.length; j++){
                System.out.println();
                 Icon icono = new ImageIcon(getClass().getResource(CARPETA+Palo.values()[j]+"/"+(i+1)+Palo.values()[j]+PNG));
                 this.mazo.add(new CartaComun((i+1),Palo.values()[j],icono)); 
            }    
        }
       //////COMODINES///////
       Icon comodinNegro = new ImageIcon(getClass().getResource(CARPETA+"1comodin"+PNG));
       Icon comodinRojo = new ImageIcon(getClass().getResource(CARPETA+"2comodin"+PNG));
       this.mazo.add(new CartaComodin(Color.NEGRO,comodinNegro));
       this.mazo.add(new CartaComodin(Color.ROJO,comodinRojo));
       Collections.shuffle(mazo);
    }
}
