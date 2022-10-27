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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Samy-MBIYA
 */
public class Facture extends javax.swing.JFrame {
     public String id_pa,nom, postnom, prenom, sexe, dn, ec, ad, ph, pr, em;
     public String id_sv,date, heure, tc, tas, tad, fc, fr, o, poid;
     public String Id_user, User,prestation;
     public String id_cons, dig, obs="C";
     public int compte;
     private Statement state,state2;
     private ResultSet result,result2;
     //protected Sv sv_t=new Sv();
     protected Enregistrement sv_enreg=new Enregistrement();
     protected Modification sv_mofi=new Modification();
     protected Suppression sv_sup=new Suppression();
     protected Date da=new Date();

    /** Creates new form Sv */
        public Facture() {
         initComponents();
        }
       public void affectation ()
        {
            //Pacient  
            id_pa=id.getText();
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
        public void user(String id_user, String User1)
        {
            User_nam.setText(User1);
            Id_User.setText(id_user);
            User=User1;
        }
        public void info_patient (String id_con, String id_p,String nom,String postnom, String prenom,String sexe,String dn, String ec,String adresse, String phone, String profession,String employeur,String ATCD,String labo_cal)
        {
            id_cons=id_con;
            id.setText(id_p);
            id_pa=id_p;
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
            Tab_Fac.getModel().setValueAt(labo_cal, 8, 2);
            Tab_Fac.getModel().setValueAt("1", 8, 1);
           
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
        ecLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        User_nam = new javax.swing.JLabel();
        Id_User = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Tab_Fac = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        TG = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        CV = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        SNP = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        SR = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Tab_Fac1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        TG1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        SNP1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        CV1 = new javax.swing.JLabel();
        SR1 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FACTURATION ");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Information du Patient"));

        nomLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        nomLabel.setText("Nom:");

        postnomLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        postnomLabel.setText("Postnom:");

        prenomLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        prenomLabel.setText("Prenom:");

        sexeLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        sexeLabel.setText("Sexe:");

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
        employeurLabel1.setText("ATCD :");

        ATCD_1.setFont(new java.awt.Font("Tahoma", 0, 14));
        ATCD_1.setText(".........");

