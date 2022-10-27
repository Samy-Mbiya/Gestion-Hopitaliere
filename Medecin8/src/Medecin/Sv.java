/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Sv.java
 *
 * Created on 9 août 2018, 13:35:18
 */
package Medecin;
import com.mysql.jdbc.Statement;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Samy-MBIYA
 */
public class Sv extends javax.swing.JFrame {
     public String id_psv,nom, postnom, prenom, sexe, dn, ec, ad, ph, pr, em;
     public String id_sv,date, heure,Traitement,mode_emploi, tc, tas, tad, fc, fr, o, poid, date1;
     public String id_cons,Id_pr1,id_ph, dig, user1,Id_ev, Id_pharmacie;
     public int ligne_select1;
     private Statement state,state2;
     private ResultSet result,result2;
     protected Enregistrement enregistrement=new Enregistrement();
     protected Modification modification=new Modification();
     //protected Modification ev_mofi=new Modification();
     protected Suppression suppression=new Suppression();
     protected Date da=new Date();
     protected Impression impression =new Impression();
     private JTextArea mode;
     private JLabel lab;

    /** Creates new form Sv */
    public Sv() {
        initComponents();
        jLabel1.setVisible(false);
    }

public void info_patient (String Id_pr1,String user1,String id_p,String nom,String postnom, String prenom,String sexe,String dn, String ec,String adresse, String phone, String profession,String employeur, String ATCD_p)
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
    ATCD_P.setText(ATCD_p);
    user(Id_pr1, user1);
    try { 
        //affichage de la SV
        state = (Statement) connection.getInstance().createStatement();
         result = state.executeQuery("SELECT* FROM  sv WHERE Id_pa='"+id_p+"' ORDER BY Id_sv DESC;");
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
                   Table2.addColumn("Doc");
                   Table2.addColumn("S");
                   Table2.addColumn("ATCD");
                   Table2.addColumn("HMA");
                   Table2.addColumn("CA");
                    Table2.addColumn("EP");
                   Table2.addColumn("A");
                   Table2.addColumn("CAT");
                   Table2.setRowCount(0);
                   while (result.next())
                      {//
                            Object[] objets= new Object[10];
                            objets[0]= result.getString("Id_consultation");
                            objets[1]= result.getString("Date");
                            objets[2]= result.getString("Nom");
                            objets[3]= result.getString("s");
                            objets[4]= result.getString("ATCD");
                            objets[5]= result.getString("HMA");
                            objets[6]= result.getString("CA");
                            objets[7]= result.getString("EP");
                            objets[8]= result.getString("A");
                            objets[9]= result.getString("CAT");
                            Table2.addRow(objets);
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
        jPanel13 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        ATCD_P = new javax.swing.JTextArea();
        jButton18 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        User_nam = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tb2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tb_consultation = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Doc_nam = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        Date_consultation = new javax.swing.JTextArea();
        jButton20 = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        s = new javax.swing.JTextPane();
        jScrollPane15 = new javax.swing.JScrollPane();
        ATCD = new javax.swing.JTextPane();
        jScrollPane16 = new javax.swing.JScrollPane();
        HMA = new javax.swing.JTextPane();
        jScrollPane17 = new javax.swing.JScrollPane();
        CA = new javax.swing.JTextPane();
        jScrollPane18 = new javax.swing.JScrollPane();
        EP = new javax.swing.JTextPane();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        A = new javax.swing.JTextPane();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tb_labo = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        Tb_imagerie = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jScrollPane20 = new javax.swing.JScrollPane();
        Valeur_labo = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        interpretation = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        Traitement1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Traitement_tx = new javax.swing.JTextPane();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane42 = new javax.swing.JScrollPane();
        mode_emploie = new javax.swing.JTextPane();
        User_nam5 = new javax.swing.JLabel();
        User_nam6 = new javax.swing.JLabel();
        jScrollPane45 = new javax.swing.JScrollPane();
        Qt1 = new javax.swing.JTextPane();
        User_nam7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tb_Traitement = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Tb_evolution = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        Doc_nam1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        Date_evol = new javax.swing.JTextArea();
        Date_con = new javax.swing.JLabel();
        Date_con1 = new javax.swing.JLabel();
        Doc_nam2 = new javax.swing.JLabel();
        Id_evolu = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        s1 = new javax.swing.JTextPane();
        jScrollPane24 = new javax.swing.JScrollPane();
        HMA1 = new javax.swing.JTextPane();
        jScrollPane25 = new javax.swing.JScrollPane();
        CA1 = new javax.swing.JTextPane();
        jScrollPane26 = new javax.swing.JScrollPane();
        EP1 = new javax.swing.JTextPane();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        A1 = new javax.swing.JTextPane();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        Tb_labo1 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        Tb_imagerie1 = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jScrollPane29 = new javax.swing.JScrollPane();
        Valeur_labo1 = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        interpretation1 = new javax.swing.JTextArea();
        jButton16 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        Tb_Traitement1 = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        Traitement2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        Traitement_tx1 = new javax.swing.JTextPane();
        User_nam8 = new javax.swing.JLabel();
        User_nam9 = new javax.swing.JLabel();
        jScrollPane46 = new javax.swing.JScrollPane();
        Qt2 = new javax.swing.JTextPane();
        jScrollPane47 = new javax.swing.JScrollPane();
        mode_emploi1 = new javax.swing.JTextPane();
        User_nam10 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                            .addComponent(Postnom_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Prenom_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nom_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Sexe_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGap(11, 11, 11)
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ATCD"));
        jPanel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        ATCD_P.setColumns(20);
        ATCD_P.setRows(5);
        jScrollPane21.setViewportView(ATCD_P);

        jButton18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/b_edit.png"))); // NOI18N
        jButton18.setText("Modifier");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton18)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/1leftarrow.png"))); // NOI18N
        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel8.setText("Dr :");

        User_nam.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        User_nam.setText("user");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel13, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(User_nam, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(25, 25, 25))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(User_nam))
                    .addComponent(jButton1))
                .addGap(21, 21, 21))
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail de la Consultation"));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Consultation fait par Docteur ");

        Doc_nam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Doc_nam.setText("dc");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Date");

        Date_consultation.setColumns(20);
        Date_consultation.setRows(5);
        jScrollPane22.setViewportView(Date_consultation);

        jButton20.setText("Print");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Doc_nam, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(76, 76, 76))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Doc_nam)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton20)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail"));

        jScrollPane4.setViewportView(s);

        jScrollPane15.setViewportView(ATCD);

        jScrollPane16.setViewportView(HMA);

        jScrollPane17.setViewportView(CA);

        jScrollPane18.setViewportView(EP);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("ATCD");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Histoire de la maladie");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Complement d'anamnese");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Examen Physique");

        jScrollPane19.setViewportView(A);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Diagnostique");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Symtome dominant");

        jButton7.setText("Enregistrer");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Modifier");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Vider");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/paraJeu16.png"))); // NOI18N
        jButton2.setText("Examen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(0, 275, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton2)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Analyse", jPanel8);

        Tb_labo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom de l'examen", "Type de l'examen", "Valeur labo"
            }
        ));
        Tb_labo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_laboMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tb_labo);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Examen de Labo");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/paraJeu16.png"))); // NOI18N
        jButton10.setText("Ajout examen");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        Valeur_labo.setColumns(20);
        Valeur_labo.setRows(5);
        jScrollPane20.setViewportView(Valeur_labo);

        interpretation.setColumns(20);
        interpretation.setRows(5);
        jScrollPane7.setViewportView(interpretation);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/button_ok.png"))); // NOI18N
        jButton11.setText("Interpretation");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel1.setText(".");

        jButton19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/DeleteHS.png"))); // NOI18N
        jButton19.setText("Supprimer");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel1)))
                        .addContainerGap(97, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(0, 322, Short.MAX_VALUE)
                                .addComponent(jButton19))
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                        .addGap(19, 19, 19))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jLabel1))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Examen Paraclinique", jPanel12);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detaille de traitement"));

        Traitement1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Traitement1.setText("...");

        jScrollPane6.setViewportView(Traitement_tx);

        jButton3.setText("Valider");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Modification");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jScrollPane42.setViewportView(mode_emploie);

        User_nam5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        User_nam5.setText("Medicament");

        User_nam6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        User_nam6.setText("Detail du traitement");

        jScrollPane45.setViewportView(Qt1);

        User_nam7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        User_nam7.setText("Quantité");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(User_nam5, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addGap(120, 120, 120))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(User_nam7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane45, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(User_nam6, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addGap(211, 211, 211))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane42, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(Traitement1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)))
                        .addContainerGap())
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(User_nam5)
                    .addComponent(User_nam7))
                .addGap(16, 16, 16)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane45)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(User_nam6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane42, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(Traitement1)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Traitement", jPanel9);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultation", jPanel1);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Liste de l'évolution"));

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
        jScrollPane8.setViewportView(Tb_evolution);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail de la Consultation"));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Consultation faite par Dr ");

        Doc_nam1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Doc_nam1.setText("dc");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Date évolution faite par  ");

        Date_evol.setColumns(20);
        Date_evol.setRows(5);
        jScrollPane23.setViewportView(Date_evol);

        Date_con.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Date_con.setText("Date_con");

        Date_con1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Date_con1.setText("Date:");

        Doc_nam2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Doc_nam2.setText("dc");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Doc_nam1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Doc_nam2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane23)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(Date_con1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Date_con, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(Doc_nam1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Date_con1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Date_con, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(Doc_nam2))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        Id_evolu.setText("jLabel3");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Id_evolu)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Id_evolu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail"));

        jScrollPane9.setViewportView(s1);

        jScrollPane24.setViewportView(HMA1);

        jScrollPane25.setViewportView(CA1);

        jScrollPane26.setViewportView(EP1);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Histoire de la maladie");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Complement d'anamnese");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Examen Physique");

        jScrollPane27.setViewportView(A1);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Diagnostique");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Symtome dominant");

        jButton12.setText("Enregistrer");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Modifier");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Vider");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/paraJeu16.png"))); // NOI18N
        jButton5.setText("Examen");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jLabel24)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jLabel23)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jButton12)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)
                        .addGap(18, 18, 18)
                        .addComponent(jButton14)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton14)
                    .addComponent(jButton5))
                .addGap(98, 98, 98))
        );

        jTabbedPane5.addTab("Analyse", jPanel16);

        Tb_labo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom de l'examen", "Type de l'examen", "Valeur labo"
            }
        ));
        Tb_labo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_labo1MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(Tb_labo1);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setText("Examen de Labo");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setText("Imagerie");

        Tb_imagerie1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom de l'examen", "Type de l'examen", "Valeur labo"
            }
        ));
        Tb_imagerie1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_imagerie1MouseClicked(evt);
            }
        });
        jScrollPane28.setViewportView(Tb_imagerie1);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/paraJeu16.png"))); // NOI18N
        jButton15.setText("Ajout examen");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        Valeur_labo1.setColumns(20);
        Valeur_labo1.setRows(5);
        jScrollPane29.setViewportView(Valeur_labo1);

        interpretation1.setColumns(20);
        interpretation1.setRows(5);
        jScrollPane11.setViewportView(interpretation1);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/button_ok.png"))); // NOI18N
        jButton16.setText("Interpretation");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel2.setText(".");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                            .addComponent(jScrollPane28, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel2)))
                        .addContainerGap(97, Short.MAX_VALUE))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton16)
                    .addComponent(jLabel2))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Examen Paraclinique", jPanel17);

        Tb_Traitement1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicament"
            }
        ));
        Tb_Traitement1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_Traitement1MouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(Tb_Traitement1);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detaille de traitement"));

        Traitement2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Traitement2.setText("...");

        jButton6.setText("Valider");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton17.setText("Modification");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jScrollPane13.setViewportView(Traitement_tx1);

        User_nam8.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        User_nam8.setText("Medicament");

        User_nam9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        User_nam9.setText("Quantité");

        jScrollPane46.setViewportView(Qt2);

        jScrollPane47.setViewportView(mode_emploi1);

        User_nam10.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        User_nam10.setText("Detail du traitement");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane47, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(User_nam10, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addGap(201, 201, 201))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(User_nam8, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addGap(120, 120, 120)))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(User_nam9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(72, 72, 72)
                        .addComponent(Traitement2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jButton17)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(User_nam8)
                    .addComponent(User_nam9))
                .addGap(16, 16, 16)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(User_nam10))
                    .addComponent(jScrollPane46, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(Traitement2)
                    .addComponent(jButton17))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Traitement", jPanel18);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane5)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Evolution", jPanel2);

        id.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void affichage_table_traitement(String id_p, String id_cons, String Type, String Id_ev)
{
     try {  
         //affichage du Traitement
        state = (Statement) connection.getInstance().createStatement();
         result = state.executeQuery("SELECT * FROM traitement WHERE Id_pa='"+id_p+"' AND Id_cons='"+id_cons+"' AND Type='"+Type+"';");
                if("Consultation".equals(Type))
                { 
                   DefaultTableModel Table4=  (DefaultTableModel) Tb_Traitement.getModel();
                   Table4.setColumnCount(0);
                   Table4.addColumn("N°");
                   Table4.addColumn("Traitement");
                   Table4.addColumn("Quantité");
                   Table4.addColumn("Detail");
                   Table4.setRowCount(0);
                   while (result.next())
                      {//
                            Object[] objets= new Object[4];
                            objets[0]= result.getString("Id_tr");
                            objets[1]= result.getString("Medicament");
                            objets[2]= result.getString("Qt_prise");
                            objets[3]= result.getString("mode_emploi");
                            Table4.addRow(objets);
                      }
                }
                else {
                   DefaultTableModel Table4=  (DefaultTableModel) Tb_Traitement1.getModel();
                   Table4.setColumnCount(0);
                   Table4.addColumn("N°");
                   Table4.addColumn("Traitement");
                   Table4.addColumn("Quantité");
                   Table4.addColumn("Detail");
                   Table4.setRowCount(0);
                   while (result.next())
                      {//
                            Object[] objets= new Object[4];
                            objets[0]= result.getString("Id_tr");
                            objets[1]= result.getString("Medicament");
                            objets[2]= result.getString("Qt_prise");
                            objets[3]= result.getString("mode_emploi");
                            Table4.addRow(objets);
                      }
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
        }
}
/*public void affichage_table_traitement_pharamci(String id_p, String id_cons, String Type, String Id_ev)
{
     try {  
         //affichage du Traitement
        state = (Statement) connection.getInstance().createStatement();
        result2= state.executeQuery("SELECT * FROM traitement WHERE Id_pa='"+id_p+"' AND Id_cons='"+id_cons+"';");
                
                if("Consultation".equals(Type)) {
                   DefaultTableModel Table4=  (DefaultTableModel) Table_Produit_prescrit.getModel();
                   Table4.setColumnCount(0);
                   Table4.addColumn("N°");
                   Table4.addColumn("Medicament");
                   Table4.addColumn("Quantité");
                   Table4.addColumn("Detail");
                   Table4.setRowCount(0);
                   while (result2.next())
                      {//
                            Object[] objets= new Object[4];
                            objets[0]= result2.getString("Id_tr");
                            objets[1]= result2.getString("Medicament");
                            objets[2]= result2.getString("Qt_prise");
                            objets[3]= result2.getString("mode_emploi");
                            Table4.addRow(objets);
                      }
                }
        } catch (SQLException ex) {
            Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
        }
}*/
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
                   Table4.addColumn("S");
                   Table4.addColumn("HMA");
                   Table4.addColumn("CA");
                   Table4.addColumn("EP");
                   Table4.addColumn("A");
                   Table4.addColumn("Doc");
                   Table4.setRowCount(0);
                   while (result.next())
                      {//
                            Object[] objets= new Object[8];
                            objets[0]= result.getString("Id_ev");
                            objets[1]= result.getString("Date");
                            objets[2]= result.getString("S");
                            objets[3]= result.getString("HMA");
                            objets[4]= result.getString("CA");
                            objets[5]= result.getString("EP");
                            objets[6]= result.getString("A");
                            objets[7]= result.getString("Nom");
                            Table4.addRow(objets);
                      }


        } catch (SQLException ex) {
            Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void affectation ()
{
    //Signe Viteaux
    
    DateFormat dat= DateFormat.getDateInstance( DateFormat.SHORT);
    date1=dat.format(da);
    //Pacient  
    id_psv=id.getText();
    nom=Nom_p.getText();  
    postnom=Postnom_p.getText();
    prenom=Prenom_p.getText();  
    sexe=Sexe_p.getText();
    ec=EC_p.getText();  
    dn=Dn_p.getText();
    ad=A_p.getText();  
    ph=Ph_p.getText();
    pr=Pr_p.getText();
    em=Em_p.getText();
}
public void vider (int code)
{
    if(code==1)
    {
        s.setText("");
        ATCD.setText("");
        HMA.setText("");
        CA.setText("");
        EP.setText("");
        A.setText("");
    }
    if(code==2)
    {
        s1.setText("");
        HMA1.setText("");
        CA1.setText("");
        EP1.setText("");
        A1.setText("");
    }
}
public void user(String Id_pr, String user)
{
    user1=user;
    Id_pr1=Id_pr;
    User_nam.setText(user);
}
public void affichage ()
{
    try {
        //affichage des Signe Vitaux
        state = (Statement) connection.getInstance().createStatement();
         result = state.executeQuery("SELECT* FROM  sv WHERE Id_pa='"+id.getText()+"' ;");
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
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:    
    Dimension tailleEcran= Toolkit.getDefaultToolkit().getScreenSize();// Recuperation de la taille de l'ecran
    int H=tailleEcran.height;
    int L=tailleEcran.width;
    Liste_Patient lp= new Liste_Patient();
    lp.setSize(L, H);//Longeure et Hauteur l'ecran Id_pr1, dig, user1
    lp.user(Id_pr1, user1);
    lp.setVisible(true);
    this.setVisible(false);
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
// TODO add your handling code here:
    String interp=interpretation.getText();
    if (interp!=null)
    {
        String code=JOptionPane.showInputDialog("Entrez le code");
        System.out.println(code);
        /*if(code=="1234")
        {*/
                try {
                    modification.modif_img(jLabel1.getText(), interp);
                    interpretation.setText("");
                } catch (SQLException ex) {
                    Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
                }
            
       /* }else{
             JOptionPane.showMessageDialog(null, "Code invalide", "Erreur", JOptionPane.WARNING_MESSAGE);
        }*/
    }else{
        JOptionPane.showMessageDialog(null, "interpretation est vide", "Erreur", JOptionPane.WARNING_MESSAGE);
    }
    
}//GEN-LAST:event_jButton11ActionPerformed

private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
// TODO add your handling code here:
if( "".equals(s.getText())||"".equals(ATCD.getText())||"".equals(HMA.getText())||"".equals(CA.getText())||"".equals(EP.getText())||"".equals(A.getText()))
    {
        JOptionPane.showMessageDialog(null, "Selectionnez la nouvelle consultation", "Erreur", JOptionPane.WARNING_MESSAGE);
    }else{

                 int ligne_select= Tb_consultation.getSelectedRowCount();//Nombre de lignes selectionner
                 int in= Tb_consultation.getSelectedRow();
                 if(ligne_select==1)
                    {    
                         //Affichage des valeur du tableau dans les champs
                         id_cons=(String)Tb_consultation.getModel().getValueAt(in, 0);// Recuperation id Consultation
                        
                        Dimension tailleEcran= Toolkit.getDefaultToolkit().getScreenSize();// Recuperation de la taille de l'ecran
                        //Envoie et affichage dans l'enregistrement labo 
                        int H=tailleEcran.height;
                        int L=tailleEcran.width;
                        affectation ();
                        Examemn_pratique Examemn_pratique= new Examemn_pratique();
                        Examemn_pratique.info_patient(Id_pr1,user1,id_psv,id_cons, nom, postnom, prenom, sexe, dn, ec, ad, ph, pr, em,"Consultation",ATCD_P.getText());
                        Examemn_pratique.setSize(L, H);//Longeure et Hauteur l'ecran Id_pr1, dig, user1
                        Examemn_pratique.setVisible(true);
                        this.setVisible(false);
                 }
    }
}//GEN-LAST:event_jButton10ActionPerformed

private void Tb_imagerieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_imagerieMouseClicked
// TODO add your handling code here:
     int ligne_select= Tb_imagerie.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_imagerie.getSelectedRow();
   
   if(ligne_select==1)
   {
     interpretation.setText((String)Tb_imagerie.getModel().getValueAt(in, 3));
     jLabel1.setText((String)Tb_imagerie.getModel().getValueAt(in, 0));
   }
}//GEN-LAST:event_Tb_imagerieMouseClicked

