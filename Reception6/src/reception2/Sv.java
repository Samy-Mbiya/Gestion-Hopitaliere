/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Sv.java
 *
 * Created on 9 août 2018, 13:35:18
 */
package reception2;
import com.mysql.jdbc.Statement;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Samy-MBIYA
 */
public class Sv extends javax.swing.JFrame {
     public String id_psv,nom, postnom, prenom, sexe, dn, ec, ad, ph, pr, em;
     public String id_sv,date, heure, tc, tas, tad, fc, fr, o, poid;
     public String  User,prestation, qte,pu,dig;
     public String id_cons,id_ev,Id_user , id_traitement,id_ho,id_fac, obs="C";
     public int compt,ligne_select,in;
     private Statement state,state2;
     private ResultSet result,result2,result3;
     protected Enregistrement sv_enreg=new Enregistrement();
     protected Modification sv_mofi=new Modification();
     protected Modification cardex_mofi=new Modification();
     protected Suppression sv_sup=new Suppression();
     protected Facture fac =new Facture (); 

    /** Creates new form Sv */
        public Sv() {
         initComponents();
         jButton6.setVisible(false);
         jButton12.setVisible(false);
         jButton11.setVisible(false);
        }
        public void valider()
        {   compt=Tab_Fac.getRowCount();
            double tg=0;
            for (int i=0; i<compt; i++) //linge
            {
                qte= (String) Tab_Fac.getModel().getValueAt(i,2);
                pu= (String) Tab_Fac.getModel().getValueAt(i,3);
                // CALCUL DU PRIX TOTAL
                if (qte!=null && pu!=null){
                    prestation= (String) Tab_Fac.getModel().getValueAt(i,1);
                    double qte2= new Double(qte);
                    double pu2= new Double(pu);
                    double pt=qte2*pu2;// PRIX TOTAL
                    //Tab_Fac.getModel().setValueAt(pt, i, 4);
                    tg=tg+pt;//TOTAL GENERAL
                }
            }
         String tg2=String.valueOf(tg);
         double snp=tg;
         double cv = new Double(CV.getText());
         double sr= new Double(SR.getText());
         snp=snp-cv;
         snp=snp-sr;
         String snp2= String.valueOf(snp);
         SNP.setText(snp2);
         TG.setText(tg2);
         SNP1.setText(snp2);
         TG1.setText(tg2);
        
        }
        public void user(String id_user, String User)
        {
            User_nam.setText(User);
            Id_User.setText(id_user);
        }
        public void info_patient (String id_p,String nom,String postnom, String prenom,String sexe,String dn, String ec,String adresse, String phone, String profession,String employeur,String ATCD)
        {
            id.setText(id_p);
            id_psv=id_p;
            Nom_p.setText(nom);  
            Postnom_p.setText(postnom);
            Prenom_p.setText(prenom);  
            Sexe_p.setText(sexe);
            EC_p.setText(dn);  
            Dn_p.setText(ec);
            A_p.setText(adresse);  
            Ph_p.setText(phone);
            Pr_p.setText(profession);
            Em_p.setText(employeur);
            ATCD_1.setText(ATCD);

            try { 
                //affichage de la SV
                state = (Statement) connection.getInstance().createStatement();
                 result = state.executeQuery("SELECT* FROM  sv WHERE Id_pa='"+id_p+"' AND O LIKE '"+"%"+obs+"%"+"'  ORDER BY Id_sv DESC;");
                           DefaultTableModel Table=  (DefaultTableModel) Tb2.getModel();
                           Table.setColumnCount(0);
                           Table.addColumn("Numero");
                           Table.addColumn("Date");
                           Table.addColumn("Heure");
                           Table.addColumn("TC");
                           Table.addColumn("TAS");
                           Table.addColumn("TAD");
                           Table.addColumn("FC");
                           Table.addColumn("FR");
                           Table.addColumn("Poid");
                           Table.addColumn("O");
                           Table.setRowCount(0);
                           while (result.next())
                              {//
                                    Object[] objets= new Object[10];
                                    objets[0]= result.getString("Id_sv");
                                    objets[1]= result.getString("Date");
                                    objets[2]= result.getString("Heure");
                                    objets[3]= result.getString("TC");
                                    objets[4]= result.getString("TAS");
                                    objets[5]= result.getString("TAD");
                                    objets[6]= result.getString("FC");
                                    objets[7]= result.getString("FR");
                                    objets[8]= result.getString("Poid");
                                    objets[9]= result.getString("O");
                                    Table.addRow(objets);
                              }
                           //Affichage de la consultation
                           consultation (id_p);

                } catch (SQLException ex) {
                    Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
                }

        }
        public void consultation (String id_p)
        {
       //affichage de la Consultation
        try {  
        state = (Statement) connection.getInstance().createStatement();
         result = state.executeQuery("SELECT * FROM  consultation, personnel WHERE consultation.Id_pa='"+id_p+"' AND consultation.Id_pr=personnel.Id_pr  ORDER BY consultation.Id_consultation DESC;");
           
                   DefaultTableModel Table2=  (DefaultTableModel) Tb_consultation.getModel();
                   Table2.setColumnCount(0);
                   Table2.addColumn("Id_Cons");
                   Table2.addColumn("Date");
                   Table2.addColumn("Symptome");
                   Table2.addColumn("Complement");
                   Table2.addColumn("Docteur");
                   Table2.addColumn("Diagno");
                   Table2.setRowCount(0);
                   while (result.next())
                      {//
                            Object[] objets= new Object[6];
                            objets[0]= result.getString("Id_consultation");
                            objets[1]= result.getString("Date");
                            objets[2]= result.getString("s");
                            objets[3]= result.getString("CA");
                            objets[4]= result.getString("Nom");
                            objets[5]= result.getString("A");
                            Table2.addRow(objets);
                      }


        } catch (SQLException ex) {
            Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
        public void affichage_table_evolution(String id_psv, String id_cons)
{
    try {  
         //affichage de l'évolution
        state = (Statement) connection.getInstance().createStatement();
        result = state.executeQuery("SELECT * FROM evolution, personnel  WHERE evolution.Id_pa='"+id_psv+"' AND evolution.Id_con='"+id_cons+"' AND evolution.Id_pr =personnel.Id_pr  ORDER BY evolution.Id_ev DESC;;");
                   DefaultTableModel Table4=  (DefaultTableModel) Tb_evolution.getModel();
                   Table4.setColumnCount(0);
                   Table4.addColumn("N°");
                   Table4.addColumn("Date");
                   Table4.addColumn("Doc");
                   Table4.addColumn("A");
                   Table4.setRowCount(0);
                   while (result.next())
                      {//
                            Object[] objets= new Object[4];
                            objets[0]= result.getString("Id_ev");
                            objets[1]= result.getString("Date");
                            objets[2]= result.getString("Nom");
                            objets[3]= result.getString("A");
                            
                            Table4.addRow(objets);
                      }


        } catch (SQLException ex) {
            Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
        }
}
        public void affichage_cardex (String id_cons, String id_traitement )
        {     
                 //Affichage du  Cardex
                 try{
                     state = (Statement) connection.getInstance().createStatement();
                     result = state.executeQuery("SELECT* FROM  cardex WHERE Id_cons='"+id_cons+"' AND Id_traitement='"+id_traitement+"' ;");
                               DefaultTableModel Table=  (DefaultTableModel) Tb_Cardex.getModel();
                               Table.setColumnCount(0);
                               Table.addColumn("ID");
                               Table.addColumn("Date");
                               Table.addColumn("Heure");
                               Table.addColumn("Observation");
                               Table.addColumn("TC");
                               Table.addColumn("TAS");
                               Table.addColumn("TAD");
                               Table.addColumn("FC");
                               Table.addColumn("FR");
                               Table.addColumn("SaO2");
                               Table.addColumn("Glycemie");
                               
                               Table.setRowCount(0);
                               while (result.next())
                                  {//
                                        Object[] objets= new Object[11];
                                        objets[0]= result.getString("Id_cardex");
                                        objets[1]= result.getString("Date");
                                        objets[2]= result.getString("Heure");
                                        objets[3]= result.getString("Observation");
                                        objets[4]= result.getString("TC");
                                        objets[5]= result.getString("TAS");
                                        objets[6]= result.getString("TAD");
                                        objets[7]= result.getString("FC");
                                        objets[8]= result.getString("FR");
                                        objets[9]= result.getString("SaO");
                                        objets[10]= result.getString("Glycemie");
                                        Table.addRow(objets);
                                  }


                    } catch (SQLException ex) {
                        Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
                    }
       }
        public void affichage_table_facture(String id_cons)
        {
         try {
             // AFFICHAGE TABLE FACTURE 
             
             state = (Statement) connection.getInstance().createStatement(); 
             result2 = state.executeQuery("SELECT* FROM  facture WHERE id_cons='"+id_cons+"' ;");
                  
                           DefaultTableModel Table=  (DefaultTableModel) Tab_Fac1.getModel();
                           Table.setColumnCount(0);
                           Table.addColumn("id_fac");
                           Table.addColumn("prestation");
                           Table.addColumn("prix");
                           Table.setRowCount(0);
                           while (result2.next())
                              {//
                                    Object[] objets= new Object[3];
                                    objets[0]= result2.getString("id_fac");
                                    objets[1]= result2.getString("prestation");
                                    objets[2]= result2.getString("prix");
                                    Table.addRow(objets);     
                              }
                            // AFFICHAGE CALCUL FACTURE 
                          
         } catch (SQLException ex) {
             Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
         }
                 
        }
        private void affichage_table_honoraire (String id_cons)
        {
             try {  
                 // AFFICHAGE HONORAIRE
                
                 state = (Statement) connection.getInstance().createStatement();   
                 result2 = state.executeQuery("SELECT* FROM  honoraire WHERE id_cons='"+id_cons+"' ;");
                  
                           DefaultTableModel Table=  (DefaultTableModel) Tab_Fac.getModel();
                           Table.setColumnCount(0);
                           Table.addColumn("Id_H");
                           Table.addColumn("Prestation");
                           Table.addColumn("Quantité");
                           Table.addColumn("Prix Unitaire");
                           Table.addColumn("Prix Total");
                           Table.setRowCount(0);
                           while (result2.next())
                              {//
                                    Object[] objets= new Object[5];
                                    objets[0]= result2.getString("id_h");
                                    objets[1]= result2.getString("prestation");
                                    objets[2]= result2.getString("qte");
                                    objets[3]= result2.getString("pu");
                                    objets[4]= result2.getString("pt");
                                    Table.addRow(objets);
                                   
                              }
                    // AFFICHAGE OU PAS DU BOUTTON FACTURE, FACTURATION et HONORAIRE
                   
                   String req1="SELECT COUNT(*) AS id_h FROM honoraire WHERE id_cons='"+id_cons+"'";
                   result= state.executeQuery(req1);
                   while(result.next()){
                              compt=result.getInt("id_h");
                     }
                           if(compt!=0){
                               jButton6.setVisible(true);
                               jButton11.setVisible(false);
                               jButton12.setVisible(true);
                    }
                   else {
                       
                       jButton6.setVisible(false);
                       jButton11.setVisible(true);
                       jButton12.setVisible(false);  
                   }
                   
                  // AFFICHE LA VALEUR DE CAUSSION VERSER ET SOMME NET A PAYER
                   String reql4="SELECT COUNT(*) AS id_to FROM total WHERE id_cons='"+id_cons+"'";
                   result= state.executeQuery(reql4);
                   while(result.next()){
                              compt=result.getInt("id_to");
                     }
                   if (compt!=0)
                       {
                   String req3="SELECT* FROM total WHERE id_cons='"+id_cons+"'";       
                   result3=state.executeQuery(req3);
                   while(result3.next()){
                       
                       String cv=result3.getString("CV");
                       String  sr=result3.getString("SR");
                       user_fac.setText(result3.getString("user"));
                       Date_fac.setText(result3.getString("date"));
                       CV.setText(cv);
                       SR.setText(sr);
                       CV1.setText(cv);
                       SR1.setText(sr);

                       }  }else{
                           CV.setText("0");
                            SR.setText("0");
                            user_fac.setText("");
                            Date_fac.setText("");
                       }                                         
                } catch (SQLException ex) {
                    Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        public void affichage_table_traitement(String id_p, String id_cons)
        {
             try {  
                 //affichage du Traitement
                state = (Statement) connection.getInstance().createStatement();
                 result = state.executeQuery("SELECT * FROM traitement WHERE Id_pa='"+id_p+"' AND Id_cons='"+id_cons+"';");
                           DefaultTableModel Table4=  (DefaultTableModel) Tb_Traitement.getModel();
                           Table4.setColumnCount(0);
                           Table4.addColumn("Id");
                           Table4.addColumn("Produit");
                           Table4.addColumn("Quantité");
                           Table4.addColumn("mode_emploie");
                            Table4.addColumn("Prix");
                           Table4.setRowCount(0);
                           while (result.next())
                              {//
                                    Object[] objets= new Object[5];
                                    objets[0]= result.getString("Id_tr");
                                    objets[1]= result.getString("Medicament");
                                    objets[2]= result.getString("Qt_prise");
                                    objets[3]= result.getString("mode_emploi");
                                    objets[4]= result.getString("Prix");
                                    Table4.addRow(objets);
                              }


                } catch (SQLException ex) {
                    Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        public void affichage_table_traitement_ev(String id_p, String id_ev)
        {
             try {  
                 //affichage du Traitement
                state = (Statement) connection.getInstance().createStatement();
                 result = state.executeQuery("SELECT * FROM traitement WHERE Id_pa='"+id_p+"' AND Id_ev='"+id_ev+"';");
                           DefaultTableModel Table4=  (DefaultTableModel) Tb_Traitement_ev.getModel();
                           Table4.setColumnCount(0);
                           Table4.addColumn("Id");
                           Table4.addColumn("Produit");
                           Table4.addColumn("Quantité");
                           Table4.addColumn("mode_emploie");
                            Table4.addColumn("Prix");
                           Table4.setRowCount(0);
                           while (result.next())
                              {//
                                    Object[] objets= new Object[5];
                                    objets[0]= result.getString("Id_tr");
                                    objets[1]= result.getString("Medicament");
                                    objets[2]= result.getString("Qt_prise");
                                    objets[3]= result.getString("mode_emploi");
                                    objets[4]= result.getString("Prix");
                                    Table4.addRow(objets);
                              }


                } catch (SQLException ex) {
                    Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        public void affectation ()
        {
            //Signe Viteaux
            Date da=new Date();
            DateFormat dat= DateFormat.getDateInstance( DateFormat.SHORT);
            date=dat.format(da);
            heure=Heure.getText();
            tc=TC.getText();
            tas=TAS.getText();
            tad=TAD.getText();
            fc=FC.getText();
            fr=FR.getText();
            o=O.getText();
            poid=Poid.getText();
        }
        public void vide()
        {
            Heure.setText("");
            TC.setText("");
            TAS.setText("");
            TAD.setText("");
            FC.setText("");
            FR.setText("");
            O.setText("");
            Poid.setText("");
            Traitement_tx.setText("");
        }
        public void affichage ()
        {
            try {  
                state = (Statement) connection.getInstance().createStatement();
                 result = state.executeQuery("SELECT* FROM  sv WHERE Id_pa='"+id.getText()+"' ;");
                   //affichage de la location

                           DefaultTableModel Table=  (DefaultTableModel) Tb2.getModel();
                           Table.setColumnCount(0);
                           Table.addColumn("Numero");
                           Table.addColumn("Date");
                           Table.addColumn("Heure");
                           Table.addColumn("TC");
                           Table.addColumn("TAS");
                           Table.addColumn("TAD");
                           Table.addColumn("FC");
                           Table.addColumn("FR");
                           Table.addColumn("Poid");
                           Table.addColumn("O");
                           Table.setRowCount(0);
                           while (result.next())
                              {//
                                    Object[] objets= new Object[10];
                                    objets[0]= result.getString("Id_sv");
                                    objets[1]= result.getString("Date");
                                    objets[2]= result.getString("Heure");
                                    objets[3]= result.getString("TC");
                                    objets[4]= result.getString("TAS");
                                    objets[5]= result.getString("TAD");
                                    objets[6]= result.getString("FC");
                                    objets[7]= result.getString("FR");
                                    objets[8]= result.getString("Poid");
                                    objets[9]= result.getString("O");
                                    Table.addRow(objets);
                              }


                } catch (SQLException ex) {
                    Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
                }

        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        nomLabel = new javax.swing.JLabel();
        postnomLabel = new javax.swing.JLabel();
        prenomLabel = new javax.swing.JLabel();
        sexeLabel = new javax.swing.JLabel();
        ecLabel = new javax.swing.JLabel();
        adresseLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        professionLabel = new javax.swing.JLabel();
        Nom_p = new javax.swing.JLabel();
        Postnom_p = new javax.swing.JLabel();
        Prenom_p = new javax.swing.JLabel();
        Sexe_p = new javax.swing.JLabel();
        EC_p = new javax.swing.JLabel();
        Dn_p = new javax.swing.JLabel();
        dnLabel = new javax.swing.JLabel();
        A_p = new javax.swing.JLabel();
        Ph_p = new javax.swing.JLabel();
        Pr_p = new javax.swing.JLabel();
        Em_p = new javax.swing.JLabel();
        employeurLabel = new javax.swing.JLabel();
        employeurLabel1 = new javax.swing.JLabel();
        ATCD_1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        User_nam = new javax.swing.JLabel();
        Id_User = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tb2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TC = new javax.swing.JTextField();
        TAS = new javax.swing.JTextField();
        TAD = new javax.swing.JTextField();
        FC = new javax.swing.JTextField();
        FR = new javax.swing.JTextField();
        Poid = new javax.swing.JTextField();
        O = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Heure = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tb_consultation = new javax.swing.JTable();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tb_labo = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Diag = new javax.swing.JTextPane();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        Tb_imagerie = new javax.swing.JTable();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Plainte1 = new javax.swing.JTextPane();
        jScrollPane18 = new javax.swing.JScrollPane();
        Plainte2 = new javax.swing.JTextPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tb_Traitement = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Traitement_tx = new javax.swing.JTextPane();
        User_nam7 = new javax.swing.JLabel();
        jScrollPane45 = new javax.swing.JScrollPane();
        Qt1 = new javax.swing.JTextPane();
        jScrollPane42 = new javax.swing.JScrollPane();
        mode_emploie = new javax.swing.JTextPane();
        User_nam6 = new javax.swing.JLabel();
        User_nam5 = new javax.swing.JLabel();
        jScrollPane46 = new javax.swing.JScrollPane();
        Prix_traitement = new javax.swing.JTextPane();
        User_nam8 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        Prd = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Tb_Cardex = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        TC1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        obs_cardex = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        TD1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        TS1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        FC1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        Heure_cardex4 = new javax.swing.JTextField();
        qt_car = new javax.swing.JLabel();
        Presciption = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        FR1 = new javax.swing.JTextField();
        SaO1 = new javax.swing.JTextField();
        glycemie1 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Tab_Fac = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        TG = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        CV = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        SNP = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        SR = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        user_fac = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        Date_fac = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        Pres = new javax.swing.JTextField();
        qt_mod = new javax.swing.JTextField();
        pu_mod = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        Prestation = new javax.swing.JComboBox();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        TG1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        SNP1 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Tab_Fac1 = new javax.swing.JTable();
        CV1 = new javax.swing.JLabel();
        SR1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        Tb_evolution = new javax.swing.JTable();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        Tb_labo_ev = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        Diag_ev = new javax.swing.JTextPane();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        Tb_imagerie_ev = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        Tb_Traitement_ev = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        Traitement_tx1 = new javax.swing.JTextPane();
        User_nam9 = new javax.swing.JLabel();
        jScrollPane47 = new javax.swing.JScrollPane();
        Qt2 = new javax.swing.JTextPane();
        jScrollPane43 = new javax.swing.JScrollPane();
        mode_emploie1 = new javax.swing.JTextPane();
        User_nam10 = new javax.swing.JLabel();
        User_nam11 = new javax.swing.JLabel();
        jScrollPane48 = new javax.swing.JScrollPane();
        Prix_traitement1 = new javax.swing.JTextPane();
        User_nam12 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenu1.setText("File");

        jMenu4.setBackground(new java.awt.Color(255, 102, 255));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Consultation.png"))); // NOI18N
        jMenu4.setText("Consultation");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jMenu1.add(jMenu4);

        jMenu5.setBackground(new java.awt.Color(255, 102, 255));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Facturation.jpg"))); // NOI18N
        jMenu5.setText("Soins");
        jMenu5.setAutoscrolls(true);
        jMenu5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jMenu1.add(jMenu5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INTOMATION DU PACIENT ");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Information du Patient"));

        nomLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nomLabel.setText("Nom:");

        postnomLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        postnomLabel.setText("Postnom:");

        prenomLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prenomLabel.setText("Prenom:");

        sexeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sexeLabel.setText("Sexe:");

        ecLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ecLabel.setText("Etat Civil:");

        adresseLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        adresseLabel.setText("Adresse:");

        phoneLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneLabel.setText("Phone:");

        professionLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        professionLabel.setText("Profession:");

        Nom_p.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Nom_p.setText(".........");

        Postnom_p.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Postnom_p.setText(".........");

        Prenom_p.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Prenom_p.setText(".........");

        Sexe_p.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Sexe_p.setText(".........");

        EC_p.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EC_p.setText(".........");

        Dn_p.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Dn_p.setText(".........");

        dnLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dnLabel.setText("Né le:");

        A_p.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        A_p.setText(".........");

        Ph_p.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Ph_p.setText(".........");

        Pr_p.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Pr_p.setText(".........");

        Em_p.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Em_p.setText(".........");

        employeurLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeurLabel.setText("Employeur:");

        employeurLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employeurLabel1.setText("ATCD :");

        ATCD_1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ATCD_1.setText(".........");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(adresseLabel)
                        .addGap(46, 46, 46)
                        .addComponent(A_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(phoneLabel)
                        .addGap(54, 54, 54)
                        .addComponent(Ph_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(professionLabel)
                        .addGap(31, 31, 31)
                        .addComponent(Pr_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(employeurLabel)
                        .addGap(27, 27, 27)
                        .addComponent(Em_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexeLabel)
                            .addComponent(nomLabel)
                            .addComponent(prenomLabel)
                            .addComponent(postnomLabel)
                            .addComponent(ecLabel)
                            .addComponent(dnLabel))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EC_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Dn_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Postnom_p, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(Prenom_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nom_p, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(Sexe_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(employeurLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(ATCD_1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomLabel)
                    .addComponent(Nom_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Postnom_p, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postnomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Prenom_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sexe_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexeLabel))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(EC_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(A_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(adresseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(Ph_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Pr_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(professionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Em_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(employeurLabel)))
                                            .addComponent(phoneLabel)))
                                    .addComponent(dnLabel)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ecLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Dn_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(prenomLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ATCD_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeurLabel1))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(51, 255, 51));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Save16.png"))); // NOI18N
        jButton3.setText("Enregitrer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/b_edit.png"))); // NOI18N
        jButton4.setText("Modifier");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/DeleteHS.png"))); // NOI18N
        jButton5.setText("Supprimer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/paraJeu16.png"))); // NOI18N
        jButton2.setText("Evaluation");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/1leftarrow.png"))); // NOI18N
        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Facturation.jpg"))); // NOI18N
        jButton11.setText("facturation");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Print.png"))); // NOI18N
        jButton6.setText("Facture");
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Print.png"))); // NOI18N
        jButton12.setText("Honoraire");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel10.setText("Infirmiere :");

        User_nam.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        User_nam.setText(".");

        Id_User.setFont(new java.awt.Font("Tahoma", 0, 3)); // NOI18N
        Id_User.setText(".");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Id_User, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(User_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(User_nam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Id_User)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Date", "Heure", "TC", "TAS", "FC", "FR", "Poid", "Onservation"
            }
        ));
        Tb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tb2);
        if (Tb2.getColumnModel().getColumnCount() > 0) {
            Tb2.getColumnModel().getColumn(4).setHeaderValue("TAS");
            Tb2.getColumnModel().getColumn(5).setHeaderValue("FC");
            Tb2.getColumnModel().getColumn(6).setHeaderValue("FR");
            Tb2.getColumnModel().getColumn(7).setHeaderValue("Poid");
            Tb2.getColumnModel().getColumn(8).setHeaderValue("Onservation");
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Signe Viteaux"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("TC:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("FC");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("TAS:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("TAD:");

        Poid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PoidActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("FR:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Poid");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Observation");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Heure");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FR, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Heure, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TC, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Poid, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TAD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TAS, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FC, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(O, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(FR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(Poid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(O, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(Heure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(TC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Signe Viteaux", jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Liste de consultation"));

        Tb_consultation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "docteur"
            }
        ));
        Tb_consultation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_consultationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tb_consultation);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail"));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Diagnostique");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("LABO");

        Tb_labo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom de l'examen", "Type de l'examen", "Valeur labo"
            }
        ));
        jScrollPane3.setViewportView(Tb_labo);

        jScrollPane4.setViewportView(Diag);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Imagerie");

        Tb_imagerie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom de l'examen", "Type de l'examen", "Valeur labo"
            }
        ));
        Tb_imagerie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_imagerieMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(Tb_imagerie);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Plainte");

        jScrollPane7.setViewportView(Plainte1);

        jScrollPane18.setViewportView(Plainte2);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel43))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane4.addTab("Analyse", jPanel8);

        Tb_Traitement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicament"
            }
        ));
        Tb_Traitement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_TraitementMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(Tb_Traitement);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detaille de traitement"));

        jScrollPane6.setViewportView(Traitement_tx);

        User_nam7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        User_nam7.setText("Quantité");

        jScrollPane45.setViewportView(Qt1);

        jScrollPane42.setViewportView(mode_emploie);

        User_nam6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        User_nam6.setText("Detail du traitement");

        User_nam5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        User_nam5.setText("Medicament");

        jScrollPane46.setViewportView(Prix_traitement);

        User_nam8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        User_nam8.setText("Prix");

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/b_edit.png"))); // NOI18N
        jButton15.setText("Modifier");
        jButton15.setToolTipText("");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton15)
                        .addContainerGap())
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(User_nam5, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                .addGap(120, 120, 120))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(User_nam6, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addGap(114, 114, 114))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(0, 2, Short.MAX_VALUE)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(User_nam8, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(jScrollPane46, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(User_nam7, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                .addComponent(jScrollPane45)))
                        .addGap(25, 25, 25))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(User_nam5)
                    .addComponent(User_nam7))
                .addGap(16, 16, 16)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane45, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(User_nam6)
                    .addComponent(User_nam8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane42, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jScrollPane46))
                .addGap(18, 18, 18)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );

        jTabbedPane4.addTab("Traitement", jPanel9);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail"));

        Prd.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Prd.setText("Produit ");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Prescriptions");

        Tb_Cardex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_cardex", "Date", "Heure", "Observation"
            }
        ));
        Tb_Cardex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_CardexMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(Tb_Cardex);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/button_ok.png"))); // NOI18N
        jButton7.setText("Valider");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel19.setText("TC");

        TC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TC1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel20.setText("Observation");

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/b_usredit.png"))); // NOI18N
        jButton8.setText("Modification");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel21.setText("TAD");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel22.setText("TAS");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel25.setText("FC");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel26.setText("Heure");

        qt_car.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        qt_car.setText("Qt");

        Presciption.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Presciption.setText("Prescription");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel40.setText(" FR");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel41.setText("SaO 2");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel42.setText("Glycemie");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addComponent(Prd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addComponent(Presciption, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qt_car, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(obs_cardex, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(TC1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(TS1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TD1)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(FC1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(FR1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SaO1)
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(glycemie1)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Heure_cardex4)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(Prd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(qt_car)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Presciption)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addGap(7, 7, 7)
                            .addComponent(TS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addGap(7, 7, 7)
                            .addComponent(TC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addGap(7, 7, 7)
                            .addComponent(TD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addComponent(jLabel40)
                                    .addGap(7, 7, 7)
                                    .addComponent(FR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                                    .addComponent(jLabel41)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SaO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(7, 7, 7)
                                .addComponent(glycemie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addGap(7, 7, 7)
                            .addComponent(FC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(obs_cardex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Heure_cardex4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Cardex des soins", jPanel12);

        Tab_Fac.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        Tab_Fac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "Consultantion + Visites médicales ", null, null, null},
                {null, "Radiologie", null, null, null},
                {null, "ECG", null, null, null},
                {null, "Echographie", null, null, null},
                {null, "Echographie cardiaque", null, null, null},
                {null, "Gastroscopie", null, null, null},
                {null, "Rectoscopie", null, null, null},
                {null, "Laboratoire", null, null, null},
                {null, "Actes médicaux", null, null, null},
                {null, "Actes chirurgicaux", null, null, null},
                {null, "Anesthésiste", null, null, null},
                {null, "accouchement", null, null, null},
                {null, "Médicament + Perfusion ", null, null, null},
                {null, "Kinésithérapie", null, null, null},
                {null, "Actes infirmiers +soins", null, null, null},
                {null, "Occupation chambre", null, null, null},
                {null, "Frais administratifs", null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_H", "Prestation", "Quantité", "Prix Unitaire/$", "Prix Total/$"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tab_Fac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tab_FacMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(Tab_Fac);
        if (Tab_Fac.getColumnModel().getColumnCount() > 0) {
            Tab_Fac.getColumnModel().getColumn(2).setHeaderValue("Quantité");
            Tab_Fac.getColumnModel().getColumn(3).setHeaderValue("Prix Unitaire/$");
        }

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel14.setText("Total Global : ");

        TG.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        TG.setText("........................");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel23.setText("$");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel27.setText("Caution versée:");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel28.setText("$");

        CV.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        CV.setText("0");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel29.setText("Solde Net à payer:");

        SNP.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        SNP.setText("........................");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel30.setText("$");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel31.setText("Somme remboursée :");

        SR.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        SR.setText("0");

        jLabel32.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel32.setText("$");

        user_fac.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        user_fac.setText("........................");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jLabel34.setText("Date");

        Date_fac.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        Date_fac.setText("........................");

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/b_edit.png"))); // NOI18N
        jButton9.setText("Modification ");
        jButton9.setToolTipText("");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        Pres.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N

        qt_mod.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N

        pu_mod.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Save16.png"))); // NOI18N
        jButton10.setText("Enregestrer");
        jButton10.setToolTipText("");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/DeleteHS.png"))); // NOI18N
        jButton14.setText("Supprimer");
        jButton14.setToolTipText("");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        Prestation.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        Prestation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Consultation", "Laboratoire", "Examen Speciaux", "Produit pharmacietique","Actes medicaux","Actes chirurgicaux et Anesthèsiste","Hospitalisation et soins medicaux","Accouchemnt" }));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)
                        .addGap(28, 28, 28)
                        .addComponent(jButton14))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(TG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23))
                    .addComponent(user_fac, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Date_fac, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addComponent(Prestation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Pres, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(qt_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pu_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(SR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(CV, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(18, 18, 18)
                                .addComponent(SNP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel32)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qt_mod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pu_mod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Prestation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TG)
                        .addComponent(jLabel23))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(CV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(SNP)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(SR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(user_fac, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(Date_fac))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Honoraire", jPanel13);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel15.setText("Total Global : ");

        TG1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        TG1.setText("........................");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel24.setText("$");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel33.setText("Caution versée:");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel35.setText("$");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel36.setText("Solde Net à payer:");

        SNP1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        SNP1.setText("........................");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel37.setText("$");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel38.setText("Somme remboursée :");

        jLabel39.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel39.setText("$");

        Tab_Fac1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        Tab_Fac1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "Consultantion + Visites médicales ", null},
                {null, "Laboratoire", null},
                {null, "Examen Speciaux", null},
                {null, "Produit pharmacietique", null},
                {null, "Actes medicaux", null},
                {null, "Actes chirurgicaux et Anesthèsiste", null},
                {null, "Hospitalisation et soins medicaux", null},
                {null, "Accouchemnt ", null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Prestation", "Prix /$"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tab_Fac1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tab_Fac1MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(Tab_Fac1);

        CV1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        CV1.setText("........................");

        SR1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        SR1.setText("........................");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(TG1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(SNP1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel37))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(CV1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(SR1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TG1)
                        .addComponent(jLabel24))
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(CV1)
                    .addComponent(jLabel35))
                .addGap(17, 17, 17)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(SNP1)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38)
                    .addComponent(SR1))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(15, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Facture", jPanel15);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, 0, 661, Short.MAX_VALUE)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 661, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultation", jPanel1);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Liste des évolutions"));

        Tb_evolution.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "docteur"
            }
        ));
        Tb_evolution.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_evolutionMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(Tb_evolution);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail"));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Diagnostique");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("LABO");

        Tb_labo_ev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom de l'examen", "Type de l'examen", "Valeur labo"
            }
        ));
        jScrollPane12.setViewportView(Tb_labo_ev);

        jScrollPane13.setViewportView(Diag_ev);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Imagerie");

        Tb_imagerie_ev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom de l'examen", "Type de l'examen", "Valeur labo"
            }
        ));
        Tb_imagerie_ev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_imagerie_evMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(Tb_imagerie_ev);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Analyse", jPanel21);

        Tb_Traitement_ev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicament"
            }
        ));
        Tb_Traitement_ev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_Traitement_evMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(Tb_Traitement_ev);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detaille de traitement"));

        jScrollPane17.setViewportView(Traitement_tx1);

        User_nam9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        User_nam9.setText("Quantité");

        jScrollPane47.setViewportView(Qt2);

        jScrollPane43.setViewportView(mode_emploie1);

        User_nam10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        User_nam10.setText("Detail du traitement");

        User_nam11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        User_nam11.setText("Medicament");

        jScrollPane48.setViewportView(Prix_traitement1);

        User_nam12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        User_nam12.setText("Prix");

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/b_edit.png"))); // NOI18N
        jButton16.setText("Modifier");
        jButton16.setToolTipText("");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jButton16)
                        .addContainerGap())
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(User_nam11, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                .addGap(120, 120, 120))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(User_nam10, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addGap(114, 114, 114))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                    .addGroup(jPanel23Layout.createSequentialGroup()
                                        .addGap(0, 2, Short.MAX_VALUE)
                                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(User_nam12, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(jScrollPane48, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(User_nam9, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                .addComponent(jScrollPane47)))
                        .addGap(25, 25, 25))))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(User_nam11)
                    .addComponent(User_nam9))
                .addGap(16, 16, 16)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane47, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jScrollPane17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(User_nam10)
                    .addComponent(User_nam12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane43, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jScrollPane48))
                .addGap(18, 18, 18)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );

        jTabbedPane7.addTab("Traitement", jPanel22);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jTabbedPane7, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 797, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab(" Evolution", jPanel10);

        id.setText(".");

        jMenu3.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Reports.png"))); // NOI18N
        jMenuItem2.setText("Honoraire");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Reports.png"))); // NOI18N
        jMenuItem1.setText("Facture");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar2.add(jMenu3);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(id)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        affectation ();
        if( "".equals(date)||"".equals(heure)||"".equals(tc)||"".equals(tas)||"".equals(tad)||"".equals(fc)||"".equals(fr)||"".equals(poid))
    {
        JOptionPane.showMessageDialog(null, "Champs vide", "Erreur", JOptionPane.WARNING_MESSAGE);
    }else{
            o="C/"+o;
        sv_enreg.enr_sv(id_psv, date, heure, tc, tas, tad, fc, fr, o, poid);
        affichage ();
        vide();
     }
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        affectation ();
   if( "".equals(date)||"".equals(heure)||"".equals(tc)||"".equals(tas)||"".equals(tad)||"".equals(fc)||"".equals(fr)||"".equals(poid))
    {
        JOptionPane.showMessageDialog(null, "Champs vide", "Erreur", JOptionPane.WARNING_MESSAGE);
    }else{
            try {
                sv_mofi.modif_sv(id_sv,id_psv, date, heure, tc, tas, tad, fc, fr, o, poid);
                affichage ();
                vide();
            } catch (SQLException ex) {
                Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
    
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
    sv_sup.sup_sv(id_sv);
    vide();
    affichage ();
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    Liste_Patient lp= new Liste_Patient();
    Dimension tailleEcran= Toolkit.getDefaultToolkit().getScreenSize();// Recuperation de la taille de l'ecran
    int H=tailleEcran.height;
    int L=tailleEcran.width;
    lp.setSize(L, H);//Longeure et Hauteur l'ecran
    lp.setLocationRelativeTo(null);//Permet de centrer le JFrame
    lp.setVisible(true);
    lp.user(Id_User.getText(), User_nam.getText());
    this.setVisible(false);
}//GEN-LAST:event_jButton1ActionPerformed

private void Tb_TraitementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_TraitementMouseClicked
// TODO add your handling code here:
   ligne_select= Tb_Traitement.getSelectedRowCount();//Nombre de lignes selectionner
   in= Tb_Traitement.getSelectedRow();
   if(ligne_select==1)
   {
     Traitement_tx.setText((String)Tb_Traitement.getModel().getValueAt(in, 1));
     Qt1.setText((String)Tb_Traitement.getModel().getValueAt(in, 2));
     mode_emploie.setText((String)Tb_Traitement.getModel().getValueAt(in, 3));
     Prix_traitement.setText((String)Tb_Traitement.getModel().getValueAt(in, 4));
     id_traitement=(String)Tb_Traitement.getModel().getValueAt(in, 0);
     
    // Affectation 
     Prd.setText("Produit: "+(String)Tb_Traitement.getModel().getValueAt(in, 1));
     qt_car.setText("Quantité: "+(String)Tb_Traitement.getModel().getValueAt(in, 2));
     Presciption.setText("Mode d'emploie: "+(String)Tb_Traitement.getModel().getValueAt(in, 3));
     
     affichage_cardex (id_cons, id_traitement); 
   }
    
}//GEN-LAST:event_Tb_TraitementMouseClicked

