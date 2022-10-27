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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Samy-MBIYA
 */
     public class Examemn_pratique extends javax.swing.JFrame {
     private Statement state;
     private ResultSet result;
     public String id_psv,nom, postnom, prenom, sexe, dn, ec, ad, ph, pr, em;
     public String id_cons,Id_pr1, dig, user1;
     public String examen, type_examen,sorte;
     protected Enregistrement enrg=new Enregistrement();
     protected Modification mofi=new Modification();
     protected Suppression sup=new Suppression();
     
    /** Creates new form Sv */
    public Examemn_pratique() {
        initComponents();
        id_con.setVisible(false);
        id.setVisible(false);
        sorte1.setVisible(false);
        affichage_examen();
        affichage_examen_selectionner (id.getText(), id_con.getText());
       
// javax.swing. Code adding the component to the parent container - not shown here
       
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
        Id_ev = new javax.swing.JLabel();
        sorte1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        User_nam = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        ATCD_P = new javax.swing.JTextArea();
        jButton18 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tableau_selectionner = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_examen = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        sang2 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        bacteriologie = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        Exam = new javax.swing.JTextField();
        Type = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Rech_examen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        exam_dem = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        Rec = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        id_con = new javax.swing.JLabel();

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

        Id_ev.setText("0");

        sorte1.setText("sorte");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/1leftarrow.png"))); // NOI18N
        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        User_nam.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        User_nam.setText("user");

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel8.setText("Dr :");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(jButton18))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton18)
                .addContainerGap())
        );

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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Id_ev))
                        .addContainerGap(107, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(sorte1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(113, 113, 113))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(User_nam, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                        .addGap(184, 184, 184))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(User_nam))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sorte1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Id_ev)
                .addContainerGap())
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Tableau_selectionner.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Tableau_selectionner.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"SED"},
                {"SUCRE"},
                {"ABL"},
                {"GRAM"},
                {"TESTE DE GROSSESSE"},
                {"COMBUR TEST"}
            },
            new String [] {
                "EXAMEN SELECTIONNEE"
            }
        ));
        Tableau_selectionner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tableau_selectionnerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tableau_selectionner);

        Table_examen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Table_examen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"HCT"},
                {"HB"},
                {"GE"},
                {"VS"},
                {"GBL"},
                {"FL"},
                {"TC"},
                {"TS"},
                {"COOMBS DIRECT"},
                {"TESTE EMMEL"},
                {" GROUPE SANGUIN"},
                {"FACTEUR RHESUS"}
            },
            new String [] {
                "EXAMEN"
            }
        ));
        Table_examen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_examenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_examen);

        sang2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sang2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"HCT", null},
                {"HB", null},
                {"GE", null},
                {"VS", null},
                {"GBL", null},
                {"FL", null},
                {"TC", null},
                {"TS", null},
                {"COOMBS DIRECT", null},
                {"TESTE EMMEL", null},
                {" GROUPE SANGUIN", null},
                {"FACTEUR RHESUS", null},
                {"AUTRES", null}
            },
            new String [] {
                "SANG", "VALIDER"
            }
        ));
        jScrollPane3.setViewportView(sang2);

        bacteriologie.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bacteriologie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"FU", null},
                {"GRAM", null},
                {"VF VRAIS ", null},
                {"CULTURE", null}
            },
            new String [] {
                "BACTERIOLOGIE", "VALIDER"
            }
        ));
        bacteriologie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bacteriologieMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(bacteriologie);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/button_ok.png"))); // NOI18N
        jButton2.setText("Valider");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Examen");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Type d'examen");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel4.setText("Examen");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/button_ok.png"))); // NOI18N
        jButton5.setText("Recherche");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(8, 8, 8)
                                .addComponent(Rech_examen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(131, 131, 131)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Exam, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(44, 44, 44)
                        .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jButton2)
                        .addGap(456, 456, 456))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Rech_examen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jButton5))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(188, 188, 188)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jButton2))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Exam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("LABORATOIRE", jPanel6);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Examen demandé :");

        exam_dem.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        Rec.setColumns(20);
        Rec.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        Rec.setRows(5);
        jScrollPane9.setViewportView(Rec);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/packImages/button_ok.png"))); // NOI18N
        jButton3.setText("Valider");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setText("Renseignement clinique :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane9)
                            .addComponent(exam_dem, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))))
                .addGap(211, 211, 211))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(708, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(exam_dem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(350, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel5)
                    .addContainerGap(509, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("IMAGERIE", jPanel1);

        id.setText(".");

        id_con.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(id_con, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(721, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 918, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_con)
                            .addComponent(id))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

public void affichage_examen()
        {
            try {
            state = (Statement) connection.getInstance().createStatement();
            result = state.executeQuery("SELECT* FROM  examen ORDER BY Type;");
            DefaultTableModel Table=  (DefaultTableModel) Table_examen.getModel();
            String no;
            Table.setColumnCount(0);
            //Table.addColumn("Examen");
            Table.addColumn("Examen");
            Table.setRowCount(0);
            while (result.next())
            {
                Object[] objets= new Object[1];
                //objets[0]= result.getString("Examen");
                objets[0]= result.getString("Type");
                Table.addRow(objets);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Examemn_pratique.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void affichage_examen_selectionner (String id_pa, String id_con)
        {
         try {
            state = (Statement) connection.getInstance().createStatement();
            result = state.executeQuery("SELECT* FROM  labo WHERE Id_pa ='"+id_pa+"' AND Id_cons = '"+id_con+"' ORDER BY Type_ex ;");
            DefaultTableModel Table=  (DefaultTableModel) Tableau_selectionner.getModel();
            String no;
            Table.setColumnCount(0);
            Table.addColumn("Id");
            Table.addColumn("Examen Demandé");
            Table.setRowCount(0);
            while (result.next())
            {
                Object[] objets= new Object[2];
                objets[0]= result.getString("Id_la");
                objets[1]= result.getString("Type_ex");
                Table.addRow(objets);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Examemn_pratique.class.getName()).log(Level.SEVERE, null, ex);
        }   
        }
        
public void info_patient (String Id_pr1,String user1,String id_p,String id_cons,String nom,String postnom, String prenom,String sexe,String dn, String ec,String adresse, String phone, String profession,String employeur, String sorte, String ATDC)
{
    id.setText(id_p);
    id_con.setText(id_cons);
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
    sorte1.setText(sorte);// Pour deterniner d'ou vient  la demande de l'examen 
    user(Id_pr1, user1);
    ATCD_P.setText(ATDC);
}
public void affectation ()
{
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
    public void user(String Id_pr, String user)
{
    user1=user;
    Id_pr1=Id_pr;
    User_nam.setText(user);
}
    public void id_ev(String Id__ev)
    {
        Id_ev.setText(Id__ev);
    }
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    
    Dimension tailleEcran= Toolkit.getDefaultToolkit().getScreenSize();// Recuperation de la taille de l'ecran
    int H=tailleEcran.height;
    int L=tailleEcran.width;
    Sv sv= new Sv();
    affectation ();
    sv.info_patient(Id_pr1,user1,id_psv, nom, postnom, prenom, sexe, dn, ec, ad, ph, pr, em, ATCD_P.getText());
    sv.setSize(L, H);//Longeure et Hauteur l'ecran Id_pr1, dig, user1
    sv.user(Id_pr1, user1);
    sv.setVisible(true);
    this.setVisible(false);
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    enrg.en_labo(Exam.getText(), Type.getText(), id.getText(), id_con.getText(),sorte1.getText(), Id_ev.getText());
    affichage_examen();
    affichage_examen_selectionner (id.getText(), id_con.getText());
    Exam.setText("");
    Type.setText("");
}//GEN-LAST:event_jButton2ActionPerformed

private void Table_examenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_examenMouseClicked
// TODO add your handling code here:
    int ligne_select= Table_examen.getSelectedRowCount();//Nombre de lignes selectionner
    int in= Table_examen.getSelectedRow();
   
   if(ligne_select==1)
   {    
     //Affichage des valeur du tableau dans les champs
       //examen=(String) Table_examen.getModel().getValueAt(in, 0);// On recuper le examen du tableau
       type_examen=(String) Table_examen.getModel().getValueAt(in, 0);// On recuper le type_examen du tableau
       DefaultTableModel Tableau=  (DefaultTableModel) Table_examen.getModel();
       enrg.en_labo(".", type_examen, id.getText(), id_con.getText(),sorte1.getText(), Id_ev.getText());
       affichage_examen_selectionner (id.getText(), id_con.getText());
        Tableau.removeRow(in);//Suppressio de la ligne
   }
}//GEN-LAST:event_Table_examenMouseClicked

private void Tableau_selectionnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tableau_selectionnerMouseClicked
// TODO add your handling code here:
    int ligne_select= Tableau_selectionner.getSelectedRowCount();//Nombre de lignes selectionner
    int in= Tableau_selectionner.getSelectedRow();
  
   if(ligne_select==1)
   {    
     //Affichage des valeur du tableau dans les champs
       String id_lab=(String) Tableau_selectionner.getModel().getValueAt(in, 0);// On recuper le id du tableau
        DefaultTableModel tab=  (DefaultTableModel) Tableau_selectionner.getModel();
        sup.sup_labo(id_lab);
        tab.removeRow(in);//Suppressio de la ligne
   }
}//GEN-LAST:event_Tableau_selectionnerMouseClicked

private void bacteriologieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bacteriologieMouseClicked
// TODO add your handling code here:bacteriologie
    int ligne_select= bacteriologie.getSelectedRowCount();//Nombre de lignes selectionner
    int in= bacteriologie.getSelectedRow();
   
   if(ligne_select==1)
   {    
     //Affichage des valeur du tableau dans les champs
       examen="Bacteriologie";
       type_examen=(String) bacteriologie.getModel().getValueAt(in, 0);// On recuper le id du tableau
        DefaultTableModel Bacteriologie=  (DefaultTableModel) bacteriologie.getModel();
        enrg.en_labo(examen, type_examen, id.getText(), id_con.getText(),sorte1.getText(), Id_ev.getText());
        Bacteriologie.removeRow(in);//Suppressio de la ligne
   }
}//GEN-LAST:event_bacteriologieMouseClicked

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
    enrg.en_image(exam_dem.getText(), Rec.getText(), id_con.getText(),sorte1.getText(), Id_ev.getText());
    exam_dem.setText("");
    Rec.setText("");
    
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
String Rech_exam=Rech_examen.getText();
try {
            state = (Statement) connection.getInstance().createStatement();
            result = state.executeQuery("SELECT* FROM  examen WHERE Type LIKE '"+"%"+Rech_exam+"' ;");
            DefaultTableModel Table=  (DefaultTableModel) Table_examen.getModel();
            String no;
            Table.setColumnCount(0);
            Table.addColumn("Examen");
            Table.addColumn("Type");
            Table.setRowCount(0);
            while (result.next())
            {
                Object[] objets= new Object[2];
                objets[0]= result.getString("Examen");
                objets[1]= result.getString("Type");
                Table.addRow(objets);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Examemn_pratique.class.getName()).log(Level.SEVERE, null, ex);
        }  
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
// MODIFICATION ATCD
    try {
            mofi.modif_ATDC( id.getText(),  ATCD_P.getText());
         } catch (SQLException ex) {
                Logger.getLogger(Sv.class.getName()).log(Level.SEVERE, null, ex);
            }
}//GEN-LAST:event_jButton18ActionPerformed

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
            java.util.logging.Logger.getLogger(Examemn_pratique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Examemn_pratique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Examemn_pratique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Examemn_pratique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Examemn_pratique().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ATCD_P;
    private javax.swing.JLabel A_p;
    private javax.swing.JLabel Dn_p;
    private javax.swing.JLabel EC_p;
    private javax.swing.JLabel Em_p;
    private javax.swing.JTextField Exam;
    private javax.swing.JLabel Id_ev;
    private javax.swing.JLabel Nom_p;
    private javax.swing.JLabel Ph_p;
    private javax.swing.JLabel Postnom_p;
    private javax.swing.JLabel Pr_p;
    private javax.swing.JLabel Prenom_p;
    private javax.swing.JTextArea Rec;
    private javax.swing.JTextField Rech_examen;
    private javax.swing.JLabel Sexe_p;
    private javax.swing.JTable Table_examen;
    private javax.swing.JTable Tableau_selectionner;
    private javax.swing.JTextField Type;
    private javax.swing.JLabel User_nam;
    private javax.swing.JLabel adresseLabel;
    private javax.swing.JTable bacteriologie;
    private javax.swing.JLabel dnLabel;
    private javax.swing.JLabel ecLabel;
    private javax.swing.JLabel employeurLabel;
    private javax.swing.JTextField exam_dem;
    private javax.swing.JLabel id;
    private javax.swing.JLabel id_con;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel postnomLabel;
    private javax.swing.JLabel prenomLabel;
    private javax.swing.JLabel professionLabel;
    private javax.swing.JTable sang2;
    private javax.swing.JLabel sexeLabel;
    private javax.swing.JLabel sorte1;
    // End of variables declaration//GEN-END:variables

    
}
