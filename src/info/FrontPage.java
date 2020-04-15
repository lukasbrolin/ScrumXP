/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

/**
 *
 * @author Lukas
 */
public class FrontPage extends javax.swing.JFrame {

    private int inValue;

    private int researchCategoryID;

    private int educationCategoryID;

    /**
     * Creates new form Forum
     */
    public FrontPage() {
        initComponents();
        //addAllForumPost();

        //setExtendedState(MAXIMIZED_BOTH);
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //int height = screenSize.height;
        //int width = screenSize.width;
        //setSize(width, height);
        setLocationRelativeTo(null);

    }

    /*public int getResearchCategoryID() // Get the PK for the research Category in the database
    {
        try{
        researchCategoryID = Integer.parseInt(conn.fetchSingle("SELECT CATEGORY_ID FROM CATEGORY WHERE CATEGORY_NAME = " + "'" + "Research" + "'"));
        }

        catch(SQLException ex)
        {
           Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(researchCategoryID);
        return researchCategoryID;

        }

     public int getEducationCategoryID() // Get the PK for the education Category in the database
    {
        try{
        educationCategoryID = Integer.parseInt(conn.fetchSingle("SELECT CATEGORY_ID FROM CATEGORY WHERE CATEGORY_NAME = " + "'" + "Education" + "'"));
        }

        catch(SQLException ex)
        {
           Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return educationCategoryID;
        }


    public void addAllGeneralPost() // add all the Post which are Informal to the table
    {
     try {
            DefaultTableModel model = (DefaultTableModel)tblForumPost.getModel();
            model.setRowCount(0);
           ArrayList<HashMap<String, String>> posts = conn.fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM INFORMAL_POST)");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION")});

            }
        } catch (SQLException ex)

        {
           Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void addAllForumPost() // add all the Post to the table
    {
        try {
            DefaultTableModel model = (DefaultTableModel)tblForumPost.getModel();

            model.setRowCount(0);
           ArrayList<HashMap<String, String>> posts = conn.fetchRows("select * FROM POSTS");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION")});
                //model.addRow(new Object[]{"Hej"});
            }
        } catch (SQLException ex)

        {
           Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public void addCategoryForumPost(int inValue) // add all the Post in a certain category  to the table
        {


            try {
            DefaultTableModel model = (DefaultTableModel)tblForumPost.getModel();
            model.setRowCount(0);
             this.inValue = inValue;


           ArrayList<HashMap<String, String>> posts = conn.fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM FORMAL_POST WHERE CATEGORY = " + inValue + ")");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION")});

            }
        } catch (SQLException ex)

        {
           Logger.getLogger(FrontPage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackgroundForum = new javax.swing.JPanel();
        pnlHeaderForum = new javax.swing.JPanel();
        lblImageHeaderForum = new javax.swing.JLabel();
        pnlBreadForum = new javax.swing.JPanel();
        pnlTableForum = new javax.swing.JPanel();
        spnTableForum = new javax.swing.JScrollPane();
        tblForumPost = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        pnlFooterForum = new javax.swing.JPanel();
        lblFooterImageForum = new javax.swing.JLabel();
        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnSeePostEducation = new javax.swing.JButton();
        btnSeePostResearch = new javax.swing.JButton();
        btnSeePostGeneral = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnSeePostGeneral1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1024, 2000));
        getContentPane().setLayout(new java.awt.FlowLayout());

        pnlHeaderForum.setPreferredSize(new java.awt.Dimension(1024, 150));

        lblImageHeaderForum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundheader.jpg"))); // NOI18N
        lblImageHeaderForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout pnlHeaderForumLayout = new javax.swing.GroupLayout(pnlHeaderForum);
        pnlHeaderForum.setLayout(pnlHeaderForumLayout);
        pnlHeaderForumLayout.setHorizontalGroup(
            pnlHeaderForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImageHeaderForum)
        );
        pnlHeaderForumLayout.setVerticalGroup(
            pnlHeaderForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderForumLayout.createSequentialGroup()
                .addComponent(lblImageHeaderForum, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlBreadForum.setBackground(new java.awt.Color(126, 197, 239));
        pnlBreadForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        pnlTableForum.setBackground(new java.awt.Color(44, 95, 125));
        pnlTableForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlTableForum.setPreferredSize(new java.awt.Dimension(910, 400));

        tblForumPost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblForumPost.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Author", "Date", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblForumPost.setGridColor(new java.awt.Color(255, 255, 255));
        tblForumPost.setPreferredSize(new java.awt.Dimension(300, 450));
        tblForumPost.setRowHeight(26);
        spnTableForum.setViewportView(tblForumPost);

        javax.swing.GroupLayout pnlTableForumLayout = new javax.swing.GroupLayout(pnlTableForum);
        pnlTableForum.setLayout(pnlTableForumLayout);
        pnlTableForumLayout.setHorizontalGroup(
            pnlTableForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableForumLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(spnTableForum, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTableForumLayout.setVerticalGroup(
            pnlTableForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableForumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spnTableForum, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Latest Posts:");

        javax.swing.GroupLayout pnlBreadForumLayout = new javax.swing.GroupLayout(pnlBreadForum);
        pnlBreadForum.setLayout(pnlBreadForumLayout);
        pnlBreadForumLayout.setHorizontalGroup(
            pnlBreadForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBreadForumLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBreadForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(pnlTableForum, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        pnlBreadForumLayout.setVerticalGroup(
            pnlBreadForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBreadForumLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTableForum, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        lblFooterImageForum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        lblFooterImageForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout pnlFooterForumLayout = new javax.swing.GroupLayout(pnlFooterForum);
        pnlFooterForum.setLayout(pnlFooterForumLayout);
        pnlFooterForumLayout.setHorizontalGroup(
            pnlFooterForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFooterImageForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlFooterForumLayout.setVerticalGroup(
            pnlFooterForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterForumLayout.createSequentialGroup()
                .addComponent(lblFooterImageForum, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlNavBarSeePost.setBackground(new java.awt.Color(44, 95, 125));
        pnlNavBarSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlNavBarSeePost.setPreferredSize(new java.awt.Dimension(1024, 50));

        btnSeePostHome.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostHome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSeePostHome.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostHome.setText("Home");
        btnSeePostHome.setBorder(null);
        btnSeePostHome.setBorderPainted(false);
        btnSeePostHome.setContentAreaFilled(false);
        btnSeePostHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeePostHomeActionPerformed(evt);
            }
        });

        btnSeePostEducation.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostEducation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSeePostEducation.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostEducation.setText("Education");
        btnSeePostEducation.setBorder(null);
        btnSeePostEducation.setBorderPainted(false);
        btnSeePostEducation.setContentAreaFilled(false);
        btnSeePostEducation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeePostEducationActionPerformed(evt);
            }
        });

        btnSeePostResearch.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostResearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSeePostResearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostResearch.setText("Research");
        btnSeePostResearch.setBorder(null);
        btnSeePostResearch.setBorderPainted(false);
        btnSeePostResearch.setContentAreaFilled(false);
        btnSeePostResearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeePostResearchActionPerformed(evt);
            }
        });

        btnSeePostGeneral.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostGeneral.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSeePostGeneral.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostGeneral.setText("General");
        btnSeePostGeneral.setBorder(null);
        btnSeePostGeneral.setBorderPainted(false);
        btnSeePostGeneral.setContentAreaFilled(false);
        btnSeePostGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeePostGeneralActionPerformed(evt);
            }
        });

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSeePostGeneral1.setBackground(new java.awt.Color(44, 95, 125));
        btnSeePostGeneral1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSeePostGeneral1.setForeground(new java.awt.Color(255, 255, 255));
        btnSeePostGeneral1.setText("My profile");
        btnSeePostGeneral1.setBorder(null);
        btnSeePostGeneral1.setBorderPainted(false);
        btnSeePostGeneral1.setContentAreaFilled(false);
        btnSeePostGeneral1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeePostGeneral1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNavBarSeePostLayout = new javax.swing.GroupLayout(pnlNavBarSeePost);
        pnlNavBarSeePost.setLayout(pnlNavBarSeePostLayout);
        pnlNavBarSeePostLayout.setHorizontalGroup(
            pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavBarSeePostLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnSeePostHome)
                .addGap(40, 40, 40)
                .addComponent(btnSeePostEducation)
                .addGap(56, 56, 56)
                .addComponent(btnSeePostResearch)
                .addGap(51, 51, 51)
                .addComponent(btnSeePostGeneral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeePostGeneral1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );
        pnlNavBarSeePostLayout.setVerticalGroup(
            pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNavBarSeePostLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSeePostEducation, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(btnSeePostHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeePostResearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlNavBarSeePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSeePostGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addComponent(btnSeePostGeneral1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlBackgroundForumLayout = new javax.swing.GroupLayout(pnlBackgroundForum);
        pnlBackgroundForum.setLayout(pnlBackgroundForumLayout);
        pnlBackgroundForumLayout.setHorizontalGroup(
            pnlBackgroundForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundForumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBackgroundForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlFooterForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                    .addComponent(pnlHeaderForum, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                    .addComponent(pnlBreadForum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlBackgroundForumLayout.setVerticalGroup(
            pnlBackgroundForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundForumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlHeaderForum, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(pnlNavBarSeePost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBreadForum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFooterForum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(921, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBackgroundForum);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeePostEducationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostEducationActionPerformed
        //addCategoryForumPost(getEducationCategoryID());
    }//GEN-LAST:event_btnSeePostEducationActionPerformed

    private void btnSeePostResearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostResearchActionPerformed
        //addCategoryForumPost(getResearchCategoryID());
    }//GEN-LAST:event_btnSeePostResearchActionPerformed

    private void btnSeePostGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostGeneralActionPerformed
        //addAllGeneralPost();
    }//GEN-LAST:event_btnSeePostGeneralActionPerformed

    private void btnSeePostHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostHomeActionPerformed
        //addAllForumPost();

    }//GEN-LAST:event_btnSeePostHomeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSeePostGeneral1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostGeneral1ActionPerformed
        Profil profil = new Profil();
        profil.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSeePostGeneral1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeePostEducation;
    private javax.swing.JButton btnSeePostGeneral;
    private javax.swing.JButton btnSeePostGeneral1;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.JButton btnSeePostResearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblFooterImageForum;
    private javax.swing.JLabel lblImageHeaderForum;
    private javax.swing.JPanel pnlBackgroundForum;
    private javax.swing.JPanel pnlBreadForum;
    private javax.swing.JPanel pnlFooterForum;
    private javax.swing.JPanel pnlHeaderForum;
    private javax.swing.JPanel pnlNavBarSeePost;
    private javax.swing.JPanel pnlTableForum;
    private javax.swing.JScrollPane spnTableForum;
    private javax.swing.JTable tblForumPost;
    // End of variables declaration//GEN-END:variables
}
