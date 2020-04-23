/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Lukas
 */
public class Blog extends javax.swing.JFrame {

    private DefaultTableModel model;

    /**
     * Creates new form Forum
     */
    public Blog() {
        initComponents();
        TableColumnModel columnmodel = tblForumPost.getColumnModel();
        columnmodel.removeColumn(columnmodel.getColumn(4));
        columnmodel.removeColumn(columnmodel.getColumn(3));

        pnlSortButtonsForum.setVisible(false);

        addAllForumPost();

        setExtendedState(MAXIMIZED_BOTH);

        setLocationRelativeTo(null);

    }

    public void addAllGeneralPost() // add all the Post which are Informal to the table
    {
        try {
            model = (DefaultTableModel) tblForumPost.getModel();
            model.setRowCount(0);
            ArrayList<HashMap<String, String>> posts = db.getDB().fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM INFORMAL_POST)");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Posts"});
        }
    }

    public void addAllForumPost() // add all the Post to the table
    {
        try {
            model = (DefaultTableModel) tblForumPost.getModel();
            model.setRowCount(0);
            ArrayList<HashMap<String, String>> posts = db.getDB().fetchRows("SELECT POSTS.POST_ID, TITLE, DESCRIPTION, DATE, AUTHOR FROM POSTS INNER JOIN INFORMAL_POST ON POSTS.POST_ID=INFORMAL_POST.POST_ID\n"
                    + "UNION\n"
                    + "SELECT POSTS.POST_ID, TITLE, DESCRIPTION, DATE, AUTHOR FROM POSTS INNER JOIN RESEARCH_POSTS ON RESEARCH_POSTS.POST_ID=POSTS.POST_ID INNER JOIN GROUP_MEMBERS ON RESEARCH_POSTS.RESEARCH_GROUP=GROUP_MEMBERS.RESEARCH_GROUP WHERE MEMBER = '" + User.getUser() + "'\n"
                    + "UNION\n"
                    + "SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM EDUCATION_POSTS)");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
                //model.addRow(new Object[]{"Hej"});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Posts"});
        }
    }

    public void addResearchForumPost() // add all the Post in a certain category  to the table
    {

        try {
            model = (DefaultTableModel) tblForumPost.getModel();
            model.setRowCount(0);

            ArrayList<HashMap<String, String>> posts = db.getDB().fetchRows("SELECT POSTS.POST_ID, TITLE, DESCRIPTION, DATE, AUTHOR FROM POSTS INNER JOIN RESEARCH_POSTS ON RESEARCH_POSTS.POST_ID=POSTS.POST_ID"
                    + " INNER JOIN GROUP_MEMBERS ON RESEARCH_POSTS.RESEARCH_GROUP=GROUP_MEMBERS.RESEARCH_GROUP WHERE MEMBER = '" + User.getUser() + "'");
            System.out.println(User.getUser());
            System.out.println(posts);

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Posts"});
        }
    }

    public void addEducationForumPost() // add all the Post in a certain category  to the table
    {
        try {
            model = (DefaultTableModel) tblForumPost.getModel();
            model.setRowCount(0);

            ArrayList<HashMap<String, String>> posts = db.getDB().fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM EDUCATION_POSTS)");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Posts"});
        }

    }

    public void addGroupResearchForumPost(int groupID) // add all the Post in a certain category  to the table
    {

        try {
            model = (DefaultTableModel) tblForumPost.getModel();
            model.setRowCount(0);

            ArrayList<HashMap<String, String>> posts = db.getDB().fetchRows("SELECT * FROM POSTS WHERE POST_ID in(SELECT POST_ID FROM RESEARCH_POSTS WHERE RESEARCH_GROUP =" + groupID + ")");

            for (HashMap<String, String> aPost : posts) {

                model.addRow(new Object[]{aPost.get("TITLE"), aPost.get("AUTHOR"), aPost.get("DATE"), aPost.get("DESCRIPTION"), aPost.get("POST_ID")});

            }

        } catch (SQLException ex) {
            Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Posts"});
        }

    }

    public void swicthCategoryButtons(boolean state) {
        boolean switchState = state;

        if (switchState) {
            pnlSortButtonsForum.setVisible(true);
        } else {
            pnlSortButtonsForum.setVisible(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupForum = new javax.swing.ButtonGroup();
        pnlBackgroundForum = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblImageHeader = new javax.swing.JLabel();
        pnlBreadForum = new javax.swing.JPanel();
        spnTableForum = new javax.swing.JScrollPane();
        tblForumPost = new javax.swing.JTable();
        pnlSortButtonsForum = new javax.swing.JPanel();
        rbtnAllGroupForum = new javax.swing.JRadioButton();
        rbtnEHealthForum = new javax.swing.JRadioButton();
        rbtnEGovForum = new javax.swing.JRadioButton();
        rbtnICTdevForum = new javax.swing.JRadioButton();
        rbtnITSecForum = new javax.swing.JRadioButton();
        rbtnITEdForum = new javax.swing.JRadioButton();
        rbtnSysDevMethForum = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jcbUsers = new javax.swing.JComboBox<>();
        jcbGroups = new javax.swing.JComboBox<>();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jButton2 = new javax.swing.JButton();
        pnlFooterForum = new javax.swing.JPanel();
        lblFooterImageForum = new javax.swing.JLabel();
        pnlNavBarSeePost = new javax.swing.JPanel();
        btnSeePostHome = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnCalendar = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnResarchAndEducation = new javax.swing.JButton();
        btnBlog = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setSize(new java.awt.Dimension(1024, 768));
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        pnlBackgroundForum.setAlignmentX(0.0F);
        pnlBackgroundForum.setAlignmentY(0.0F);
        pnlBackgroundForum.setMaximumSize(new java.awt.Dimension(1024, 768));
        pnlBackgroundForum.setMinimumSize(new java.awt.Dimension(1024, 768));
        pnlBackgroundForum.setPreferredSize(new java.awt.Dimension(1024, 768));
        pnlBackgroundForum.setLayout(null);

        pnlHeader.setAlignmentX(0.0F);
        pnlHeader.setAlignmentY(0.0F);
        pnlHeader.setPreferredSize(new java.awt.Dimension(1024, 150));

        lblImageHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundheader.jpg"))); // NOI18N
        lblImageHeader.setAlignmentY(0.0F);
        lblImageHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblImageHeader.setMaximumSize(new java.awt.Dimension(1022, 148));
        lblImageHeader.setMinimumSize(new java.awt.Dimension(1022, 148));
        lblImageHeader.setPreferredSize(new java.awt.Dimension(1022, 148));

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImageHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImageHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlBackgroundForum.add(pnlHeader);
        pnlHeader.setBounds(0, 0, 1028, 148);

        pnlBreadForum.setBackground(new java.awt.Color(255, 255, 255));
        pnlBreadForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlBreadForum.setAlignmentX(0.0F);
        pnlBreadForum.setAlignmentY(0.0F);
        pnlBreadForum.setMinimumSize(new java.awt.Dimension(1022, 405));
        pnlBreadForum.setPreferredSize(new java.awt.Dimension(1022, 405));
        pnlBreadForum.setLayout(null);

        spnTableForum.setBackground(new java.awt.Color(255, 255, 255));
        spnTableForum.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Posts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        spnTableForum.setForeground(new java.awt.Color(0, 0, 0));

        tblForumPost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblForumPost.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Author", "Date", "Description", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        tblForumPost.setSelectionBackground(new java.awt.Color(0, 153, 102));
        tblForumPost.getTableHeader().setReorderingAllowed(false);
        tblForumPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblForumPostMouseClicked(evt);
            }
        });
        spnTableForum.setViewportView(tblForumPost);
        if (tblForumPost.getColumnModel().getColumnCount() > 0) {
            tblForumPost.getColumnModel().getColumn(0).setResizable(false);
            tblForumPost.getColumnModel().getColumn(0).setPreferredWidth(400);
            tblForumPost.getColumnModel().getColumn(1).setResizable(false);
            tblForumPost.getColumnModel().getColumn(1).setPreferredWidth(20);
            tblForumPost.getColumnModel().getColumn(2).setResizable(false);
            tblForumPost.getColumnModel().getColumn(3).setResizable(false);
            tblForumPost.getColumnModel().getColumn(4).setResizable(false);
        }

        pnlBreadForum.add(spnTableForum);
        spnTableForum.setBounds(290, 90, 710, 240);

        pnlSortButtonsForum.setBackground(new java.awt.Color(44, 95, 125));
        pnlSortButtonsForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        rbtnAllGroupForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnAllGroupForum);
        rbtnAllGroupForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnAllGroupForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAllGroupForum.setText("All groups");
        rbtnAllGroupForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAllGroupForumActionPerformed(evt);
            }
        });

        rbtnEHealthForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnEHealthForum);
        rbtnEHealthForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnEHealthForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnEHealthForum.setText("eHealth");
        rbtnEHealthForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEHealthForumActionPerformed(evt);
            }
        });

        rbtnEGovForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnEGovForum);
        rbtnEGovForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnEGovForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnEGovForum.setText("eGov");
        rbtnEGovForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnEGovForumActionPerformed(evt);
            }
        });

        rbtnICTdevForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnICTdevForum);
        rbtnICTdevForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnICTdevForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnICTdevForum.setText("ICTdev");
        rbtnICTdevForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnICTdevForumActionPerformed(evt);
            }
        });

        rbtnITSecForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnITSecForum);
        rbtnITSecForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnITSecForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnITSecForum.setText("ITsec");
        rbtnITSecForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnITSecForumActionPerformed(evt);
            }
        });

        rbtnITEdForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnITEdForum);
        rbtnITEdForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnITEdForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnITEdForum.setText("ITed");
        rbtnITEdForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnITEdForumActionPerformed(evt);
            }
        });

        rbtnSysDevMethForum.setBackground(new java.awt.Color(44, 95, 125));
        buttonGroupForum.add(rbtnSysDevMethForum);
        rbtnSysDevMethForum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnSysDevMethForum.setForeground(new java.awt.Color(255, 255, 255));
        rbtnSysDevMethForum.setText("SysdevMeth");
        rbtnSysDevMethForum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSysDevMethForumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSortButtonsForumLayout = new javax.swing.GroupLayout(pnlSortButtonsForum);
        pnlSortButtonsForum.setLayout(pnlSortButtonsForumLayout);
        pnlSortButtonsForumLayout.setHorizontalGroup(
            pnlSortButtonsForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSortButtonsForumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSortButtonsForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnAllGroupForum)
                    .addComponent(rbtnEHealthForum)
                    .addComponent(rbtnEGovForum)
                    .addComponent(rbtnICTdevForum)
                    .addComponent(rbtnITSecForum)
                    .addComponent(rbtnITEdForum)
                    .addComponent(rbtnSysDevMethForum))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSortButtonsForumLayout.setVerticalGroup(
            pnlSortButtonsForumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSortButtonsForumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnAllGroupForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnEHealthForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnEGovForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnICTdevForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnITSecForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnITEdForum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnSysDevMethForum)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pnlBreadForum.add(pnlSortButtonsForum);
        pnlSortButtonsForum.setBounds(20, 120, 118, 256);

        jButton1.setBackground(new java.awt.Color(44, 95, 125));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Edit selected post");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlBreadForum.add(jButton1);
        jButton1.setBounds(680, 350, 140, 37);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FIlter selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        jcbUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Users" }));
        jPanel1.add(jcbUsers);
        jcbUsers.setBounds(190, 30, 160, 26);

        jcbGroups.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Research Groups" }));
        jPanel1.add(jcbGroups);
        jcbGroups.setBounds(20, 30, 160, 26);
        jPanel1.add(jXDatePicker1);
        jXDatePicker1.setBounds(370, 30, 160, 24);

        pnlBreadForum.add(jPanel1);
        jPanel1.setBounds(20, 10, 980, 70);

        jButton2.setBackground(new java.awt.Color(44, 95, 125));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Create new post");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlBreadForum.add(jButton2);
        jButton2.setBounds(840, 350, 140, 37);

        pnlBackgroundForum.add(pnlBreadForum);
        pnlBreadForum.setBounds(0, 190, 1022, 405);

        pnlFooterForum.setAlignmentX(0.0F);
        pnlFooterForum.setAlignmentY(0.0F);
        pnlFooterForum.setMaximumSize(new java.awt.Dimension(1024, 148));
        pnlFooterForum.setMinimumSize(new java.awt.Dimension(1024, 148));
        pnlFooterForum.setPreferredSize(new java.awt.Dimension(1022, 148));
        pnlFooterForum.setLayout(null);

        lblFooterImageForum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info/images/Backgroundfooter.jpg"))); // NOI18N
        lblFooterImageForum.setAlignmentY(0.0F);
        lblFooterImageForum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblFooterImageForum.setMaximumSize(new java.awt.Dimension(1022, 148));
        lblFooterImageForum.setMinimumSize(new java.awt.Dimension(1022, 148));
        lblFooterImageForum.setPreferredSize(new java.awt.Dimension(1022, 148));
        pnlFooterForum.add(lblFooterImageForum);
        lblFooterImageForum.setBounds(0, 0, 1022, 148);

        pnlBackgroundForum.add(pnlFooterForum);
        pnlFooterForum.setBounds(0, 600, 1022, 148);

        pnlNavBarSeePost.setBackground(new java.awt.Color(44, 95, 125));
        pnlNavBarSeePost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlNavBarSeePost.setAlignmentX(0.0F);
        pnlNavBarSeePost.setAlignmentY(0.0F);
        pnlNavBarSeePost.setAutoscrolls(true);
        pnlNavBarSeePost.setMinimumSize(new java.awt.Dimension(1022, 30));
        pnlNavBarSeePost.setLayout(null);

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
        pnlNavBarSeePost.add(btnSeePostHome);
        btnSeePostHome.setBounds(20, 8, 33, 14);

        btnLogOut.setBackground(new java.awt.Color(44, 95, 125));
        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setText("Log out");
        btnLogOut.setBorder(null);
        btnLogOut.setBorderPainted(false);
        btnLogOut.setContentAreaFilled(false);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        pnlNavBarSeePost.add(btnLogOut);
        btnLogOut.setBounds(950, 8, 60, 14);

        btnCalendar.setBackground(new java.awt.Color(44, 95, 125));
        btnCalendar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCalendar.setForeground(new java.awt.Color(255, 255, 255));
        btnCalendar.setText("Calendar");
        btnCalendar.setBorder(null);
        btnCalendar.setBorderPainted(false);
        btnCalendar.setContentAreaFilled(false);
        btnCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarActionPerformed(evt);
            }
        });
        pnlNavBarSeePost.add(btnCalendar);
        btnCalendar.setBounds(250, 8, 50, 14);

        btnMyProfile.setBackground(new java.awt.Color(44, 95, 125));
        btnMyProfile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMyProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnMyProfile.setText("My Profile");
        btnMyProfile.setBorder(null);
        btnMyProfile.setBorderPainted(false);
        btnMyProfile.setContentAreaFilled(false);
        btnMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyProfileActionPerformed(evt);
            }
        });
        pnlNavBarSeePost.add(btnMyProfile);
        btnMyProfile.setBounds(880, 8, 60, 14);

        btnResarchAndEducation.setBackground(new java.awt.Color(44, 95, 125));
        btnResarchAndEducation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnResarchAndEducation.setForeground(new java.awt.Color(255, 255, 255));
        btnResarchAndEducation.setText("Research & Education");
        btnResarchAndEducation.setBorder(null);
        btnResarchAndEducation.setBorderPainted(false);
        btnResarchAndEducation.setContentAreaFilled(false);
        btnResarchAndEducation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResarchAndEducationActionPerformed(evt);
            }
        });
        pnlNavBarSeePost.add(btnResarchAndEducation);
        btnResarchAndEducation.setBounds(70, 8, 123, 14);

        btnBlog.setBackground(new java.awt.Color(44, 95, 125));
        btnBlog.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBlog.setForeground(new java.awt.Color(255, 255, 255));
        btnBlog.setText("Blog");
        btnBlog.setBorder(null);
        btnBlog.setBorderPainted(false);
        btnBlog.setContentAreaFilled(false);
        btnBlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlogActionPerformed(evt);
            }
        });
        pnlNavBarSeePost.add(btnBlog);
        btnBlog.setBounds(210, 8, 24, 14);

        pnlBackgroundForum.add(pnlNavBarSeePost);
        pnlNavBarSeePost.setBounds(0, 154, 1022, 30);

        getContentPane().add(pnlBackgroundForum);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int id = tblForumPost.getSelectedRow();
        String idString = tblForumPost.getModel().getValueAt(id, 4).toString();
        NewPost newPost = new NewPost(idString);
        newPost.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbtnSysDevMethForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSysDevMethForumActionPerformed
        addGroupResearchForumPost(6);
    }//GEN-LAST:event_rbtnSysDevMethForumActionPerformed

    private void rbtnITEdForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnITEdForumActionPerformed
        addGroupResearchForumPost(5);
    }//GEN-LAST:event_rbtnITEdForumActionPerformed

    private void rbtnITSecForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnITSecForumActionPerformed
        addGroupResearchForumPost(4);
    }//GEN-LAST:event_rbtnITSecForumActionPerformed

    private void rbtnICTdevForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnICTdevForumActionPerformed
        addGroupResearchForumPost(3);
    }//GEN-LAST:event_rbtnICTdevForumActionPerformed

    private void rbtnEGovForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEGovForumActionPerformed
        addGroupResearchForumPost(2);
    }//GEN-LAST:event_rbtnEGovForumActionPerformed

    private void rbtnEHealthForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnEHealthForumActionPerformed

        addGroupResearchForumPost(1);
    }//GEN-LAST:event_rbtnEHealthForumActionPerformed

    private void rbtnAllGroupForumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAllGroupForumActionPerformed
        addResearchForumPost();
    }//GEN-LAST:event_rbtnAllGroupForumActionPerformed

    private void tblForumPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblForumPostMouseClicked
        String idString = "";
        if (evt.getClickCount() == 2) {
            int id = tblForumPost.getSelectedRow();
            try {
                idString = tblForumPost.getModel().getValueAt(id, 4).toString();
                new SeePost(idString).setVisible(true);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Not a valid option");
            }

        }
    }//GEN-LAST:event_tblForumPostMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSeePostHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeePostHomeActionPerformed
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSeePostHomeActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        new LogInGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarActionPerformed
        new CalendarView().setVisible(true);
    }//GEN-LAST:event_btnCalendarActionPerformed

    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
        new Profil().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMyProfileActionPerformed

    private void btnResarchAndEducationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResarchAndEducationActionPerformed
        new Forum().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnResarchAndEducationActionPerformed

    private void btnBlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlogActionPerformed
        new Blog().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBlogActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBlog;
    private javax.swing.JButton btnCalendar;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnResarchAndEducation;
    private javax.swing.JButton btnSeePostHome;
    private javax.swing.ButtonGroup buttonGroupForum;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JComboBox<String> jcbGroups;
    private javax.swing.JComboBox<String> jcbUsers;
    private javax.swing.JLabel lblFooterImageForum;
    private javax.swing.JLabel lblImageHeader;
    private javax.swing.JPanel pnlBackgroundForum;
    private javax.swing.JPanel pnlBreadForum;
    private javax.swing.JPanel pnlFooterForum;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlNavBarSeePost;
    private javax.swing.JPanel pnlSortButtonsForum;
    private javax.swing.JRadioButton rbtnAllGroupForum;
    private javax.swing.JRadioButton rbtnEGovForum;
    private javax.swing.JRadioButton rbtnEHealthForum;
    private javax.swing.JRadioButton rbtnICTdevForum;
    private javax.swing.JRadioButton rbtnITEdForum;
    private javax.swing.JRadioButton rbtnITSecForum;
    private javax.swing.JRadioButton rbtnSysDevMethForum;
    private javax.swing.JScrollPane spnTableForum;
    private javax.swing.JTable tblForumPost;
    // End of variables declaration//GEN-END:variables
}