private void Tb_consultationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_consultationMouseClicked
  // TODO add your handling code here:
 // Lorsqu'on selectione sur le tableau
   ligne_select= Tb_consultation.getSelectedRowCount();//Nombre de lignes selectionner
   in= Tb_consultation.getSelectedRow();
   if(ligne_select==1)
   {  String nom_doc;  
     //Affichage des valeur du tableau dans les champs
     id_cons=(String)Tb_consultation.getModel().getValueAt(in, 0);// On recuper le id du tableau
     Plainte1.setText((String)Tb_consultation.getModel().getValueAt(in, 2));
     Plainte2.setText((String)Tb_consultation.getModel().getValueAt(in, 3));
     Diag.setText((String)Tb_consultation.getModel().getValueAt(in, 5));
     //Affichage des informations du labo dans la table Tb_labo
     try { 
         state = (Statement) connection.getInstance().createStatement();
         result = state.executeQuery("SELECT * FROM labo WHERE Id_pa='"+id_psv+"' AND Id_cons='"+id_cons+"';");// Pour le labo    
             //affichage de la Laboratoir
                   DefaultTableModel Table3=  (DefaultTableModel) Tb_labo.getModel();
                   Table3.setColumnCount(0);
                   Table3.addColumn("N°");
                   Table3.addColumn("Examen");
                   Table3.addColumn("Valeur labo");
                   Table3.addColumn("Prix");
                   Table3.setRowCount(0);
                   while (result.next())
                      {//
                            Object[] objets= new Object[4];
                            objets[0]= result.getString("Id_la");
                            objets[1]= result.getString("Type_ex");
                            objets[2]= result.getString("Valeur");
                            objets[3]= result.getString("prix");
                            Table3.addRow(objets);
                      }
                   
              //affichage de la Imageri
                   state2 = (Statement) connection.getInstance().createStatement();
                   result2 = state.executeQuery("SELECT * FROM imagerie WHERE  Id_cons='"+id_cons+"';");// Pour l'imagirie
                   DefaultTableModel Table4=  (DefaultTableModel) Tb_imagerie.getModel();
                   Table4.setColumnCount(0);
                   Table4.addColumn("N°");
                   Table4.addColumn("Examen Demandé");
                   Table4.addColumn("REC");
                   Table4.addColumn("Interpretation");
                   Table4.setRowCount(0);
                   while (result2.next())
                      {//
                            Object[] objets= new Object[4];
                            //Id_im
                            objets[0]= result2.getString("Id_im");
                            objets[1]= result2.getString("Exd");
                            objets[2]= result2.getString("Rec");
                            objets[3]= result2.getString("Interpretation");
                            Table4.addRow(objets);
                      }
        } catch (SQLException ex) {
            Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
        }
     affichage_table_traitement(id_psv, id_cons);
     affichage_table_honoraire(id_cons);
     affichage_table_evolution(id_psv, id_cons);
     affichage_table_facture(id_cons);
     valider();
     vide();
   } 
    
}//GEN-LAST:event_Tb_consultationMouseClicked

