/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.PictureHandler;
import dbUtils.QueryClass;
import dbUtils.db;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * @author fabian
 */
public class NewPost extends javax.swing.JFrame {

    private String postId;

    private DefaultListModel model;
    
    private int incrID;
    
    private File[] aListOfFiles;
    
    private ArrayList<File> aListForDisplayingFiles;
    
    private QueryClass query;
    
    /**
     * Creates new form NewPost
     */
    public NewPost() {
        
        initComponents();
        
        fillCb();
        
        this.model = new DefaultListModel();
        
        cbScienceGroups.setVisible(false);
        
        cbEduSci.setVisible(false);
        
        cbCategory.setVisible(false);
        
        buttonSave.setVisible(true);
        
        query = new QueryClass(db.getDB());
        
        incrID = query.autoIncrementField("POSTS", "POST_ID");
        
        aListForDisplayingFiles = new ArrayList<>();
        
    }

    public NewPost(String postId) {
        
        initComponents();
        this.model = new DefaultListModel();
        this.postId = postId;
        fillTitleandMainText();
        findPostLocation(postId);
        buttonPost.setVisible(false);
    }

    private void clear() {
        textTitle.setText("");
        textMain.setText("");
    }

    private void fillCbEdit(String e) {

    }

    private void findPostLocation(String idString) {
        try {
            String q1 = db.getDB().fetchSingle("SELECT POST_ID FROM INFORMAL_POSTS WHERE POST_ID = " + idString);
            if (q1 != null) {
                cbSubject.addItem("Informal");
            } else {
                cbSubject.addItem("Formal");
                String q2 = db.getDB().fetchSingle("SELECT CATEGORY_NAME FROM CATEGORY WHERE CATEGORY_ID = (SELECT CATEGORY FROM FORMAL_POST WHERE POST_ID = " + idString + ")");
                cbCategory.addItem(q2);
                System.out.println(q2 + "q2");
                String q3 = db.getDB().fetchSingle("SELECT POST_ID FROM EDUCATION_POSTS WHERE POST_ID = " + idString);
                if (q3 != null) {
                    cbEduSci.addItem("Education");
                } else {
                    cbEduSci.addItem("Science");
                    String q4 = db.getDB().fetchSingle("SELECT RESEARCH_GROUP FROM RESEARCH_POSTS WHERE POST_ID = " + idString);
                    String q5 = db.getDB().fetchSingle("SELECT GROUP_NAME FROM RESEARCH_GROUP WHERE GROUP_ID = " + q4);
                    cbScienceGroups.addItem(q5);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void fillCb() {
        cbSubject.addItem("Informal");
        if (User.getEduAdmin() || User.getResAdmin()) {
            cbSubject.addItem("Formal");
            try {
                String postCategory = "SELECT CATEGORY_NAME FROM CATEGORY";
                ArrayList<String> categories = new ArrayList<String>();
                categories = db.getDB().fetchColumn(postCategory);
                for (String category : categories) {
                    cbCategory.addItem(category);
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            if (User.getEduAdmin()) {
                cbEduSci.addItem("Education");
            }
            if (User.getResAdmin()) {
                cbEduSci.addItem("Science");
                cbEduSci.setSelectedItem("Science");
                try {
                    String category = "SELECT GROUP_NAME FROM RESEARCH_GROUP";
                    ArrayList<String> subjects = new ArrayList<String>();
                    subjects = db.getDB().fetchColumn(category);
                    for (String subject : subjects) {
                        cbScienceGroups.addItem(subject);
                    }
                } catch (SQLException ex) {
                    System.err.println(ex);
                }
            }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textMain = new javax.swing.JEditorPane();
        buttonPost = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        buttonAttach = new javax.swing.JButton();
        panelRibbon = new javax.swing.JPanel();
        textTitle = new javax.swing.JTextField();
        cbSubject = new javax.swing.JComboBox<>();
        cbEduSci = new javax.swing.JComboBox<>();
        cbScienceGroups = new javax.swing.JComboBox<>();
        cbCategory = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstDisplayingAttachedFiles = new javax.swing.JList<>();
        btnRemoveFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(126, 197, 239));
        jPanel1.setPreferredSize(new java.awt.Dimension(998, 613));

        jPanel2.setBackground(new java.awt.Color(44, 95, 125));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 420));

        textMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jScrollPane1.setViewportView(textMain);

        buttonPost.setBackground(new java.awt.Color(126, 197, 239));
        buttonPost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonPost.setForeground(new java.awt.Color(255, 255, 255));
        buttonPost.setText("Post");
        buttonPost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPostActionPerformed(evt);
            }
        });

        buttonSave.setBackground(new java.awt.Color(126, 197, 239));
        buttonSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonSave.setForeground(new java.awt.Color(255, 255, 255));
        buttonSave.setText("Save");
        buttonSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonClear.setBackground(new java.awt.Color(126, 197, 239));
        buttonClear.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonClear.setForeground(new java.awt.Color(255, 255, 255));
        buttonClear.setText("Clear text");
        buttonClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        buttonAttach.setBackground(new java.awt.Color(126, 197, 239));
        buttonAttach.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonAttach.setForeground(new java.awt.Color(255, 255, 255));
        buttonAttach.setText("Attach file");
        buttonAttach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        buttonAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAttachActionPerformed(evt);
            }
        });

        panelRibbon.setBackground(new java.awt.Color(153, 153, 153));
        panelRibbon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout panelRibbonLayout = new javax.swing.GroupLayout(panelRibbon);
        panelRibbon.setLayout(panelRibbonLayout);
        panelRibbonLayout.setHorizontalGroup(
            panelRibbonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRibbonLayout.setVerticalGroup(
            panelRibbonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );

        textTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTitleActionPerformed(evt);
            }
        });

        cbSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSubjectActionPerformed(evt);
            }
        });

        cbEduSci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEduSciActionPerformed(evt);
            }
        });

        cbScienceGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbScienceGroupsActionPerformed(evt);
            }
        });

        cbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoryActionPerformed(evt);
            }
        });

        lstDisplayingAttachedFiles.setBackground(new java.awt.Color(102, 102, 102));
        lstDisplayingAttachedFiles.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lstDisplayingAttachedFiles.setForeground(new java.awt.Color(0, 51, 255));
        jScrollPane2.setViewportView(lstDisplayingAttachedFiles);

        btnRemoveFile.setBackground(new java.awt.Color(126, 197, 239));
        btnRemoveFile.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRemoveFile.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveFile.setText("Remove file");
        btnRemoveFile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnRemoveFile.setPreferredSize(new java.awt.Dimension(96, 32));
        btnRemoveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveFile, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonAttach, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonPost, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRibbon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textTitle)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEduSci, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbScienceGroups, 0, 160, Short.MAX_VALUE)))
                .addGap(0, 125, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(panelRibbon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEduSci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbScienceGroups, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonPost, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buttonAttach, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRemoveFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbScienceGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbScienceGroupsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbScienceGroupsActionPerformed

    private void cbEduSciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEduSciActionPerformed
        showCbEduSci();
    }//GEN-LAST:event_cbEduSciActionPerformed

    private void cbSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubjectActionPerformed
        String choice = cbSubject.getSelectedItem().toString();
        if (choice.equals("Formal")) {
            cbEduSci.setVisible(true);
            cbCategory.setVisible(true);
            if (User.getResAdmin()) {
                cbScienceGroups.setVisible(true); // Makes ScienceGroups visible if Research-Admin
            }
        } else {
            cbEduSci.setVisible(false);
            cbScienceGroups.setVisible(false);
            cbCategory.setVisible(false); // Hides Category when its a Informal post
        }
    }//GEN-LAST:event_cbSubjectActionPerformed

    private void textTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTitleActionPerformed

    private void buttonPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPostActionPerformed
        if (Validation.checkTextFieldEmpty(textTitle)) {
            try {
                String autoID;
                autoID = db.getDB().getAutoIncrement("POSTS", "POST_ID");
                
                if (autoID == null) {
                    autoID = "1";
                }

                Calendar cal = Calendar.getInstance();
                Date date = cal.getTime();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                String date1 = format1.format(date);

                String title = textTitle.getText();
                String mainText = textMain.getText();
JOptionPane.showMessageDialog(null, "Post added! 1");
                db.getDB().insert("INSERT INTO POSTS VALUES ('" + autoID + "','" + title + "','" + mainText + "','" + date1 + "','" + User.getUser() + "')");
                JOptionPane.showMessageDialog(null, "Post added! 2");
                // Added insert values depending on the selected options in the ColumnBox
                if (cbSubject.getSelectedItem().toString().equals("Informal"))
                
                {
                    JOptionPane.showMessageDialog(null, "Post added! 3");
                    db.getDB().insert("INSERT INTO INFORMAL_POST VALUES ('" + autoID + "')");
                    JOptionPane.showMessageDialog(null, "Post added! 4");
                } else if (cbSubject.getSelectedItem().toString().equals("Formal")) {
                    String categoryNumber = db.getDB().fetchSingle("SELECT CATEGORY_ID FROM CATEGORY WHERE CATEGORY_NAME = '" + cbCategory.getSelectedItem().toString() + "'");
                    db.getDB().insert("INSERT INTO FORMAL_POST VALUES ('" + autoID + "','" + categoryNumber + "')");
                    if (cbEduSci.getSelectedItem().toString().equals("Science")) {
                        
                        JOptionPane.showMessageDialog(null, "Post added! 5");
                        String groupNumber = db.getDB().fetchSingle("SELECT GROUP_ID FROM RESEARCH_GROUP WHERE GROUP_NAME = '" + cbScienceGroups.getSelectedItem().toString() + "'");
                        db.getDB().insert("INSERT INTO RESEARCH_POSTS VALUES ('" + autoID + "','" + groupNumber + "')");
                    } else if (cbEduSci.getSelectedItem().toString().equals("Education")) {
                        db.getDB().insert("INSERT INTO EDUCATION_POSTS VALUES ('" + autoID + "')");
                    }
                }
                JOptionPane.showMessageDialog(null, "Post added!");
                clear();
            } catch (SQLException e) {
                System.err.println(e);
            }
            
            
             if(model.getSize() > 0){
             for(File oneFile: aListForDisplayingFiles)
        {

            String path = oneFile.getAbsolutePath();


            int fileID = query.autoIncrementField("FILES", "FILE_ID");

            query.executeUploadQueryFiles(oneFile,"INSERT INTO FILES VALUES(" + fileID + ",'" + path + "', ? ," + incrID + ")");
               
        }
            }
            
            
            
        }
    }//GEN-LAST:event_buttonPostActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        clear();
    }//GEN-LAST:event_buttonClearActionPerformed

    private void cbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoryActionPerformed

    private void fillTitleandMainText() {
        try {
            String title = db.getDB().fetchSingle("SELECT TITLE FROM POSTS WHERE POST_ID = " + postId);
            String mainText = db.getDB().fetchSingle("SELECT DESCRIPTION FROM POSTS WHERE POST_ID = " + postId);

            textTitle.setText(title);
            textMain.setText(mainText);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        try {
            String title = textTitle.getText();
            String mainText = textMain.getText();

            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = format1.format(date);

            db.getDB().update("UPDATE POSTS SET DATE = " + "'" + date1 + "'" + " WHERE POST_ID = " + postId);
            db.getDB().update("UPDATE POSTS SET TITLE = " + "'" + title + "'" + " WHERE POST_ID = " + postId);
            db.getDB().update("UPDATE POSTS SET DESCRIPTION = " + "'" + mainText + "'" + " WHERE POST_ID = " + postId);

            JOptionPane.showMessageDialog(null, "Post edited!");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        if(model.getSize() > 0){
         for(File oneFile: aListForDisplayingFiles)
        {


            String path = oneFile.getAbsolutePath().toString();

            //String insertName = path.substring(path.lastIndexOf("."),path.length());

            int fileID = query.autoIncrementField("FILES", "FILE_ID");


            query.executeUploadQueryFiles(oneFile,"INSERT INTO FILES VALUES(" + fileID + ",'" + path + "', ? ," + incrID + ")");
               
        
        
        
        }
        }
        
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAttachActionPerformed
       PictureHandler fileHandler = new PictureHandler(1, 1);
       
       aListOfFiles = fileHandler.openFiles();
       
       
       
       
       lstDisplayingAttachedFiles.setModel(model);
      
       
      
       
       
       if(aListOfFiles !=null){
       
           
           for(int i = 0; i < aListOfFiles.length; i++)
           {
               aListForDisplayingFiles.add(aListOfFiles[i]);
               
               String path = aListOfFiles[i].getAbsolutePath();
               
               //String filTyp = paths.substring(paths.lastIndexOf("."),paths.length());
               
               String pathInsert = path.substring(path.lastIndexOf("\\")+1,path.length());
            
                model.addElement(pathInsert);
                
                 System.out.println(aListForDisplayingFiles.size());
               
           }    
           
           
       
       }
       
       
    }//GEN-LAST:event_buttonAttachActionPerformed

    private void btnRemoveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFileActionPerformed
         if(!lstDisplayingAttachedFiles.isSelectionEmpty())
       {  
       int i = lstDisplayingAttachedFiles.getSelectedIndex();
     
       model.removeElementAt(i);
       
       aListForDisplayingFiles.remove(i);
       
       }
    }//GEN-LAST:event_btnRemoveFileActionPerformed

    private void showCbEduSci() {
        String choice = cbEduSci.getSelectedItem().toString();
        if (choice.equals("Science")) {
            cbScienceGroups.setVisible(true);
        } else {
            cbScienceGroups.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemoveFile;
    private javax.swing.JButton buttonAttach;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonPost;
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cbEduSci;
    private javax.swing.JComboBox<String> cbScienceGroups;
    private javax.swing.JComboBox<String> cbSubject;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstDisplayingAttachedFiles;
    private javax.swing.JPanel panelRibbon;
    private javax.swing.JEditorPane textMain;
    private javax.swing.JTextField textTitle;
    // End of variables declaration//GEN-END:variables

}
