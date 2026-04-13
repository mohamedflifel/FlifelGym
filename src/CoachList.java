
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.CoachModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class CoachList extends javax.swing.JFrame {

    /**
     * Creates new form CoachList
     */
    public CoachList() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminInf f=new AdminInf();
                f.setLocationRelativeTo(null);
                f.pack();
                f.setVisible(true);
                
                CoachList.this.dispose();
            }
            @Override
            public void mouseEntered(MouseEvent evt) {
                home.setForeground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                home.setForeground(Color.WHITE);
            }
        });
        
        members.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        members.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MemberList m1=new MemberList();
                m1.setLocationRelativeTo(null);
                m1.pack();
                m1.setVisible(true);
                
                CoachList.this.dispose();
            }
            @Override
            public void mouseEntered(MouseEvent evt) {
                members.setForeground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                members.setForeground(Color.WHITE);
            }
        });
        activities.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        activities.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Activity m1=new Activity();
                m1.setLocationRelativeTo(null);
                m1.pack();
                m1.setVisible(true);
                
                CoachList.this.dispose();
            }
            @Override
            public void mouseEntered(MouseEvent evt) {
                activities.setForeground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                activities.setForeground(Color.WHITE);
            }
        });
     
        stats.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stats.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Satistics s=new Satistics();
                s.setLocationRelativeTo(null);
                s.pack();
                s.setVisible(true);

                CoachList.this.dispose();
  
            }
            @Override
            public void mouseEntered(MouseEvent evt) {
                stats.setForeground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                stats.setForeground(Color.WHITE);
            }
        });
        
        log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        log.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // JOptionPane.showMessageDialog(null, "log out clicked!");
                LogIn f1 ;
                f1 = new LogIn();

                f1.pack();
                f1.setVisible(true);

                CoachList.this.dispose();
            }
            @Override
            public void mouseEntered(MouseEvent evt) {
                log.setForeground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                log.setForeground(Color.WHITE);
            }
        });
        this.loadTable();
    }
    
    private Connection getConnection() {
        ConfigDb db = new ConfigDb();
        return db.getConnection();
    }
    
    // medthod for load data from coach
    public List<CoachModel> loadCoaches(){
        List<CoachModel> coaches =  new ArrayList<>();
        
        String query = 
                "SELECT p.id_person, p.name, p.email, p.password, c.speciality " +
                "FROM person p " +
                "JOIN coach c ON p.id_person = c.id_coach ";
        
        try{
            // make query select all data from coach table ...
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int idCoach = rs.getInt("id_person");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String speciality = rs.getString("speciality");
                
                CoachModel a = new CoachModel(
                    idCoach,
                    name,
                    email,
                    password,
                    speciality
                );
                coaches.add(a);
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
           
        }
        return coaches;
    }

    // method for load table 
    public void loadAllDataIntoTable(List<CoachModel> coaches){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        for(CoachModel coach : coaches ) {
            Vector v = new Vector();
            v.add(coach.getIdCoach());
            v.add(coach.getName());
            v.add(coach.getEmail());
            v.add(coach.getPassword());
            v.add(coach.getSpeciality());
            
            dtm.addRow(v);
            
        }
    }
    
    private void loadTable(){ // call method into constructeur 
        // sucess those method which selecting all data
        List coaches = this.loadCoaches();
        loadAllDataIntoTable(coaches);
        System.out.println("table loaded inside activities ==============="); 
    }
    
    //method to clear text fields data
    public void clearTextFields(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTable1.clearSelection();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        activities = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        stats = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        log = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        members = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        del = new javax.swing.JButton();
        upd = new javax.swing.JButton();
        ref = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        cls = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        Attribuer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 122, 122));

        activities.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        activities.setForeground(new java.awt.Color(255, 255, 255));
        activities.setText("Activités");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("|");

        home.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Accueil");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("|");

        stats.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        stats.setForeground(new java.awt.Color(255, 255, 255));
        stats.setText("Statistiques");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("|");

        log.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        log.setForeground(new java.awt.Color(255, 255, 255));
        log.setText("Se déconnecter");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("|");

        members.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        members.setForeground(new java.awt.Color(255, 255, 255));
        members.setText("Members");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(activities, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(members, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stats, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(log)
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stats, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(activities, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(members, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Coach", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 18))); // NOI18N

        jLabel5.setText("Name :");

        insert.setText("Insérer");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        del.setText("Supprimer");
        del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delActionPerformed(evt);
            }
        });

        upd.setText("Mettre à jour");
        upd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updActionPerformed(evt);
            }
        });

        ref.setText("Actualiser");
        ref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refActionPerformed(evt);
            }
        });

        jLabel7.setText("email :");

        jLabel8.setText("Password :");

        cls.setText("Effacer");
        cls.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clsMouseClicked(evt);
            }
        });

        jLabel10.setText("Speciality :");

        Attribuer.setText("Attribuer");
        Attribuer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttribuerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField1)
                            .addComponent(jTextField4)
                            .addComponent(jTextField3))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cls, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Attribuer, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(upd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ref, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(14, 14, 14))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ref, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cls, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Attribuer, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Coach", "Name", "Email", "Password", "Speciality"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        String name = jTextField1.getText();
        String email = jTextField2.getText();
        String password = jTextField3.getText();
        String speciality = jTextField4.getText();
        
        CoachModel coach = new CoachModel(
            SelectedIdCoach,
            name,
            email,
            password,
            speciality);


        this.insertCoach(coach);
        loadTable();
    }//GEN-LAST:event_insertActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        this.deleteCoach(SelectedIdCoach);
        loadTable(); // refresh table after delete
    }//GEN-LAST:event_delActionPerformed

    private void updActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updActionPerformed
        String name = jTextField1.getText();
        String email = jTextField2.getText();
        String password = jTextField3.getText();
        String speciality = jTextField4.getText();
        
        CoachModel coach = new CoachModel(
            SelectedIdCoach,
            name,
            email,
            password,
            speciality);
        this.updateCoach(coach);
        loadTable(); // refresh table after update
    }//GEN-LAST:event_updActionPerformed

    private void refActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refActionPerformed
        CoachList f=new CoachList();
        f.setLocationRelativeTo(null);
        f.pack();
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_refActionPerformed

    private void AttribuerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttribuerActionPerformed
        JOptionPane.showMessageDialog(
            this, 
            "Ce bouton sera implémenté dans le futur", 
            "Info", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_AttribuerActionPerformed

    private void clsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clsMouseClicked
        System.out.println("button clicked clear ==================");
        this.clearTextFields();
    }//GEN-LAST:event_clsMouseClicked
    
    int SelectedIdCoach = 0;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(this, "No row selected for update or delete !");
            // if no row selected this msg will show to user 
        }else {

            // get values from table to text fields 
            SelectedIdCoach = (int) jTable1.getValueAt(row, 0); // get id Coach
            
            CoachModel coach = this.returnAllDataToTextFields(SelectedIdCoach);


            jTextField1.setText(coach.getName());
            jTextField2.setText(coach.getEmail());
            jTextField3.setText(coach.getPassword());
            jTextField4.setText(coach.getSpeciality());
        }
    }//GEN-LAST:event_jTable1MouseClicked




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
            java.util.logging.Logger.getLogger(CoachList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoachList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoachList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoachList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoachList().setVisible(true);
            }
        });
    }

    // method for fetch row table to text fields
    public CoachModel returnAllDataToTextFields(int id){
        CoachModel a = null;
        try {
            String query = 
                "SELECT p.id_person, p.name, p.email, p.password, c.speciality " +
                "FROM person p " +
                "JOIN coach c ON p.id_person = c.id_coach " +
                "WHERE p.id_person = ?";
            
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
             
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                int idCoach = rs.getInt("id_person");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String speciality = rs.getString("speciality");
                a = new CoachModel(
                    idCoach,
                    name,
                    email,
                    password,
                    speciality
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return a;
    }
    
    // methode insert Coach in database
    public CoachModel insertCoach(CoachModel coach){
        try {
            
            Connection con = getConnection();
            // 1. INSERT into person
            String insertPerson = 
                "INSERT INTO person (name, email, password, role) VALUES (?, ?, ?, 'coach')";
            
            PreparedStatement ps1 = con.prepareStatement(insertPerson, Statement.RETURN_GENERATED_KEYS);
            
            ps1.setString(1, coach.getName());
            ps1.setString(2, coach.getEmail());
            ps1.setString(3, coach.getPassword());
            
            
            int res1 = ps1.executeUpdate();
            
            if (res1 > 0) {
                ResultSet rs = ps1.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);  // new id_person
                    coach.setIdCoach(generatedId);
                }

                // 2. INSERT into coach
                String insertCoach = "INSERT INTO coach (id_coach, speciality) VALUES (?, ?)";
                try (PreparedStatement ps2 = con.prepareStatement(insertCoach)) {
                    ps2.setInt(1, coach.getIdCoach());
                    ps2.setString(2, coach.getSpeciality());
                    
                    int res2 = ps2.executeUpdate();
                    
                    if (res2 > 0) {
                        JOptionPane.showMessageDialog(null, "Coach inserted successfully!");
                        this.clearTextFields();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to insert coach in coach table!");
                    }
                }catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Failed to insert coach in person table!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return coach;
    }
    
    // a method for update data select on table from text fields 
    public void updateCoach(CoachModel coach){
        try {
            Connection con = getConnection();

            // 1. UPDATE person (name, email, password)
            String updatePerson = 
                "UPDATE person SET name = ?, email = ?, password = ? WHERE id_person = ?";
            
            PreparedStatement ps1 = con.prepareStatement(updatePerson);
            ps1.setString(1, coach.getName());
            ps1.setString(2, coach.getEmail());
            ps1.setString(3, coach.getPassword());
            ps1.setInt(4, coach.getIdCoach());

            int res1 = ps1.executeUpdate();
            
            if(res1>0){
                // 2. UPDATE coach (speciality)
                String updateCoach = 
                    "UPDATE coach SET speciality = ? WHERE id_coach = ?";

                PreparedStatement ps2 = con.prepareStatement(updateCoach);
                ps2.setString(1, coach.getSpeciality());
                ps2.setInt(2, coach.getIdCoach());

                int res2 = ps2.executeUpdate();
                if(res2>0){
                    JOptionPane.showMessageDialog(null, "Coach updated successfully!");
                    this.clearTextFields();
                }else {
                    JOptionPane.showMessageDialog(null, "Failed to update coach in coach table!");
                }
                ps2.close();
            }else {
                JOptionPane.showMessageDialog(null, "Failed to update coach in person table!");
            }
            ps1.close();
            con.close();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    // method for delete coach
    public void deleteCoach(int id){
        try {
            String query = "DELETE FROM person WHERE id_person = ?";
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Coach deleted successfully !");
                this.clearTextFields();
            }else {
                JOptionPane.showMessageDialog(null, "Failed to delete coach !");
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Attribuer;
    private javax.swing.JLabel activities;
    private javax.swing.JButton cls;
    private javax.swing.JButton del;
    private javax.swing.JLabel home;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel log;
    private javax.swing.JLabel members;
    private javax.swing.JButton ref;
    private javax.swing.JLabel stats;
    private javax.swing.JButton upd;
    // End of variables declaration//GEN-END:variables
}
