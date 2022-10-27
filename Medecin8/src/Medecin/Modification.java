/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Medecin;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 * @author Samy-MBIYA
 */
 public class Modification {
 protected Statement state;
 private ResultSet result;
 private String date;
 protected Date da=new Date();
 //Modification de la consultation
 public void modif_Consultation(String Id_consultation, String s,String ATCD, String HMA,String CA,String EP, String A, String Date_cons,String User_nam) throws SQLException{
        String Date_cons1;
        // Date et heure
        DateFormat dat= DateFormat.getDateInstance( DateFormat.SHORT);
        date=(String)dat.format(da);
        Date_cons1=Date_cons+"(modifié le "+date+" par Dr."+User_nam+")";
        String sql = "UPDATE consultation SET s=? ,ATCD=? ,HMA=? ,CA=? ,EP=? , A=? ,CAT=?, Date=? WHERE Id_consultation=?";
                PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
                statement.setObject(1,s);
                statement.setObject(2,ATCD);
                statement.setObject(3,HMA);
                statement.setObject(4,CA);
                statement.setObject(5,EP);
                statement.setObject(6,A);
                statement.setObject(7,EP);
                statement.setObject(8,Date_cons1);
                statement.setObject(9,Id_consultation);
                statement.executeUpdate();
         // JOptionPane.showMessageDialog(null, "Modification effectué ", "Validation", JOptionPane.WARNING_MESSAGE);
    }
 
 //Modification du traitement 
 public void modif_traitement(String Id_tr,String Medicament,String mode_emploi1,String Qt) throws SQLException
 {
      
      String sql = "UPDATE traitement SET Medicament=?, Qt_prise=?, mode_emploi=?  WHERE Id_tr=?";
      PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
      statement.setObject(1,Medicament);
      statement.setObject(2,Qt);
      statement.setObject(3,mode_emploi1);
      statement.setObject(4,Id_tr);
      statement.executeUpdate();
      
 }
 
 //Modification (introduction de l'interpretation de l'imagérie) de l'imagérie
 public void modif_img(String Id_im,String Interpretation) throws SQLException
 { 
      String sql = "UPDATE imagerie SET Interpretation=?  WHERE Id_im=?";
      PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
      statement.setObject(1,Interpretation);
      statement.setObject(2,Id_im);
      statement.executeUpdate();
 }
 
  //Modification de l'elevolution
    public void modif_evolution (String S,String HMA, String CA, String EP,String A,String Date,String User_nam, String Id_ev)throws SQLException
    {
         String Date_ev = null;
        // Date et heure
        DateFormat dat= DateFormat.getDateInstance( DateFormat.SHORT);
        date=(String)dat.format(da);
        Date_ev=Date+"(modifié le "+date+" par Dr."+User_nam+")";   
        System.out.println("Modifier ="+Id_ev);
        // Enregistrement de l'evolution
                String sql = "UPDATE evolution SET S=? ,HMA=? ,CA=? ,EP=? ,A=? , Date=? WHERE Id_ev=?";
                PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
                statement.setObject(1,S);
                statement.setObject(2,HMA);
                statement.setObject(3,CA);
                statement.setObject(4,EP);
                statement.setObject(5,A);
                statement.setObject(6,Date_ev);
                statement.setObject(7,Id_ev);
                statement.executeUpdate();   
    }
    
    // MOdification de PHARMACIE
    public void modif_pharmacie(String Id_pharmacie,String Qt_ph,String Qt_tr) throws SQLException
    {
        int Qt_ph1, Qt_tr2,Qt_final;
        String sql = "UPDATE  produit SET Qt_Prod=?  WHERE id_Prod =?";
        Qt_ph1= Integer.parseInt(Qt_ph);
        Qt_tr2= Integer.parseInt(Qt_tr);
        Qt_final=Qt_ph1-Qt_tr2;
        if (Qt_final>=0)
        {
            PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
            statement.setObject(1,Qt_final);
            statement.setObject(2,Id_pharmacie);
            statement.executeUpdate();
        }else {
           JOptionPane.showMessageDialog(null, "Stock insufisant", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
        
        
        
    }
   
     //Modification ATDC
    public void modif_ATDC (String Id_p,String ATDC)throws SQLException
    {    
        // Enregistrement de l'evolution
                String sql = "UPDATE patient SET ATCD=? WHERE id_pa=?";
                PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
                statement.setObject(1,ATDC);
                statement.setObject(2,Id_p);
                statement.executeUpdate();   
    }
}
