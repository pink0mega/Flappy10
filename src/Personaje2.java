/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvar
 */

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

//import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

public class Personaje2 extends Ellipse2D.Double{
    int posX;
    int posY;
    int yVelocidad = 20;
    Image imagen2;
    int rotacion = 10;
    
    public Personaje2 (int _radio){
        super(900,100, _radio, _radio);
        
        imagen2 = (new ImageIcon(new ImageIcon(getClass().getResource("Imagenes/goku_ssgss_run_by_saodvd-d9hjhru.png")).getImage().getScaledInstance(50, 35, 16)).getImage());
        
    }
    
}
