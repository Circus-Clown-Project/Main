/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.AudioController;
import controller.DiffcultyController;
import controller.GameController;
import controller.MyController;
import controller.SavingController;
import eg.edu.alexu.csd.oop.game.GameEngine;
import interfaces.Node;
import interfaces.Observer;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import interfaces.Difficulty;

/**
 *
 * @author Kimo Store
 */
public class Themes extends javax.swing.JFrame implements Node, Observer {

    /**
     * Creates new form Themes
     */
    private AudioController audio;
    private Node parent;
    private boolean gameOver = false;
    private GameEngine.GameController gameController;
    private SavingController database;
    private GameController gameControl;
    private boolean newGame = true;

    public Themes(AudioController audio, SavingController database) {
        initComponents();
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        background.setIcon(new javax.swing.ImageIcon("./images/themes.png"));
        easyLabel.setIcon(new javax.swing.ImageIcon("./images/easy label.png"));
        mediumLabel.setIcon(new javax.swing.ImageIcon("./images/normal label.png"));
        HardLabel.setIcon(new javax.swing.ImageIcon("./images/hard label.png"));
        Back.setIcon(new javax.swing.ImageIcon("./images/back.png"));
        this.database = database;
        this.audio = audio;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Easy = new javax.swing.JButton();
        Medium = new javax.swing.JButton();
        Hard = new javax.swing.JButton();
        easyLabel = new javax.swing.JLabel();
        mediumLabel = new javax.swing.JLabel();
        HardLabel = new javax.swing.JLabel();
        Choose = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Diffculty");
        setLocation(new java.awt.Point(500, 250));
        setPreferredSize(new java.awt.Dimension(900, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Easy.setText("Easy");
        Easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EasyActionPerformed(evt);
            }
        });
        getContentPane().add(Easy, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));

        Medium.setText("Medium");
        Medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MediumActionPerformed(evt);
            }
        });
        getContentPane().add(Medium, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, -1, -1));

        Hard.setText("Hard");
        Hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HardActionPerformed(evt);
            }
        });
        getContentPane().add(Hard, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 360, -1, -1));
        getContentPane().add(easyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 200, 140));
        getContentPane().add(mediumLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 200, 130));
        getContentPane().add(HardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, -1, -1));

        Choose.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Choose.setText("Choose a difficulity");
        getContentPane().add(Choose, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 220, 50));

        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 150, 60));
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EasyActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        setup("Easy");
        audio.stopMenuTheme();
        audio.playEasyMusic();
    }//GEN-LAST:event_EasyActionPerformed

    private void MediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MediumActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        setup("Normal");
        audio.stopMenuTheme();
        audio.playNormalMusic();
    }//GEN-LAST:event_MediumActionPerformed

    private void HardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HardActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        setup("Hard");
        audio.stopMenuTheme();
        audio.playHardMusic();
    }//GEN-LAST:event_HardActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ((JFrame) this.getParentNode()).setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    /**
     * @param args the command line arguments
     */
    void setup(String theme) {
        DiffcultyController diffculty = new DiffcultyController();

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        //Adding Exit as a menu item and setting it shortcut
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        //Adding new as a menu item and setting it shortcut
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        //Adding Pause as a menu item and setting it shortcut
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        pauseMenuItem.setAccelerator(KeyStroke.getKeyStroke('P', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        //Adding Resume as a menu item and setting it shortcut
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        resumeMenuItem.setAccelerator(KeyStroke.getKeyStroke('R', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        //Adding File menu items
        fileMenu.add(exitMenuItem);
        fileMenu.add(newMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(pauseMenuItem);
        fileMenu.add(resumeMenuItem);
        menuBar.add(fileMenu);
        ////////////////////// User set the following by gui ///////////////////
        Difficulty world = diffculty.getDifficulty(theme);
//        gameControl = GameController.getInstance(900, 600, audio);
        gameControl = new GameController(900, 600, audio);
        ////////////////////////////////////////////////////////////////////////
        MyController controller = new MyController(gameControl, world, audio);
        Game clownGame = new Game(controller);
        clownGame.addObserver(this);
        gameController = GameEngine.start(theme + " Mode", clownGame, menuBar);

        JFrame gameFrame = (JFrame) menuBar.getParent().getParent().getParent();
        gameFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        gameFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                gameController.pause();
                if (JOptionPane.showConfirmDialog(gameFrame, "Are you sure you want to close this game?",
                        "End Game?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    gameFrame.dispose();

                    //some code to return to game main window.
                    
                    audio.stopHardMusic();
                    audio.stopNormalMusic();
                    audio.stopEasyMusic();
                    audio.stopGameOver();
                    audio.playMenuTheme();
                    ((JFrame) getParentNode()).setVisible(true);
                    newGame = true;
                }else{
                    gameController.resume();
                }
            }
        });
        

        //Setting each menu Item its function
        newMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.pause();
                if (JOptionPane.showConfirmDialog(gameFrame, "Are you sure you want to start a new Game?",
                        "End Game?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                gameFrame.dispose();
                audio.stopHardMusic();
                audio.stopNormalMusic();
                audio.stopEasyMusic();
                audio.stopGameOver();
                audio.playMenuTheme();
//                ((JFrame) getParentNode()).setVisible(true);
                ((JFrame)getThis()).setVisible(true);
                newGame = true;
                }else{
                    gameController.resume();
                }
            }
        });
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.pause();
            }
        });
        resumeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.resume();
            }
        });
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.pause();
                if (JOptionPane.showConfirmDialog(gameFrame, "Are you sure you want to close this game?",
                        "End Game?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    
                    gameFrame.dispose();

                    //some code to return to game main window.
                    
                    audio.stopHardMusic();
                    audio.stopNormalMusic();
                    audio.stopEasyMusic();
                    audio.stopGameOver();
                    audio.playMenuTheme();
                    ((JFrame) getParentNode()).setVisible(true);
                    newGame = true;
                }else{
                    gameController.resume();
                }
            }
        });
    }

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
            java.util.logging.Logger.getLogger(Themes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Themes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Themes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Themes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel Choose;
    private javax.swing.JButton Easy;
    private javax.swing.JButton Hard;
    private javax.swing.JLabel HardLabel;
    private javax.swing.JButton Medium;
    private javax.swing.JLabel background;
    private javax.swing.JLabel easyLabel;
    private javax.swing.JLabel mediumLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public Node getParentNode() {
        return parent;
    }

    @Override
    public void setParentNode(Node node) {
        this.parent = node;
    }

    @Override
    public void update() {
        newGame = false;
        gameOver();
    }

    public void gameOver() {
        if (!newGame) {
            gameOver = true;
            gameController.pause();
            Saving saving = new Saving(gameControl.getScore(), database);
            saving.setVisible(true);
        }
    }

    private Node getThis(){
        return this;
    }
}
