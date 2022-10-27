/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reception2;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author Samy-MBIYA
 */
public class Modification {
 protected Statement state;
 private ResultSet result;
 public String date;
 public int compt;
 // Modification des information du Patient
 public void modif_Patien(String id_p,String nom,String postnom, String prenom,String sexe,String dn, String ec,String adresse, String phone, String profession,String employeur  ) throws SQLException{
         state = (Statement) connection.getInstance().createStatement();
         state.executeUpdate("UPDATE patient SET Nom='"+nom+"' ,Post_nom='"+postnom+"' ,Prenom='"+prenom+"' ,Sexe='"+sexe+"',DN='"+dn+"', EC='"+ec+"', Adresse='"+adresse+"', Phone='"+phone+"', Profession='"+profession+"', Employeur='"+employeur+"' WHERE id_pa='"+id_p+"'"); 
         JOptionPane.showMessageDialog(null, "Modification effectué ", "Validation", JOptionPane.WARNING_MESSAGE);
    }
 
 //Modification des signes vitaux
    public void modif_sv(String Id_sv,String Id_pa,String Date, String Heure, String TC, String TAS, String TAD, String FC, String FR, String O, String Poid ) throws SQLException
    {
      state = (Statement) connection.getInstance().createStatement();
      state.executeUpdate("UPDATE sv SET Date='"+Date+"' ,Heure='"+Heure+"',TC='"+TC+"',TAS='"+TAS+"', TAD='"+TAD+"', FC='"+FC+"', FR='"+FR+"', O='"+O+"', Poid='"+Poid+"' WHERE Id_sv='"+Id_sv+"'"); 
      JOptionPane.showMessageDialog(null, "Modification effectué ", "Validation", JOptionPane.WARNING_MESSAGE);
 }
 
 // MOdification de PHARMACIE
    public void modif_achat(String Id_Achat, String Produit, Double Qt_Gros,  Double Qt_Detail, Double Prix_Gros, Double Prix_Detail, String Date_expi, String Date_achat, String Type_Achat) throws SQLException
    {    
                String sql = "UPDATE acheter SET Qt_Gros=? ,Qt_Detail=? ,Prix_Gros=?, Prix_Detail=?, Date_expi=?, Date_achat=?, Type_Achat=? WHERE Id_Achat =?";
                PreparedStatement statement1 = (PreparedStatement) connection.conn.prepareStatement(sql);
                statement1.setObject(1,Qt_Gros);
                statement1.setObject(2,Qt_Detail);
                statement1.setObject(3,Prix_Gros);
                statement1.setObject(4,Prix_Detail);
                statement1.setObject(5,Date_expi);
                statement1.setObject(6,Date_achat);
                statement1.setObject(7,Type_Achat);
                statement1.setObject(8,Id_Achat);
                statement1.executeUpdate();        
                
    }
    
    // MOdification du stock
    public void modif_stock (String Produit,String Prod) throws SQLException
    {
       Statement state2 = (Statement) connection .getInstance().createStatement();
        String req1="SELECT * FROM produit WHERE Nom_Prod='"+Prod+"'";
                result= state2.executeQuery(req1);
                while(result.next()){
                              compt=result.getInt("id_Prod");
                     }
        String sql = "UPDATE produit SET Nom_Prod=? WHERE id_Prod=?";
        PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
        statement.setObject(1,Produit);
        statement.setObject(2,compt);
        statement.executeUpdate();
    }
    
    // Ajout Quantité produit
    public void Ajout (String Produit,Double stock_prod, Double stock_prix) throws SQLException
    {
                String req1="SELECT * FROM produit WHERE Nom_Prod='"+Produit+"'";
                result= state.executeQuery(req1);
                while(result.next()){
                              compt=result.getInt("id_Prod");
                     }
                String sql = "UPDATE produit SET Nom_Prod=? ,Qt_Prod=? ,PU_Prod=? WHERE Nom_Prod=?";
                PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
                statement.setObject(1,Produit);
                statement.setObject(2,stock_prod);
                statement.setObject(3,stock_prix);
                statement.setObject(4,Produit);
                statement.executeUpdate();
    }
    
    // MOdification de EXAMEN
    public void modif_examen(String Id_examen, String Examen, String Type, String Prix) throws SQLException
    {
                String sql = "UPDATE examen SET Examen=? ,Type=? ,Prix=?  WHERE Id_examen=?";
                PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
                statement.setObject(1,Examen);
                statement.setObject(2,Type);
                statement.setObject(3,Prix);
                statement.setObject(4,Id_examen);
                statement.executeUpdate();
    }
    
    // MOdification du CARDEX
    public void modif_cardex(String id_cardex, String TC,String TD, String TS, String FC, String FR,String SaO,String Glycemie, String heure, String Obs) throws SQLException {
                String sql = "UPDATE cardex SET TC=?, TAD=?, TAS=?, FC=?, FR=? ,SaO=? ,Glycemie=? ,Heure=? ,Observation=? WHERE Id_cardex=?";
                PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
                statement.setObject(1,TC);
                statement.setObject(2,TD);
                statement.setObject(3,TS);
                statement.setObject(4,FC);
                statement.setObject(5,FR);
                statement.setObject(6,SaO);
                statement.setObject(7,Glycemie);
                statement.setObject(8,heure);
                statement.setObject(9,Obs);
                statement.setObject(10,id_cardex);
                statement.executeUpdate();
    }
    
    //Modification Note d'HONORAIRE
    public void honoriare (String prestation, double qte, double pu , double pt, String id_ho) throws SQLException {
                String sql = "UPDATE honoraire SET prestation=? ,qte=?, pu=?, pt=? WHERE id_h =?";
                PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
                statement.setObject(1,prestation);
                statement.setObject(2,qte);
                statement.setObject(3,pu);
                statement.setObject(4,pt);
                statement.setObject(5,id_ho);
                statement.executeUpdate();
    }
    
    //Modification Note FACTURE
    public void facture (String prestation, Double prix) throws SQLException {
                String sql = "UPDATE facture SET prix=? WHERE prestation=?";
                PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
                statement.setObject(1,prix);
                statement.setObject(2, prestation);
                statement.executeUpdate();
    }
    
    //Modification Note d'TOTAL
    public void Total (String TG, String CV , String SNP, String SR,String id_cons,String user) throws SQLException {
                java.util.Date da=new java.util.Date();
                DateFormat dat= DateFormat.getDateInstance( DateFormat.SHORT);
                date=dat.format(da);
                String user1=user+"("+date+")";
                String sql = "UPDATE total SET TG=? ,CV=?, SNP=?, SR=?, user=? WHERE id_cons =?";
                PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
                statement.setObject(1,TG);
                statement.setObject(2,CV);
                statement.setObject(3,SNP);
                statement.setObject(4,SR);
                statement.setObject(5,user1);
                statement.setObject(6,id_cons);
                statement.executeUpdate();
    }
    
//Modification du traitement 
 public void modif_traitement(String Id_tr,String Prix) throws SQLException
 {
      String sql = "UPDATE traitement SET Prix=?  WHERE Id_tr=?";
      PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
      statement.setObject(1,Prix);
      statement.setObject(2,Id_tr);
      statement.executeUpdate();
 }
}