private void Tb_laboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_laboMouseClicked
// TODO add your handling code here:
   int ligne_select= Tb_labo.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_labo.getSelectedRow();
   
   if(ligne_select==1)
   {
     String ty,val;
     ty=(String)Tb_labo.getModel().getValueAt(in, 1);
     val=(String)Tb_labo.getModel().getValueAt(in, 2);
     Valeur_labo.setText(ty+"="+val);
   }
}//GEN-LAST:event_Tb_laboMouseClicked

private void Tb_consultationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_consultationMouseClicked
// Lorsqu'on selectione sur le tableau
   int ligne_select= Tb_consultation.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_consultation.getSelectedRow();
   
   if(ligne_select==1)
   {  String nom_doc;  
     //Affichage des valeur du tableau dans les champs
     id_cons=(String)Tb_consultation.getModel().getValueAt(in, 0);// On recuper le id du tableau
     Doc_nam.setText((String)Tb_consultation.getModel().getValueAt(in, 2));// On recuper le le nom du docteur  du tableau pour l'afficher au label
     Date_consultation.setText((String)Tb_consultation.getModel().getValueAt(in, 1));// On recuper la date de consultation  du tableau pour l'afficher au label
     s.setText((String)Tb_consultation.getModel().getValueAt(in, 3));
     ATCD.setText((String)Tb_consultation.getModel().getValueAt(in, 4)); 
     HMA.setText((String)Tb_consultation.getModel().getValueAt(in, 5)); 
     CA.setText((String)Tb_consultation.getModel().getValueAt(in, 6)); 
     EP.setText((String)Tb_consultation.getModel().getValueAt(in, 7)); 
     A.setText((String)Tb_consultation.getModel().getValueAt(in, 8)); 
     Doc_nam1.setText((String)Doc_nam.getText());// Date_con On recuper le nom du docteur
     Date_con.setText((String)Date_consultation.getText());// La date de la consultation  
     
     //Affichage des informations du labo dans la table Tb_labo
     try { 
         String sorte=null;
         state = (Statement) connection.getInstance().createStatement();
         result = state.executeQuery("SELECT * FROM labo WHERE Id_pa='"+id_psv+"' AND Id_cons='"+id_cons+"' ;");// Pour le labo
         
           //affichage de la Laboratoir

                   DefaultTableModel Table3=  (DefaultTableModel) Tb_labo.getModel();
                   Table3.setColumnCount(0);
                   Table3.addColumn("N°");
                   Table3.addColumn("Type ");
                   Table3.addColumn("Valeur labo");
                   Table3.setRowCount(0);
                   while (result.next())
                      {//
                            Object[] objets= new Object[3];
                            objets[0]= result.getString("Id_la");
                            objets[1]= result.getString("Type_ex");
                            objets[2]= result.getString("Valeur");
                            Table3.addRow(objets);
                      }
                   
              //affichage de la Imageri
                   state2 = (Statement) connection.getInstance().createStatement();
                   result2 = state.executeQuery("SELECT * FROM imagerie WHERE  Id_cons='"+id_cons+"' AND sorte<>'Evolution';");// Pour l'imagirie
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
     affichage_table_traitement(id_psv, id_cons,"Consultation",".");
     affichage_table_evolution(id_psv, id_cons);
     //affichage_table_traitement_pharamci (id_psv, id_cons,"Consultation","0");
   } 
    
}//GEN-LAST:event_Tb_consultationMouseClicked

