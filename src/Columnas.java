/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
//import java.awt.Image;
//import java.awt.Rectangle;
//import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.ImageIcon;
/**
 *
 * @author alvar
 */
public class Columnas {
     Rectangle2D capitel, base;
    
    int hueco = 200;
    int altura_columna = 500;
    int ancho_columna = 500;
    private final int ancho_pantalla;
    Image col_abajo, col_arriba;

    public Columnas(int _ancho, int _anchoPantalla) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       posicionInicialColumna(_ancho);
       ancho_pantalla = _anchoPantalla;
       precargaImagenes();
       
    }
      private void posicionInicialColumna(int _ancho) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Random aleatorio = new Random();
        int desplazamiento = aleatorio.nextInt(400)+300;
        capitel = new Rectangle2D.Double(_ancho, -desplazamiento - ancho_columna/2 ,ancho_columna, altura_columna);
        base = new Rectangle2D.Double(_ancho, altura_columna + hueco - desplazamiento + ancho_columna/2, ancho_columna, ancho_columna);
        
    
    }
    private void precargaImagenes(){
        
        col_abajo = (new ImageIcon(new ImageIcon(getClass().getResource("Imagenes/Kintoun.PNG")).getImage().getScaledInstance(50, 100, Image.SCALE_DEFAULT))).getImage();
//        col_arriba = (new ImageIcon(new ImageIcon(
//                getClass().getResource("/imagenes/pipe_top.png"))
//                .getImage().getScaledInstance(79, 500, Image.SCALE_DEFAULT)))
//                .getImage();    
    }

  
    public boolean mueve(Graphics2D g2, Personaje p){
        mueveColumnas();
        g2.setColor(Color.red);
        
        g2.drawImage(col_abajo, (int)base.getX(), (int)base.getY()-ancho_columna/2, null);
         return (capitel.getX() == p.x);
    }
    private void mueveColumnas(){
        if(base.getX()+ ancho_columna < 20){
            posicionInicialColumna(ancho_pantalla);
        }
        else{
            capitel.setFrame(capitel.getX()-1, capitel.getY(),capitel.getWidth(), capitel.getHeight());
            base.setFrame(base.getX()-1, base.getY(),base.getWidth(), base.getHeight());
        }
    }
}
