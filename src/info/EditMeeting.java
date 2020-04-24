/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import dbUtils.db;
import dbUtils.dbConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Hedengren
 */
public class EditMeeting extends javax.swing.JFrame {

    private String meetingID;
    private static dbConnection conn;
    private DefaultTableModel model;
    private String user;
    
    
    public EditMeeting() {
        this.user=User.getUser();
        
        conn = db.getDB();
        
        initComponents();
        
        TableColumnModel columnmodel = tblMyMeeting.getColumnModel();
        addMeetings();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMyMeeting = new javax.swing.JTable();
        txtFieldTitle = new javax.swing.JTextField();
        txtFieldDate = new javax.swing.JTextField();
        txtFieldTime = new javax.swing.JTextField();
        txtFieldLocation = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblMeetingID = new javax.swing.JLabel();
        lblMeetingIDUpdate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        tblMyMeeting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Date", "Location", "Time", "Meeting - ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMyMeeting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMyMeetingMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMyMeeting);

        txtFieldDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldDateActionPerformed(evt);
            }
        });

        jLabel1.setText("Title:");

        jLabel2.setText("Date:");

        jLabel3.setText("Time:");

        jLabel4.setText("Location:");

        jButton1.setText("Update meeting");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Select the meeting you wish to edit");

        lblMeetingID.setText("Meeting- ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(lblMeetingID)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 55, Short.MAX_VALUE)
                                .addComponent(lblMeetingIDUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFieldDate, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtFieldTitle)
                                    .addComponent(txtFieldTime, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFieldLocation))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton1)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMeetingID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMeetingIDUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addMeetings() 
    {
        
        try {
            
            model = (DefaultTableModel) tblMyMeeting.getModel();
            model.setRowCount(0);
            String s = db.getDB().fetchSingle("SELECT user from MEETINGS where user='"+user+"';");
            System.out.println(s);
            
            ArrayList<HashMap<String, String>> meetings = db.getDB().fetchRows("SELECT * FROM MEETINGS WHERE USER ='"+user+"'");
            
            

            for (HashMap<String, String> aMeeting : meetings) {

                model.addRow(new Object[]{aMeeting.get("TITLE"),aMeeting.get("DATE"),aMeeting.get("LOCATION"),aMeeting.get("TIME"),  aMeeting.get("MEETING_ID") });
                           }
        } catch (SQLException ex) {
            //Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Meetings"});
            System.out.println(e.getMessage());
        }
        
        
    }
    
    
    private void txtFieldDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldDateActionPerformed

    private void tblMyMeetingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMyMeetingMouseClicked
        int selectedRow = tblMyMeeting.getSelectedRow();
        int tal = tblMyMeeting.getColumnCount();
            
        int[] selectedColumns = tblMyMeeting.getSelectedColumns();
        
        for(int i = 0; i < tal; i++)
        {
            if(i == 0)
            {
                txtFieldTitle.setText(tblMyMeeting.getValueAt(selectedRow, i).toString());
            }
            else if(i==1)
            {
                txtFieldDate.setText(tblMyMeeting.getValueAt(selectedRow, i).toString());
            }
            else if(i==2)
            {
                txtFieldTime.setText(tblMyMeeting.getValueAt(selectedRow, i).toString());
            }
            
            else if(i==3)
            {
                
                txtFieldLocation.setText(tblMyMeeting.getValueAt(selectedRow, i).toString());
            }
            else if(i==4)
                
            {
                
                lblMeetingIDUpdate.setText(tblMyMeeting.getValueAt(selectedRow, i).toString());
            }
            
        }
        
    }//GEN-LAST:event_tblMyMeetingMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(Validation.isCorrectDateFormat(txtFieldDate))
        {
        String m = lblMeetingIDUpdate.getText().toString();
        String q1 = "UPDATE MEETINGS SET TITLE='"+txtFieldTitle.getText()+"', DATE ='"+txtFieldDate.getText()+"', TIME='"+txtFieldTime.getText()+"', LOCATION='"+txtFieldLocation.getText()+"' where MEETING_ID="+m;
        try {
            db.getDB().update(q1);
            
           tblMyMeeting.removeAll();
           addMeetings();
        } catch (SQLException ex) {
            Logger.getLogger(EditMeeting.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print(ex);
        }
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EditMeeting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditMeeting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditMeeting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditMeeting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMeetingID;
    private javax.swing.JLabel lblMeetingIDUpdate;
    private javax.swing.JTable tblMyMeeting;
    private javax.swing.JTextField txtFieldDate;
    private javax.swing.JTextField txtFieldLocation;
    private javax.swing.JTextField txtFieldTime;
    private javax.swing.JTextField txtFieldTitle;
    // End of variables declaration//GEN-END:variables
}
