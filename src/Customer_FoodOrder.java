/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hw
 */
public class Customer_FoodOrder extends javax.swing.JFrame {
    private String user;
    /**
     * Creates new form Sample_Menu
     */
    public Customer_FoodOrder(String user) {
        setTitle("Food Menu");
        initComponents();
        this.user=user;
        AddOrderRowToLabel();
        cal_Quantity();
        try {
            readvendor();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnConfirmOrder = new java.awt.Button();
        lbSelectedorder = new javax.swing.JLabel();
        lbMenu = new javax.swing.JLabel();
        lbSelectedlist1 = new javax.swing.JLabel();
        btnAddToChart = new java.awt.Button();
        lbSelectedlist4 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TBLMenu = new javax.swing.JTable();
        lbSelectedlist3 = new javax.swing.JLabel();
        CBOrderMethod = new javax.swing.JComboBox<>();
        btnBack = new java.awt.Button();
        lbSelectedlist5 = new javax.swing.JLabel();
        cbPickOrder = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        TBLCart = new javax.swing.JTable();

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("0");

        jButton5.setText("-");

        jButton6.setText("+");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(840, 530));
        setResizable(false);
        setSize(new java.awt.Dimension(840, 500));

        btnConfirmOrder.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConfirmOrder.setLabel("ORDER");
        btnConfirmOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmOrderActionPerformed(evt);
            }
        });

        lbSelectedorder.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbMenu.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lbMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMenu.setText("MENU");

        lbSelectedlist1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSelectedlist1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSelectedlist1.setText("YOUR CART:");

        btnAddToChart.setActionCommand("AD");
        btnAddToChart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddToChart.setLabel("ADD");
        btnAddToChart.setName(""); // NOI18N
        btnAddToChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToChartActionPerformed(evt);
            }
        });

        lbSelectedlist4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSelectedlist4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSelectedlist4.setText("SELECTED ITEM:");

        TBLMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FOOD CODE", "NAME", "PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBLMenu.setRowHeight(30);
        TBLMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TBLMenuMouseReleased(evt);
            }
        });
        jScrollPane8.setViewportView(TBLMenu);
        if (TBLMenu.getColumnModel().getColumnCount() > 0) {
            TBLMenu.getColumnModel().getColumn(0).setMinWidth(85);
            TBLMenu.getColumnModel().getColumn(0).setMaxWidth(85);
            TBLMenu.getColumnModel().getColumn(1).setMinWidth(190);
            TBLMenu.getColumnModel().getColumn(1).setMaxWidth(190);
        }

        lbSelectedlist3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSelectedlist3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSelectedlist3.setText("PICK YOUR ORDER METHOD:");

        CBOrderMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DINE IN", "TAKE AWAY", "DELIVERY" }));
        CBOrderMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBOrderMethodActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setLabel("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lbSelectedlist5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSelectedlist5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSelectedlist5.setText("SELECT SHOP:");

        cbPickOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPickOrderActionPerformed(evt);
            }
        });

        TBLCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FOOD CODE", "NAME", "*QUANTITY", "PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBLCart.setRowHeight(30);
        jScrollPane9.setViewportView(TBLCart);
        if (TBLCart.getColumnModel().getColumnCount() > 0) {
            TBLCart.getColumnModel().getColumn(0).setMinWidth(85);
            TBLCart.getColumnModel().getColumn(0).setMaxWidth(85);
            TBLCart.getColumnModel().getColumn(1).setMinWidth(190);
            TBLCart.getColumnModel().getColumn(1).setMaxWidth(190);
            TBLCart.getColumnModel().getColumn(2).setMinWidth(90);
            TBLCart.getColumnModel().getColumn(2).setMaxWidth(90);
            TBLCart.getColumnModel().getColumn(2).setHeaderValue("*QUANTITY");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbSelectedlist5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbPickOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbSelectedlist4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbSelectedorder, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(btnAddToChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbSelectedlist1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbSelectedlist3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CBOrderMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnConfirmOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(295, 295, 295)
                        .addComponent(lbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbSelectedlist5)
                                .addComponent(cbPickOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbSelectedlist4))
                            .addComponent(lbSelectedorder, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnConfirmOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbSelectedlist1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbSelectedlist3)
                                    .addComponent(CBOrderMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddToChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmOrderActionPerformed
        if (TBLCart.getRowCount() > 0) {
            String fileOrder="FoodOrderDetail.txt";

            try{
                FileWriter fw= new FileWriter(fileOrder);
                BufferedWriter writer= new BufferedWriter(fw);
                writer.write("");
                writer.flush();
                
                String ordermethod = CBOrderMethod.getSelectedItem().toString();
                String shop=cbPickOrder.getSelectedItem().toString();
               
                for (int i = 0; i < TBLCart.getRowCount(); i++) {
                    // Assuming column indices, modify them accordingly based on your table structure
                    String foodCode = TBLCart.getValueAt(i, 0).toString();
                    String foodName = TBLCart.getValueAt(i, 1).toString();
                    String quantity = TBLCart.getValueAt(i, 2).toString();
                    String price = TBLCart.getValueAt(i, 3).toString();
                    
                    String userid=user;

                    String row = userid+":"+foodCode + ": " + foodName + ": " + quantity + ": " + price + ":" + ordermethod + ":" + shop ;
                    writer.write(row);
                    writer.newLine();
                }
                
                writer.close();
                fw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(Customer_FoodOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Order Added to Cart", "Order Added Successfully", JOptionPane.INFORMATION_MESSAGE);
            
            Customer_FoodOrderDetail fod = new Customer_FoodOrderDetail(user);
            fod.show();
            dispose();  
  
        } else {
            JOptionPane.showMessageDialog(this, "No order have been found.", "Your Chart", JOptionPane.WARNING_MESSAGE);
        }           
    }//GEN-LAST:event_btnConfirmOrderActionPerformed

    private void btnAddToChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToChartActionPerformed
        DefaultTableModel Menumodel = (DefaultTableModel)TBLMenu.getModel();
        int selectedRowInMenu = TBLMenu.getSelectedRow(); // Initialize to -1

        if (Menumodel != null && selectedRowInMenu != -1) {
            String foodCode = Menumodel.getValueAt(selectedRowInMenu, 0).toString();
            String Name = Menumodel.getValueAt(selectedRowInMenu, 1).toString();
            String price = Menumodel.getValueAt(selectedRowInMenu, 2).toString();

            DefaultTableModel selectedItemsTableModel = (DefaultTableModel) TBLCart.getModel();

            boolean itemAlreadyAdded = false;
            for (int i = 0; i < selectedItemsTableModel.getRowCount(); i++) {
                String existingFoodCode = selectedItemsTableModel.getValueAt(i, 0).toString();
                if (existingFoodCode.equals(foodCode)) {
                    itemAlreadyAdded = true;
                    break;
                }
            }

            if (!itemAlreadyAdded) {
                selectedItemsTableModel.addRow(new Object[]{foodCode, Name, 1,price});
            } else {
                JOptionPane.showMessageDialog(this, "Item is already in the chart.", "Item Already Added", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAddToChartActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Customer_Homepage home = new Customer_Homepage(user);
        home.show();
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void cbPickOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPickOrderActionPerformed
        DefaultTableModel cartModel = (DefaultTableModel) TBLCart.getModel();

        if (cartModel.getRowCount() == 0) {
            String filePath = cbPickOrder.getSelectedItem() + "Menu.txt";

            try {
                loadMenuFromFile(filePath, (DefaultTableModel) TBLMenu.getModel());
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(Customer_FoodOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            int changeShop = JOptionPane.showConfirmDialog(this, "Do you want to give up the order to proceed?", "Shop Changed", JOptionPane.YES_NO_OPTION);

            if (changeShop == JOptionPane.YES_OPTION) {
                cartModel.setRowCount(0);

                String filePath = cbPickOrder.getSelectedItem() + "Menu.txt";

                try {
                    loadMenuFromFile(filePath, (DefaultTableModel) TBLMenu.getModel());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(Customer_FoodOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_cbPickOrderActionPerformed

    private void CBOrderMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBOrderMethodActionPerformed
         
    }//GEN-LAST:event_CBOrderMethodActionPerformed

    private void TBLMenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLMenuMouseReleased
        
    }//GEN-LAST:event_TBLMenuMouseReleased

    private void loadMenuFromFile(String filePath, DefaultTableModel menuModel) throws IOException {
        try (FileReader menuFile = new FileReader(new File(filePath));
             BufferedReader br = new BufferedReader(menuFile)) {

            menuModel.setRowCount(0);

            String menuLine;
            while ((menuLine = br.readLine()) != null) {
                String[] parts = menuLine.split(":");
                if (parts.length == 3) {
                    String foodCode = parts[0];
                    String name = parts[1];
                    String price = parts[2];

                    menuModel.addRow(new Object[]{foodCode, name, "RM" + price});
                }
            }
        }
    }
    
    private void AddOrderRowToLabel(){
        TBLMenu.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            int selectedRow = TBLMenu.getSelectedRow();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) TBLMenu.getModel();
                String Name = model.getValueAt(selectedRow, 1).toString();
                lbSelectedorder.setText(Name);
            }
        }
        });
    }
    
    private void cal_Quantity() {
        DefaultTableModel quantityModel = (DefaultTableModel) TBLCart.getModel();
        DefaultTableModel priceModel = (DefaultTableModel) TBLMenu.getModel();

        quantityModel.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 2) {
                    for (int i = 0; i < TBLCart.getRowCount(); i++) {
                        String foodCode = TBLCart.getValueAt(i, 0).toString();
                        String quantityStr = TBLCart.getValueAt(i, 2).toString();
                        String originalPriceStr = priceModel.getValueAt(i, 2).toString();

                        String exFoodCode = quantityModel.getValueAt(i, 0).toString();
                        if (exFoodCode.equals(foodCode)) {
                            int quantity = Integer.parseInt(quantityStr);

                            if (quantity > 0) {
                                originalPriceStr = originalPriceStr.replaceAll("[^0-9.]", "");
                                double originalPrice = Double.parseDouble(originalPriceStr);

                                MenuItem menuItem = new MenuItem(foodCode, "ItemName", originalPrice);
                                ShopcartItem cartItem = new ShopcartItem(menuItem, quantity);

                                double newTotal = cartItem.getQuantity() * cartItem.getMenuItem().getPrice();
                                TBLCart.setValueAt("RM" + String.format("%.2f", newTotal), i, 3);
                            } else {
                                JOptionPane.showMessageDialog(null, "Order quantity must be greater than 0.", "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
                                TBLCart.setValueAt(1, i, 2);
                            }
                        }
                    }
                }
            }
        });
    }

    
    private void readvendor() throws FileNotFoundException, IOException{
        String vendor="vendor.txt";
        File venfile=new File(vendor);
        FileReader vfr=new FileReader(venfile);
        BufferedReader vbr= new BufferedReader(vfr);
        
        String vendorline;
        
        while((vendorline = vbr.readLine())!=null){
            String[] vendorpart = vendorline.split(":");
            if (vendorpart.length == 3) {
                String readvendor = vendorpart[0];
                cbPickOrder.addItem(readvendor);
            }
        } 
    }
    
    private void avoidchangeshop(){
        cbPickOrder.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel cartmodel = (DefaultTableModel) TBLCart.getModel();
            if (cartmodel.getRowCount() > 0 && cbPickOrder.getSelectedItem() != null) {
                int userChoice = JOptionPane.showConfirmDialog(null,
                        "Changing the ComboBox value will remove all rows from the table. Do you want to proceed?",
                        "Confirmation", JOptionPane.YES_NO_OPTION);

                if (userChoice == JOptionPane.YES_OPTION) {
                    cartmodel.setRowCount(0); // Remove all rows from the table
                } 
            }
        }
    });
    }
   
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBOrderMethod;
    private javax.swing.JTable TBLCart;
    private javax.swing.JTable TBLMenu;
    private java.awt.Button btnAddToChart;
    private java.awt.Button btnBack;
    private java.awt.Button btnConfirmOrder;
    private javax.swing.JComboBox<String> cbPickOrder;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lbMenu;
    private javax.swing.JLabel lbSelectedlist1;
    private javax.swing.JLabel lbSelectedlist3;
    private javax.swing.JLabel lbSelectedlist4;
    private javax.swing.JLabel lbSelectedlist5;
    private javax.swing.JLabel lbSelectedorder;
    // End of variables declaration//GEN-END:variables
}