private void Tb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb2MouseClicked
// TODO add your handling code here:
   int ligne_select= Tb2.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb2.getSelectedRow();
   if(ligne_select==1)
   {
     id_sv=(String)Tb2.getModel().getValueAt(in, 0);
     date=((String) Tb2.getModel().getValueAt(in, 1));
   }
   
}//GEN-LAST:event_Tb2MouseClicked

private void Tb_evolutionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_evolutionMouseClicked
 // Evolution  
   // Lorsqu'on selectione sur le tableau de l'évolution
   ligne_select1= Tb_evolution.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_evolution.getSelectedRow();
   
   if(ligne_select1==1)
   {  String nom_doc;  
     //Affichage des valeur du tableau dans les champs
     Id_evolu.setText((String)Tb_evolution.getModel().getValueAt(in, 0));
     Id_ev=(String)Tb_evolution.getModel().getValueAt(in, 0);// On recuper le id du tableau
     //System.out.println(Id_ev);
     s1.setText((String)Tb_evolution.getModel().getValueAt(in, 2)); 
     HMA1.setText((String)Tb_evolution.getModel().getValueAt(in, 3)); 
     CA1.setText((String)Tb_evolution.getModel().getValueAt(in, 4)); 
     EP1.setText((String)Tb_evolution.getModel().getValueAt(in, 5)); 
     A1.setText((String)Tb_evolution.getModel().getValueAt(in, 6));  
     Doc_nam2.setText((String)Tb_evolution.getModel().getValueAt(in,7));// Date_con On recuper le le nom du docteur  du tableau pour l'afficher au label
     //Date_con.setText((String)Date_consultation.getText());// 
     Date_evol.setText((String)Tb_evolution.getModel().getValueAt(in, 1));// On recuper la date de consultation  du tableau pour l'afficher au label*/
    /*****************************************************
     AFFICHAGE EXAMEN*/
      //Affichage des informations du labo dans la table Tb_labo1 pour l'evolution
     try { 
         state = (Statement) connection.getInstance().createStatement();
         result = state.executeQuery("SELECT * FROM labo WHERE Id_pa='"+id_psv+"' AND Id_cons='"+id_cons+"' AND Id_ev='"+Id_ev+"' ;");// Pour le labo
         
           //affichage de la Laboratoir

                   DefaultTableModel Table3=  (DefaultTableModel) Tb_labo1.getModel();
                   Table3.setColumnCount(0);
                   Table3.addColumn("N°");
                   Table3.addColumn("Nom");
                   Table3.addColumn("Type ");
                   Table3.addColumn("Valeur labo");
                   Table3.setRowCount(0);
                   while (result.next())
                      {//
                            Object[] objets= new Object[4];
                            objets[0]= result.getString("Id_la");
                            objets[1]= result.getString("Nom_ex");
                            objets[2]= result.getString("Type_ex");
                            objets[3]= result.getString("Valeur");
                            Table3.addRow(objets);
                      }
                   
              //affichage de la Imageri
                   state2 = (Statement) connection.getInstance().createStatement();
                   result2 = state.executeQuery("SELECT * FROM imagerie WHERE  Id_cons='"+id_cons+"' AND Id_ev='"+Id_ev+"';");// Pour l'imagirie
                   DefaultTableModel Table4=  (DefaultTableModel) Tb_imagerie1.getModel();
                   Table4.setColumnCount(0);
                   Table4.addColumn("N°");
                   Table4.addColumn("Examen Demandé");
                   Table4.addColumn("REC");
                   Table4.addColumn("Interpretation");
                   Table4.setRowCount(0);
                   while (result2.next())
                      {
                            Object[] objets= new Object[4];
                            objets[0]= result2.getString("Id_im");
                            objets[1]= result2.getString("Exd");
                            objets[2]= result2.getString("Rec");
                            objets[3]= result2.getString("Interpretation");
                            Table4.addRow(objets);
                      }

        } catch (SQLException ex) {
            Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
        }
     affichage_table_traitement(id_psv, id_cons,"Evolution",Id_ev);
     affichage_table_evolution(id_psv, id_cons);
   }
}//GEN-LAST:event_Tb_evolutionMouseClicked

