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
public class Ev extends javax.swing.JFrame {
     public String id_psv,nom, postnom, prenom, sexe, dn, ec, ad, ph, pr, em;
     public String id_sv,date, heure, tc, tas, tad, fc, fr, o, poid;
     public String id_cons, dig, obs="E";
     public String id_ev,Id_user, User;
     private Statement state,state2;
     private ResultSet result,result2;
     protected Enregistrement sv_enreg=new Enregistrement();
     protected Modification sv_mofi=new Modification();
     protected Suppression sv_sup=new Suppression();

    /** Creates new form Sv */
    public Ev() {
        initComponents();
    }
    public void user(String id_user, String User)
        {
            User_nam.setText(User);
            Id_user=id_user;
        }
public void info_patient (String Id_con,String id_p,String nom,String postnom, String prenom,String sexe,String dn, String ec,String adresse, String phone, String profession,String employeur, String ATDC)
{
    id_cons=Id_con;
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
    ATDC_1.setText(ATDC);
    
    try { 
        //affichage de la SV
        state = (Statement) connection.getInstance().createStatement();
         result = state.executeQuery("SELECT* FROM  sv WHERE Id_pa='"+id_p+"' AND O LIKE '"+obs+"%' ORDER BY Id_sv DESC;");
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
                   //evolution ( id_p, Id_con);

        } catch (SQLException ex) {
            Logger.getLogger(Ev.class.getName()).log(Level.SEVERE, null, ex);
        }

}
   public void evolution (String id_p, String Id_con)
   {
       System.out.println(Id_con);
       //affichage de l'evolution
        try {  
        state = (Statement) connection.getInstance().createStatement();
         result = state.executeQuery("SELECT * FROM  evolution, personnel WHERE evolution.Id_con='"+Id_con+"' AND evolution.Id_pa='"+id_p+"' AND evolution.Id_pr=personnel.Id_pr  ORDER BY evolution.Id_ev DESC;");
           
                   DefaultTableModel Table2=  (DefaultTableModel) Tb_evolution.getModel();
                   Table2.setColumnCount(0);
                   Table2.addColumn("Id_Ev");
                   Table2.addColumn("Date");
                   Table2.addColumn("Docteur");
                   Table2.addColumn("Diagno");
                   Table2.setRowCount(0);
                   while (result.next())
                      {//
                            Object[] objets= new Object[4];
                            objets[0]= result.getString("Id_ev");
                            objets[1]= result.getString("Date");
                            objets[2]= result.getString("Nom");
                            objets[3]= result.getString("A");
                            Table2.addRow(objets);
                      }

        } catch (SQLException ex) {
            Logger.getLogger(Ev.class.getName()).log(Level.SEVERE, null, ex);
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
        employeurLabel1 = new javax.swing.JLabel();
        ATDC_1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        User_nam = new javax.swing.JLabel();
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
        Tb_evolution = new javax.swing.JTable();
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
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tb_Traitement = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        Traitement1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Traitement_tx = new javax.swing.JTextPane();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Information du Patient"));

        nomLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        nomLabel.setText("Nom:");

        postnomLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        postnomLabel.setText("Postnom:");

        prenomLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        prenomLabel.setText("Prenom:");

        sexeLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        sexeLabel.setText("Sexe:");

        ecLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        ecLabel.setText("Etat Civil:");

        adresseLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        adresseLabel.setText("Adresse:");

        phoneLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        phoneLabel.setText("Phone:");

        professionLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        professionLabel.setText("Profession:");

        Nom_p.setFont(new java.awt.Font("Tahoma", 0, 14));
        Nom_p.setText(".........");

        Postnom_p.setFont(new java.awt.Font("Tahoma", 0, 14));
        Postnom_p.setText(".........");

        Prenom_p.setFont(new java.awt.Font("Tahoma", 0, 14));
        Prenom_p.setText(".........");

        Sexe_p.setFont(new java.awt.Font("Tahoma", 0, 14));
        Sexe_p.setText(".........");

        EC_p.setFont(new java.awt.Font("Tahoma", 0, 14));
        EC_p.setText(".........");

        Dn_p.setFont(new java.awt.Font("Tahoma", 0, 14));
        Dn_p.setText(".........");

        dnLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        dnLabel.setText("Né le:");

        A_p.setFont(new java.awt.Font("Tahoma", 0, 14));
        A_p.setText(".........");

        Ph_p.setFont(new java.awt.Font("Tahoma", 0, 14));
        Ph_p.setText(".........");

        Pr_p.setFont(new java.awt.Font("Tahoma", 0, 14));
        Pr_p.setText(".........");

        Em_p.setFont(new java.awt.Font("Tahoma", 0, 14));
        Em_p.setText(".........");

        employeurLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        employeurLabel.setText("Employeur:");

        employeurLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        employeurLabel1.setText("ATCD:");

        ATDC_1.setFont(new java.awt.Font("Tahoma", 0, 14));
        ATDC_1.setText(".........");

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
                            .addComponent(Postnom_p, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                            .addComponent(Prenom_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nom_p, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                            .addComponent(Sexe_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(employeurLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ATDC_1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(employeurLabel)
                                .addGap(27, 27, 27)
                                .addComponent(Em_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ATDC_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeurLabel1))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(51, 255, 51));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Save16.png"))); // NOI18N
        jButton3.setText("Enregitrer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/b_edit.png"))); // NOI18N
        jButton4.setText("Modifier");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/DeleteHS.png"))); // NOI18N
        jButton5.setText("Supprimer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/1leftarrow.png"))); // NOI18N
        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 14));
        jLabel10.setText("Infirmiere :");

        User_nam.setFont(new java.awt.Font("Tahoma", 3, 14));
        User_nam.setText(".");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(User_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(User_nam))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14));

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Signe Viteaux"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("TC:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setText("FC");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setText("TAS:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel4.setText("TAD:");

        Poid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PoidActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel5.setText("FR:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setText("Poid");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel7.setText("Observation");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(O, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
                .addContainerGap())
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Signe Viteaux Evolution ", jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Liste de l'evolution"));

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
        jScrollPane2.setViewportView(Tb_evolution);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail"));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel9.setText("Diagnostique");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18));
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

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18));
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Analyse Evolution ", jPanel8);

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

        Traitement1.setFont(new java.awt.Font("Tahoma", 0, 14));
        Traitement1.setText("...");

        jScrollPane6.setViewportView(Traitement_tx);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(Traitement1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Traitement1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Traitement Evolution", jPanel9);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Evolution", jPanel1);

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
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id)
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
            o="E/"+o;
        sv_enreg.enr_sv(id_psv, date, heure, tc, tas, tad, fc, fr, o, poid);
        affichage ();
        vide();
     }
}//GEN-LAST:event_jButton3ActionPerformed
public void affichage_table_traitement(String id_p, String id_cons, String id_ev)
{
     try {  
         //affichage du Traitement
        state = (Statement) connection.getInstance().createStatement();
         result = state.executeQuery("SELECT * FROM traitement WHERE Id_pa='"+id_p+"' AND Id_cons='"+id_cons+"' AND Id_ev='"+id_ev+"';");
                   DefaultTableModel Table4=  (DefaultTableModel) Tb_Traitement.getModel();
                   Table4.setColumnCount(0);
                   Table4.addColumn("Traitement");
                   Table4.setRowCount(0);
                   while (result.next())
                      {//
                            Object[] objets= new Object[1];
                            objets[0]= result.getString("Medicament");
                            Table4.addRow(objets);
                      }
        } catch (SQLException ex) {
            Logger.getLogger(Ev.class.getName()).log(Level.SEVERE, null, ex);
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
        result = state.executeQuery("SELECT* FROM  sv WHERE Id_pa='"+id.getText()+"' AND O LIKE '"+"%"+obs+"' ;");   
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
            Logger.getLogger(Ev.class.getName()).log(Level.SEVERE, null, ex);
        }

}
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
                Logger.getLogger(Ev.class.getName()).log(Level.SEVERE, null, ex);
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
    Dimension tailleEcran= Toolkit.getDefaultToolkit().getScreenSize();// Recuperation de la taille de l'ecran
    int H=tailleEcran.height;
    int L=tailleEcran.width;
    Sv sv= new Sv();
    sv.info_patient(id_psv, Nom_p.getText(), Postnom_p.getText(), Prenom_p.getText(), Sexe_p.getText(), EC_p.getText(), Dn_p.getText(), A_p.getText(), Ph_p.getText(), Pr_p.getText(), Em_p.getText(),ATDC_1.getText());
    sv.user(Id_user, User_nam.getText());
    sv.setSize(L, H);//Longeure et Hauteur l'ecran
    sv.setVisible(true);
    this.setVisible(false);
}//GEN-LAST:event_jButton1ActionPerformed

