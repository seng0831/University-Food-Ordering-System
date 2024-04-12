
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MenuVendor extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel();

    private String[] columName = {"Food ID", "Food Name","Prices"};

    
    private int row = -1;
    private String foodid;
    private String foodname;
    private String foodprice;
    
    //temporaly set to Western
    private String vendorname;
    private String filepath;
    private String filepath2;

    public MenuVendor() {
        initComponents();
        clearTextField();      
        model.setColumnIdentifiers(columName);
        ReadFile(filepath2);
        TableMenu.setEnabled(false);
    }
    
    public MenuVendor(String vendorname) {
        setVisible(true);
        setTitle("Edit menu");
        this.vendorname = vendorname;
        initComponents();
        clearTextField();
        model.setColumnIdentifiers(columName);
        filepath2 = vendorname + "Menu.txt";
        ReadFile(filepath2);
        TableMenu.setEnabled(false);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tffoodname = new javax.swing.JTextField();
        tffoodprice = new javax.swing.JTextField();
        lfoodname = new javax.swing.JLabel();
        lfoodprice = new javax.swing.JLabel();
        badd = new javax.swing.JButton();
        bremove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMenu = new javax.swing.JTable();
        lfoodid = new javax.swing.JLabel();
        tffoodid = new javax.swing.JTextField();
        tbedit = new javax.swing.JToggleButton();
        breturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lfoodname.setText("Food Name");

        lfoodprice.setText("Food Price");

        badd.setText("Add");
        badd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baddActionPerformed(evt);
            }
        });

        bremove.setText("Remove");
        bremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bremoveActionPerformed(evt);
            }
        });

        TableMenu.setModel(model);
        TableMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TableMenuMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TableMenu);

        lfoodid.setText("Food ID");

        tbedit.setText("Edit");
        tbedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbeditActionPerformed(evt);
            }
        });

        breturn.setText("Return to Main Page");
        breturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lfoodname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lfoodprice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lfoodid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tffoodname, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(tffoodid)
                            .addComponent(tffoodprice))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(badd, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(bremove, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(tbedit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(breturn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lfoodid)
                            .addComponent(tffoodid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tffoodname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lfoodname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lfoodprice)
                            .addComponent(tffoodprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(badd)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(breturn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbedit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bremove)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void baddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baddActionPerformed
        String foodid = tffoodid.getText();
        String foodname = tffoodname.getText();
        String foodprice = tffoodprice.getText();
        
        String[] values = {foodid, foodname, foodprice};
        
        
        model.addRow(values);

        
        System.out.println(foodid + foodname + foodprice);
        WriteFile(filepath2);
        clearTextField();      
        
    }//GEN-LAST:event_baddActionPerformed
    private void clearTextField(){
        tffoodid.setText("");
        tffoodname.setText("");
        tffoodprice.setText("");
    }
    
    
    
    private void bremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bremoveActionPerformed
        // TODO add your handling code here:
        if(row == -1){
            JOptionPane.showMessageDialog(null,"Please select a row");
        }
        else{
        model.removeRow(row);
        WriteFile(filepath2);
        clearTextField();
        }
    }//GEN-LAST:event_bremoveActionPerformed

    private void TableMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMenuMouseReleased
        // TODO add your handling code here:
        row = TableMenu.getSelectedRow();
        
        String foodid = String.valueOf(model.getValueAt(row, 0));
        String foodname = String.valueOf(model.getValueAt(row, 1));
        String foodprice = String.valueOf(model.getValueAt(row, 2));
        
        tffoodid.setText(foodid);
        tffoodname.setText(foodname);
        tffoodprice.setText(foodprice);
    }//GEN-LAST:event_TableMenuMouseReleased

    private void tbeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbeditActionPerformed
        if (tbedit.isSelected()) {
            TableMenu.setEnabled(true);
            tbedit.setText("Finish");
            
        } else {
            TableMenu.setEnabled(false);
            tbedit.setText("Edit");
            System.out.println("Editted Successfully");
        }
        WriteFile(filepath2);
    }//GEN-LAST:event_tbeditActionPerformed

    private void breturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breturnActionPerformed
        MainMenuVendorForm vf = new MainMenuVendorForm(vendorname);
        vf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_breturnActionPerformed

    
    private void ReadFile(String filepath2){
        String[] values = {foodid, foodname, foodprice};

        try {
            FileReader fr = new FileReader(filepath2);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] split_line = line.split(":");
                String[] rowValues = new String[3]; // Assuming there are three values in each line

                for (int i = 0; i < split_line.length; i++) {
                    rowValues[i] = split_line[i].trim();
                    System.out.println(rowValues[i]);
                }
                model.addRow(rowValues);
            }
            br.close();

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
    
    private void WriteFile(String filepath2) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            // Write table data
            for (int row = 0; row < model.getRowCount(); row++) {
                String foodid = model.getValueAt(row, 0).toString();
                String foodname = model.getValueAt(row, 1).toString();
                String foodprice = model.getValueAt(row, 2).toString();
                writer.write(foodid + ": " + foodname + ": " + foodprice);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableMenu;
    private javax.swing.JButton badd;
    private javax.swing.JButton bremove;
    private javax.swing.JButton breturn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lfoodid;
    private javax.swing.JLabel lfoodname;
    private javax.swing.JLabel lfoodprice;
    private javax.swing.JToggleButton tbedit;
    private javax.swing.JTextField tffoodid;
    private javax.swing.JTextField tffoodname;
    private javax.swing.JTextField tffoodprice;
    // End of variables declaration//GEN-END:variables
}