private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
// TODO add your handling code here:
    if( "".equals(s1.getText())||"".equals(HMA1.getText())||"".equals(CA1.getText())||"".equals(EP1.getText())||"".equals(A1.getText()))
    {
        JOptionPane.showMessageDialog(null, "Champs vide", "Erreur", JOptionPane.WARNING_MESSAGE);
    }else{
            try {
                //
                //String Date="20"; 
                affectation ();
                enregistrement.enrg_evolution(s1.getText(),  HMA1.getText(), CA1.getText(), EP1.getText(), A1.getText(),date1,Id_pr1, id_psv,id_cons );
                affichage_table_evolution(id_psv, id_cons);
            } catch (SQLException ex) {
                Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
            }
        affichage ();
        vider(2);}
}//GEN-LAST:event_jButton12ActionPerformed

private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
// Modification Evolution
    
     if( "".equals(s1.getText())||"".equals(HMA1.getText())||"".equals(CA1.getText())||"".equals(EP1.getText())||"".equals(A1.getText()))
    {
        JOptionPane.showMessageDialog(null, "Champs vide", "Erreur", JOptionPane.WARNING_MESSAGE);
    }else{
            
                 int ligne_select= Tb_evolution.getSelectedRowCount();//Nombre de lignes selectionner
                 int in= Tb_evolution.getSelectedRow();
                 //if(ligne_select==1)
                   // {    
                         //Affichage des valeur du tableau dans les champs
                         Id_ev=Id_evolu.getText();
                         //date=(String)Tb_evolution.getModel().getValueAt(in, 1);
                try {
                
                        modification.modif_evolution(s1.getText(), HMA1.getText(), CA1.getText(), EP1.getText(), A1.getText(), Date_evol.getText(), User_nam.getText(), Id_ev); //
                        affichage_table_evolution(id_psv, id_cons);//Affichage apres modification
                    } catch (SQLException ex) {
                            Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         consultation (id_psv);//pour afficher la table de la consultation
                    //}
                
        affichage ();
        vider(2);}
}//GEN-LAST:event_jButton13ActionPerformed