private void Tb_TraitementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_TraitementMouseClicked
// TODO add your handling code here:
   int ligne_select= Tb_Traitement.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_Traitement.getSelectedRow();
   if(ligne_select==1)
   {
     Traitement_tx.setText((String)Tb_Traitement.getModel().getValueAt(in, 0));
     //Traitement2.setText((String) Tb_Traitement.getModel().getValueAt(in, 1));
     //Traitement3.setText((String) Tb_Traitement.getModel().getValueAt(in, 2));
     //Traitement4.setText((String) Tb_Traitement.getModel().getValueAt(in, 3));
     //Traitement5.setText((String) Tb_Traitement.getModel().getValueAt(in, 4));
     //Traitement6.setText((String) Tb_Traitement.getModel().getValueAt(in, 5));
     //Traitement7.setText((String) Tb_Traitement.getModel().getValueAt(in, 6));
   }
    
}//GEN-LAST:event_Tb_TraitementMouseClicked

private void Tb_imagerieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_imagerieMouseClicked
// TODO add your handling code here:
     int ligne_select= Tb_imagerie.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_imagerie.getSelectedRow();
   
   if(ligne_select==1)
   {
     //interpretation.setText((String)Tb_imagerie.getModel().getValueAt(in, 3));
     //jLabel1.setText((String)Tb_imagerie.getModel().getValueAt(in, 0));
   }
}//GEN-LAST:event_Tb_imagerieMouseClicked

