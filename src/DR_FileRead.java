
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;
public class DR_FileRead implements DR_FileReading{
    String filepath;
    private DefaultTableModel model = new DefaultTableModel();
    private double totalincome;
    private int rowcount = model.getRowCount();

    public DR_FileRead(String filepath){
        this.filepath = filepath;
    }
       public String getFilepath() {
        return filepath;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public double getTotalincome() {
        return totalincome;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public void setTotalincome(double totalincome) {
        this.totalincome = totalincome;
    }
        
    public DefaultTableModel ReadReview(){
            String orderID;
            String date;
            String income;
            String status;
            String review;
            double total = 0;
            String[] columnName = {"Order ID","Date","Review"};
            model.setColumnIdentifiers(columnName);
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            model.setRowCount(0);
            while ((line = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line);
                orderID = tokens.nextToken();
                date = tokens.nextToken();
                income = tokens.nextToken();
                status = tokens.nextToken();
                review = tokens.nextToken();
                String[] values = {orderID, date, review};
                model.addRow(values);
            }
            br.close();
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel ReadFile(){
            String orderID;
            String date;
            String income;
            String status;
            double total = 0;
            String[] columnName = {"Order ID","Date","Status"};
            model.setColumnIdentifiers(columnName);
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            model.setRowCount(0);
            while ((line = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line);
                orderID = tokens.nextToken();
                date = tokens.nextToken();
                income = tokens.nextToken();
                status = tokens.nextToken();
                String[] values = {orderID, date, status};
                model.addRow(values);
            }
            br.close();
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return model;
    }
    
    public DefaultTableModel ReadFile(String year, String month){
        String orderID;
        String date;
        String income;
        double total = 0;
        String[] columnName = {"Order ID","Date","Income"};
        model.setColumnIdentifiers(columnName);
        model.setRowCount(0);
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line);
                orderID = tokens.nextToken();
                date = tokens.nextToken();
                income = tokens.nextToken();
                String[] values = {orderID, date, income};
                if(year.equals("All")){
                    if(month.equals("All")){
                        model.addRow(values);
                        total += Double.parseDouble(income);
                    }
                    else if(date.contains(month)){
                        model.addRow(values);
                        total += Double.parseDouble(income);
                    }
                }
                else{
                    if(date.contains(year)){
                        if(month.equals("All")){
                            model.addRow(values);
                            total += Double.parseDouble(income);
                        }
                        else if(date.contains(month)){
                            model.addRow(values);
                            total += Double.parseDouble(income);
                        }
                    }
                }
                this.totalincome = total;
            }
            br.close();
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return model;
    }

    public double TodayIncome(){
        String orderID;
        String date;
        String income;
        CurrentDate currentdate = new CurrentDate();
        String todaydate = currentdate.getdate();
        double total = 0;
        String[] columnName = {"Order ID","Date","Income"};
        model.setColumnIdentifiers(columnName);
        
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line);
                orderID = tokens.nextToken();
                date = tokens.nextToken();
                income = tokens.nextToken();
                String[] values = {orderID, date, income};
                if(date.equals(todaydate)){
                    total += Double.parseDouble(income);
                }
            }
            br.close();
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return total;
    }

 
    
    
}