private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
// TODO add your handling code here:
 vider(2);
}//GEN-LAST:event_jButton14ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     
    if( "".equals(s1.getText())||"".equals(HMA1.getText())||"".equals(CA1.getText())||"".equals(EP1.getText())||"".equals(A1.getText()))
    {
        JOptionPane.showMessageDialog(null, "Selectionnez l'evaluation", "Erreur", JOptionPane.WARNING_MESSAGE);
    }else{

                 int ligne_select= Tb_consultation.getSelectedRowCount();//Nombre de lignes selectionner
                 int in= Tb_consultation.getSelectedRow();
                 if(ligne_select==1)
                    {    
                         //Affichage des valeur du tableau dans les champs
                         id_cons=(String)Tb_consultation.getModel().getValueAt(in, 0);// Recuperation id Consultation
                         Id_ev=(String)Tb_evolution.getModel().getValueAt(in, 0); 
                        Dimension tailleEcran= Toolkit.getDefaultToolkit().getScreenSize();// Recuperation de la taille de l'ecran
                        //Envoie et affichage dans l'enregistrement labo 
                        int H=tailleEcran.height;
                        int L=tailleEcran.width;
                        affectation ();
                        Examemn_pratique Examemn_pratique= new Examemn_pratique();
                        Examemn_pratique.info_patient(Id_pr1,user1,id_psv,id_cons, nom, postnom, prenom, sexe, dn, ec, ad, ph, pr, em,"Evolution",ATCD_P.getText());
                        Examemn_pratique.id_ev(Id_ev);
                        Examemn_pratique.setSize(L, H);//Longeure et Hauteur l'ecran Id_pr1, dig, user1
                        Examemn_pratique.setVisible(true);
                        this.setVisible(false);
                 }
    }
}//GEN-LAST:event_jButton5ActionPerformed

