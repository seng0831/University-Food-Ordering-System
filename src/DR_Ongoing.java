
import javax.swing.JOptionPane;

public class DR_Ongoing extends javax.swing.JFrame {
    private String location;
    private String userid;
    private String filepath;
    
    public DR_Ongoing() {
        initComponents();
    }
    public DR_Ongoing(String userid) {
        setTitle("Ongoing Task");
        initComponents();
        this.userid = userid;
        this.filepath = "TaskOngoing.txt";
        DR_FileManips fm = new DR_FileManips(filepath, "", "OrderHistory.txt", "");
        String[] line = fm.Read(userid);
        ReadData(line);
    }
    
    private void ReadData(String[] line){
        if(line !=null){
            String neededpart = line[0];
            String neededpart2 = line[6];
            String[] needed = neededpart.split(":");
            String[] needed2 = neededpart2.split(":");
            txtCustomer.setText(needed[0]);
            txtDate.setText(needed[1]);
            txtID.setText(needed[2]);
            txtCuisine.setText(needed[3]);
            txtIncome.setText("2");
            txtStatus.setText(needed2[4]);
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

        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCuisine = new javax.swing.JTextField();
        btnOTW = new javax.swing.JButton();
        btnDelivered = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtIncome = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        txtCustomer = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(650, 500));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setText("OrderID");

        jLabel3.setText("Date");

        jLabel4.setText("Income");

        jLabel5.setText("Cuisine");

        jLabel1.setText("Available Task");

        txtCuisine.setEnabled(false);

        btnOTW.setText("OTW");
        btnOTW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOTWActionPerformed(evt);
            }
        });

        btnDelivered.setText("Delivered");
        btnDelivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveredActionPerformed(evt);
            }
        });

        txtID.setEnabled(false);

        txtIncome.setEnabled(false);

        txtDate.setEnabled(false);

        jLabel6.setText("Status");

        txtStatus.setEnabled(false);

        txtCustomer.setEnabled(false);

        jLabel7.setText("Customer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDelivered, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnOTW)
                                    .addGap(92, 92, 92))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53)
                                                .addComponent(jLabel4))))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCuisine, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(txtCuisine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOTW)
                    .addComponent(btnDelivered))
                .addGap(20, 20, 20)
                .addComponent(btnBack)
                .addGap(109, 109, 109))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        DR_Menu deliveryform = new DR_Menu(userid);
        deliveryform.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnOTWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOTWActionPerformed
        DR_FileManips fm = new DR_FileManips("TaskOngoing.txt", "", "", "OrderStatus.txt");
        String status = txtStatus.getText();
        if(status.equals("OTW")){
            JOptionPane.showMessageDialog(null, "The order is already OTW", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(status.equals("")){
            JOptionPane.showMessageDialog(null, "The is no ongoing task!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String orderid = txtID.getText();
            fm.Modify("OTW", orderid);
            fm.ModifyNotification(orderid, "runnersNotifications.txt", "OTW");
            String line[] = fm.Read(userid);
            ReadData(line);
        }
    }//GEN-LAST:event_btnOTWActionPerformed

    private void btnDeliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveredActionPerformed
        DR_FileManips fm = new DR_FileManips("TaskOngoing.txt", userid + ".txt", "OrderHistory.txt", "OrderStatus.txt");
        String status = txtStatus.getText();
        if(status.equals("DELIVERED")){
            JOptionPane.showMessageDialog(null, "The order is already delivered", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(status.equals("")){
            JOptionPane.showMessageDialog(null, "The is no ongoing task!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            String orderid = txtID.getText();
            fm.Modify("DELIVERED", orderid);
            fm.ModifyNotification(orderid, "runnersNotifications.txt", "Delivered");
            String line[] = fm.Read(userid);
            ReadData(line);
            fm.Delete();
        }
    }//GEN-LAST:event_btnDeliveredActionPerformed

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
            java.util.logging.Logger.getLogger(DR_Ongoing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DR_Ongoing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DR_Ongoing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DR_Ongoing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DR_Ongoing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelivered;
    private javax.swing.JButton btnOTW;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCuisine;
    private javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIncome;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}