        ecLabel.setFont(new java.awt.Font("Tahoma", 0, 14));
        ecLabel.setText("Etat Civil:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomLabel)
                            .addComponent(prenomLabel)
                            .addComponent(postnomLabel))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Postnom_p, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(Prenom_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nom_p, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
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
                                    .addComponent(dnLabel)
                                    .addComponent(ecLabel))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EC_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Dn_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Sexe_p, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(69, 69, 69))
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
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Prenom_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prenomLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sexe_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexeLabel))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(EC_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ecLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dnLabel)
                                .addGap(42, 42, 42)))
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
                    .addComponent(Dn_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ATCD_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeurLabel1))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(51, 255, 51));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/1leftarrow.png"))); // NOI18N
        jButton4.setText("Retour");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Save16.png"))); // NOI18N
        jButton6.setText("Valider");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Print.png"))); // NOI18N
        jButton9.setText("HONORAIRE");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/Print.png"))); // NOI18N
        jButton10.setText("Facture");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 14));
        jLabel10.setText("Infirmiere :");

        User_nam.setFont(new java.awt.Font("Tahoma", 3, 14));
        User_nam.setText(".");

        Id_User.setFont(new java.awt.Font("Tahoma", 0, 3));
        Id_User.setText(".");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(Id_User, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(User_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Id_User)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(User_nam))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14));

        Tab_Fac.setFont(new java.awt.Font("Times New Roman", 0, 14));
        Tab_Fac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Consultation", "0", "0", "0"},
                {"Radiologie", "0", "0", "0"},
                {"ECG", "0", "0", "0"},
                {"Echographie", "0", "0", "0"},
                {"Ecographie Cardiaque", "0", "0", "0"},
                {"Gastroscopie", "0", "0", "0"},
                {"Rectoscopie", "0", "0", "0"},
                {"Kinesitherapie", "0", "0", "0"},
                {"Laboratoire", "0", "0", "0"},
                {"Actes Medicaux", "0", "0", "0"},
                {"Actes Chirugicaux", "0", "0", "0"},
                {"Anesthésite", "0", "0", "0"},
                {"Accouchement", "0", "0", "0"},
                {"Medicament", "0", "0", "0"},
                {"Actes Infirmieres + Soins", "0", "0", "0"},
                {"Occupation chambre", "0", "0", "0"},
                {"Frais administratifs", "0", "0", "0"},
                {null, "0", "0", "0"},
                {null, "0", "0", "0"},
                {null, "0", "0", "0"},
                {null, "0", "0", "0"},
                {null, "0", "0", "0"}
            },
            new String [] {
                "Prestation", "Quantité", "Prix Unitaire/$", "Prix Total/$"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane7.setViewportView(Tab_Fac);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel13.setText("Total Global : ");

        TG.setFont(new java.awt.Font("Times New Roman", 3, 24));
        TG.setText("........................");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel15.setText("$");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel16.setText("Caution versée:");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel21.setText("$");

        CV.setFont(new java.awt.Font("Times New Roman", 3, 14));
        CV.setText("0");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel22.setText("Solde Net à payer:");

        SNP.setFont(new java.awt.Font("Times New Roman", 3, 24));
        SNP.setText("........................");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel24.setText("$");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel25.setText("Somme remboursée :");

        SR.setFont(new java.awt.Font("Times New Roman", 3, 14));
        SR.setText("0");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel26.setText("$");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(TG)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(CV, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(SNP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(SR, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26)))
                        .addGap(0, 409, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TG)
                        .addComponent(jLabel15))
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(CV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(SNP)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addComponent(SR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("HONORAIRE", jPanel12);

        Tab_Fac1.setFont(new java.awt.Font("Times New Roman", 0, 14));
        Tab_Fac1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Consultantion ", null},
                {"Laboratoire", null},
                {"Examen Speciaux", null},
                {"Produit pharmacietique", null},
                {"Actes medicaux", null},
                {"Actes chirurgicaux et Anesthèsiste", null},
                {"Hospitalisation et soins medicaux", null},
                {"Accouchemnt ", null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Prestation", "Prix /$"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
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
        jScrollPane8.setViewportView(Tab_Fac1);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel14.setText("Total Global : ");

        TG1.setFont(new java.awt.Font("Times New Roman", 3, 24));
        TG1.setText("........................");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel17.setText("$");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel18.setText("Caution versée:");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel23.setText("$");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel27.setText("Solde Net à payer:");

        SNP1.setFont(new java.awt.Font("Times New Roman", 3, 24));
        SNP1.setText("........................");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel28.setText("$");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel29.setText("Somme remboursée :");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 3, 24));
        jLabel30.setText("$");

        CV1.setFont(new java.awt.Font("Times New Roman", 3, 24));
        CV1.setText("........................");

        SR1.setFont(new java.awt.Font("Times New Roman", 3, 24));
        SR1.setText("........................");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(TG1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(CV1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(SNP1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel28))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SR1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel30)))
                        .addGap(0, 401, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TG1)
                        .addComponent(jLabel17))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(CV1))
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(SNP1)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel29)
                    .addComponent(SR1))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 834, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 75, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 75, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("FACTURE", jPanel1);

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
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         //Retoure SV 
        //sv_t.info_patient;
        Sv sv= new Sv();
        Dimension tailleEcran= Toolkit.getDefaultToolkit().getScreenSize();// Recuperation de la taille de l'ecran
        int H=tailleEcran.height;
        int L=tailleEcran.width;
        sv.setSize(L, H);//Longeure et Hauteur l'ecran
        sv.setLocationRelativeTo(null);//Permet de centrer le JFrame
        sv.setVisible(true);
        affectation ();
        sv.info_patient(id_pa, nom, postnom, prenom, sexe, dn, ec, ad, ph, pr, em,ATCD_1.getText());
        sv.user(Id_User.getText(), User_nam.getText());
        this.setVisible(false); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Tab_FacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_FacMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tab_FacMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            // NOTE D'HONORAIRE
            //------------------
              double tg=0;
                for (int i=0; i<=21; i++) //linge
                  {     
                      String qte= (String) Tab_Fac.getModel().getValueAt(i,1);
                      String pu= (String) Tab_Fac.getModel().getValueAt(i,2);
                      Tab_Fac.editCellAt(21, 3);
                      double qte2= new Double(qte);
                      double pu2= new Double(pu);
                      // CALCUL DU PRIX TOTAL
                          if (qte2>0.0  && pu2>0.0){
                              prestation= (String) Tab_Fac.getModel().getValueAt(i,0);                              
                              double pt=qte2*pu2;// PRIX TOTAL
                              Tab_Fac.getModel().setValueAt(pt, i, 3);
                              tg=tg+pt;//TOTAL GENERAL
                             // ENREGISTREMENT NOTE D'HONORAIRE
                              sv_enreg.enr_honoraire(prestation, qte2, pu2,pt, id_cons);
                              Tab_Fac.setLocation(0, 0);
                             // System.out.print(prestation+"-"+qte+"-"+pu+"="+tg+"_"+id_cons);
                         }
                  }
                    // CALCUL DU TOTAL GENERAL ET ENREGISTREMENT 
                     String tg2=String.valueOf(tg);// Total General
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
                     CV1.setText(CV.getText());
                     SR1.setText(SR.getText());
                     sv_enreg.enr_total(tg, cv, snp, sr, id_cons, "Particulier", "0",User,id.getText());
                        
              // FACTURE 
            //-----------
             //AFFECTATION
                
               Tab_Fac1.getModel().setValueAt(Tab_Fac.getModel().getValueAt(0, 3), 0, 1);//Consultation  et visites médicaless
               Tab_Fac1.getModel().setValueAt(Tab_Fac.getModel().getValueAt(8, 3), 1, 1);//Labo
               
               // CALCUL Examens specialisés 
               tg=0;
               for (int i=1; i<8; i++) //linge
                  {  
                   tg2= String.valueOf(Tab_Fac.getModel().getValueAt(i,3)) ;
                    if (tg2!=null ){
                    double ex_special=new Double(tg2);
                    tg=tg+ex_special;
                    }
                  }
               Tab_Fac1.getModel().setValueAt(tg, 2, 1);//Examens specialisés
               Tab_Fac1.getModel().setValueAt(Tab_Fac.getModel().getValueAt(13 ,3), 3, 1);//Produit pharmacietique
               Tab_Fac1.getModel().setValueAt(Tab_Fac.getModel().getValueAt(9 ,3), 4, 1);//Actes medicaux
               
               // CALCUL Actes chirurgicaux et Anesthèsiste 
               tg=0;
               for (int i=10; i<12; i++) 
                  {  
                   
                    tg2= String.valueOf(Tab_Fac.getModel().getValueAt(i,3)) ;
                    if (tg2!=null ){
                    double ex_special=new Double(tg2);
                    tg=tg+ex_special;
                    }
                  }
               Tab_Fac1.getModel().setValueAt(tg, 5, 1);//Actes chirurgicaux et Anesthèsiste
               
               // CALCUL Hospitalisation et soins medicaux
               tg=0;
               for (int i=14; i<22; i++) 
                  {  
                   
                    tg2= String.valueOf(Tab_Fac.getModel().getValueAt(i,3));
                    if (tg2!=null ){
                    double ex_special=new Double(tg2);
                    tg=tg+ex_special;
                    }
                  }
               Tab_Fac1.getModel().setValueAt(tg, 6, 1);//Hospitalisation et soins medicaux
               Tab_Fac1.getModel().setValueAt(Tab_Fac.getModel().getValueAt(12 ,3), 7, 1);//Accouchement
               
               compte=Tab_Fac1.getRowCount();
               for (int i=0; i<compte; i++) 
                  { 
                   prestation= (String)Tab_Fac1.getModel().getValueAt(i,0);  
                   String ptl= String.valueOf(Tab_Fac1.getModel().getValueAt(i,1));
                   if ((ptl!=null && prestation!=null  )&& (!"0.0".equals(ptl) && !"0".equals(ptl))){
                        sv_enreg.enr_facture(id_cons, prestation, ptl);
                   }
                  }
         } catch (SQLException ex) {
             Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, "Les information ont été mal saisie", "Erreur", JOptionPane.WARNING_MESSAGE);   
         }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void Tab_Fac1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tab_Fac1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Tab_Fac1MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Imprsion imp= new Imprsion ();
        imp.info(id_cons, Nom_p.getText(), Postnom_p.getText(), TG.getText(), CV.getText(), SNP.getText(), SR.getText());  
        imp.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        Imprsion_Facture Facture = new Imprsion_Facture();
        Facture.info(id_cons, Nom_p.getText(), Postnom_p.getText(), Sexe_p.getText(), EC_p.getText(),TG.getText(), CV.getText(), SNP.getText(), SR.getText());
        Facture.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(Facture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Facture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Facture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Facture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Facture().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ATCD_1;
    private javax.swing.JLabel A_p;
    private javax.swing.JTextField CV;
    private javax.swing.JLabel CV1;
    private javax.swing.JLabel Dn_p;
    private javax.swing.JLabel EC_p;
    private javax.swing.JLabel Em_p;
    private javax.swing.JLabel Id_User;
    private javax.swing.JLabel Nom_p;
    private javax.swing.JLabel Ph_p;
    private javax.swing.JLabel Postnom_p;
    private javax.swing.JLabel Pr_p;
    private javax.swing.JLabel Prenom_p;
    private javax.swing.JLabel SNP;
    private javax.swing.JLabel SNP1;
    private javax.swing.JTextField SR;
    private javax.swing.JLabel SR1;
    private javax.swing.JLabel Sexe_p;
    private javax.swing.JLabel TG;
    private javax.swing.JLabel TG1;
    private javax.swing.JTable Tab_Fac;
    private javax.swing.JTable Tab_Fac1;
    private javax.swing.JLabel User_nam;
    private javax.swing.JLabel adresseLabel;
    private javax.swing.JLabel dnLabel;
    private javax.swing.JLabel ecLabel;
    private javax.swing.JLabel employeurLabel;
    private javax.swing.JLabel employeurLabel1;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel postnomLabel;
    private javax.swing.JLabel prenomLabel;
    private javax.swing.JLabel professionLabel;
    private javax.swing.JLabel sexeLabel;
    // End of variables declaration//GEN-END:variables
}
