
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
import models.AdherantModel;
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
public class MemberList extends javax.swing.JFrame {

    /**
     * Creates new form MemberList
     */
    public MemberList() {
        initComponents();
        this.setLocationRelativeTo(null);
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            AdminInf m1=new AdminInf();
            m1.setLocationRelativeTo(null);
            m1.pack();
            m1.setVisible(true);
            
            MemberList.this.dispose();
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

        activities.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        activities.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Activity m1=new Activity();
                m1.setLocationRelativeTo(null);
                m1.pack();
                m1.setVisible(true);
                
                MemberList.this.dispose();
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

        
        coachs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        coachs.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            CoachList c=new CoachList();
            c.setLocationRelativeTo(null);
            c.pack();
            c.setVisible(true);
            
            MemberList.this.dispose();
        }
        @Override
        public void mouseEntered(MouseEvent evt) {
            coachs.setForeground(Color.YELLOW);
        }

        @Override
        public void mouseExited(MouseEvent evt) {
            coachs.setForeground(Color.WHITE);
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

            MemberList.this.dispose();
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

            MemberList.this.dispose();
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
    
    loadTable();
    }
    
    private Connection getConnection() {
        ConfigDb db = new ConfigDb();
        return db.getConnection();
    }
    
    // medthod for load data from coach
    public List<AdherantModel> loadAdherants(){
        List<AdherantModel> adherents =  new ArrayList<>();
        
        String query = 
                "SELECT p.id_person, p.name, p.email, p.password, p.phone_number, a.current_subscription_start ,a.current_subscription_end, a.associated_program " +
                "FROM person p " +
                "JOIN adherent a ON p.id_person = a.id_adherent";
        
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
                String phoneNumber = rs.getString("phone_number");
                String associatedProgram = rs.getString("associated_program");
                Date subscriptionStart = rs.getDate("current_subscription_start");
                Date subscriptionEnd = rs.getDate("current_subscription_end"); 
                AdherantModel a = new AdherantModel(
                    idCoach,
                    name,
                    email,
                    password,
                    phoneNumber,
                    associatedProgram,
                    subscriptionStart,
                    subscriptionEnd      
                );
                adherents.add(a);
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
           
        }
        System.out.println("table loaded inside activities ===============");
        return adherents;
    }
    
    // method for load table 
    public void loadAllDataIntoTable(List<AdherantModel> adherents){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        for(AdherantModel adherent : adherents ) {
            Vector v = new Vector();
            v.add(adherent.getIdAdherant());
            v.add(adherent.getName());
            v.add(adherent.getEmail());
            v.add(adherent.getPassword());
            v.add(adherent.getSubScriptionStart());
            v.add(adherent.getSubScriptionEnd());
            v.add(adherent.getPhoneNumber());
            
            dtm.addRow(v);
            
        }
    }
    private void loadTable(){ // call method into constructeur 
        // sucess those method which selecting all data
        List adherents = this.loadAdherants();
        loadAllDataIntoTable(adherents);
    }
    

    
    //method to clear text fields data
    public void clearTextFields(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jComboBox1.setSelectedItem("1 mois");
        jDateChooser1.setDate(null);
        jTable1.clearSelection();
    }
    
    private boolean isNumeric(String ch){
        if (ch.isEmpty()) {
            return false;
        }
        else{
            for (int i = 0; i < ch.length(); i++) {
                if (ch.charAt(i)>= '0' && ch.charAt(i)<='9') {    
                }
                else{
                    return false;
                }
                
            }
        }
        return true;
    }
    private boolean VefPhone(String ch){
        return ch.length()==8 && isNumeric(ch);
    }
    
    private boolean VefEmail(String ch) {
        if (ch == null) return false;

        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";
        return ch.matches(emailRegex);
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
        home = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        coachs = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        stats = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        log = new javax.swing.JLabel();
        activities = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        del = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        upd = new javax.swing.JButton();
        cls = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        Renouvellement = new javax.swing.JButton();
        ref = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 122, 122));

        home.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Home");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("|");

        coachs.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        coachs.setForeground(new java.awt.Color(255, 255, 255));
        coachs.setText("Entraîneurs");

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
        log.setText("Log out");

        activities.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        activities.setForeground(new java.awt.Color(255, 255, 255));
        activities.setText("Activities");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("|");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("|");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(activities, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coachs, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stats, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(651, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(449, 449, 449)))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(coachs, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(activities, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Member", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 18))); // NOI18N

        jLabel4.setText("Numéro Télephone :");

        jLabel5.setText("Nom :");

        jLabel6.setText("E-mail :");

        insert.setText("Insérer");
        insert.setMaximumSize(new java.awt.Dimension(98, 23));
        insert.setMinimumSize(new java.awt.Dimension(98, 23));
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

        jLabel9.setText("Mot de Passe :");

        upd.setText("Mettre à jour");
        upd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updActionPerformed(evt);
            }
        });

        cls.setText("Effacer");
        cls.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clsMouseClicked(evt);
            }
        });

        jLabel10.setText("Programme associé :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 mois", "3 mois", "6 mois", "12 mois" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Début abonnement :");

        Renouvellement.setText("Renouvellement");
        Renouvellement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RenouvellementActionPerformed(evt);
            }
        });

        ref.setText("Actualiser");
        ref.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refMouseClicked(evt);
            }
        });
        ref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cls, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insert, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(upd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ref, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(del, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Renouvellement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cls, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Renouvellement, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ref, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Membre", "Nom", "E-mail", "Mot de Passe", "Debut abonnement", "Fin abonnement", "Numéro Teléphone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Membre\n");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        String name = jTextField1.getText();
        String email = jTextField2.getText();
        String password = jTextField3.getText();
        String phoneNumber = jTextField4.getText();
        String selectedProgram = jComboBox1.getSelectedItem().toString();
        Date subscriptionStart = new Date(jDateChooser1.getDate().getTime());
        AdherantModel adherent = new AdherantModel(
            SelectedIdMember,
            name,
            email,
            password,
            phoneNumber,
            selectedProgram,
            subscriptionStart);


        this.insertAdherent(adherent);
        loadTable();
    }//GEN-LAST:event_insertActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
        this.deleteMember(SelectedIdMember);
        loadTable(); // refresh table after delete
    }//GEN-LAST:event_delActionPerformed

    private void refActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refActionPerformed
        MemberList f=new MemberList();
        f.setLocationRelativeTo(null);
        f.pack();
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_refActionPerformed

    private void updActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updActionPerformed
        String name = jTextField1.getText();
        String email = jTextField2.getText();
        String password = jTextField3.getText();
        String phoneNumber = jTextField4.getText();
        String selectedProgram = jComboBox1.getSelectedItem().toString();
        Date subscriptionStart = new Date(jDateChooser1.getDate().getTime());
        AdherantModel adherent = new AdherantModel(
            SelectedIdMember,
            name,
            email,
            password,
            phoneNumber,
            selectedProgram,
            subscriptionStart);
        
        this.updateAdherent(adherent);
        loadTable(); // refresh table after update
    }//GEN-LAST:event_updActionPerformed

    private void clsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clsMouseClicked
        System.out.println("button clicked clear ==================");
        this.clearTextFields();
    }//GEN-LAST:event_clsMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    int SelectedIdMember = 0;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(this, "No row selected for update or delete !");
            // if no row selected this msg will show to user 
        }else {

            // get values from table to text fields 
            SelectedIdMember = (int) jTable1.getValueAt(row, 0); // get id Coach
            
            AdherantModel adherent = this.returnAllDataToTextFields(SelectedIdMember);


            jTextField1.setText(adherent.getName());
            jTextField2.setText(adherent.getEmail());
            jTextField3.setText(adherent.getPassword());
            jTextField4.setText(adherent.getPhoneNumber());
            jComboBox1.setSelectedItem(adherent.getAssociatedProgram());
            jDateChooser1.setDate(adherent.getSubScriptionStart());
            
            
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void RenouvellementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenouvellementActionPerformed
        JOptionPane.showMessageDialog(
            this, 
            "Ce bouton sera implémenté dans le futur", 
            "Info", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_RenouvellementActionPerformed

    private void refMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_refMouseClicked

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
            java.util.logging.Logger.getLogger(MemberList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberList().setVisible(true);
            }
        });
    }
    
    // method for fetch row table to text fields
    public AdherantModel returnAllDataToTextFields(int id){
        AdherantModel a = null;
        try {
            String query = 
                "SELECT p.id_person, p.name, p.email, p.password, p.phone_number,a.current_subscription_start , a.current_subscription_end, a.associated_program " +
                "FROM person p " +
                "JOIN adherent a ON p.id_person = a.id_adherent " +
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
                String phoneNumber = rs.getString("phone");
                String associatedProgram = rs.getString("associated_program");
                Date subscriptionStart = rs.getDate("current_subscription_start");
                Date subscriptionEnd = rs.getDate("current_subscription_end");
                a = new AdherantModel(
                    idCoach,
                    name,
                    email,
                    password,
                    phoneNumber,
                    associatedProgram,
                    subscriptionStart,
                    subscriptionEnd);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(e.getMessage());
        }
        return a;
    }
    
    // methode insert Adherent in database
    public AdherantModel insertAdherent(AdherantModel adherent){
        try {
            
            Connection con = getConnection();
            // 1. INSERT into person
            String insertPerson = 
                "INSERT INTO person (name, email, password,phone_number, role) VALUES (?, ?, ?, ?, 'adherent')";
            
            PreparedStatement ps1 = con.prepareStatement(insertPerson, Statement.RETURN_GENERATED_KEYS);
            
            ps1.setString(1, adherent.getName());
            ps1.setString(2, adherent.getEmail());
            ps1.setString(3, adherent.getPassword());
            ps1.setString(4, adherent.getPhoneNumber());
            
            
            int res1 = ps1.executeUpdate();
            
            if (res1 > 0) {
                ResultSet rs = ps1.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);  // new id_person
                    adherent.setIdAdherant(generatedId);
                }

                // 2. INSERT into Adherent
                String insertAdherent = "INSERT INTO adherent (id_adherent, current_subscription_start, current_subscription_end, associated_program) VALUES (?, ?, ?, ?)";
                try (PreparedStatement ps2 = con.prepareStatement(insertAdherent)) {
                    ps2.setInt(1, adherent.getIdAdherant());
                    ps2.setDate(2, adherent.getSubScriptionStart());
                    ps2.setDate(3, adherent.getSubScriptionEnd());
                    ps2.setString(4, adherent.getAssociatedProgram());
                    int res2 = ps2.executeUpdate();
                    
                    if (res2 > 0) {
                        JOptionPane.showMessageDialog(null, "Adherent inserted successfully!");
                        this.clearTextFields();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to insert Adherent in Adherent table!");
                    }
                }catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Failed to insert Adhrent in person table!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return adherent;
    }
    
    // a method for update data select on table from text fields 
    public void updateAdherent(AdherantModel adherent){
        try {
            Connection con = getConnection();

            // 1. UPDATE person (name, email, password)
            String updatePerson = 
                "UPDATE person SET name = ?, email = ?, password = ?, phone_number = ? WHERE id_person = ?";
            
            PreparedStatement ps1 = con.prepareStatement(updatePerson);
            ps1.setString(1, adherent.getName());
            ps1.setString(2, adherent.getEmail());
            ps1.setString(3, adherent.getPassword());
            ps1.setString(4, adherent.getPhoneNumber());
            ps1.setInt(5, adherent.getIdAdherant());

            int res1 = ps1.executeUpdate();
            
            if(res1>0){
                // 2. UPDATE Adherent (associated_program ==> current_subscription_end)
                String updateAdherent = 
                    "UPDATE adherent SET associated_program = ?, current_subscription_end = ?, current_subscription_start = ? WHERE id_adherent = ?";

                try (PreparedStatement ps2 = con.prepareStatement(updateAdherent)) {
                    ps2.setString(1, adherent.getAssociatedProgram());
                    ps2.setDate(2, adherent.getSubScriptionEnd());
                    ps2.setDate(3, adherent.getSubScriptionStart());
                    ps2.setInt(4, adherent.getIdAdherant());
                    
                    int res2 = ps2.executeUpdate();
                    if(res2>0){
                        JOptionPane.showMessageDialog(null, "Adherent updated successfully!");
                        this.clearTextFields();
                    }else {
                        JOptionPane.showMessageDialog(null, "Failed to update Adherent in Adherent table!");
                    }
                }catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }else {
                JOptionPane.showMessageDialog(null, "Failed to update Adherent in person table!");
            }
            ps1.close();
            con.close();
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    // method for delete Member
    public void deleteMember(int id){
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
    private javax.swing.JButton Renouvellement;
    private javax.swing.JLabel activities;
    private javax.swing.JButton cls;
    private javax.swing.JLabel coachs;
    private javax.swing.JButton del;
    private javax.swing.JLabel home;
    private javax.swing.JButton insert;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JButton ref;
    private javax.swing.JLabel stats;
    private javax.swing.JButton upd;
    // End of variables declaration//GEN-END:variables
}
