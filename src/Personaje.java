/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

//import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

/**
 *
 * @author alvar
 */
public class Personaje extends Ellipse2D.Double{
   int posX;
   int posY;
    int yVelocidad = 15;
    Image imagen1;
    int rotacion = 10;
    
    public Personaje(int _radio){
        super(10, 100, _radio, _radio);
        
        
        imagen1 = (new ImageIcon(new ImageIcon(getClass().getResource("Imagenes/goku_ssgss_power_3_sin_ki_by_saodvd-d9r5v4o.png")).
                getImage().getScaledInstance(50, 50, 30)).getImage());
    }
    
    public void subir(){
        this.yVelocidad += 15;
        //this.y = y-30;
    }
    
    public void mueve(Graphics2D g2, int imagenGoku){
        AffineTransform trans = new AffineTransform();
        rotacion -= yVelocidad;
        if (rotacion < -45) { rotacion = -45;}
        if (rotacion > 45) { rotacion =45;}
        trans.translate(x,y);
        trans.rotate(Math.toRadians(rotacion), width/2,height/2);
        this.y = this.y - yVelocidad;
        if (this.y < 0){this.y = 0;}
        if (imagenGoku < 45){
            g2.drawImage(imagen1, trans, null);
        }
        yVelocidad --;
        if (yVelocidad < -3){yVelocidad = -5;
        }        
    }
    public boolean chequeaColision(Columnas nube){
        
        Area areaGoku = new Area(this);
        Area areaNube = new Area(nube.base);
        boolean choca = true;
        areaGoku.intersect(areaNube);
        if(areaNube.isEmpty()){
            choca = false;
        }
       return (this.intersects(nube.base));
    }
    
}
