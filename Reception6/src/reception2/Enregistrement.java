/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reception2;

import com.mysql.jdbc.Statement;
import java.sql.*;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Samy-MBIYA
 * 
 */
    public class Enregistrement {
    private Statement state;
    private ResultSet result;
    public int compt;
    public double qt_stock,prix_stock;
    public String date;
    public Modification modification=new Modification();
    
    public void enrg_patient (String nom,String postnom, String prenom,String sexe,String dn, String ec,String adresse, String phone, String profession,String employeur  )throws SQLException
    {
        try {   state = (Statement) connection.getInstance().createStatement();
                String req1="SELECT COUNT(*) AS id_pa FROM patient WHERE Nom='"+nom+"' AND Post_nom='"+postnom+"' AND Prenom='"+prenom+"'";
                result= state.executeQuery(req1);
                   while(result.next()){
                              compt=result.getInt("id_pa");
                     }
                   if(compt==0)
                              {
                                 state.executeUpdate("INSERT INTO ce2.patient (id_pa ,Nom ,Post_nom ,Prenom,Sexe,DN, EC, Adresse, Phone, Profession, Employeur) VALUES (NULL , '"+nom+"', '"+postnom+"','"+prenom+"','"+sexe+"', '"+dn+"', '"+ec+"','"+adresse+"','"+phone+"','"+profession+"','"+employeur+"');"); 
                              }
                              else {
                                  JOptionPane.showMessageDialog(null, "Le Patient existe dejà ", "Attention", JOptionPane.WARNING_MESSAGE);
                              }
                 } catch (SQLException ex) {
                    Logger.getLogger(Enregistrement.class.getName()).log(Level.SEVERE, null, ex);
                }
      
    }
    // Enregistrement des Signe Viteaux
    public void enr_sv(String Id_pa,String Date, String Heure, String TC, String TAS, String TAD, String FC, String FR, String O, String Poid )
    {
        try {   state = (Statement) connection.getInstance().createStatement();
                String req1="SELECT COUNT(*) AS id_pa FROM sv WHERE Id_pa='"+Id_pa+"'";
                result= state.executeQuery(req1);
                state.executeUpdate("INSERT INTO ce2.sv (Id_sv ,Id_pa ,Date ,Heure,TC,TAS, TAD, FC, FR, O, Poid) VALUES (NULL , '"+Id_pa+"', '"+Date+"','"+Heure+"','"+TC+"', '"+TAS+"', '"+TAD+"', '"+FC+"','"+FR+"','"+O+"','"+Poid+"');");                
             } catch (SQLException ex) {
                    Logger.getLogger(Enregistrement.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    // Enregistrement de la PHARMACIE
    // Enregistrement Achat
    public void enr_achat(String Produit, Double Qt_Gros,  Double Qt_Detail, Double Prix_Gros, Double Prix_Detail, String Date_expi, String Date_achat, String Type_Achat ) throws SQLException
    {
       try {   state = (Statement) connection.getInstance().createStatement();
                String req1="SELECT id_Prod FROM produit WHERE Nom_Prod='"+Produit+"'";
                result= state.executeQuery(req1);
                   while(result.next()){
                              compt=result.getInt("id_Prod");
                     }
                   
                        String sql = "INSERT INTO ce2.acheter (Id_Prod, Qt_Gros, Qt_Detail, Prix_Gros, Prix_Detail, Date_expi, Date_achat, Type_Achat) VALUES(?,?,?,?,?,?,?,?)";
                        PreparedStatement statement = connection.conn.prepareStatement(sql);
                        statement.setObject(1,compt);
                        statement.setObject(2,Qt_Gros);
                        statement.setObject(3,Qt_Detail);
                        statement.setObject(4,Prix_Gros);
                        statement.setObject(5,Prix_Detail);
                        statement.setObject(6,Date_expi);
                        statement.setObject(7,Date_achat);
                        statement.setObject(8,Type_Achat);
                        statement.executeUpdate();       
                   
                 } catch (SQLException ex) {
                    Logger.getLogger(Enregistrement.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
     
    // Enregistrement Produit
    public void enr_produit (String Nom_Prod, Double Qt_Prod, Double PU_Prod)
    {
        try {   state = (Statement) connection .getInstance().createStatement();
                String req1="SELECT * FROM produit WHERE Nom_Prod='"+Nom_Prod+"'";
                result= state.executeQuery(req1);
                while(result.next()){
                              compt=result.getInt("id_Prod");
                              qt_stock=result.getDouble("Qt_Prod");
                              prix_stock=result.getDouble("PU_Prod");
                     }
                   if(compt==0){
                       state.executeUpdate("INSERT INTO ce2.produit (id_Prod, Nom_Prod ,Qt_Prod ,PU_Prod) VALUES (NULL ,'"+Nom_Prod+"', '"+Qt_Prod+"','"+PU_Prod+"');");  
                   }
                   else{
                        qt_stock=qt_stock+Qt_Prod;
                        String sql = "UPDATE produit SET Nom_Prod=?, Qt_Prod=?,PU_Prod=? WHERE id_Prod=?";
                        PreparedStatement statement = (PreparedStatement) connection.conn.prepareStatement(sql);
                        statement.setObject(1,Nom_Prod);
                        statement.setObject(2,qt_stock);
                        statement.setObject(3,PU_Prod);
                        statement.setObject(4,compt);
                        statement.executeUpdate();
                   }      
             } catch (SQLException ex) {
                    Logger.getLogger(Enregistrement.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
     // Enregistrement de la Examen
    public void enr_examen(String Examen, String Type, String Prix) throws SQLException
    {
         try {   state = (Statement) connection.getInstance().createStatement();
                String req1="SELECT COUNT(*) AS Id_examen FROM examen WHERE Examen='"+Examen+"' AND Type='"+Type+"'";
                result= state.executeQuery(req1);
                   while(result.next()){
                              compt=result.getInt("Id_examen");
                     }
                   if(compt==0)
                              {
                                String sql = "INSERT INTO ce2.examen (Examen ,Type,Prix) VALUES(?,?,?)";
                                PreparedStatement statement = connection.conn.prepareStatement(sql);
                                statement.setObject(1,Examen);
                                statement.setObject(2,Type);
                                statement.setObject(3,Prix);
                                statement.executeUpdate();
                               }
                   else {
                               JOptionPane.showMessageDialog(null, "Le Examen existe dejà ", "Attention", JOptionPane.WARNING_MESSAGE);   
                              }
                 } catch (SQLException ex) {
                    Logger.getLogger(Enregistrement.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    // Enregistrement du Cadexe
    public void enr_cardex(String Id_cons, String Id_traitement,String TC,String TD, String TS, String FC, String FR,String SaO,String Glycemie, String Date , String heure, String Obs) throws SQLException
    {
        String sql = "INSERT INTO ce2.cardex (Id_cons ,Id_traitement,TC,TAD,TAS,FC,FR,SaO,Glycemie,Date,Heure,Observation) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.conn.prepareStatement(sql);
                statement.setObject(1,Id_cons);
                statement.setObject(2,Id_traitement);
                statement.setObject(3,TC);
                statement.setObject(4,TD);
                statement.setObject(5,TS);
                statement.setObject(6,FC);
                statement.setObject(7,FR);
                statement.setObject(8,SaO);
                statement.setObject(9,Glycemie);
                statement.setObject(10,Date);
                statement.setObject(11,heure);
                statement.setObject(12,Obs);
                statement.executeUpdate();
    }
    
     // Enregistrement Note d'honoraire
    public void enr_honoraire (String prestation, double qte, double pu , double pt, String id_cons) throws SQLException
    {
            state = (Statement) connection.getInstance().createStatement();
                String req1="SELECT COUNT(*) AS id_to FROM total";
                result= state.executeQuery(req1);
                   while(result.next()){
                              compt=result.getInt("id_to");
                     }
                   compt=compt+1;
                                String sql = "INSERT INTO ce2.honoraire (prestation ,qte,pu,pt,id_cons,Id_total) VALUES(?,?,?,?,?,?)";
                                PreparedStatement statement = connection.conn.prepareStatement(sql);
                                statement.setObject(1,prestation);
                                statement.setObject(2,qte);
                                statement.setObject(3,pu);
                                statement.setObject(4,pt);
                                statement.setObject(5,id_cons);
                                statement.setObject(6,compt);
                                statement.executeUpdate();
    }
    
     // Enregistrement FACTURE
     public void enr_facture ( String id_cons,String prestation,String prix) throws SQLException
    {
        String sql = "INSERT INTO ce2.facture (prestation ,prix,id_cons, Id_total) VALUES(?,?,?,?)";
        PreparedStatement statement = connection.conn.prepareStatement(sql);
        statement.setObject(1,prestation);
        statement.setObject(2,prix);
        statement.setObject(3,id_cons);
        statement.setObject(4,compt);
        statement.executeUpdate();
    }
    // Enregistrement Total
     public void enr_total ( double TG, double CV , double SNP, double SR,String id_cons,String Type,String id_fac,String user, String Id_pat) throws SQLException
    {
        java.util.Date da=new java.util.Date();
        DateFormat dat= DateFormat.getDateInstance( DateFormat.SHORT);
        date=dat.format(da);
        String sql = "INSERT INTO ce2.total (TG ,CV,SNP,SR,id_cons,Type,user,date,Id_pat) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.conn.prepareStatement(sql);
        statement.setObject(1,TG);
        statement.setObject(2,CV);
        statement.setObject(3,SNP);
        statement.setObject(4,SR);
        statement.setObject(5,id_cons);
        statement.setObject(6,Type);
        statement.setObject(7,user);
        statement.setObject(8,date);
        statement.setObject(9,Id_pat);
        statement.executeUpdate();
    }
     
}