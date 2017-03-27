/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
/**
 *
 * @author alvar
 */


public class Pantalla extends javax.swing.JFrame {

   boolean gameOver = false;
    Personaje miPersonaje = new Personaje(30);
    
    static int ANCHOPANTALLA = 1000;
    static int ALTOPANTALLA = 1000;
    static int SEPARACION_COLUMNAS = 100 ;
    int numColumnas = 10;
    int puntuacion = 0;
    int contadorAnimacion = 0;
    Columnas[] columnas = new Columnas[numColumnas];
//    /**
//     * Creates new form Pantalla
//     */
    
     BufferedImage buffer = null;
    Graphics2D bufferGraphics, lienzoGraphics = null;
    
    Timer temporizador = new Timer(10, new ActionListener(){
        public void actionPerformed(ActionEvent e){
            bucleDelJuego();
        }
    });
    
    private void bucleDelJuego(){
        contadorAnimacion++;
        if (contadorAnimacion > 30) {contadorAnimacion = 0;}
        bufferGraphics.setColor(new Color(113, 198, 205)); //el color original del flappy bird
        bufferGraphics.fillRect(0, 0, ANCHOPANTALLA, ALTOPANTALLA);
        miPersonaje.mueve(bufferGraphics, contadorAnimacion);
        for (int i=0; i<numColumnas; i++){
            if(columnas[i].mueve(bufferGraphics, miPersonaje)){
                puntuacion++;
            }
        }
        lienzoGraphics.drawImage(buffer, 0,0, null);

    }

    public Pantalla() {
        initComponents();
        inicializaBuffers();
        
        for (int i= 0; i<numColumnas; i++){
          // Columnas[] columna = null;
         columnas[i]= new Columnas (ANCHOPANTALLA + i*SEPARACION_COLUMNAS, ANCHOPANTALLA);
//            
       }
        temporizador.start();
    }
    private void inicializaBuffers(){
        lienzoGraphics = (Graphics2D) jPantalla.getGraphics();
        buffer = (BufferedImage) jPantalla.createImage(ANCHOPANTALLA, ALTOPANTALLA);
        bufferGraphics = buffer.createGraphics();
        
        bufferGraphics.setColor(Color.BLACK);
        bufferGraphics.fillRect(0, 0, ANCHOPANTALLA, ALTOPANTALLA);
        //carga las imagenes de los adornos
        
//        matorrales = cargaImagen("/imagenes/bush.png", ALTOPANTALLA*0.05);
//        nubes = cargaImagen("/imagenes/clouds.png", ALTOPANTALLA*0.10);
//        posicionMatorralesY = (int)(ALTOPANTALLA * 0.60)-matorrales.getHeight(null);
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPantalla = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPantallaLayout = new javax.swing.GroupLayout(jPantalla);
        jPantalla.setLayout(jPantallaLayout);
        jPantallaLayout.setHorizontalGroup(
            jPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPantallaLayout.setVerticalGroup(
            jPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE){
            miPersonaje.subir();
        }
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        
        java.awt.EventQueue.invokeLater(() -> {
            new Pantalla().setVisible(true);
        });
    }
     


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPantalla;
    // End of variables declaration//GEN-END:variables

}