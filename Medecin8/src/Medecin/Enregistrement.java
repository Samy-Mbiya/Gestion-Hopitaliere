/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Medecin;

import com.mysql.jdbc.Statement;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author Samy-MBIYA
 * 
 * 
 */
    public class Enregistrement {
    private Statement state,state1;
    private ResultSet result;
    public int compt;
    public double Qt_cons;
    public String date, heure, EP;
   
    //Enregistrement de la consultation
    public void enrg_consultation (String Id_pr,String Id_pa, String s,String ATCD,String HMA, String CA,String EP, String A )throws SQLException
    {
        // Date et heure
        Date da=new Date();
        DateFormat dat= DateFormat.getDateInstance( DateFormat.SHORT);
        date=(String)dat.format(da);
        DateFormat heur= new SimpleDateFormat("HH'H'mm");
        heure=(String)heur.format(da);
        
        // Enregistrement de la Consultation
        try {   
                String sql = "INSERT INTO ce2.consultation (Id_pr ,Id_pa ,s,ATCD, HMA, CA, EP, A,CAT,Date,Heure) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.conn.prepareStatement(sql);
                statement.setObject(1,Id_pr);
                statement.setObject(2,Id_pa);
                statement.setObject(3,s);
                statement.setObject(4,ATCD);
                statement.setObject(5,HMA);
                statement.setObject(6,CA);
                statement.setObject(7,EP);
                statement.setObject(8,A);
                statement.setObject(9,EP);
                statement.setObject(10,date);
                statement.setObject(11,heure); 
                statement.executeUpdate(); 
                 } catch (SQLException ex) {
                    Logger.getLogger(Enregistrement.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
     //Enregistrement de l'elevolution
    public void enrg_evolution (String S,String HMA, String CA, String EP,String A,String Date, String Ip_pr,String Ip_pa, String Ip_con )throws SQLException
    {
        // Enregistrement de l'evolution

        try {    
                String sql = "INSERT INTO ce2.evolution (S ,HMA ,CA,EP, A, Date,Id_pr, Id_pa, Id_con) VALUES(?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.conn.prepareStatement(sql);
                statement.setObject(1,S);
                statement.setObject(2,HMA);
                statement.setObject(3,CA);
                statement.setObject(4,EP);
                statement.setObject(5,A);
                statement.setObject(6,Date);
                statement.setObject(7,Ip_pr);
                statement.setObject(8,Ip_pa);
                statement.setObject(9,Ip_con);
                statement.executeUpdate(); 
                 } catch (SQLException ex) {
                    Logger.getLogger(Enregistrement.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
     //Enregistrement de du traitement 
    public void en_traitement(String Medicament,String Id_pa,String id_cons, String type, String Id_ev,String mode_emploi, String Qt,String prix_prod, String Source_Pord)
    {
        if ("".equals(prix_prod))
        {
            prix_prod="0";
        }
        try {   
                String sql = "INSERT INTO ce2.traitement (Medicament ,Qt_prise,Type,mode_emploi,Prix,Id_ev, Id_pa,Source,Id_cons) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement statement = connection.conn.prepareStatement(sql);
                statement.setObject(1,Medicament);
                statement.setObject(2,Qt);
                statement.setObject(3,type);
                statement.setObject(4,mode_emploi);
                statement.setObject(5,prix_prod);
                statement.setObject(6,Id_ev);
                statement.setObject(7,Id_pa);
                statement.setObject(8,Source_Pord);
                statement.setObject(9,id_cons);
                statement.executeUpdate();
                 } catch (SQLException ex) {
                    Logger.getLogger(Enregistrement.class.getName()).log(Level.SEVERE, null, ex);
                }
        //Qt_cons
    }
    
    // Enregistrement Examen de labo
    public void en_labo(String examen, String type, String Id_pa, String Id_cons,String sorte, String Id_ev)
    {
        try {   
                state = (Statement) connection.getInstance().createStatement();
                state1 = (Statement) connection.getInstance().createStatement();
                state.executeUpdate("INSERT INTO labo (Id_la,Id_pa, Id_cons ,Id_ev ,Nom_ex ,Type_ex,Valeur,sorte) VALUES (Null, '"+Id_pa+"', '"+Id_cons+"','"+Id_ev+"', '"+examen+"','"+type+"','.','"+sorte+"');"); 
                //state1.executeUpdate("INSERT INTO examen (Id_examen,Examen, Type)VALUES (Null, '"+examen+"', '"+type+"');");
                 } catch (SQLException ex) {
                    Logger.getLogger(Enregistrement.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    // Enregistrement Examen de de l'imagerie
    public void en_image(String Exd, String Rec, String Id_cons, String sorte,String Id_ev)
    {
        try {   
                state = (Statement) connection.getInstance().createStatement(); 
                String sql = "INSERT INTO ce2.imagerie (Exd ,Rec, Interpretation,Id_cons, Id_ev, sorte) VALUES(?,?,?,?,?,?)";
                PreparedStatement statement = connection.conn.prepareStatement(sql);
                statement.setObject(1,Exd);
                statement.setObject(2,Rec);
                statement.setObject(3,".");
                statement.setObject(4,Id_cons);
                statement.setObject(5,Id_ev);
                statement.setObject(6,sorte);
                statement.executeUpdate();  
                
                 } catch (SQLException ex) {
                    Logger.getLogger(Enregistrement.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
