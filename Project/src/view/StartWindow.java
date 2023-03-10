package view;

import controller.AudioController;
import controller.SavingController;
import interfaces.Node;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;

public class StartWindow extends javax.swing.JFrame implements Node {

    private AudioController audio = null;
    private SavingController database;

    public StartWindow() {
        initComponents();
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        try {
            audio = new AudioController();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        database = new SavingController();
        background.setIcon(new javax.swing.ImageIcon("./images/Start window.png"));
        NewGame.setIcon(new javax.swing.ImageIcon("./images/new game.png")); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon("./images/exit.png"));
        HighScores.setIcon(new javax.swing.ImageIcon("./images/High Scores.png"));

        //Playing main menu music
        audio.playMenuTheme();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NewGame = new javax.swing.JButton();
        HighScores = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Circus OF Plates");
        setFocusable(false);
        setLocation(new java.awt.Point(500, 250));
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NewGame.setMaximumSize(new java.awt.Dimension(200, 80));
        NewGame.setMinimumSize(new java.awt.Dimension(200, 80));
        NewGame.setPreferredSize(new java.awt.Dimension(200, 80));
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });
        getContentPane().add(NewGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 200, 80));

        HighScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HighScoresActionPerformed(evt);
            }
        });
        getContentPane().add(HighScores, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 200, 80));

        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 200, 80));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HighScoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HighScoresActionPerformed
        // TODO add your handling code here:
        HighScores highScores = new HighScores(database);
        highScores.setParentNode(this);
        this.setVisible(false);
        highScores.setVisible(true);
    }//GEN-LAST:event_HighScoresActionPerformed

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
        // TODO add your handling code here:
        Themes themes = new Themes(audio, database);
        themes.setParentNode(this);
        this.setVisible(false);
        themes.setVisible(true);
    }//GEN-LAST:event_NewGameActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HighScores;
    private javax.swing.JButton NewGame;
    private javax.swing.JLabel background;
    private javax.swing.JButton exit;
    // End of variables declaration//GEN-END:variables

    @Override
    public Node getParentNode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParentNode(Node node) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}