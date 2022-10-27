/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Medecin;

//import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sun.applet.Main;

/**
 *
 * @author Samy-MBIYA
 */
public class Reception2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(new  McWinLookAndFeel  ());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension tailleEcran= Toolkit.getDefaultToolkit().getScreenSize();// Recuperation de la taille de l'ecran
        int H=tailleEcran.height;
        int L=tailleEcran.width;
        Login A= new Login();
        //A.setSize(0, 0);//Longeure et Hauteur l'ecran
        A.setLocationRelativeTo(null);//Permet de centrer le JFrame
        A.setVisible(true);
        //A.setPreferredSize(null);
    }
    
    
}