private void PoidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PoidActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_PoidActionPerformed

private void Tb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb2MouseClicked
// TODO add your handling code here:
   vide();
   ligne_select= Tb2.getSelectedRowCount();//Nombre de lignes selectionner
   in= Tb2.getSelectedRow();
   if(ligne_select==1)
   {
     id_sv=(String)Tb2.getModel().getValueAt(in, 0);
     date=((String) Tb2.getModel().getValueAt(in, 1));
     Heure.setText((String) Tb2.getModel().getValueAt(in, 2));
     TC.setText((String) Tb2.getModel().getValueAt(in, 3));
     TAS.setText((String) Tb2.getModel().getValueAt(in, 4));
     TAD.setText((String) Tb2.getModel().getValueAt(in, 5));
     FC.setText((String) Tb2.getModel().getValueAt(in, 6));
     FR.setText((String) Tb2.getModel().getValueAt(in, 7));
     O.setText((String) Tb2.getModel().getValueAt(in, 9));
     Poid.setText((String) Tb2.getModel().getValueAt(in, 8));
   }
   
}//GEN-LAST:event_Tb2MouseClicked

private void Tb_imagerieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_imagerieMouseClicked
// TODO add your handling code here:
   ligne_select= Tb_imagerie.getSelectedRowCount();//Nombre de lignes selectionner
   in= Tb_imagerie.getSelectedRow();
   
   if(ligne_select==1)
   {
     //interpretation.setText((String)Tb_imagerie.getModel().getValueAt(in, 3));
     //jLabel1.setText((String)Tb_imagerie.getModel().getValueAt(in, 0));
   }
}//GEN-LAST:event_Tb_imagerieMouseClicked

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    // Lorsqu'on selectione sur le tableau
   ligne_select= Tb_consultation.getSelectedRowCount();//Nombre de lignes selectionner
   in= Tb_consultation.getSelectedRow();
   
   if(ligne_select==1)
   {  String nom_doc;  
     //Affichage des valeur du tableau dans les champs
    Dimension tailleEcran= Toolkit.getDefaultToolkit().getScreenSize();// Recuperation de la taille de l'ecran
    int H=tailleEcran.height;
    int L=tailleEcran.width;
     id_cons=(String)Tb_consultation.getModel().getValueAt(in, 0);// On recuper le id du tableau
     Ev Eva= new Ev();
     Eva.info_patient(id_cons,id_psv, Nom_p.getText(), Postnom_p.getText(), Prenom_p.getText(), Sexe_p.getText(), EC_p.getText(), Dn_p.getText(), A_p.getText(), Ph_p.getText(), Pr_p.getText(), Em_p.getText(),ATCD_1.getText());
     //Eva.setLocationRelativeTo(null);//Permet de centrer le JFrame
    Eva.user(Id_User.getText(), User_nam.getText());
     Eva.setSize(L, H);//Longeure et Hauteur l'ecran
     Eva.setVisible(true);
     this.setVisible(false);
     
   }else{
       JOptionPane.showMessageDialog(null, "Selectionez une consultation", "Erreur", JOptionPane.WARNING_MESSAGE);
   }
    
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
// TODO add your handling code here:
    if( "Produit".equals(Prd.getText()))// Champ est Vide
        {
         JOptionPane.showMessageDialog(null, "Champs vide", "Erreur", JOptionPane.WARNING_MESSAGE);
        }else{
          affectation();
                try {
                    sv_enreg.enr_cardex(id_cons, id_traitement,TC1.getText(),TS1.getText(),TD1.getText(),FC1.getText(),FR1.getText(),SaO1.getText(),glycemie1.getText(), date, Heure_cardex4.getText(), obs_cardex.getText());
                    TC1.setText("");
                    TS1.setText("");
                    TD1.setText("");
                    FC1.setText("");
                    FR1.setText("");
                    SaO1.setText("");
                    glycemie1.setText("");
                    Heure_cardex4.setText("");
                    obs_cardex.setText("");
                } catch (SQLException ex) {
                    Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
                }
               }
    affichage_cardex (id_cons, id_traitement);
}//GEN-LAST:event_jButton7ActionPerformed

