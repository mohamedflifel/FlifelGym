import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author PC
 */

public class Activity extends javax.swing.JFrame  {
    /**
     * Creates new form activity
     */
    public Activity() {
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
            
            Activity.this.dispose();
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
                
                Activity.this.dispose();
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

        coachs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        coachs.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoachList c=new CoachList();
                c.setLocationRelativeTo(null);
                c.pack();
                c.setVisible(true);
                
                Activity.this.dispose();
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
                
                Activity.this.dispose();
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

                Activity.this.dispose();
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
        loadIdsinComboBox(jComboBoxAdmin,"admin");
        loadIdsinComboBox(jComboBoxCoach,"coach");
        
    }

    
    
    private Connection getConnection() {
        ConfigDb db = new ConfigDb();
        return db.getConnection();
    }
    // medthod for load data from activity
    public List<ActivityModel> loadActivities(){
        List<ActivityModel> activities =  new ArrayList<>();
        String query = "select * from activity";
        
        try{
            // make query select all data from activity table ...
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int idAct = rs.getInt("id_activity");
                String title = rs.getString("title");
                String Description = rs.getString("description");
                Date actDate = rs.getDate("activity_date");
                Time startTime = rs.getTime("start_time");
                Time endTime = rs.getTime("end_time");
                int idCoach = rs.getInt("id_coach");
                int idAdmin = rs.getInt("id_admin");
                
                ActivityModel a = new ActivityModel(
                    idAct,
                    title,
                    Description,
                    actDate,
                    startTime,
                    endTime,
                    idCoach,
                    idAdmin
                );
                activities.add(a);
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return activities;
    }

    // method for load table 
    public void loadAllDataIntoTable(List<ActivityModel> activities){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        for(ActivityModel act : activities ) {
            Vector v = new Vector();
            v.add(act.getIdAct());
            v.add(act.getTitle());
            v.add(act.getDescription());
            v.add(act.getActivityDate());
            v.add(act.getStartTime());
            v.add(act.getEndTime());
            v.add(act.getIdCoach());
            v.add(act.getIdAdmin());
            
            dtm.addRow(v);
            
        }
    }
    
    private void loadTable(){ // call method into constructeur 
        // sucess those method which selecting all data
        List acts = this.loadActivities();
        loadAllDataIntoTable(acts);
        System.out.println("table loaded inside activities ==============="); 
    }

    //method to clear text fields data
    public void clearTextFields(){
        jTextField1.setText("");
        jTextField2.setText("");
        jDateChooser1.setDate(null);
        jTextField3.setText("");
        jTextField4.setText("");
        
        jComboBoxAdmin.setSelectedIndex(-1); // no selection
        jComboBoxCoach.setSelectedIndex(-1); // no selection
        
        jTable1.clearSelection();
    }

    /**
     *
     * @param comboBox
     * @param role
     */
    private void loadIdsinComboBox(JComboBox<Integer> comboBox, String role) {

        String sql = "SELECT id_person FROM person WHERE role = ?";

        try (Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, role);

            try (ResultSet rs = ps.executeQuery()) {

                comboBox.removeAllItems();

                while (rs.next()) {
                    comboBox.addItem(rs.getInt("id_person"));
                }

                comboBox.setSelectedIndex(-1); // no selection
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        starter1 = new com.engelkec.jtableproject.Starter();
        jPanel1 = new javax.swing.JPanel();
        members = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        coachs = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        stats = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        log = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        del = new javax.swing.JButton();
        ref = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        upd = new javax.swing.JButton();
        cls = new javax.swing.JButton();
        jComboBoxCoach = new javax.swing.JComboBox<>();
        jComboBoxAdmin = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(0, 122, 122));

        members.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        members.setForeground(new java.awt.Color(255, 255, 255));
        members.setText("Members");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("|");

        coachs.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        coachs.setForeground(new java.awt.Color(255, 255, 255));
        coachs.setText("Coaches");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("|");

        stats.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        stats.setForeground(new java.awt.Color(255, 255, 255));
        stats.setText("Statistcs");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("|");

        log.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        log.setForeground(new java.awt.Color(255, 255, 255));
        log.setText("Log out");

        home.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Home");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("|");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(members, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(coachs, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stats, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
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
                            .addComponent(members, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coachs, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Member", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 18))); // NOI18N

        jLabel4.setText("activty Date :");

        jLabel5.setText("Title : ");

        jLabel6.setText("Description :");

        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        insert.setText("Insert");
        insert.addActionListener(this::insertActionPerformed);

        del.setText("Delete");
        del.addActionListener(this::delActionPerformed);

        ref.setText("Refresh");
        ref.addActionListener(this::refActionPerformed);

        jLabel8.setText("Start Time :");

        jLabel9.setText("End Time :");

        jLabel10.setText("coach Id :");

        jLabel11.setText("admin id :");

        upd.setText("Update");
        upd.addActionListener(this::updActionPerformed);

        cls.setText("Clear");
        cls.addActionListener(this::clsActionPerformed);


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ref, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxAdmin, 0, 83, Short.MAX_VALUE)
                                            .addComponent(jTextField4))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxCoach, 0, 95, Short.MAX_VALUE)
                                            .addComponent(jTextField3))))))))
                .addGap(37, 37, 37))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(upd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(cls, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCoach, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(del, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ref, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(cls, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id activity", "title", "Description", "activity date", "start time", "end time", "coach id", "admin id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        String title = jTextField1.getText();
        String description = jTextField2.getText();
        Date activityDate = new Date(jDateChooser1.getDate().getTime());
        Time startTime = Time.valueOf(jTextField4.getText());
        Time endTime = Time.valueOf(jTextField3.getText());
        Integer idAdmin = (Integer) jComboBoxAdmin.getSelectedItem();
        Integer idCoach = (Integer) jComboBoxCoach.getSelectedItem();
        ActivityModel activity = new ActivityModel(
            SelectedIdAct,
            title,
            description,
            activityDate,
            startTime,
            endTime,
            idCoach,
            idAdmin
        );


        this.insertActivity(activity);
        loadTable();
    }//GEN-LAST:event_insertActionPerformed

    private void delActionPerformed(java.awt.event.ActionEvent evt) {                                    
        this.deleteActivity(SelectedIdAct);
        loadTable(); // refresh table after delete
    }

    private void updActionPerformed(java.awt.event.ActionEvent evt) {                                    
        String title = jTextField1.getText();
        String description = jTextField2.getText();
        Date activityDate = new Date(jDateChooser1.getDate().getTime());
        Time startTime = Time.valueOf(jTextField4.getText());
        Time endTime = Time.valueOf(jTextField3.getText());
        Integer selectedAdminId = (Integer) jComboBoxAdmin.getSelectedItem();
        Integer selectedCoachId = (Integer) jComboBoxCoach.getSelectedItem();

        ActivityModel activity = new ActivityModel(
            SelectedIdAct,
            title,
            description,
            activityDate,
            startTime,
            endTime,
            selectedCoachId,
            selectedAdminId
        );
        this.updateActivity(activity);
        loadTable(); // refresh table after update
        

    
    }

    private void refActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refActionPerformed
        Activity a = new Activity();
        a.setLocationRelativeTo(null);
        a.pack();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_refActionPerformed

    private void clsActionPerformed(java.awt.event.ActionEvent evt) {                                    
        clearTextFields();
    }

    

    
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
    
    private void setComboSelection(JComboBox<Integer> combo, Integer value) {
    if (value == 0) {
        combo.setSelectedIndex(-1);
    } else {
        combo.setSelectedItem(value);
    }
}
    
    int SelectedIdAct = 0;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(this, "No row selected for update or delete !");
            // if no row selected this msg will show to user 
        }else {

            // get values from table to text fields 
            SelectedIdAct = (int) jTable1.getValueAt(row, 0); // get id Act
            
            ActivityModel activity = this.returnAllDataToTextFields(SelectedIdAct);


            jTextField1.setText(activity.getTitle());
            jTextField2.setText(activity.getDescription());
            jDateChooser1.setDate(activity.getActivityDate());
            jTextField4.setText(activity.getStartTime().toString());
            jTextField3.setText(activity.getEndTime().toString());
            
            setComboSelection(jComboBoxCoach, activity.getIdCoach());  
            setComboSelection(jComboBoxAdmin, activity.getIdAdmin());
            
            
            
        }
        
    }//GEN-LAST:event_jTable1MouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cls;
    private javax.swing.JLabel coachs;
    private javax.swing.JButton del;
    private javax.swing.JLabel home;
    private javax.swing.JButton insert;
    private javax.swing.JComboBox<Integer> jComboBoxAdmin;
    private javax.swing.JComboBox<Integer> jComboBoxCoach;
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
    private javax.swing.JLabel members;
    private javax.swing.JButton ref;
    private com.engelkec.jtableproject.Starter starter1;
    private javax.swing.JLabel stats;
    private javax.swing.JButton upd;
    // End of variables declaration//GEN-END:variables

    // method for fetch row table to text fields
    public ActivityModel returnAllDataToTextFields(int id){
        ActivityModel a = null;
        try {
           String query = "select * from activity where id_activity="+id; 
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                int idAct = rs.getInt("id_activity");
                String title = rs.getString("title");
                String Description = rs.getString("description");
                Date actDate = rs.getDate("activity_date");
                Time startTime = rs.getTime("start_time");
                Time endTime = rs.getTime("end_time");
                int idCoach = rs.getInt("id_coach");
                int idAdmin = rs.getInt("id_admin");
                a = new ActivityModel(
                    idAct,
                    title,
                    Description,
                    actDate,
                    startTime,
                    endTime,
                    idCoach,
                    idAdmin
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return a;
    }

    // methode insert activity in database
    public ActivityModel insertActivity(ActivityModel activity){
        try {
            String query = "insert into activity (title, description, activity_date, start_time, end_time, id_coach, id_admin) values (?, ?, ?, ?, ?, ?, ?)";
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, activity.getTitle());
            ps.setString(2, activity.getDescription());
            ps.setDate(3, activity.getActivityDate());
            ps.setTime(4, activity.getStartTime());
            ps.setTime(5,  activity.getEndTime());
            ps.setInt(6, activity.getIdCoach());
            ps.setInt(7, activity.getIdAdmin());
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Activity inserted successfully !");
                this.clearTextFields();
            }else {
                JOptionPane.showMessageDialog(null, "Failed to insert activity !");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return activity;
    }

    // a method for update data select on table from text fields 
    public void updateActivity(ActivityModel activity){
        try {
            String query = "update activity set title=?, description=?, activity_date=?, start_time=?, end_time=?, id_coach=?, id_admin=? where id_activity=?";
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, activity.getTitle());
            ps.setString(2, activity.getDescription());
            ps.setDate(3, activity.getActivityDate());
            ps.setTime(4, activity.getStartTime());
            ps.setTime(5, activity.getEndTime());
            ps.setInt(6, activity.getIdCoach());
            ps.setInt(7, activity.getIdAdmin());
            ps.setInt(8, SelectedIdAct);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Activity updated successfully !");
                this.clearTextFields();
            }else {
                JOptionPane.showMessageDialog(null, "Failed to update activity !");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // method for delete activity
    public void deleteActivity(int id){
        try {
            String query = "delete from activity where id_activity=?";
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Activity deleted successfully !");
                this.clearTextFields();
            }else {
                JOptionPane.showMessageDialog(null, "Failed to delete activity !");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
}
