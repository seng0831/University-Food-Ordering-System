/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author hw
 */
public class Customer_Homepage extends javax.swing.JFrame {
    private String user;
    /**
     * Creates new form Customer_Homepage
     */
    public Customer_Homepage(String user) {
        setTitle("Customer Home");
        initComponents();
        this.user=user;
        showID();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFoodOrder = new javax.swing.JButton();
        btnC_OrderHis = new javax.swing.JButton();
        btnCustomerReview = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        btnNotification = new javax.swing.JButton();
        btnC_CreditBal1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(675, 500));
        setVisible(true);

        btnFoodOrder.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnFoodOrder.setText("FOOD ORDER");
        btnFoodOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoodOrderActionPerformed(evt);
            }
        });

        btnC_OrderHis.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnC_OrderHis.setText("CHECK ORDER STATUS AND HISTORY");
        btnC_OrderHis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_OrderHisActionPerformed(evt);
            }
        });

        btnCustomerReview.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCustomerReview.setText("CUSTOMER REVIEW");
        btnCustomerReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerReviewActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 51, 51));
        btnLogout.setText("LOG OUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel2.setText("Welcome Back");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel3.setText("User: ");

        lbUser.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        lbUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNotification.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNotification.setText("NOTIFICATION");
        btnNotification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificationActionPerformed(evt);
            }
        });

        btnC_CreditBal1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnC_CreditBal1.setText("CHECK CREDIT BALANCE");
        btnC_CreditBal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnC_CreditBal1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNotification)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(202, 202, 202))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCustomerReview, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnC_OrderHis, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnC_CreditBal1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFoodOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNotification)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(btnFoodOrder)
                .addGap(18, 18, 18)
                .addComponent(btnC_OrderHis)
                .addGap(18, 18, 18)
                .addComponent(btnCustomerReview)
                .addGap(18, 18, 18)
                .addComponent(btnC_CreditBal1)
                .addGap(18, 18, 18)
                .addComponent(btnLogout)
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCustomerReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerReviewActionPerformed
        try {
            Customer_Review cr = new Customer_Review(user);
            cr.show();        
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(Customer_Homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCustomerReviewActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int confirmLogout = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Log Out",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmLogout == JOptionPane.YES_OPTION) {
            LoginView view = new LoginView();
            LoginController controller = new LoginController(view);
            controller.startApplication();
            dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnFoodOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoodOrderActionPerformed
        Customer_FoodOrder order = new Customer_FoodOrder(user);
        order.show();
        dispose();
    }//GEN-LAST:event_btnFoodOrderActionPerformed

    private void btnC_OrderHisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_OrderHisActionPerformed
        Customer_OrderStatus_History osh = new Customer_OrderStatus_History(user);
        osh.show();
        dispose();
    }//GEN-LAST:event_btnC_OrderHisActionPerformed

    private void btnNotificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificationActionPerformed
        new Notifications(user);
        dispose();
    }//GEN-LAST:event_btnNotificationActionPerformed

    private void btnC_CreditBal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnC_CreditBal1ActionPerformed
        Customer_CreditBalance credit = new Customer_CreditBalance(user);
        credit.show();
        dispose();
    }//GEN-LAST:event_btnC_CreditBal1ActionPerformed

    private void showID(){
        lbUser.setText(user);
    }
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnC_CreditBal1;
    private javax.swing.JButton btnC_OrderHis;
    private javax.swing.JButton btnCustomerReview;
    private javax.swing.JButton btnFoodOrder;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNotification;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbUser;
    // End of variables declaration//GEN-END:variables
}