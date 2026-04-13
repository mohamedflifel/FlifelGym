
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author PC
 */
public class CoachTodayActivities extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CoachTodayActivities.class.getName());
    private final int coachId;
    /**
     * Creates new form CoachTodayActivities
     */
    public CoachTodayActivities(int coachId) {
        this.coachId = coachId;
        initComponents();
        this.setLocationRelativeTo(null);
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoachInf m1=new CoachInf(coachId);
                m1.setLocationRelativeTo(null);
                m1.pack();
                m1.setVisible(true);

                CoachTodayActivities.this.dispose();
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
        
        log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        log.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // JOptionPane.showMessageDialog(null, "log out clicked!");
                LogIn f1 ;
                f1 = new LogIn();

                f1.pack();
                f1.setVisible(true);

                CoachTodayActivities.this.dispose();
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
    // medthod for load data from activity
    public List<ActivityModel> loadActivities(){
        List<ActivityModel> activities =  new ArrayList<>();
        String query = "select * from activity where activity_date = CURDATE() AND id_coach = "
                + coachId + ";";
        
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
            // v.add(act.getIdCoach());
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        log = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 122, 122));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("|");

        log.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        log.setForeground(new java.awt.Color(255, 255, 255));
        log.setText("Log out");

        home.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Home");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Activity Id", "Title", "Description", "Activity Date", "Start Time", "End Time", "Added By Admin "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @-param args the command line arguments
     */
    // public static void main(String args[]) {
    //     /* Set the Nimbus look and feel */
    //     //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    //     /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    //      * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    //      */
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
    //         logger.log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */

    //     java.awt.EventQueue.invokeLater(() -> new CoachTodayActivities().setVisible(true));
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel log;
    // End of variables declaration//GEN-END:variables
}
