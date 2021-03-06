/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import Utility.Extra;
import java.awt.Button;
import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Umesh Saranga
 */
public class Message_Send_Common extends javax.swing.JFrame {

    JFrame parent;
    int xMouse, yMouse;
    File file;

    public Message_Send_Common(JFrame parent) {
        initComponents();
        this.parent = parent;
        txtCaption.setEditable(false);
        txtAreaEmailMassage.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        panMain = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        scrAreaEffect = new javax.swing.JScrollPane();
        txtAreaMassage = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtCaption = new javax.swing.JTextField();
        scrAreaEffect1 = new javax.swing.JScrollPane();
        txtAreaEmailMassage = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtFilePath = new javax.swing.JTextField();
        btnSet = new java.awt.Button();
        btnCancel = new java.awt.Button();
        btnSend = new java.awt.Button();
        chkBoth = new javax.swing.JCheckBox();
        chkOnlySMS = new javax.swing.JCheckBox();
        chkOnlyEmail = new javax.swing.JCheckBox();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        panMain.setBackground(new java.awt.Color(255, 255, 255));
        panMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(49, 58, 115), 2));
        panMain.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panMainMouseDragged(evt);
            }
        });
        panMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panMainMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panMainMouseReleased(evt);
            }
        });
        panMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(49, 58, 115));

        jLabel1.setBackground(new java.awt.Color(49, 58, 115));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Massage Sender");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        panMain.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 23, 450, -1));

        lblMinimize.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMinimize.setForeground(new java.awt.Color(54, 33, 89));
        lblMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinimize.setText("-");
        lblMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
        });
        panMain.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 20, 20));

        lblExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblExit.setForeground(new java.awt.Color(255, 0, 0));
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setText("X");
        lblExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        panMain.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 20, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("E-mail");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 43, 80, 20));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText(":");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 43, 20, 20));

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jPanel3.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 43, 270, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Contact No");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 80, 20));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText(":");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 11, 20, 20));

        txtContactNo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jPanel3.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 11, 270, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Massage");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 80, 20));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText(":");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 20, 20));

        txtAreaMassage.setColumns(20);
        txtAreaMassage.setRows(5);
        scrAreaEffect.setViewportView(txtAreaMassage);

        jPanel3.add(scrAreaEffect, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 78, 270, 81));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Caption");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 218, 80, 20));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText(":");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 218, 20, 20));

        txtCaption.setEditable(false);
        txtCaption.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jPanel3.add(txtCaption, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 218, 270, -1));

        txtAreaEmailMassage.setEditable(false);
        txtAreaEmailMassage.setColumns(20);
        txtAreaEmailMassage.setRows(5);
        scrAreaEffect1.setViewportView(txtAreaEmailMassage);

        jPanel3.add(scrAreaEffect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 257, 270, 142));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Massage");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 257, 80, 20));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText(":");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 257, 20, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Attachment");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 417, 80, 20));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText(":");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 417, 20, 20));

        txtFilePath.setEditable(false);
        txtFilePath.setBackground(new java.awt.Color(250, 250, 250));
        txtFilePath.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jPanel3.add(txtFilePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 417, 270, -1));

        btnSet.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSet.setEnabled(false);
        btnSet.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnSet.setLabel("Set");
        btnSet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSetMouseExited(evt);
            }
        });
        btnSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetActionPerformed(evt);
            }
        });
        jPanel3.add(btnSet, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 417, 50, -1));

        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnCancel.setLabel("Cancel");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMouseExited(evt);
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 457, 78, -1));

        btnSend.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSend.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnSend.setLabel("Send");
        btnSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSendMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSendMouseExited(evt);
            }
        });
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        jPanel3.add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 457, 78, -1));

        chkBoth.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(chkBoth);
        chkBoth.setText("Both");
        chkBoth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBothActionPerformed(evt);
            }
        });
        jPanel3.add(chkBoth, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 177, -1, -1));

        chkOnlySMS.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(chkOnlySMS);
        chkOnlySMS.setSelected(true);
        chkOnlySMS.setText("Only SMS");
        chkOnlySMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOnlySMSActionPerformed(evt);
            }
        });
        jPanel3.add(chkOnlySMS, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 177, -1, -1));

        chkOnlyEmail.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(chkOnlyEmail);
        chkOnlyEmail.setText("Only Email");
        chkOnlyEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOnlyEmailActionPerformed(evt);
            }
        });
        jPanel3.add(chkOnlyEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 177, -1, -1));

        panMain.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 50, 450, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panMain, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        this.setState(1);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked

        this.dispose();
        parent.setState(0);

    }//GEN-LAST:event_lblExitMouseClicked

    private void btnSetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSetMouseEntered
        setButtonColour(btnSet);
    }//GEN-LAST:event_btnSetMouseEntered

    private void btnSetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSetMouseExited
        resetButtonColour(btnSet);
    }//GEN-LAST:event_btnSetMouseExited

    private void btnCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseEntered
        setButtonColour(btnCancel);
    }//GEN-LAST:event_btnCancelMouseEntered

    private void btnCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseExited
        resetButtonColour(btnCancel);
    }//GEN-LAST:event_btnCancelMouseExited

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
        parent.setState(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSendMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendMouseEntered
        setButtonColour(btnSend);
    }//GEN-LAST:event_btnSendMouseEntered

    private void btnSendMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendMouseExited
        resetButtonColour(btnSend);
    }//GEN-LAST:event_btnSendMouseExited

    private void chkBothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBothActionPerformed
        txtContactNo.setEditable(true);
        txtAreaMassage.setEditable(true);
        txtEmail.setEditable(true);
        txtCaption.setEditable(true);
        txtAreaEmailMassage.setEditable(true);
        btnSet.setEnabled(true);
    }//GEN-LAST:event_chkBothActionPerformed

    private void panMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMainMousePressed
        setOpacity((float) 0.8);
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panMainMousePressed

    private void panMainMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMainMouseReleased
        setOpacity((float) 1);
    }//GEN-LAST:event_panMainMouseReleased

    private void panMainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMainMouseDragged
        int x = evt.getXOnScreen(), y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panMainMouseDragged

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        btnSend.setEnabled(false);
        if (chkOnlySMS.isSelected()) {
            if (!Extra.isValidPhoneNumber(txtContactNo.getText())) {
                JOptionPane.showMessageDialog(this, "Invalid Contact Number..!", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("Images/message_error.png")));
                btnSend.setEnabled(true);
            } else {
                try {
                    if (new SendMessage().send(txtContactNo.getText(), txtAreaMassage.getText())) {
                        JOptionPane.showMessageDialog(this, "Message Send Successfull...!", "Send Succeed", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("Images/message_success.png")));
                        btnSend.setEnabled(true);
                    }
                } catch (Exception e) {
                }
            }
        } else if (chkOnlyEmail.isSelected()) {
            if (!Extra.isValidEmail(txtEmail.getText().trim())) {
                JOptionPane.showMessageDialog(this, "Invalid Email..!", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("Images/message_error.png")));
                btnSend.setEnabled(true);
            } else {
                try {
                    if (new MailSender().send(txtEmail.getText().trim(), txtCaption.getText(), txtAreaEmailMassage.getText(), txtFilePath.getText())) {
                        JOptionPane.showMessageDialog(this, "Message Send Successfull...!", "Send Succeed", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("Images/message_success.png")));
                        btnSend.setEnabled(true);
                    }else {
                        JOptionPane.showMessageDialog(this, "Send Fail..!", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("Images/message_error.png")));
                        btnSend.setEnabled(true);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Send Fail..!", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("Images/message_error.png")));
                    btnSend.setEnabled(true);
                }
            }

        }else {
            if (!Extra.isValidPhoneNumber(txtContactNo.getText())) {
                JOptionPane.showMessageDialog(this, "Invalid Contact Number..!", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("Images/message_error.png")));
                btnSend.setEnabled(true);
            }else if (!Extra.isValidEmail(txtEmail.getText().trim())) {
                JOptionPane.showMessageDialog(this, "Invalid Email..!", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("Images/message_error.png")));
                btnSend.setEnabled(true);
            } else {
                try {
                    if (new SendMessage().send(txtContactNo.getText(), txtAreaMassage.getText()) && new MailSender().send(txtEmail.getText().trim(), txtCaption.getText(), txtAreaEmailMassage.getText(), txtFilePath.getText())) {
                        JOptionPane.showMessageDialog(this, "Message Send Successfull...!", "Send Succeed", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("Images/message_success.png")));
                        btnSend.setEnabled(true);
                    }else {
                        JOptionPane.showMessageDialog(this, "Send Fail..!", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("Images/message_error.png")));
                        btnSend.setEnabled(true);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Send Fail..!", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("Images/message_error.png")));
                    btnSend.setEnabled(true);
                }
            }

        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            file = chooser.getSelectedFile();
            String path = file.getAbsolutePath();
            txtFilePath.setText(path);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSetActionPerformed

    private void chkOnlySMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOnlySMSActionPerformed
        txtContactNo.setEditable(true);
        txtAreaMassage.setEditable(true);
        txtEmail.setEditable(false);
        txtCaption.setEditable(false);
        txtAreaEmailMassage.setEditable(false);
        btnSet.setEnabled(false);
    }//GEN-LAST:event_chkOnlySMSActionPerformed

    private void chkOnlyEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOnlyEmailActionPerformed
        txtContactNo.setEditable(false);
        txtAreaMassage.setEditable(false);
        txtEmail.setEditable(true);
        txtCaption.setEditable(true);
        txtAreaEmailMassage.setEditable(true);
        btnSet.setEnabled(true);
    }//GEN-LAST:event_chkOnlyEmailActionPerformed

    private void setButtonColour(Button button) {
        button.setBackground(new Color(0, 153, 0));
        button.setForeground(new Color(255, 255, 255));

    }

    private void resetButtonColour(Button button) {
        button.setBackground(new Color(240, 240, 240));
        button.setForeground(new Color(0, 0, 0));

    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Message_Send_Common.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Message_Send_Common.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Message_Send_Common.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Message_Send_Common.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new Message_Send_Common(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnCancel;
    private java.awt.Button btnSend;
    private java.awt.Button btnSet;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkBoth;
    private javax.swing.JCheckBox chkOnlyEmail;
    private javax.swing.JCheckBox chkOnlySMS;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JPanel panMain;
    private javax.swing.JScrollPane scrAreaEffect;
    private javax.swing.JScrollPane scrAreaEffect1;
    private javax.swing.JTextArea txtAreaEmailMassage;
    private javax.swing.JTextArea txtAreaMassage;
    private javax.swing.JTextField txtCaption;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFilePath;
    // End of variables declaration//GEN-END:variables
}
