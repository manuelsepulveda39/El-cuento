package forms;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Juego extends javax.swing.JFrame {
    private final JLabel[][] cuadricula;
    private final ImageIcon imagenCohete;
    private final ImageIcon imagenMeteorito;
    private int coheteFila;
    private int coheteColumna;
    private int meteoritoFila;
    private int meteoritoColumna;
    private Timer timer;
    private JPanel panel;
    private JFrame frame;
    public int puntos = 0;
    private int velocidadMeteorito = 800;

    public Juego() {
        imagenCohete = new ImageIcon(Juego.class.getResource("/clases/cohete.jpg"));
        imagenMeteorito = new ImageIcon(Juego.class.getResource("/clases/Meteorito.jpg"));
        
        initComponents();
        
        desactivarInterface();
        cuadricula = new JLabel[4][10];
        agregarCuadricula();
        coheteFila = 2;
        coheteColumna = 0;
        colocarCohete();
        moverMeteoritoAleatorio();
        movimientoCohete();
    }
    
    public void desactivarInterface(){
        labelTitulo.setVisible(false);
        labelPuntos.setVisible(false);
        botonRepetir.setVisible(false);
        BotonSeguir.setVisible(false);
        botonRepetir.setEnabled(false);
        BotonSeguir.setEnabled(false);
    }

    public void agregarCuadricula() {
        frame = new JFrame("tablero juego");
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 10, 10, 10));
        panel.setBackground(Color.BLACK);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                JLabel label = new JLabel();
                label.setPreferredSize(new Dimension(40, 40));
                panel.add(label);
                cuadricula[i][j] = label;
            }
        }

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.toFront();
    }
    
    public void movimientoCohete(){
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_W) {
                    moverCoheteArriba();
                } else if (key == KeyEvent.VK_S) {
                    moverCoheteAbajo();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public void colocarCohete() {
        cuadricula[coheteFila][coheteColumna].setIcon(imagenCohete);
    }

    public void moverMeteoritoAleatorio() {
        Random random = new Random();
        meteoritoFila = random.nextInt(4);
        meteoritoColumna = 9;

        timer = new Timer(velocidadMeteorito, e -> moverMeteorito());
        timer.start();
    }

    public void moverMeteorito() {
        cuadricula[meteoritoFila][meteoritoColumna].setIcon(null);
        meteoritoColumna--;

        if (meteoritoColumna < 0) {
            puntos += 1;
            timer.stop();
            aumentarVelocidad();
            moverMeteoritoAleatorio();
        } else {
            cuadricula[meteoritoFila][meteoritoColumna].setIcon(imagenMeteorito);
        }
        
        if (meteoritoFila == coheteFila && meteoritoColumna == coheteColumna) {
            finJuego();
        }
    }
    
    public void moverCoheteArriba() {
        if (coheteFila > 0) {
            cuadricula[coheteFila][0].setIcon(null);
            coheteFila--;
            colocarCohete();
        }
    }
    
    public void moverCoheteAbajo() {
        if (coheteFila < 3) {
            cuadricula[coheteFila][0].setIcon(null);
            coheteFila++;
            colocarCohete();
        }
    }
    
    public void aumentarVelocidad() {
        velocidadMeteorito -= 100;
        if (velocidadMeteorito < 100) {
            velocidadMeteorito = 70;
        }
    }
    
    public void finJuego() {
        timer.stop();
        frame.dispose();
        mostrarPuntos();
    }
    
    public void mostrarPuntos(){
        labelTitulo.setVisible(true);
        labelPuntos.setVisible(true);
        botonRepetir.setVisible(true);
        BotonSeguir.setVisible(true);
        botonRepetir.setEnabled(true);
        BotonSeguir.setEnabled(true);
        
        labelPuntos.setText(puntos + "");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelPuntos = new javax.swing.JLabel();
        botonRepetir = new javax.swing.JButton();
        BotonSeguir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        labelTitulo.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        labelTitulo.setText("Puntos:");

        labelPuntos.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        labelPuntos.setForeground(new java.awt.Color(255, 255, 255));
        labelPuntos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPuntos.setText(".");

        botonRepetir.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        botonRepetir.setText("Repetir");
        botonRepetir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRepetirActionPerformed(evt);
            }
        });

        BotonSeguir.setFont(new java.awt.Font("Agency FB", 3, 14)); // NOI18N
        BotonSeguir.setText("Seguir");
        BotonSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSeguirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonRepetir)
                .addGap(18, 18, 18)
                .addComponent(BotonSeguir)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPuntos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRepetir)
                    .addComponent(BotonSeguir))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRepetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRepetirActionPerformed
        puntos = 0;
        desactivarInterface();
        agregarCuadricula();
        coheteFila = 2;
        coheteColumna = 0;
        colocarCohete();
        moverMeteoritoAleatorio();
        movimientoCohete();
    }//GEN-LAST:event_botonRepetirActionPerformed

    private void BotonSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSeguirActionPerformed
        Final siguiente = new Final();
        siguiente.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BotonSeguirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Juego().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonSeguir;
    private javax.swing.JButton botonRepetir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelPuntos;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
