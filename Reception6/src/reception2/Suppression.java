/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reception2;
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
    
     //Supression Pharmacie du produit acheter
    public void sup_pharmacie(String Id_pharmacie)
    {
        try {
            state = (Statement) connection.getInstance().createStatement();
            state.executeUpdate("DELETE FROM acheter WHERE Id_Achat='"+Id_pharmacie+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Suppression.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
     //Supression Examen
    public void sup_examen(String Id_examen)
    {
        try {
            state = (Statement) connection.getInstance().createStatement();
            state.executeUpdate("DELETE FROM examen WHERE Id_examen='"+Id_examen+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Suppression.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
     public void sup_honoraire(String id_ho)
    {
        try {
            state = (Statement) connection.getInstance().createStatement();
            state.executeUpdate("DELETE FROM honoraire WHERE id_h='"+id_ho+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Suppression.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
     
      public void sup_facture(String id_fac)
    {
        try {
            state = (Statement) connection.getInstance().createStatement();
            state.executeUpdate("DELETE FROM facture WHERE id_fac ='"+id_fac+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Suppression.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
}