private void Tb_evolutionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_evolutionMouseClicked
// TODO add your handling code here:
 // Lorsqu'on selectione sur le tableau
   int ligne_select= Tb_evolution.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb_evolution.getSelectedRow();
   
   if(ligne_select==1)
   {  String nom_doc;  
     //Affichage des valeur du tableau dans les champs
     id_ev=(String)Tb_evolution.getModel().getValueAt(in, 0);// On recuper le id du tableau 
     Diag.setText((String)Tb_evolution.getModel().getValueAt(in, 3)); 
     
     //Affichage des informations du labo dans la table Tb_labo
     try { 
         state = (Statement) connection.getInstance().createStatement();
         result = state.executeQuery("SELECT * FROM labo WHERE Id_pa='"+id_psv+"' AND Id_ev='"+id_ev+"';");// Pour le labo
         
           //affichage de la Laboratoir

                   DefaultTableModel Table3=  (DefaultTableModel) Tb_labo.getModel();
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
                   result2 = state.executeQuery("SELECT * FROM imagerie WHERE  Id_ev='"+id_ev+"';");// Pour l'imagirie
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
            Logger.getLogger(Ev.class.getName()).log(Level.SEVERE, null, ex);
        }
     affichage_table_traitement(id_psv, id_cons, id_ev);

     vide();
   } 
    
}//GEN-LAST:event_Tb_evolutionMouseClicked

private void PoidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PoidActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_PoidActionPerformed

private void Tb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb2MouseClicked
// TODO add your handling code here:
   vide();
   int ligne_select= Tb2.getSelectedRowCount();//Nombre de lignes selectionner
   int in= Tb2.getSelectedRow();
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
            java.util.logging.Logger.getLogger(Ev.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ev.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ev.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ev.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Ev().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ATDC_1;
    private javax.swing.JLabel A_p;
    private javax.swing.JTextPane Diag;
    private javax.swing.JLabel Dn_p;
    private javax.swing.JLabel EC_p;
    private javax.swing.JLabel Em_p;
    private javax.swing.JTextField FC;
    private javax.swing.JTextField FR;
    private javax.swing.JTextField Heure;
    private javax.swing.JLabel Nom_p;
    private javax.swing.JTextField O;
    private javax.swing.JLabel Ph_p;
    private javax.swing.JTextField Poid;
    private javax.swing.JLabel Postnom_p;
    private javax.swing.JLabel Pr_p;
    private javax.swing.JLabel Prenom_p;
    private javax.swing.JLabel Sexe_p;
    private javax.swing.JTextField TAD;
    private javax.swing.JTextField TAS;
    private javax.swing.JTextField TC;
    private javax.swing.JTable Tb2;
    private javax.swing.JTable Tb_Traitement;
    private javax.swing.JTable Tb_evolution;
    private javax.swing.JTable Tb_imagerie;
    private javax.swing.JTable Tb_labo;
    private javax.swing.JLabel Traitement1;
    private javax.swing.JTextPane Traitement_tx;
    private javax.swing.JLabel User_nam;
    private javax.swing.JLabel adresseLabel;
    private javax.swing.JLabel dnLabel;
    private javax.swing.JLabel ecLabel;
    private javax.swing.JLabel employeurLabel;
    private javax.swing.JLabel employeurLabel1;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel postnomLabel;
    private javax.swing.JLabel prenomLabel;
    private javax.swing.JLabel professionLabel;
    private javax.swing.JLabel sexeLabel;
    // End of variables declaration//GEN-END:variables
}
