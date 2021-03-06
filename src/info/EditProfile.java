package info;

import dbUtils.PictureHandler;
import dbUtils.db;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Viggo
 */
public class EditProfile extends javax.swing.JFrame {

    private Profil profile;
    private File file;
    private ImageIcon profilePicture;

    public EditProfile(Profil profile) {
        initComponents();
        this.profile = profile;

        try {
            profilePicture = new ImageIcon(db.getDB().fetchImageBytes("select IMAGE from USER_PROFILE where PROFILE_ID = '" + User.getUser() + "'"));
        } catch (SQLException ex) {
            Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            lblEditUserImage.setIcon(null);
        }
        lblEditUserImage.setIcon(profilePicture);

        txfMail.setText(User.getMail());
        txtPhone.setText(User.getPhone());
        lblUserName.setText(User.getName());
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackgroundEditProfile = new javax.swing.JPanel();
        pnlContactInfo = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        txfMail = new javax.swing.JTextField();
        lblEditUserEmailEditProfile = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        btnUpdateContact = new javax.swing.JButton();
        pnlUserInfoEditProfile = new javax.swing.JPanel();
        lblNewPassword = new javax.swing.JLabel();
        pwdOldPassword = new javax.swing.JPasswordField();
        pwdNewPassword = new javax.swing.JPasswordField();
        lblOldPassword = new javax.swing.JLabel();
        btnUpdatePassword = new javax.swing.JButton();
        btnEditPicture = new javax.swing.JButton();
        btnSaveProfileChanges = new javax.swing.JButton();
        btnCancelEdit = new javax.swing.JButton();
        lblEditUserImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnlBackgroundEditProfile.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackgroundEditProfile.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Profile", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlBackgroundEditProfile.setForeground(new java.awt.Color(0, 0, 0));
        pnlBackgroundEditProfile.setPreferredSize(new java.awt.Dimension(540, 480));
        pnlBackgroundEditProfile.setLayout(null);

        pnlContactInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlContactInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contact Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlContactInfo.setLayout(null);

        lblUser.setForeground(new java.awt.Color(0, 0, 0));
        lblUser.setText("Name");
        pnlContactInfo.add(lblUser);
        lblUser.setBounds(30, 20, 33, 16);
        pnlContactInfo.add(txfMail);
        txfMail.setBounds(80, 50, 230, 24);

        lblEditUserEmailEditProfile.setBackground(new java.awt.Color(0, 0, 0));
        lblEditUserEmailEditProfile.setForeground(new java.awt.Color(0, 0, 0));
        lblEditUserEmailEditProfile.setText("E-mail");
        pnlContactInfo.add(lblEditUserEmailEditProfile);
        lblEditUserEmailEditProfile.setBounds(30, 50, 35, 16);
        pnlContactInfo.add(txtPhone);
        txtPhone.setBounds(80, 80, 230, 24);

        lblPhone.setForeground(new java.awt.Color(0, 0, 0));
        lblPhone.setText("Phone");
        pnlContactInfo.add(lblPhone);
        lblPhone.setBounds(30, 80, 41, 16);

        lblUserName.setForeground(new java.awt.Color(0, 0, 0));
        lblUserName.setText("Name");
        pnlContactInfo.add(lblUserName);
        lblUserName.setBounds(80, 20, 230, 20);

        btnUpdateContact.setBackground(new java.awt.Color(44, 95, 125));
        btnUpdateContact.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUpdateContact.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateContact.setText("Update contact information");
        btnUpdateContact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnUpdateContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateContactActionPerformed(evt);
            }
        });
        pnlContactInfo.add(btnUpdateContact);
        btnUpdateContact.setBounds(120, 120, 190, 37);

        pnlBackgroundEditProfile.add(pnlContactInfo);
        pnlContactInfo.setBounds(180, 40, 340, 180);

        pnlUserInfoEditProfile.setBackground(new java.awt.Color(255, 255, 255));
        pnlUserInfoEditProfile.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(44, 95, 125))); // NOI18N
        pnlUserInfoEditProfile.setLayout(null);

        lblNewPassword.setForeground(new java.awt.Color(0, 0, 0));
        lblNewPassword.setText("New password");
        pnlUserInfoEditProfile.add(lblNewPassword);
        lblNewPassword.setBounds(20, 70, 100, 16);
        pnlUserInfoEditProfile.add(pwdOldPassword);
        pwdOldPassword.setBounds(130, 40, 170, 22);
        pnlUserInfoEditProfile.add(pwdNewPassword);
        pwdNewPassword.setBounds(130, 70, 170, 22);

        lblOldPassword.setForeground(new java.awt.Color(0, 0, 0));
        lblOldPassword.setText("Old password");
        pnlUserInfoEditProfile.add(lblOldPassword);
        lblOldPassword.setBounds(20, 40, 100, 16);

        btnUpdatePassword.setBackground(new java.awt.Color(44, 95, 125));
        btnUpdatePassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUpdatePassword.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdatePassword.setText("Update password");
        btnUpdatePassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnUpdatePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePasswordActionPerformed(evt);
            }
        });
        pnlUserInfoEditProfile.add(btnUpdatePassword);
        btnUpdatePassword.setBounds(130, 110, 170, 37);

        pnlBackgroundEditProfile.add(pnlUserInfoEditProfile);
        pnlUserInfoEditProfile.setBounds(180, 240, 340, 160);

        btnEditPicture.setBackground(new java.awt.Color(44, 95, 125));
        btnEditPicture.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditPicture.setForeground(new java.awt.Color(255, 255, 255));
        btnEditPicture.setText("Edit Picture");
        btnEditPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnEditPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPictureActionPerformed(evt);
            }
        });
        pnlBackgroundEditProfile.add(btnEditPicture);
        btnEditPicture.setBounds(30, 210, 100, 37);

        btnSaveProfileChanges.setBackground(new java.awt.Color(44, 95, 125));
        btnSaveProfileChanges.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSaveProfileChanges.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveProfileChanges.setText("OK");
        btnSaveProfileChanges.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnSaveProfileChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProfileChangesActionPerformed(evt);
            }
        });
        pnlBackgroundEditProfile.add(btnSaveProfileChanges);
        btnSaveProfileChanges.setBounds(260, 420, 100, 37);

        btnCancelEdit.setBackground(new java.awt.Color(44, 95, 125));
        btnCancelEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelEdit.setText("Cancel");
        btnCancelEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnCancelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditActionPerformed(evt);
            }
        });
        pnlBackgroundEditProfile.add(btnCancelEdit);
        btnCancelEdit.setBounds(390, 420, 100, 37);

        lblEditUserImage.setText("Image");
        lblEditUserImage.setMaximumSize(new java.awt.Dimension(110, 145));
        lblEditUserImage.setMinimumSize(new java.awt.Dimension(110, 145));
        lblEditUserImage.setPreferredSize(new java.awt.Dimension(110, 145));
        pnlBackgroundEditProfile.add(lblEditUserImage);
        lblEditUserImage.setBounds(30, 50, 110, 145);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackgroundEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveProfileChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProfileChangesActionPerformed
        if (file != null) {
            try {
                db.getDB().saveFileToDB(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        profile.displayProfileImage();
        this.dispose();
    }//GEN-LAST:event_btnSaveProfileChangesActionPerformed

    private void btnEditPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPictureActionPerformed
        PictureHandler handler = new PictureHandler(190, 190);
        this.file = handler.openFile2();

        Image picture = handler.convertToImageFromFile(file);
        lblEditUserImage.setIcon(new ImageIcon(picture));

    }//GEN-LAST:event_btnEditPictureActionPerformed

    private void btnCancelEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEditActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelEditActionPerformed

    private void btnUpdateContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateContactActionPerformed
        updateContactInfo();
    }//GEN-LAST:event_btnUpdateContactActionPerformed

    private void btnUpdatePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePasswordActionPerformed
        changePassword();
    }//GEN-LAST:event_btnUpdatePasswordActionPerformed

    private void updateContactInfo() {
        String mail = txfMail.getText();
        String phone = txtPhone.getText();
        profile.updateProfileTexts(mail, phone);
        try {
            db.getDB().update("UPDATE USER_PROFILE SET EMAILADDRESS = '" + mail + "', PHONE = '" + phone + "' WHERE PROFILE_ID = '" + User.getUser() + "'");
            JOptionPane.showMessageDialog(null, "Contact information updated.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "An error occurred.");
        }
    }

    private void changePassword() {
        char[] oPass = pwdOldPassword.getPassword();
        char[] nPass = pwdNewPassword.getPassword();
        StringBuilder sb = new StringBuilder("");
        StringBuilder sb2 = new StringBuilder("");
        String oldPass = sb.append(oPass).toString();
        String newPass = sb2.append(nPass).toString();
        if (Validation.checkPassword(pwdOldPassword)
                && Validation.checkPassword(pwdNewPassword)) {
            try {
                String existingPass = db.getDB().fetchSingle("select PASSWORD from USER where USER_ID = '" + User.getUser() + "'");
                if (oldPass.equals(existingPass)) {
                    db.getDB().update("update USER set PASSWORD = '" + newPass + "' where USER_ID = '" + User.getUser() + "'");
                     JOptionPane.showMessageDialog(null, "Password successfully updated.");
                     pwdOldPassword.setText("");
                     pwdNewPassword.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong password.");
                    pwdOldPassword.requestFocus();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "An error occurred.");
            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelEdit;
    private javax.swing.JButton btnEditPicture;
    private javax.swing.JButton btnSaveProfileChanges;
    private javax.swing.JButton btnUpdateContact;
    private javax.swing.JButton btnUpdatePassword;
    private javax.swing.JLabel lblEditUserEmailEditProfile;
    private javax.swing.JLabel lblEditUserImage;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblOldPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnlBackgroundEditProfile;
    private javax.swing.JPanel pnlContactInfo;
    private javax.swing.JPanel pnlUserInfoEditProfile;
    private javax.swing.JPasswordField pwdNewPassword;
    private javax.swing.JPasswordField pwdOldPassword;
    private javax.swing.JTextField txfMail;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