private void Tb_labo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_labo1MouseClicked
// TODO add your handling code here:
   int ligne_select= Tb_labo1.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_labo1.getSelectedRow();
   
   if(ligne_select==1)
   {
     Valeur_labo1.setText((String)Tb_labo1.getModel().getValueAt(in, 3));
   }
}//GEN-LAST:event_Tb_labo1MouseClicked

private void Tb_imagerie1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_imagerie1MouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_Tb_imagerie1MouseClicked

private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
// TODO add your handling code here:
   
    if( "".equals(s1.getText())||"".equals(HMA1.getText())||"".equals(CA1.getText())||"".equals(EP1.getText())||"".equals(A1.getText()))
    {
        JOptionPane.showMessageDialog(null, "Selectionnez l'evaluation", "Erreur", JOptionPane.WARNING_MESSAGE);
    }else{

                 int ligne_select= Tb_consultation.getSelectedRowCount();//Nombre de lignes selectionner
                 int in= Tb_consultation.getSelectedRow();
                 if(ligne_select==1)
                    {    
                         //Affichage des valeur du tableau dans les champs
                         id_cons=(String)Tb_consultation.getModel().getValueAt(in, 0);// Recuperation id Consultation
                         Id_ev=(String)Tb_evolution.getModel().getValueAt(in, 0); 
                        Dimension tailleEcran= Toolkit.getDefaultToolkit().getScreenSize();// Recuperation de la taille de l'ecran
                        //Envoie et affichage dans l'enregistrement labo 
                        int H=tailleEcran.height;
                        int L=tailleEcran.width;
                        H=H-1;
                        L=L-1;
                        affectation ();
                        Examemn_pratique Examemn_pratique= new Examemn_pratique();
                        Examemn_pratique.info_patient(Id_pr1,user1,id_psv,id_cons, nom, postnom, prenom, sexe, dn, ec, ad, ph, pr, em,"Evolution",ATCD_P.getText());
                        Examemn_pratique.id_ev(Id_ev);
                        Examemn_pratique.setSize(L, H);//Longeure et Hauteur l'ecran Id_pr1, dig, user1
                        Examemn_pratique.setVisible(true);
                        this.setVisible(false);
                 }
    }
}//GEN-LAST:event_jButton15ActionPerformed

private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
// TODO add your handling code here:
    int ligne_select= Tb_imagerie1.getSelectedRowCount();//Nombre de lignes selectionner
    int in= Tb_imagerie1.getSelectedRow();
    if(ligne_select==1)
    { 
        String Id_img=(String)Tb_imagerie1.getModel().getValueAt(in, 0);// On recuper le id du tableau
        String interp=interpretation1.getText();
        if (interp!=null)
            {
            String code=JOptionPane.showInputDialog("Entrez le code");
            System.out.println(code);
            /*if(code=="1234")
            {*/
                    try {
                        modification.modif_img(Id_img, interp);
                        interpretation1.setText("");
                    } catch (SQLException ex) {
                        Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
                    }

           /* }else{
                 JOptionPane.showMessageDialog(null, "Code invalide", "Erreur", JOptionPane.WARNING_MESSAGE);
            }*/
        }else{
            JOptionPane.showMessageDialog(null, "interpretation est vide", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
}//GEN-LAST:event_jButton16ActionPerformed

private void Tb_Traitement1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_Traitement1MouseClicked
// TODO add your handling code here:
    ligne_select1= Tb_Traitement1.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_Traitement1.getSelectedRow();
   if(ligne_select1==1)
   {  String nom_doc;  
     //Affichage des valeur du tableau dans les champs
   Traitement_tx1.setText((String)Tb_Traitement1.getModel().getValueAt(in, 1));
   Qt2.setText((String)Tb_Traitement1.getModel().getValueAt(in, 2));
   mode_emploi1.setText((String)Tb_Traitement1.getModel().getValueAt(in, 3));
    }
}//GEN-LAST:event_Tb_Traitement1MouseClicked

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
 // Lorsqu'on selectione sur le tableau
   ligne_select1= Tb_evolution.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_evolution.getSelectedRow();
   
   if(Id_ev!=null)
   {  
    Traitement=Traitement_tx1.getText();
    mode_emploi=mode_emploi1.getText();
    String Qt11=Qt2.getText();
    if(Traitement!=null)
    {
       enregistrement.en_traitement(Traitement, id_psv, id_cons,"Evolution","0",mode_emploi,Qt11,"","H-P");
       affichage_table_traitement(id_psv, id_cons,"Evolution",Id_ev);
       Traitement_tx1.setText("");
       mode_emploi1.setText("");
       Qt2.setText("");
    }else{
        JOptionPane.showMessageDialog(null, "Champs du traitement et vide", "Erreur", JOptionPane.WARNING_MESSAGE);
    }
    
   }else{
       JOptionPane.showMessageDialog(null, "Selectionnez une Evolution dans la liste", "Erreur", JOptionPane.WARNING_MESSAGE);
   }
}//GEN-LAST:event_jButton6ActionPerformed

