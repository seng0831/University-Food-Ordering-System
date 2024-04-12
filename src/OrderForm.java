
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class OrderForm extends javax.swing.JFrame {
    private DefaultTableModel model = new DefaultTableModel();

    private String[] columName = {"Customer ID","Date","Order ID","Order Detail","Prices"};

    private int row = -1;

    private String customerid;
    private String date;
    private String orderid;
    //private String vendorname;
    private String orderdetail;
    private String required_service;
    private String delivery_fee;
    private String totalprice;
    private String status;
    private String submit;
    
    private String customerid1;
    private String date1;
    private String orderid1;
    //private String vendorname1;
    private String orderdetail1;
    private String required_service1;
    private String delivery_fee1;
    private String totalprice1;
    private String status1;
    private String submit1;
    
    ArrayList<String> rowDataList = new ArrayList<>();
    ArrayList<String> rowDataList2 = new ArrayList<>();
    
    
    private String vendorname;
    private String filepath;
    private String filepath2;
    private String writecontent;
    private String writecontent2;
    private String oid;
    
    
    
    String[] values = {customerid,date,orderid,vendorname,orderdetail,required_service,delivery_fee,totalprice,status,submit};

    public OrderForm() {
        initComponents();
        model.setColumnIdentifiers(columName);
        insertData();
    }
    public OrderForm(String vendorname) {
        setVisible(true);
        setTitle("Order");
        this.vendorname = vendorname;
        initComponents();
        filepath = "Order" + vendorname + ".txt";
        filepath2 = "TaskAvailable.txt";
        model.setColumnIdentifiers(columName);
        insertData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableOrder = new javax.swing.JTable();
        baccept = new javax.swing.JButton();
        bdecline = new javax.swing.JButton();
        tfdetail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        breturn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableOrder.setModel(model);
        TableOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TableOrderMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TableOrder);

        baccept.setText("Accept");
        baccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bacceptActionPerformed(evt);
            }
        });

        bdecline.setText("Decline");
        bdecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeclineActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Select the Row to View the Order Detail");

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
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(breturn, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfdetail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(baccept, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bdecline, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(breturn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(baccept)
                    .addComponent(bdecline)
                .addGap(14, 14, 14)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bacceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bacceptActionPerformed

        if(row == -1){
            JOptionPane.showMessageDialog(null,"Please select a row");
        }
        else{
            WriteTask();

        model.removeRow(row);
        }
    }//GEN-LAST:event_bacceptActionPerformed

    private void bdeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeclineActionPerformed
        // TODO add your handling code here:
        if(row == -1){
            JOptionPane.showMessageDialog(null,"Please select a row");
        }
        else{
        model.removeRow(row);
        }
    }//GEN-LAST:event_bdeclineActionPerformed

    private void TableOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableOrderMouseReleased
        // TODO add your handling code here:
        
        row = TableOrder.getSelectedRow();
        orderdetail = String.valueOf(model.getValueAt(row, 3));
        tfdetail.setText(orderdetail);
        
        
        customerid = String.valueOf(model.getValueAt(row, 0));
        date = String.valueOf(model.getValueAt(row, 1));
        orderid = String.valueOf(model.getValueAt(row, 2));

        required_service = String.valueOf(model.getValueAt(row, 4));
        customerid = String.valueOf(model.getValueAt(row, 5));
        
        
    }//GEN-LAST:event_TableOrderMouseReleased

    private void breturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breturnActionPerformed
        MainMenuVendorForm vf = new MainMenuVendorForm(vendorname);
        vf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_breturnActionPerformed




    private ArrayList<String> insertData(){
        
    String[] values = {customerid,date,orderid,vendorname,orderdetail,required_service,delivery_fee,totalprice,status,submit};
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }    

        try {
        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        //System.out.println("readfile");
        while ((line = br.readLine()) != null) {
            String[] split_line = line.split(":");

            String customerid = split_line[0];
            String date = split_line[1];
            String orderid = split_line[2];
            String vendor_name = split_line[3];
            String orderdetail = split_line[4];
            String require_service = split_line[5];
            String delivery_fee = split_line[6];
            String totalprice = split_line[7];
            String status = String.valueOf(split_line[8]);
            
            //new added 
            
            rowDataList2.add(customerid);//0
            rowDataList2.add(date);//1
            rowDataList2.add(orderid);//2
            rowDataList2.add(vendor_name);//3
            rowDataList2.add(orderdetail);//4
            rowDataList2.add(require_service);//5
            rowDataList2.add(delivery_fee);//6
            rowDataList2.add(totalprice);//7
            rowDataList2.add(status);//8
            
            /*
            System.out.println("status:"+status);
            System.out.println("vendor_name"+vendor_name);
            System.out.println("vendorname"+vendorname);
            */
            
            if(vendor_name.equals(vendorname) && status.equals("DELIVERED")){
                rowDataList.add(customerid);//0
                rowDataList.add(date);//1
                rowDataList.add(orderid);//2
                rowDataList.add(vendor_name);//3
                rowDataList.add(orderdetail);//4
                rowDataList.add(require_service);//5
                rowDataList.add(delivery_fee);//6
                rowDataList.add(totalprice);//7
                rowDataList.add(status);//8
            }        
        }
                for (int i = 0; i < rowDataList.size(); i = i + 9) {
                    Object[] row = {rowDataList.get(i), rowDataList.get(i + 1),rowDataList.get(i + 2),rowDataList.get(i + 4),rowDataList.get(i + 7)};
                    model.addRow(row);
                }
                br.close();
    } catch (IOException e) {
        System.err.println("An error occurred while reading the file: " + e.getMessage());
    }
        //this is a marker
        return rowDataList;
    }
    
    
    private void WriteOrder(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            String a = String.valueOf(rowDataList.size());
            System.out.println("rowdatalist.size = "+ a);
            for (int i = 0; 2*i < rowDataList2.size(); i = i + 9) {
                customerid = rowDataList2.get(0);
                date = rowDataList2.get(1);
                orderid = rowDataList2.get(2);
                vendorname = rowDataList2.get(3);
                orderdetail = rowDataList2.get(4);
                required_service = rowDataList2.get(5);
                delivery_fee = rowDataList2.get(6);
                totalprice = rowDataList2.get(7);
                status = rowDataList2.get(8);

                if(!orderid.equals(oid)){

                writecontent2 = customerid + ":" + date + ":" + orderid +":"+ vendorname+":"+ orderdetail+":"+required_service+":"+delivery_fee+":"+totalprice+":"+"PENDING";
                }
                else{
                    System.out.println("Please Select a row");
                }
                System.out.println(writecontent);
                writer.write(writecontent);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        System.out.println("Approved");
    }
    
    //for accepted order
    private void WriteTask(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath2))) {
            String a = String.valueOf(rowDataList.size());
            System.out.println("rowdatalist.size = "+ a);
            for (int i = 0; 2*i < rowDataList.size(); i = i + 9) {
                if(row != -1){
                writecontent = customerid + ":" + date + ":" + ":" + orderid +":"+vendorname+":"+ orderdetail+":"+required_service+":"+"2.00"+":"+"24.00"+";"+"ASSIGNED:Runner1";
                }
                else{
                    System.out.println("Please Select a row");
                }

            }
                System.out.println(writecontent);
                writer.write(writecontent);
                writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        System.out.println("Table written to Menu.txt");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableOrder;
    private javax.swing.JButton baccept;
    private javax.swing.JButton bdecline;
    private javax.swing.JButton breturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfdetail;
    // End of variables declaration//GEN-END:variables
}