private void Tb_CardexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_CardexMouseClicked
// TODO add your handling code here:
       ligne_select= Tb_Cardex.getSelectedRowCount();//Nombre de lignes selectionner
       in= Tb_Cardex.getSelectedRow();
       if(ligne_select==1)
        {
            Heure_cardex4.setText((String)Tb_Cardex.getModel().getValueAt(in, 2));
            obs_cardex.setText((String)Tb_Cardex.getModel().getValueAt(in, 3)); 
            TC1.setText((String)Tb_Cardex.getModel().getValueAt(in, 4));
            TS1.setText((String)Tb_Cardex.getModel().getValueAt(in, 5)); 
            TD1.setText((String)Tb_Cardex.getModel().getValueAt(in, 6));
            FC1.setText((String)Tb_Cardex.getModel().getValueAt(in, 7)); 
            FR1.setText((String)Tb_Cardex.getModel().getValueAt(in, 8));
            SaO1.setText((String)Tb_Cardex.getModel().getValueAt(in, 9)); 
            glycemie1.setText((String)Tb_Cardex.getModel().getValueAt(in, 10));
        }

}//GEN-LAST:event_Tb_CardexMouseClicked

private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
// TODO add your handling code here:
    if( "".equals(TC1.getText())||"".equals(obs_cardex.getText()))
    {
        JOptionPane.showMessageDialog(null, "Champs vide", "Erreur", JOptionPane.WARNING_MESSAGE);
    }else{
            try {
                    ligne_select= Tb_Traitement.getSelectedRowCount();//Nombre de lignes selectionner
                    in= Tb_Traitement.getSelectedRow();
                    String id_cardex=(String)Tb_Cardex.getModel().getValueAt(in, 0);
                    if(ligne_select==1)
                      {
                        cardex_mofi.modif_cardex(id_cardex,TC1.getText(),TS1.getText(),TD1.getText(),FC1.getText(),FR1.getText(),SaO1.getText(),glycemie1.getText(), Heure_cardex4.getText(), obs_cardex.getText());
                        TD1.setText("");
                        TS1.setText(""); 
                        FC1.setText("");
                        TC1.setText(""); 
                        Heure_cardex4.setText("");
                        obs_cardex.setText("");
                      }
                } catch (SQLException ex) {
                Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
            }
            affichage_cardex (id_cons, id_traitement);
     }
}//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // Lorsqu'on selectione sur le tableau
   ligne_select= Tb_consultation.getSelectedRowCount();//Nombre de lignes selectionner
   in= Tb_consultation.getSelectedRow();
   
   if(ligne_select==1)
   {
       id_cons=(String)Tb_consultation.getModel().getValueAt(in, 0);// On recuper le id du tableau
       // Recuperation du total des examen du labo
       double labo_cal=0;
       double labo_prix1=0;
       String labo_prix="";
       compt=Tb_labo.getRowCount();
       if (compt>0){
                for (int i=0; i<compt; i++) //linge
                  {  
                    labo_prix= (String) Tb_labo.getModel().getValueAt(i,3);
                    if(labo_prix!=null){
                        labo_prix1=new Double(labo_prix);
                    }
                    labo_cal=labo_cal+labo_prix1;
                    
                  }
       }
       labo_prix=String.valueOf(labo_cal);
        fac.info_patient(id_cons,id.getText(), Nom_p.getText(), Postnom_p.getText(), Prenom_p.getText(), Sexe_p.getText(), Dn_p.getText(), EC_p.getText(), A_p.getText(), Ph_p.getText(), Pr_p.getText(), Em_p.getText(),ATCD_1.getText(),labo_prix);
        Dimension tailleEcran= Toolkit.getDefaultToolkit().getScreenSize();// Recuperation de la taille de l'ecran
        int H=tailleEcran.height;
        int L=tailleEcran.width;
        fac.setSize(L, H);//Longeure et Hauteur l'ecran
        fac.setLocationRelativeTo(null);//Permet de centrer le JFrame
        fac.setVisible(true);
        fac.user(Id_User.getText(), User_nam.getText());
        this.setVisible(false);
          
   }else {
    JOptionPane.showMessageDialog(null, "Selectionez une consultation pour faire la facture", "Erreur", JOptionPane.WARNING_MESSAGE);
   }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void Tab_FacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_FacMouseClicked
        // TODO add your handling code here:
        // Lorsqu'on selectione sur le tableau
   ligne_select= Tab_Fac.getSelectedRowCount();//Nombre de lignes selectionner
   in= Tab_Fac.getSelectedRow();
   
   if(ligne_select==1)
   {
       id_ho=(String)Tab_Fac.getModel().getValueAt(in, 0);
       Pres.setText((String)Tab_Fac.getModel().getValueAt(in, 1));
       qt_mod.setText((String)Tab_Fac.getModel().getValueAt(in, 2));
       pu_mod.setText((String)Tab_Fac.getModel().getValueAt(in, 3));
   }
    }//GEN-LAST:event_Tab_FacMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
   ligne_select= Tb_consultation.getSelectedRowCount();//Nombre de lignes selectionner
   in= Tb_consultation.getSelectedRow();
   Imprsion_Facture Facture = new Imprsion_Facture();
   
   
   if(ligne_select==1)
   {
       id_cons=(String)Tb_consultation.getModel().getValueAt(in, 0);
        Facture.info(id_cons, Nom_p.getText(), Postnom_p.getText(), Sexe_p.getText(), EC_p.getText(),TG.getText(), CV.getText(), SNP.getText(), SR.getText());
        Facture.setVisible(true);
   }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        Imprsion imp= new Imprsion ();
        imp.info(id_cons, Nom_p.getText(), Postnom_p.getText(), TG.getText(), CV.getText(), SNP.getText(), SR.getText());  
        imp.setVisible(true);
        //imp.user(Id_User.getText(), User_nam.getText());
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        //MODIFICATION DE LA NOTE  D'HONORAIRE         
         try {           
                prestation=Pres.getText();
                qte=qt_mod.getText();
                pu=pu_mod.getText();
                compt=Tab_Fac.getRowCount();
                double pt3=0;
                double qte2= new Double(qte);
                double pu2= new Double(pu);
                if(!"".equals(prestation) && !"".equals(qte) && !"".equals(pu))
                     {
                                pt3=qte2*pu2;// PRIX TOTA
                                sv_mofi.honoriare(prestation, qte2, pu2, pt3, id_ho);// Honoraire
                                String pt4=String.valueOf(pt3);
                                valider();
                                String txt1=user_fac.getText();
                                String txt2=User_nam.getText();
                                String User_mod = "Facturer par"+txt1+" Modifier par "+txt2;
                                sv_mofi.Total(TG.getText(), CV.getText(), SNP.getText(), SR.getText(), id_cons, User_mod);// Total 
                                Pres.setText("");
                                qt_mod.setText("");
                                pu_mod.setText("");
                                affichage_table_honoraire(id_cons);
                                affichage_table_facture(id_cons); 
                     }
        
         } catch (SQLException ex) {
             Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Les information ont été mal saisie", "Erreur", JOptionPane.WARNING_MESSAGE);   
         }

       
    }//GEN-LAST:event_jButton9ActionPerformed

    private void Tab_Fac1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_Fac1MouseClicked
        // TODO add your handling code here:
          // Lorsqu'on selectione sur le tableau
   ligne_select= Tab_Fac1.getSelectedRowCount();//Nombre de lignes selectionner
   in= Tab_Fac1.getSelectedRow();
   
   if(ligne_select==1)
   {
       id_fac=(String)Tab_Fac1.getModel().getValueAt(in, 0);
      
   }
    }//GEN-LAST:event_Tab_Fac1MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //AJOUT D'unEnregistrement
        // En cas d'ajour d'une prestation 
        try {           
                prestation=Pres.getText();
                qte=qt_mod.getText();
                pu=pu_mod.getText();
                compt=Tab_Fac.getRowCount();
                double pt3=0;
                double qte2= new Double(qte);
                double pu2= new Double(pu);
                if(!"".equals(prestation) && !"".equals(qte) && !"".equals(pu))
                     {
                                pt3=qte2*pu2;// PRIX TOTA
                                sv_enreg.enr_honoraire(prestation, qte2, pu2, pt3, id_cons);// Honorair
                                String pt4=String.valueOf(pt3);
                                valider();
                                String txt1=user_fac.getText();
                                String txt2=User_nam.getText();
                                String User_mod =txt1+" / "+txt2;
                                sv_mofi.Total(TG.getText(), CV.getText(), SNP.getText(), SR.getText(), id_cons, User_mod);// Total 
                                
                                // Modification ou Enregistrement Facture
                                for (int i=0; i>compt; i++)
                                {
                                    if(Prestation.getSelectedItem().toString() == null ? (String)Tab_Fac1.getModel().getValueAt(i, 1) == null : Prestation.getSelectedItem().toString().equals((String)Tab_Fac1.getModel().getValueAt(i, 1)))
                                    {
                                        String prix_fac=(String)Tab_Fac1.getModel().getValueAt(i, 1);
                                        Double Prix_fac= new Double (prix_fac);
                                        Double Prix_fac_T;
                                        String Val =JOptionPane.showInputDialog(null, "La différence");
                                        if(Val=="-"){
                                            Prix_fac_T=pt3-Prix_fac;
                                            sv_mofi.facture(Prestation.getSelectedItem().toString(), Prix_fac_T);// Facturre   
                                        }
                                        
                                    }
                                    else{
                                         sv_enreg.enr_facture(id_cons, Prestation.getSelectedItem().toString(), pt4);
                                    }
                                }
                                
                                
                                Pres.setText("");
                                qt_mod.setText("");
                                pu_mod.setText("");
                                affichage_table_honoraire(id_cons);
                                affichage_table_facture(id_cons); 
                                valider();
                     }
               
                     } catch (SQLException ex) {
                             Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
                         }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        try {
                sv_sup.sup_honoraire(id_ho);
                sv_sup.sup_facture(id_fac);
                valider();
                String txt1=user_fac.getText();
                String txt2=User_nam.getText();
                String User_mod = "Facturer par"+txt1+" Modifier par "+txt2;
                sv_mofi.Total(TG.getText(), CV.getText(), SNP.getText(), SR.getText(), id_cons, User_mod);// Total 
                Pres.setText("");
                qt_mod.setText("");
                pu_mod.setText("");
                affichage_table_honoraire(id_cons);
                affichage_table_facture(id_cons); 
                valider();
        } catch (SQLException ex) {
             Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
   int ligne_select= Tb_Traitement.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_Traitement.getSelectedRow();
   String Id_tr,Prix_Traitement;
   if(ligne_select==1)
   {
      Id_tr=(String)Tb_Traitement.getModel().getValueAt(in, 0);
      Prix_Traitement=Prix_traitement.getText();
            try {
                sv_mofi.modif_traitement(Id_tr, Prix_Traitement);
            } catch (SQLException ex) {
                Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
            }
            Traitement_tx.setText("");
            Qt1.setText("");
            mode_emploie.setText("");
            Prix_traitement.setText("");
            affichage_table_traitement(id_psv, id_cons);
   }else {
       JOptionPane.showMessageDialog(null, "Selectionnez un traitement", "Erreur", JOptionPane.WARNING_MESSAGE);
   }

    }//GEN-LAST:event_jButton15ActionPerformed

