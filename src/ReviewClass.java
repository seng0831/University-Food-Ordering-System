/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wongx
 */
public class ReviewClass {
    private DefaultTableModel model = new DefaultTableModel();
    private String[] columName = {"Date","Order ID","Comments"};
    
    private String date;
    private String orderid;
    private String vendorname;
    private String comments;
    
    private String filepath = "OrderReview.txt";
    public ReviewClass(String vendorname){
        this.vendorname = vendorname;
        insertData();
    }
    
  
    private void insertData(){
    String[] values = {date, orderid, vendorname, comments};
    try {
        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] split_line = line.split(":");
            for (int i = 3; i < split_line.length; i = i + 3) {
                
                //System.out.println("splitline1: " + split_line[i]);
                //System.out.println("vendorname: " + vendorname);

                if (split_line[i].equals(vendorname)) {
                    //System.out.println("splitline2"+split_line[i].trim());
                    values[i] = split_line[i].trim();
                    model.addRow(split_line);    

                    //System.out.println("yes");
                }


                //System.out.println("values[i]: " + values[i]);
                
            }
        }
        br.close();
    } catch (IOException e) {
        System.err.println("An error occurred while reading the file: " + e.getMessage());
    }
    }
    private void clearTable() {
        // Clear all rows from the table model
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }
}