private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
// TODO add your handling code here:
    int ligne_select= Tb_Traitement1.getSelectedRowCount();//Nombre de lignes selectionner
    int in= Tb_Traitement1.getSelectedRow();
    String Id_tr,Medicament;
    mode_emploi=mode_emploi1.getText();
    String Qt11=Qt2.getText();
   if(ligne_select==1)
   {
      Id_tr=(String)Tb_Traitement1.getModel().getValueAt(in, 0);
      Medicament=Traitement_tx1.getText();
            try {
                modification.modif_traitement(Id_tr, Medicament,mode_emploi,Qt11);
            } catch (SQLException ex) {
                Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
            }
   }else {
       JOptionPane.showMessageDialog(null, "Selectionnez un traitement", "Erreur", JOptionPane.WARNING_MESSAGE);
   }
   affichage_table_traitement(id_psv, id_cons, "Evolution", ""); 
   Traitement_tx1.setText("");
   mode_emploi1.setText("");
   Qt2.setText("");
}//GEN-LAST:event_jButton17ActionPerformed

private void Tb_TraitementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_TraitementMouseClicked
// TODO add your handling code here:
   int ligne_select= Tb_Traitement.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_Traitement.getSelectedRow();
   if(ligne_select==1)
   {
     Traitement_tx.setText((String)Tb_Traitement.getModel().getValueAt(in, 1));
     Qt1.setText((String)Tb_Traitement.getModel().getValueAt(in, 2));
     mode_emploie.setText((String)Tb_Traitement.getModel().getValueAt(in, 3));
   }
    
}//GEN-LAST:event_Tb_TraitementMouseClicked

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
   int ligne_select= Tb_Traitement.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_Traitement.getSelectedRow();
   String Id_tr,Medicament;
   mode_emploi=mode_emploie.getText();
   String Qt11=Qt1.getText();
   if(ligne_select==1)
   {
      Id_tr=(String)Tb_Traitement.getModel().getValueAt(in, 0);
      Medicament=Traitement_tx.getText();
            try {
                modification.modif_traitement(Id_tr, Medicament,mode_emploi,Qt11);
            } catch (SQLException ex) {
                Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
            }
   }else {
       JOptionPane.showMessageDialog(null, "Selectionnez un traitement", "Erreur", JOptionPane.WARNING_MESSAGE);
   }
   affichage_table_traitement(id_psv, id_cons, "Consultation", ""); 
   Traitement_tx.setText("");
   mode_emploie.setText("");
   Qt1.setText("");
   
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
    // Lorsqu'on selectione sur le tableau
   int ligne_select= Tb_consultation.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_consultation.getSelectedRow();
   if(ligne_select==1)
   {  
    Traitement=Traitement_tx.getText();
    String mode_emploi1=mode_emploie.getText();
    String Qt11=Qt1.getText();
    if(Traitement!=null)
    {
       enregistrement.en_traitement(Traitement, id_psv, id_cons,"Consultation","0",mode_emploi1,Qt11,"","H-P");
       affichage_table_traitement(id_psv, id_cons,"Consultation","0");
       Traitement_tx.setText("");
       mode_emploie.setText("");
       Qt1.setText("");
    }else{
        JOptionPane.showMessageDialog(null, "Champs du traitement et vide", "Erreur", JOptionPane.WARNING_MESSAGE);
    }
    
   }else{
       JOptionPane.showMessageDialog(null, "Selectionnez une consultation dans la liste", "Erreur", JOptionPane.WARNING_MESSAGE);
   }
    
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
// MODIFICATION ATCD
    try {
            modification.modif_ATDC( id.getText(),  ATCD_P.getText());
         } catch (SQLException ex) {
                Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
            }
}//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
   int ligne_select= Tb_labo.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_labo.getSelectedRow();
   
   if(ligne_select==1)
   {
     
     String id_lab=(String) Tb_labo.getModel().getValueAt(in, 0);// On recuper le id du tableau
     DefaultTableModel tab=  (DefaultTableModel) Tb_labo.getModel();
     suppression.sup_labo(id_lab);
     tab.removeRow(in);//Suppressio de la ligne
   }
        
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if( "".equals(s.getText())||"".equals(ATCD.getText())||"".equals(HMA.getText())||"".equals(CA.getText())||"".equals(EP.getText())||"".equals(A.getText()))
        {
            JOptionPane.showMessageDialog(null, "Selectionnez la nouvelle consultation", "Erreur", JOptionPane.WARNING_MESSAGE);
        }else{

            int ligne_select= Tb_consultation.getSelectedRowCount();//Nombre de lignes selectionner
            int in= Tb_consultation.getSelectedRow();
            if(ligne_select==1)
            {
                //Affichage des valeur du tableau dans les champs
                id_cons=(String)Tb_consultation.getModel().getValueAt(in, 0);// Recuperation id Consultation

                Dimension tailleEcran= Toolkit.getDefaultToolkit().getScreenSize();// Recuperation de la taille de l'ecran
                //Envoie et affichage dans l'enregistrement labo
                int H=tailleEcran.height;
                int L=tailleEcran.width;
                H=H-1;
                L=L-1;
                affectation ();
                Examemn_pratique Examemn_pratique= new Examemn_pratique();
                Examemn_pratique.info_patient(Id_pr1,user1,id_psv,id_cons, nom, postnom, prenom, sexe, dn, ec, ad, ph, pr, em,"Consultation",ATCD_P.getText());
                Examemn_pratique.affichage_examen_selectionner (Id_pr1, id_cons);
                Examemn_pratique.setSize(L, H);//Longeure et Hauteur l'ecran Id_pr1, dig, user1
                Examemn_pratique.setVisible(true);
                this.setVisible(false);
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        vider(1);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if( "".equals(s.getText())||"".equals(ATCD.getText())||"".equals(HMA.getText())||"".equals(CA.getText())||"".equals(EP.getText())||"".equals(A.getText()))
        {
            JOptionPane.showMessageDialog(null, "Champs vide", "Erreur", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
                int ligne_select= Tb_consultation.getSelectedRowCount();//Nombre de lignes selectionner
                int in= Tb_consultation.getSelectedRow();
                String id_cons1,Date_cons;
                if(ligne_select==1)
                {
                    //Affichage des valeur du tableau dans les champs
                    id_cons=(String)Tb_consultation.getModel().getValueAt(in, 0);
                    Date_cons=(String)Tb_consultation.getModel().getValueAt(in, 1);
                    modification.modif_Consultation(id_cons,s.getText(), ATCD.getText(), HMA.getText(), CA.getText(), EP.getText(), A.getText(),Date_cons,User_nam.getText());
                    consultation (id_psv);//pour afficher la table de la consultation
                }

            } catch (SQLException ex) {
                Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
            }
            affichage ();
            vider(1);}
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if( "".equals(s.getText())||"".equals(ATCD.getText())||"".equals(HMA.getText())||"".equals(CA.getText())||"".equals(EP.getText())||"".equals(A.getText()))
        {
            JOptionPane.showMessageDialog(null, "Champs vide", "Erreur", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
                //String
                enregistrement.enrg_consultation(Id_pr1, id_psv, s.getText(), ATCD.getText(), HMA.getText(), CA.getText(), EP.getText(), A.getText());
                consultation (id_psv);

            } catch (SQLException ex) {
                Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
            }
            affichage ();
            vider(1);}
    }//GEN-LAST:event_jButton7ActionPerformed

private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
// TODO add your handling code here:
 int ligne_select= Tb_consultation.getSelectedRowCount();//Nombre de lignes selectionner
 int in= Tb_consultation.getSelectedRow();  
   if(ligne_select==1)
   { 
      impression.info_Patient(Nom_p.getText(), Postnom_p.getText(), Prenom_p.getText(), EC_p.getText(),Sexe_p.getText());
      impression.info_Cons(s.getText(), ATCD.getText(), HMA.getText(), CA.getText(), EP.getText(), A.getText(), Date_consultation.getText());
      impression.User(User_nam.getText());
      impression.setVisible(true);
      this.setVisible(false);
   }
}//GEN-LAST:event_jButton20ActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Sv().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane A;
    private javax.swing.JTextPane A1;
    private javax.swing.JTextPane ATCD;
    private javax.swing.JTextArea ATCD_P;
    private javax.swing.JLabel A_p;
    private javax.swing.JTextPane CA;
    private javax.swing.JTextPane CA1;
    private javax.swing.JLabel Date_con;
    private javax.swing.JLabel Date_con1;
    private javax.swing.JTextArea Date_consultation;
    private javax.swing.JTextArea Date_evol;
    private javax.swing.JLabel Dn_p;
    private javax.swing.JLabel Doc_nam;
    private javax.swing.JLabel Doc_nam1;
    private javax.swing.JLabel Doc_nam2;
    private javax.swing.JLabel EC_p;
    private javax.swing.JTextPane EP;
    private javax.swing.JTextPane EP1;
    private javax.swing.JLabel Em_p;
    private javax.swing.JTextPane HMA;
    private javax.swing.JTextPane HMA1;
    private javax.swing.JLabel Id_evolu;
    private javax.swing.JLabel Nom_p;
    private javax.swing.JLabel Ph_p;
    private javax.swing.JLabel Postnom_p;
    private javax.swing.JLabel Pr_p;
    private javax.swing.JLabel Prenom_p;
    private javax.swing.JTextPane Qt1;
    private javax.swing.JTextPane Qt2;
    private javax.swing.JLabel Sexe_p;
    private javax.swing.JTable Tb2;
    private javax.swing.JTable Tb_Traitement;
    private javax.swing.JTable Tb_Traitement1;
    private javax.swing.JTable Tb_consultation;
    private javax.swing.JTable Tb_evolution;
    private javax.swing.JTable Tb_imagerie;
    private javax.swing.JTable Tb_imagerie1;
    private javax.swing.JTable Tb_labo;
    private javax.swing.JTable Tb_labo1;
    private javax.swing.JLabel Traitement1;
    private javax.swing.JLabel Traitement2;
    private javax.swing.JTextPane Traitement_tx;
    private javax.swing.JTextPane Traitement_tx1;
    private javax.swing.JLabel User_nam;
    private javax.swing.JLabel User_nam10;
    private javax.swing.JLabel User_nam5;
    private javax.swing.JLabel User_nam6;
    private javax.swing.JLabel User_nam7;
    private javax.swing.JLabel User_nam8;
    private javax.swing.JLabel User_nam9;
    private javax.swing.JTextArea Valeur_labo;
    private javax.swing.JTextArea Valeur_labo1;
    private javax.swing.JLabel adresseLabel;
    private javax.swing.JLabel dnLabel;
    private javax.swing.JLabel ecLabel;
    private javax.swing.JLabel employeurLabel;
    private javax.swing.JLabel id;
    private javax.swing.JTextArea interpretation;
    private javax.swing.JTextArea interpretation1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTextPane mode_emploi1;
    private javax.swing.JTextPane mode_emploie;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel postnomLabel;
    private javax.swing.JLabel prenomLabel;
    private javax.swing.JLabel professionLabel;
    private javax.swing.JTextPane s;
    private javax.swing.JTextPane s1;
    private javax.swing.JLabel sexeLabel;
    // End of variables declaration//GEN-END:variables
}