private void TC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TC1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_TC1ActionPerformed

    private void Tb_evolutionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_evolutionMouseClicked
   // TODO add your handling code here:
  // Lorsqu'on selectione sur le tableau
   ligne_select= Tb_evolution.getSelectedRowCount();//Nombre de lignes selectionner
   in= Tb_evolution.getSelectedRow();
   if(ligne_select==1)
   {  String nom_doc;  
     //Affichage des valeur du tableau dans les champs
     id_ev=(String)Tb_evolution.getModel().getValueAt(in, 0);// On recuper le id du tableau
     Diag_ev.setText((String)Tb_evolution.getModel().getValueAt(in, 3)); 
     //Affichage des informations du labo dans la table Tb_labo
     try { 
         state = (Statement) connection.getInstance().createStatement();
         result = state.executeQuery("SELECT * FROM labo WHERE Id_pa='"+id_psv+"' AND Id_ev='"+id_ev+"';");// Pour le labo    
             //affichage de la Laboratoir
                   DefaultTableModel Table3=  (DefaultTableModel) Tb_labo_ev.getModel();
                   Table3.setColumnCount(0);
                   Table3.addColumn("N°");
                   Table3.addColumn("Examen");
                   Table3.addColumn("Valeur labo");
                   Table3.addColumn("Prix");
                   Table3.setRowCount(0);
                   while (result.next())
                      {//
                            Object[] objets= new Object[4];
                            objets[0]= result.getString("Id_la");
                            objets[1]= result.getString("Type_ex");
                            objets[2]= result.getString("Valeur");
                            objets[3]= result.getString("prix");
                            Table3.addRow(objets);
                      }
                   
              //affichage de la Imageri
                   state2 = (Statement) connection.getInstance().createStatement();
                   result2 = state.executeQuery("SELECT * FROM imagerie WHERE  Id_ev='"+id_ev+"';");// Pour l'imagirie
                   DefaultTableModel Table4=  (DefaultTableModel) Tb_imagerie_ev.getModel();
                   Table4.setColumnCount(0);
                   Table4.addColumn("N°");
                   Table4.addColumn("Examen Demandé");
                   Table4.addColumn("REC");
                   Table4.addColumn("Interpretation");
                   Table4.setRowCount(0);
                   while (result2.next())
                      {//
                            Object[] objets= new Object[4];
                            //Id_im
                            objets[0]= result2.getString("Id_im");
                            objets[1]= result2.getString("Exd");
                            objets[2]= result2.getString("Rec");
                            objets[3]= result2.getString("Interpretation");
                            Table4.addRow(objets);
                      }
                   affichage_table_traitement(id_psv, id_cons);
        } catch (SQLException ex) {
            Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    }//GEN-LAST:event_Tb_evolutionMouseClicked

    private void Tb_imagerie_evMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_imagerie_evMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tb_imagerie_evMouseClicked

    private void Tb_Traitement_evMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_Traitement_evMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tb_Traitement_evMouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

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
            java.util.logging.Logger.getLogger(Sv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Sv().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ATCD_1;
    private javax.swing.JLabel A_p;
    private javax.swing.JTextField CV;
    private javax.swing.JLabel CV1;
    private javax.swing.JLabel Date_fac;
    private javax.swing.JTextPane Diag;
    private javax.swing.JTextPane Diag_ev;
    private javax.swing.JLabel Dn_p;
    private javax.swing.JLabel EC_p;
    private javax.swing.JLabel Em_p;
    private javax.swing.JTextField FC;
    private javax.swing.JTextField FC1;
    private javax.swing.JTextField FR;
    private javax.swing.JTextField FR1;
    private javax.swing.JTextField Heure;
    private javax.swing.JTextField Heure_cardex4;
    private javax.swing.JLabel Id_User;
    private javax.swing.JLabel Nom_p;
    private javax.swing.JTextField O;
    private javax.swing.JLabel Ph_p;
    private javax.swing.JTextPane Plainte1;
    private javax.swing.JTextPane Plainte2;
    private javax.swing.JTextField Poid;
    private javax.swing.JLabel Postnom_p;
    private javax.swing.JLabel Pr_p;
    private javax.swing.JLabel Prd;
    private javax.swing.JLabel Prenom_p;
    private javax.swing.JTextField Pres;
    private javax.swing.JLabel Presciption;
    private javax.swing.JComboBox Prestation;
    private javax.swing.JTextPane Prix_traitement;
    private javax.swing.JTextPane Prix_traitement1;
    private javax.swing.JTextPane Qt1;
    private javax.swing.JTextPane Qt2;
    private javax.swing.JLabel SNP;
    private javax.swing.JLabel SNP1;
    private javax.swing.JTextField SR;
    private javax.swing.JLabel SR1;
    private javax.swing.JTextField SaO1;
    private javax.swing.JLabel Sexe_p;
    private javax.swing.JTextField TAD;
    private javax.swing.JTextField TAS;
    private javax.swing.JTextField TC;
    private javax.swing.JTextField TC1;
    private javax.swing.JTextField TD1;
    private javax.swing.JLabel TG;
    private javax.swing.JLabel TG1;
    private javax.swing.JTextField TS1;
    private javax.swing.JTable Tab_Fac;
    private javax.swing.JTable Tab_Fac1;
    private javax.swing.JTable Tb2;
    private javax.swing.JTable Tb_Cardex;
    private javax.swing.JTable Tb_Traitement;
    private javax.swing.JTable Tb_Traitement_ev;
    private javax.swing.JTable Tb_consultation;
    private javax.swing.JTable Tb_evolution;
    private javax.swing.JTable Tb_imagerie;
    private javax.swing.JTable Tb_imagerie_ev;
    private javax.swing.JTable Tb_labo;
    private javax.swing.JTable Tb_labo_ev;
    private javax.swing.JTextPane Traitement_tx;
    private javax.swing.JTextPane Traitement_tx1;
    private javax.swing.JLabel User_nam;
    private javax.swing.JLabel User_nam10;
    private javax.swing.JLabel User_nam11;
    private javax.swing.JLabel User_nam12;
    private javax.swing.JLabel User_nam5;
    private javax.swing.JLabel User_nam6;
    private javax.swing.JLabel User_nam7;
    private javax.swing.JLabel User_nam8;
    private javax.swing.JLabel User_nam9;
    private javax.swing.JLabel adresseLabel;
    private javax.swing.JLabel dnLabel;
    private javax.swing.JLabel ecLabel;
    private javax.swing.JLabel employeurLabel;
    private javax.swing.JLabel employeurLabel1;
    private javax.swing.JTextField glycemie1;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTextPane mode_emploie;
    private javax.swing.JTextPane mode_emploie1;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JTextField obs_cardex;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel postnomLabel;
    private javax.swing.JLabel prenomLabel;
    private javax.swing.JLabel professionLabel;
    private javax.swing.JTextField pu_mod;
    private javax.swing.JLabel qt_car;
    private javax.swing.JTextField qt_mod;
    private javax.swing.JLabel sexeLabel;
    private javax.swing.JLabel user_fac;
    // End of variables declaration//GEN-END:variables

    
}
