
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author PC
 */
public final class Satistics extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Satistics.class.getName());

    /**
     * Creates new form Satistics
     */
    public Satistics() {
        initComponents();

        adherentCountLabel.setText(String.valueOf(countAdherents()));
        coachCountLabel.setText(String.valueOf(countCoaches()));
        TodayActivitySessionsLabel.setText(String.valueOf(todaysActivitiesSessions()));
        monthlyRevenueLabel.setText(getMonthlyRevenue() + " DT");
        activityCountLabel.setText(String.valueOf(countDistinctActivitiesByTitle()));
        adminCountLabel.setText(String.valueOf(countAdmins()));
        
        this.setLocationRelativeTo(null);
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            AdminInf m1=new AdminInf();
            m1.setLocationRelativeTo(null);
            m1.pack();
            m1.setVisible(true);
            
            Satistics.this.dispose();
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
                
                Satistics.this.dispose();
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

                Satistics.this.dispose();
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
        members.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        members.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MemberList m1=new MemberList();
                m1.setLocationRelativeTo(null);
                m1.pack();
                m1.setVisible(true);

                Satistics.this.dispose();
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
        
        log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        log.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // JOptionPane.showMessageDialog(null, "log out clicked!");
                LogIn f1 ;
                f1 = new LogIn();

                f1.pack();
                f1.setVisible(true);

                Satistics.this.dispose();
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
        
    }
    private Connection getConnection() {
        ConfigDb db = new ConfigDb();
        return db.getConnection();
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
        members = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        coachs = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        log = new javax.swing.JLabel();
        home = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        activities = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        coachCountContainer = new javax.swing.JPanel();
        coachCountTitle = new java.awt.Label();
        coachCountLabel = new java.awt.Label();
        adherentCountContainer = new javax.swing.JPanel();
        adherentCountTitle = new java.awt.Label();
        adherentCountLabel = new java.awt.Label();
        monthlyRevenueContainer = new javax.swing.JPanel();
        monthlyRevenueTitle = new java.awt.Label();
        monthlyRevenueLabel = new java.awt.Label();
        TodayActivitySessionsContainer = new javax.swing.JPanel();
        TodayActivitySessionsTitle = new java.awt.Label();
        TodayActivitySessionsLabel = new java.awt.Label();
        activityCountContainer = new javax.swing.JPanel();
        activityCountTitle = new java.awt.Label();
        activityCountLabel = new java.awt.Label();
        adminCountContainer = new javax.swing.JPanel();
        adminCountTitle = new java.awt.Label();
        adminCountLabel = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 122, 122));

        members.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        members.setForeground(new java.awt.Color(255, 255, 255));
        members.setText("Members");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("|");

        coachs.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        coachs.setForeground(new java.awt.Color(255, 255, 255));
        coachs.setText("Entraîneurs");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("|");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("|");

        log.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        log.setForeground(new java.awt.Color(255, 255, 255));
        log.setText("Se déconnecter");

        home.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Accueil");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("|");

        activities.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        activities.setForeground(new java.awt.Color(255, 255, 255));
        activities.setText("Activités");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coachs, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(activities, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(members, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activities, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coachs, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        coachCountContainer.setBackground(new java.awt.Color(152, 251, 152));

        coachCountTitle.setText("Coach Count");

        coachCountLabel.setText("0");

        javax.swing.GroupLayout coachCountContainerLayout = new javax.swing.GroupLayout(coachCountContainer);
        coachCountContainer.setLayout(coachCountContainerLayout);
        coachCountContainerLayout.setHorizontalGroup(
            coachCountContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachCountContainerLayout.createSequentialGroup()
                .addGroup(coachCountContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(coachCountContainerLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(coachCountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(coachCountContainerLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(coachCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        coachCountContainerLayout.setVerticalGroup(
            coachCountContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coachCountContainerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(coachCountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coachCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        adherentCountContainer.setBackground(new java.awt.Color(152, 251, 152));

        adherentCountTitle.setText("Adherant Count");

        adherentCountLabel.setText("0");

        javax.swing.GroupLayout adherentCountContainerLayout = new javax.swing.GroupLayout(adherentCountContainer);
        adherentCountContainer.setLayout(adherentCountContainerLayout);
        adherentCountContainerLayout.setHorizontalGroup(
            adherentCountContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adherentCountContainerLayout.createSequentialGroup()
                .addGroup(adherentCountContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adherentCountContainerLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(adherentCountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adherentCountContainerLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(adherentCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adherentCountContainerLayout.setVerticalGroup(
            adherentCountContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adherentCountContainerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(adherentCountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adherentCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        monthlyRevenueContainer.setBackground(new java.awt.Color(152, 251, 152));

        monthlyRevenueTitle.setText("Monthly Revenue");

        monthlyRevenueLabel.setText("0.0");

        javax.swing.GroupLayout monthlyRevenueContainerLayout = new javax.swing.GroupLayout(monthlyRevenueContainer);
        monthlyRevenueContainer.setLayout(monthlyRevenueContainerLayout);
        monthlyRevenueContainerLayout.setHorizontalGroup(
            monthlyRevenueContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monthlyRevenueContainerLayout.createSequentialGroup()
                .addGroup(monthlyRevenueContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(monthlyRevenueContainerLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(monthlyRevenueTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(monthlyRevenueContainerLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(monthlyRevenueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        monthlyRevenueContainerLayout.setVerticalGroup(
            monthlyRevenueContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monthlyRevenueContainerLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(monthlyRevenueTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthlyRevenueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        TodayActivitySessionsContainer.setBackground(new java.awt.Color(152, 251, 152));

        TodayActivitySessionsTitle.setText("Today's Activity Sessions");

        TodayActivitySessionsLabel.setText("0");

        javax.swing.GroupLayout TodayActivitySessionsContainerLayout = new javax.swing.GroupLayout(TodayActivitySessionsContainer);
        TodayActivitySessionsContainer.setLayout(TodayActivitySessionsContainerLayout);
        TodayActivitySessionsContainerLayout.setHorizontalGroup(
            TodayActivitySessionsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TodayActivitySessionsContainerLayout.createSequentialGroup()
                .addGroup(TodayActivitySessionsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TodayActivitySessionsContainerLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(TodayActivitySessionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TodayActivitySessionsContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TodayActivitySessionsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        TodayActivitySessionsContainerLayout.setVerticalGroup(
            TodayActivitySessionsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TodayActivitySessionsContainerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(TodayActivitySessionsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TodayActivitySessionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(monthlyRevenueContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adherentCountContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TodayActivitySessionsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coachCountContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coachCountContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adherentCountContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(monthlyRevenueContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TodayActivitySessionsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(161, 161, 161))
        );

        activityCountContainer.setBackground(new java.awt.Color(152, 251, 152));

        activityCountTitle.setText("Activty Count");

        activityCountLabel.setText("0");

        javax.swing.GroupLayout activityCountContainerLayout = new javax.swing.GroupLayout(activityCountContainer);
        activityCountContainer.setLayout(activityCountContainerLayout);
        activityCountContainerLayout.setHorizontalGroup(
            activityCountContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(activityCountContainerLayout.createSequentialGroup()
                .addGroup(activityCountContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(activityCountContainerLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(activityCountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(activityCountContainerLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(activityCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        activityCountContainerLayout.setVerticalGroup(
            activityCountContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(activityCountContainerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(activityCountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(activityCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        adminCountContainer.setBackground(new java.awt.Color(152, 251, 152));

        adminCountTitle.setText("Admin Count");

        adminCountLabel.setText("0");

        javax.swing.GroupLayout adminCountContainerLayout = new javax.swing.GroupLayout(adminCountContainer);
        adminCountContainer.setLayout(adminCountContainerLayout);
        adminCountContainerLayout.setHorizontalGroup(
            adminCountContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminCountContainerLayout.createSequentialGroup()
                .addGroup(adminCountContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminCountContainerLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(adminCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adminCountContainerLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(adminCountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adminCountContainerLayout.setVerticalGroup(
            adminCountContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminCountContainerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(adminCountTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activityCountContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminCountContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(268, 268, 268))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adminCountContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(activityCountContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(232, 232, 232))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Satistics().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TodayActivitySessionsContainer;
    private java.awt.Label TodayActivitySessionsLabel;
    private java.awt.Label TodayActivitySessionsTitle;
    private javax.swing.JLabel activities;
    private javax.swing.JPanel activityCountContainer;
    private java.awt.Label activityCountLabel;
    private java.awt.Label activityCountTitle;
    private javax.swing.JPanel adherentCountContainer;
    private java.awt.Label adherentCountLabel;
    private java.awt.Label adherentCountTitle;
    private javax.swing.JPanel adminCountContainer;
    private java.awt.Label adminCountLabel;
    private java.awt.Label adminCountTitle;
    private javax.swing.JPanel coachCountContainer;
    private java.awt.Label coachCountLabel;
    private java.awt.Label coachCountTitle;
    private javax.swing.JLabel coachs;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel log;
    private javax.swing.JLabel members;
    private javax.swing.JPanel monthlyRevenueContainer;
    private java.awt.Label monthlyRevenueLabel;
    private java.awt.Label monthlyRevenueTitle;
    // End of variables declaration//GEN-END:variables


    public int countAdherents() {
        String query = "SELECT COUNT(*) FROM person WHERE role = 'adherent'";
        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {

            if (rs.next()) return rs.getInt(1);

        } catch (Exception e) { 

            e.printStackTrace(); 
        }

        return 0;
    }

     public int countAdmins() {
        String query = "SELECT COUNT(*) FROM person WHERE role = 'admin'";
        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {

            if (rs.next()) return rs.getInt(1);

        } catch (Exception e) { 

            e.printStackTrace(); 
        }

        return 0;
    }

    public int countCoaches() {
        String query = "SELECT COUNT(*) FROM person WHERE role = 'coach'";
        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {

            if (rs.next()) return rs.getInt(1);

        } catch (Exception e) { 
            e.printStackTrace(); 
        }

        return 0;
    }

    public double getMonthlyRevenue() {
         String query = 
            "SELECT SUM(amount) FROM payment " +
            "WHERE MONTH(payment_date) = MONTH(CURRENT_DATE()) " +
            "AND YEAR(payment_date) = YEAR(CURRENT_DATE())";

        try (
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {

            if (rs.next()) return rs.getDouble(1);

        } catch (Exception e) { 
            e.printStackTrace(); 
        }

        return 0.0;
    }

    public int todaysActivitiesSessions() {
        String query = "SELECT COUNT(*) AS total FROM activity WHERE activity_date = CURDATE()";
        
        try (
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int countDistinctActivitiesByTitle() {
        String query = "SELECT COUNT(DISTINCT LOWER(title)) AS total FROM activity";

        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }





}
