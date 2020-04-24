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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author fabia
 */
public class SeeBooking extends javax.swing.JFrame {

   
    private static dbConnection conn;
    private DefaultTableModel model;
    private static String user;
    
    
    
    public SeeBooking() {
        initComponents();
        
        conn = db.getDB();
        this.user = User.getUser();
        addMeetings();
        TableColumnModel columnmodel = tblMyMeeting.getColumnModel();
        
        
        
        
    }
    
    private void tblPostsMouseClicked(java.awt.event.MouseEvent evt) {                                      
        
        String idString = "";
        if (evt.getClickCount() == 2) {
            int id = tblMyMeeting.getSelectedRow();
            try {
                idString = tblMyMeeting.getModel().getValueAt(id, 4).toString();
                
                new SeePost(idString).setVisible(true);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Not a valid option");
            }
        }
    }
    
    public void addMeetings() 
    {
        
        try {
            System.out.println(user);
            model = (DefaultTableModel) tblMyMeeting.getModel();
            model.setRowCount(0);
            String s = db.getDB().fetchSingle("SELECT user from MEETINGS where user='"+user+"';");
            System.out.println(s);
            
            ArrayList<HashMap<String, String>> meetings = db.getDB().fetchRows("SELECT * FROM MEETINGS WHERE USER ='"+user+"'");
            
            

            for (HashMap<String, String> aMeeting : meetings) {

                model.addRow(new Object[]{aMeeting.get("TITLE"),aMeeting.get("DATE"),aMeeting.get("LOCATION"),aMeeting.get("TIME"), aMeeting.get("USER") });
                           }
        } catch (SQLException ex) {
            //Logger.getLogger(Forum.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            model.addRow(new Object[]{"No Meetings"});
            System.out.println(e.getMessage());
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

        pnlBackgroundSeeBooking = new javax.swing.JPanel();
        pnlBookingCalender = new javax.swing.JPanel();
        pnlSortSeeBooking = new javax.swing.JPanel();
        rbtnSortByDate = new javax.swing.JRadioButton();
        rbtnSortByLocation = new javax.swing.JRadioButton();
        rbtnSortByUser = new javax.swing.JRadioButton();
        pnlMyMeetings = new javax.swing.JPanel();
        spnMyMeeting = new javax.swing.JScrollPane();
        tblMyMeeting = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        pnlBackgroundSeeBooking.setBackground(new java.awt.Color(126, 197, 239));
        pnlBackgroundSeeBooking.setPreferredSize(new java.awt.Dimension(998, 550));

        javax.swing.GroupLayout pnlBookingCalenderLayout = new javax.swing.GroupLayout(pnlBookingCalender);
        pnlBookingCalender.setLayout(pnlBookingCalenderLayout);
        pnlBookingCalenderLayout.setHorizontalGroup(
            pnlBookingCalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );
        pnlBookingCalenderLayout.setVerticalGroup(
            pnlBookingCalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );

        pnlSortSeeBooking.setBackground(new java.awt.Color(44, 95, 125));
        pnlSortSeeBooking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        rbtnSortByDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnSortByDate.setForeground(new java.awt.Color(255, 255, 255));
        rbtnSortByDate.setText("Date");
        rbtnSortByDate.setContentAreaFilled(false);

        rbtnSortByLocation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnSortByLocation.setForeground(new java.awt.Color(255, 255, 255));
        rbtnSortByLocation.setText("Location");
        rbtnSortByLocation.setContentAreaFilled(false);

        rbtnSortByUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rbtnSortByUser.setForeground(new java.awt.Color(255, 255, 255));
        rbtnSortByUser.setText("User");
        rbtnSortByUser.setContentAreaFilled(false);

        javax.swing.GroupLayout pnlSortSeeBookingLayout = new javax.swing.GroupLayout(pnlSortSeeBooking);
        pnlSortSeeBooking.setLayout(pnlSortSeeBookingLayout);
        pnlSortSeeBookingLayout.setHorizontalGroup(
            pnlSortSeeBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSortSeeBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSortSeeBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnSortByUser)
                    .addComponent(rbtnSortByDate)
                    .addComponent(rbtnSortByLocation))
                .addGap(40, 40, 40))
        );
        pnlSortSeeBookingLayout.setVerticalGroup(
            pnlSortSeeBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSortSeeBookingLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(rbtnSortByUser)
                .addGap(18, 18, 18)
                .addComponent(rbtnSortByDate)
                .addGap(18, 18, 18)
                .addComponent(rbtnSortByLocation)
                .addContainerGap())
        );

        pnlMyMeetings.setBackground(new java.awt.Color(44, 95, 125));
        pnlMyMeetings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        spnMyMeeting.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tblMyMeeting.setBackground(new java.awt.Color(153, 204, 255));
        tblMyMeeting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Date", "Location", "Time", "User"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        tblMyMeeting.setGridColor(new java.awt.Color(255, 255, 255));
        tblMyMeeting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMyMeetingMouseClicked(evt);
            }
        });
        spnMyMeeting.setViewportView(tblMyMeeting);

        javax.swing.GroupLayout pnlMyMeetingsLayout = new javax.swing.GroupLayout(pnlMyMeetings);
        pnlMyMeetings.setLayout(pnlMyMeetingsLayout);
        pnlMyMeetingsLayout.setHorizontalGroup(
            pnlMyMeetingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyMeetingsLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(spnMyMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pnlMyMeetingsLayout.setVerticalGroup(
            pnlMyMeetingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyMeetingsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(spnMyMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBackgroundSeeBookingLayout = new javax.swing.GroupLayout(pnlBackgroundSeeBooking);
        pnlBackgroundSeeBooking.setLayout(pnlBackgroundSeeBookingLayout);
        pnlBackgroundSeeBookingLayout.setHorizontalGroup(
            pnlBackgroundSeeBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundSeeBookingLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(pnlBackgroundSeeBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBookingCalender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSortSeeBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(pnlMyMeetings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        pnlBackgroundSeeBookingLayout.setVerticalGroup(
            pnlBackgroundSeeBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundSeeBookingLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlBackgroundSeeBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMyMeetings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBackgroundSeeBookingLayout.createSequentialGroup()
                        .addComponent(pnlBookingCalender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlSortSeeBooking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 137, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBackgroundSeeBooking);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMyMeetingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMyMeetingMouseClicked
     // TODO add your handling code here:
    }//GEN-LAST:event_tblMyMeetingMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlBackgroundSeeBooking;
    private javax.swing.JPanel pnlBookingCalender;
    private javax.swing.JPanel pnlMyMeetings;
    private javax.swing.JPanel pnlSortSeeBooking;
    private javax.swing.JRadioButton rbtnSortByDate;
    private javax.swing.JRadioButton rbtnSortByLocation;
    private javax.swing.JRadioButton rbtnSortByUser;
    private javax.swing.JScrollPane spnMyMeeting;
    private javax.swing.JTable tblMyMeeting;
    // End of variables declaration//GEN-END:variables
}
