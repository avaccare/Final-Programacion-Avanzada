/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



/**
 *
 * @author agust
 */
public class Controlador {
    
     private Vista vista;
     private Mazo mazo;
     
     
    
    public void iniciar(){
        
     this.vista = new Vista("Cola Sucia");
    this.vista.setVisible(true);
    this.vista.iniciarJuego(new IniciarJuego());
    this.vista.verReglas(new VerReglas());
    this.vista.sacarCarta(new SacarCartaMouse());
     this.vista.sacarCarta(new SacarCartaTeclado());
     this.vista.sonido(new Musica());
   
    }
    
        ////////BOTONES///////////////
    public void btnJugar(){
        String btnJugar = this.vista.getTextBotonJugar();
        String btnReglas = "REGLAS";
        if(btnJugar.equalsIgnoreCase("JUGAR")|| btnJugar.equalsIgnoreCase("REINICIAR")  )
        {
            this.mazo = new Mazo();
            Mazo.puntos = 0;
            btnJugar = "REINICIAR";
            btnReglas = "VOLVER";
        }
        this.vista.botonReglas(btnReglas);
        this.vista.botonJugar(btnJugar);
    }
    public void btnReglas()
    {
        String btnReglas = this.vista.getTextBotonReglas();
        String  btnJugar = "JUGAR";
        if(btnReglas.equalsIgnoreCase("REGLAS"))
        {
             btnReglas = "VOLVER";    
             this.vista.botonJugar(btnJugar);
             this.vista.panelTexto(true);
        }else if (btnReglas.equalsIgnoreCase("VOLVER"))
        {
            this.vista.panelTexto(false);
            this.vista.botonVolver();
            btnReglas = "REGLAS";
        }
         this.vista.botonReglas(btnReglas);
    } 
    /////////////////  LISTENERS  //////////////////////
   private class IniciarJuego implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            btnJugar();    
        } 
   }
   private class VerReglas implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) { 
            btnReglas(); 
        } 
   }
   
   private class SacarCartaMouse implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) 
        {
        String btnJugar = vista.getTextBotonJugar();
            if(btnJugar.equals("REINICIAR"))
            {
            vista.mostrarPuntos(mazo.puntos());
            vista.mostrarCarta(mazo.carta());
            boolean resultado = mazo.juegoTermina();
                if (resultado)
                {
                vista.terminaElJuego();
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
          
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {   
        }
   }
   private class SacarCartaTeclado implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) { 
        }

        @Override
        public void keyPressed(KeyEvent e) {   
        }

        @Override
        public void keyReleased(KeyEvent e) {
            String btnJugar = vista.getTextBotonJugar();
          
        if(btnJugar.equals("REINICIAR") && e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            vista.mostrarPuntos(mazo.puntos());
            vista.mostrarCarta(mazo.carta());
            boolean resultado = mazo.juegoTermina();
            if (resultado)
            {
                vista.terminaElJuego();
            } 
        }  
        }    
   }
   
private class Musica implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            vista.btnMusica(); 
        }
    
}
}

