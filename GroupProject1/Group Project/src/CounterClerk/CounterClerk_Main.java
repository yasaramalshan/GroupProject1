/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CounterClerk;

import Admin.Edit_Application;
import Admin.Password_Change;
import Admin.View_Application;
import ManagementAssistant.Search_Details;
import Utility.Extra;
import groupproject.DBOperations;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yasara JLP
 */
public class CounterClerk_Main extends javax.swing.JFrame {

    int xMouse, yMouse;
    ResultSet rs, application, applicant;
    DefaultTableModel table;

    public CounterClerk_Main(String userID) {
        initComponents();
        lblUserId.setText(userID);
        this.table = (DefaultTableModel) tblRegisteredApplications.getModel();
        showDate();
        showTime();
        loadTable();

        // for set table header background
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        //headerRenderer.setBackground(new Color(240, 240, 240)); // change background colour
        headerRenderer.setHorizontalAlignment(JLabel.CENTER); // change alignment of column captions

        for (int i = 0; i < tblRegisteredApplications.getModel().getColumnCount(); i++) {
            tblRegisteredApplications.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);

        }
        tblRegisteredApplications.getTableHeader().setBorder(new BevelBorder(0, Color.WHITE, Color.lightGray));

        // to set column allignments to center
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER); // change alignment of column values
        tblRegisteredApplications.setDefaultRenderer(String.class, centerRenderer);

        tblRegisteredApplications.setShowGrid(true);//to show gri in table
        tblRegisteredApplications.setShowHorizontalLines(false);//hide horizontal lines from grid
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMain = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegisteredApplications = new javax.swing.JTable();
        btnViewForm = new java.awt.Button();
        btnEditForm = new java.awt.Button();
        btnApproveForm = new java.awt.Button();
        btnRefresh = new java.awt.Button();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnApplicantReg = new javax.swing.JLabel();
        btnApplicationReg = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        btnReport = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblLogOut = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblUserId = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnChangePass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

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
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(106, 116, 145));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(224, 227, 221));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Registered Applications");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 220, 20));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 780, 20));

        jScrollPane1.setBorder(null);

        tblRegisteredApplications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Application Id", "Owner's Initial Name", "Owner's Last Name", "Owner's NIC", "Ward No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblRegisteredApplications.setGridColor(new java.awt.Color(204, 204, 204));
        tblRegisteredApplications.setSelectionBackground(new java.awt.Color(79, 142, 255));
        jScrollPane1.setViewportView(tblRegisteredApplications);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 670, 230));

        btnViewForm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnViewForm.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnViewForm.setLabel("View");
        btnViewForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewFormMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewFormMouseExited(evt);
            }
        });
        btnViewForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewFormActionPerformed(evt);
            }
        });
        jPanel2.add(btnViewForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 100, -1));

        btnEditForm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditForm.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnEditForm.setLabel("Edit");
        btnEditForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditFormMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditFormMouseExited(evt);
            }
        });
        btnEditForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditFormActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 100, -1));

        btnApproveForm.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnApproveForm.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnApproveForm.setLabel("Accept");
        btnApproveForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnApproveFormMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnApproveFormMouseExited(evt);
            }
        });
        btnApproveForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveFormActionPerformed(evt);
            }
        });
        jPanel2.add(btnApproveForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 100, -1));

        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRefresh.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnRefresh.setLabel("Refresh");
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRefreshMouseExited(evt);
            }
        });
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 100, -1));

        panMain.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 800, 290));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Counter Clerk");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CounterClerk/Images/home2.png"))); // NOI18N
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 130, 140));

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTime.setText("time");
        jPanel3.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 30));

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDate.setText("date");
        jPanel3.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 94, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 10, 150));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 280, 10));

        btnApplicantReg.setBackground(new java.awt.Color(190, 190, 190));
        btnApplicantReg.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnApplicantReg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnApplicantReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin/Images/home_Add_User.png"))); // NOI18N
        btnApplicantReg.setText(" Applicant Registration   ");
        btnApplicantReg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(170, 170, 170)));
        btnApplicantReg.setOpaque(true);
        btnApplicantReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnApplicantRegMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnApplicantRegMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnApplicantRegMouseExited(evt);
            }
        });
        jPanel3.add(btnApplicantReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 190, 25));

        btnApplicationReg.setBackground(new java.awt.Color(190, 190, 190));
        btnApplicationReg.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnApplicationReg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnApplicationReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin/Images/home_app_reg.png"))); // NOI18N
        btnApplicationReg.setText("  Application Registration");
        btnApplicationReg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(170, 170, 170)));
        btnApplicationReg.setOpaque(true);
        btnApplicationReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnApplicationRegMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnApplicationRegMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnApplicationRegMouseExited(evt);
            }
        });
        jPanel3.add(btnApplicationReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 190, 25));

        btnSearch.setBackground(new java.awt.Color(190, 190, 190));
        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin/Images/home_Search.png"))); // NOI18N
        btnSearch.setText(" Search Details                 ");
        btnSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(170, 170, 170)));
        btnSearch.setOpaque(true);
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });
        jPanel3.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 190, 25));

        btnReport.setBackground(new java.awt.Color(190, 190, 190));
        btnReport.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Admin/Images/home_Report.png"))); // NOI18N
        btnReport.setText(" Get Summary Report      ");
        btnReport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(170, 170, 170)));
        btnReport.setOpaque(true);
        btnReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportMouseExited(evt);
            }
        });
        jPanel3.add(btnReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 190, 25));

        panMain.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 800, 180));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CounterClerk/Images/home_Logout_20px.png"))); // NOI18N
        lblLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogOutMouseExited(evt);
            }
        });
        jPanel4.add(lblLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 5, 20, 20));

        lblMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CounterClerk/Images/home_Horizontal_Line_15px.png"))); // NOI18N
        lblMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseExited(evt);
            }
        });
        jPanel4.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 5, 20, 20));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CounterClerk/Images/home_User_20px.png"))); // NOI18N
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 30, 30));

        lblUserId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUserId.setText("User");
        jPanel4.add(lblUserId, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 110, 10));

        panMain.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 800, 30));

        jPanel1.setBackground(new java.awt.Color(9, 18, 72));

        btnChangePass.setBackground(new java.awt.Color(9, 18, 72));
        btnChangePass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnChangePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CounterClerk/Images/home_Password_Reset_20px.png"))); // NOI18N
        btnChangePass.setOpaque(true);
        btnChangePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChangePassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnChangePassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChangePassMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );

        panMain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showDate() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(df.format(date));
    }

    private void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss a"); // use HH for het time in 24 hour format
                lblTime.setText(df.format(date));
            }
        }).start();
    }

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        int dialogResult = JOptionPane.showConfirmDialog(this, "Would You Like to Logout...?", "Warning", JOptionPane.YES_NO_OPTION, 0, new ImageIcon(getClass().getResource("Images/message_confirm.png")));
        if (dialogResult == JOptionPane.YES_OPTION) {
            new DBOperations().setLoginStatus(lblUserId.getText(), 0);
            //Extra.smoothExitWindow(this);
            this.dispose();
            new Login.Login().setVisible(true);
        }

    }//GEN-LAST:event_lblLogOutMouseClicked

    private void panMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMainMousePressed
        setOpacity((float) 0.8);
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panMainMousePressed

    private void panMainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMainMouseDragged
        int x = evt.getXOnScreen(), y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panMainMouseDragged

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        this.setState(1);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseEntered
        lblLogOut.setIcon(new ImageIcon(getClass().getResource("Images/home_Logout_20px_1.png")));
    }//GEN-LAST:event_lblLogOutMouseEntered

    private void lblLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseExited
        lblLogOut.setIcon(new ImageIcon(getClass().getResource("Images/home_Logout_20px.png")));
    }//GEN-LAST:event_lblLogOutMouseExited

    private void lblMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseEntered
        lblMinimize.setIcon(new ImageIcon(getClass().getResource("Images/home_Horizontal_Line_15px_1.png")));
    }//GEN-LAST:event_lblMinimizeMouseEntered

    private void lblMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseExited
        lblMinimize.setIcon(new ImageIcon(getClass().getResource("Images/home_Horizontal_Line_15px.png")));
    }//GEN-LAST:event_lblMinimizeMouseExited

    private void panMainMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panMainMouseReleased
        setOpacity((float) 1);
    }//GEN-LAST:event_panMainMouseReleased

    private void btnChangePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangePassMouseClicked
        new Password_Change(this, lblUserId.getText().trim()).setVisible(true);
        this.setState(1);
    }//GEN-LAST:event_btnChangePassMouseClicked

    private void btnChangePassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangePassMouseEntered
        setLableColour(btnChangePass);
    }//GEN-LAST:event_btnChangePassMouseEntered

    private void btnChangePassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangePassMouseExited
        resetLableColour(btnChangePass);
    }//GEN-LAST:event_btnChangePassMouseExited

    private void btnViewFormMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewFormMouseEntered
        setButtonColour(btnViewForm);
    }//GEN-LAST:event_btnViewFormMouseEntered

    private void btnViewFormMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewFormMouseExited
        resetButtonColour(btnViewForm);
    }//GEN-LAST:event_btnViewFormMouseExited

    private void btnViewFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewFormActionPerformed
        if (!tblRegisteredApplications.getSelectionModel().isSelectionEmpty()) {
            String applicationID = tblRegisteredApplications.getModel().getValueAt(tblRegisteredApplications.getSelectedRow(), 0).toString();
            new View_Application(this, applicationID).setVisible(true);
            this.setState(1);
        }
    }//GEN-LAST:event_btnViewFormActionPerformed

    private void btnEditFormMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditFormMouseEntered
        setButtonColour(btnEditForm);
    }//GEN-LAST:event_btnEditFormMouseEntered

    private void btnEditFormMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditFormMouseExited
        resetButtonColour(btnEditForm);
    }//GEN-LAST:event_btnEditFormMouseExited

    private void btnEditFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditFormActionPerformed
        if (!tblRegisteredApplications.getSelectionModel().isSelectionEmpty()) {
            String applicationID = tblRegisteredApplications.getModel().getValueAt(tblRegisteredApplications.getSelectedRow(), 0).toString();
            new Edit_Application(this, applicationID).setVisible(true);
            this.setState(1);
        }
    }//GEN-LAST:event_btnEditFormActionPerformed

    private void btnApproveFormMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApproveFormMouseEntered
        setButtonColour(btnApproveForm);
    }//GEN-LAST:event_btnApproveFormMouseEntered

    private void btnApproveFormMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApproveFormMouseExited
        resetButtonColour(btnApproveForm);
    }//GEN-LAST:event_btnApproveFormMouseExited

    private void btnApproveFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveFormActionPerformed
        if (!tblRegisteredApplications.getSelectionModel().isSelectionEmpty()) {
            String applicationID = tblRegisteredApplications.getModel().getValueAt(tblRegisteredApplications.getSelectedRow(), 0).toString();
            if (new DBOperations().updateApplicationStatus(applicationID, "Management Assistant")) {
                JOptionPane.showMessageDialog(this, "Application Send Successfull...!", "Send Succeed", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("Images/message_success.png")));
            } else {
                JOptionPane.showMessageDialog(this, "Send Failed..!", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("Images/message_error.png")));
            }
            loadTable();
            
        }

    }//GEN-LAST:event_btnApproveFormActionPerformed

    private void btnRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseEntered
        setButtonColour(btnRefresh);
    }//GEN-LAST:event_btnRefreshMouseEntered

    private void btnRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseExited
        resetButtonColour(btnRefresh);
    }//GEN-LAST:event_btnRefreshMouseExited

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnApplicantRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApplicantRegMouseClicked
        new Register_Applicant(this).setVisible(true);
        this.setState(1);
    }//GEN-LAST:event_btnApplicantRegMouseClicked

    private void btnApplicantRegMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApplicantRegMouseEntered
        setBtnColour(btnApplicantReg);
    }//GEN-LAST:event_btnApplicantRegMouseEntered

    private void btnApplicantRegMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApplicantRegMouseExited
        resetBtnColour(btnApplicantReg);
    }//GEN-LAST:event_btnApplicantRegMouseExited

    private void btnApplicationRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApplicationRegMouseClicked
        new CounterClerk.Register_Application(this).setVisible(true);
        this.setState(1);
    }//GEN-LAST:event_btnApplicationRegMouseClicked

    private void btnApplicationRegMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApplicationRegMouseEntered
        setBtnColour(btnApplicationReg);
    }//GEN-LAST:event_btnApplicationRegMouseEntered

    private void btnApplicationRegMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApplicationRegMouseExited
        resetBtnColour(btnApplicationReg);
    }//GEN-LAST:event_btnApplicationRegMouseExited

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        new Search_Details(this).setVisible(true);
        this.setState(1);
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        setBtnColour(btnSearch);
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        resetBtnColour(btnSearch);
    }//GEN-LAST:event_btnSearchMouseExited

    private void btnReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseEntered
        setBtnColour(btnReport);
    }//GEN-LAST:event_btnReportMouseEntered

    private void btnReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseExited
        resetBtnColour(btnReport);
    }//GEN-LAST:event_btnReportMouseExited

    public void loadTable() {
        table.getDataVector().removeAllElements();
        table.fireTableDataChanged();
        
        DBOperations dbops = new DBOperations();
        rs = dbops.getStatusData("Counter Clerk");
        try {
            while (rs.next()) {
                application = dbops.getApplication(rs.getString("application_id"), 0);
                application.next(); // set the pointer to the data row
                applicant = dbops.getApplicant(application.getString("owner_nic"), 0);
                applicant.next();
                table.addRow(new Object[]{application.getString("application_id"), applicant.getString("init_name"), applicant.getString("last_name"), applicant.getString("nic"), application.getString("ward_no")});
            }
        } catch (Exception e) {
            System.out.println("exeption in loadTable method in CounterClerk_Main " + e);
        } finally {
            try {
                rs.close();
                applicant.close();
                application.close();
            } catch (Exception e) {
            }

        }
    }

    private void setLableColour(JLabel lbl) {
        lbl.setBackground(new Color(106, 116, 145));

    }

    private void resetLableColour(JLabel lbl) {
        lbl.setBackground(new Color(9, 18, 72));

    }

    private void setButtonColour(Button button) {
        button.setBackground(new Color(0, 153, 0));
        button.setForeground(new Color(255, 255, 255));

    }

    private void resetButtonColour(Button button) {
        button.setBackground(new Color(240, 240, 240));
        button.setForeground(new Color(0, 0, 0));

    }

    private void setBtnColour(JLabel label) {
        label.setBackground(new Color(150, 150, 150));
    }

    private void resetBtnColour(JLabel label) {
        label.setBackground(new Color(190, 190, 190));
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
            java.util.logging.Logger.getLogger(CounterClerk_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CounterClerk_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CounterClerk_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CounterClerk_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new CounterClerk_Main(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnApplicantReg;
    private javax.swing.JLabel btnApplicationReg;
    private java.awt.Button btnApproveForm;
    private javax.swing.JLabel btnChangePass;
    private java.awt.Button btnEditForm;
    private java.awt.Button btnRefresh;
    private javax.swing.JLabel btnReport;
    private javax.swing.JLabel btnSearch;
    private java.awt.Button btnViewForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblLogOut;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblUserId;
    private javax.swing.JPanel panMain;
    private javax.swing.JTable tblRegisteredApplications;
    // End of variables declaration//GEN-END:variables

}
