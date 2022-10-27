/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Medecin;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Samy-MBIYA
 */
public class Suppression {
    protected Statement state;
    //Suppression Patient
    public void sup_patient(String id_p)
    {
        try {
            state = (Statement) connection.getInstance().createStatement();
            state.executeUpdate("DELETE FROM patient WHERE id_pa='"+id_p+"'");
            JOptionPane.showMessageDialog(null, "Suppression effectué ", "Validation", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Suppression.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     //Supression Signe vitaux
    public void sup_sv(String id_sv)
    {
        try {
            state = (Statement) connection.getInstance().createStatement();
            state.executeUpdate("DELETE FROM sv WHERE Id_sv='"+id_sv+"'");
            JOptionPane.showMessageDialog(null, "Suppression effectué ", "Validation", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Suppression.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    public void sup_labo(String Id_examen)
    {
        try {
            state = (Statement) connection.getInstance().createStatement();
            state.executeUpdate("DELETE FROM labo WHERE Id_la='"+Id_examen+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Suppression.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
     public void sup_trait(String Id_traitement)
    {
        try {
            state = (Statement) connection.getInstance().createStatement();
            state.executeUpdate("DELETE FROM traitement WHERE Id_tr ='"+Id_traitement+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Suppression.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
}
