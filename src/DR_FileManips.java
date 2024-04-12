
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class DR_FileManips extends DR_FileRead implements DR_Operation{
    private String filepath2;
    private String filepath3;
    private String filepath4;
    public DR_FileManips(String filepath, String filepath2, String filepath3, String filepath4){
        super(filepath);
        this.filepath2 = filepath2;
        this.filepath3 = filepath3;
        this.filepath4 = filepath4;
    }
    public String[] Read(String userid){
        String[] split = null;
        String[] split2 = null;
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                split = line.split(",");
                split2 = line.split(":");
                if(split2[9].equals(userid)){
                    return split;
                }
            }
            
            br.close();
            fr.close();
        }catch(IOException e){
                e.printStackTrace();
        }
        return null;
    }
    
    public void Add(String userid){
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line, orderid = null;
            String newongoing = null;
            StringBuilder original = new StringBuilder();
            while((line = br.readLine())!=null){
                String[] split = line.split(":");
                if(userid.equals(split[9].trim())){
                    String replacedline = line.replaceAll("ASSIGNED", "PREPARING");
                    orderid = split[2].trim();
                    newongoing = replacedline;
                }
                else{
                    original.append(line).append("\n");
                }

            }
            StringBuilder original2 = new StringBuilder();
            FileReader fr2 = new FileReader(filepath4);
            BufferedReader br2 = new BufferedReader(fr2);
            String line2;
            String[] split2;
            split2 = null;
            while((line2 = br2.readLine()) != null){
                split2 = line2.split(":");
                if(split2[2].equals(orderid)){
                    String replaced = line2.replace("ASSIGNED", "PREPARING");
                    original2.append(replaced).append("\n");
                }
                else{
                    original2.append(line2).append("\n");
                }  
            }
            FileWriter fw = new FileWriter(filepath2);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(newongoing);
            bw.close();
            fw.close();
            FileWriter fw2 = new FileWriter(filepath);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            bw2.flush();
            bw2.write(original.toString());
            bw2.close();
            fw2.close();
            FileWriter fw3 = new FileWriter(filepath4);
            BufferedWriter bw3 = new BufferedWriter(fw3);
            bw3.flush();
            bw3.write(original2.toString());
            bw3.close();
            fw3.close();
            br.close();
            fr.close();
            br2.close();
            fr2.close();
            ModifyNotification(orderid, filepath3, "Accept");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void ModifyNotification(String orderid, String filepath, String status){
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder original = new StringBuilder();
            String line;
            int x = 1;
            while((line = br.readLine()) != null){
                String split[] = line.split(":");
                
                if(status.equals("Accept")){
                    if(split[1].equals(orderid)){
                        if(split[2].equals("Available")){
                            String replaced = line.replace("Available", "Accepted");
                            original.append(replaced).append("\n");
                            original.append(line).append("\n");
                        }
                    }
                    else{
                        original.append(line).append("\n");
                    }
                }
                else if(status.equals("OTW")){
                    if(split[1].equals(orderid)){
                        if(split[2].equals("Accepted")){
                            String replaced = line.replace("Accepted", "OTW");
                            original.append(replaced).append("\n");
                            original.append(line).append("\n");
                        }
                        else{
                            original.append(line).append("\n");
                        } 
                    }
                    else{
                        original.append(line).append("\n");
                    }
                }
                else if(status.equals("Delivered")){
                    if(split[1].equals(orderid)){
                        if(split[2].equals("OTW")){
                            String replaced = line.replace("OTW", "Delivered");
                            original.append(replaced).append("\n");
                            original.append(line).append("\n");
                        }
                        else{
                            original.append(line).append("\n");
                        }
                    }
                    else{
                        original.append(line).append("\n");
                    }
                }
                else{
                    original.append(line).append("\n");
                }
                
            }
            br.close();
            fr.close();
            FileWriter fw = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.flush();
            bw.write(original.toString());
            bw.close();
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void Modify(String status, String orderid){
        try{
            String replace = null;
            if(status.equals("OTW")){
                replace = "PREPARING";
            }
            else if(status.equals("DELIVERED")){
                replace = "OTW";
            }
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder original = new StringBuilder();
            
            String line;
            while((line=br.readLine()) != null){
                String[] split = line.split(":");
                String id = split[2];
                if(id.equals(orderid)){
                    String replaced = line.replace(replace, status);
                    original.append(replaced).append("\n");
                }
                else{
                    original.append(line).append("\n");
                }  
            }
                FileReader fr2 = new FileReader(filepath4);
                BufferedReader br2 = new BufferedReader(fr2);
                String line2;
                String[] split2;
                StringBuilder original2 = new StringBuilder();
                while((line2 = br2.readLine()) != null){
                    split2 = line2.split(":");
                    String id = split2[2];
                    if(id.equals(orderid)){
                        String replaced = line2.replace(replace, status);
                        original2.append(replaced).append("\n");
                    }
                    else{
                        original2.append(line2).append("\n");
                    }  
                }
                FileWriter fw = new FileWriter(filepath);
                BufferedWriter bw = new BufferedWriter(fw);
                FileWriter fw2 = new FileWriter(filepath4);
                BufferedWriter bw2 = new BufferedWriter(fw2);
                bw.flush();
                bw2.flush();
                bw.write(original.toString());
                bw2.write(original2.toString());
                br2.close();
                fr2.close();
                bw.close();
                bw2.close();
                fw2.close();
                fw.close();
                br.close();
                fr.close();
                JOptionPane.showMessageDialog(null, "Delivery status updated to " + status + "!", "Status", JOptionPane.INFORMATION_MESSAGE);
        }catch(IOException e){
                e.printStackTrace();
        }
    }
    
    
    
    
    
    public void Delete(){
        try{
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            FileWriter fw = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.flush();
            bw.close();
            fw.close();
            br.close();
            fr.close();
            String[] split = line.split(":");
            
            String orderid = split[2].trim();
            String date = split[1].trim();
            String income = "2";
            String status = split[8].trim();
            String output = orderid + " " + date + " " + income + " " + status + " " + "null";
            
            StringBuilder original = new StringBuilder();
            String read;
            
            FileReader fr2 = new FileReader(filepath2);
            BufferedReader br2 = new BufferedReader(fr2);
            
            while((read = br2.readLine()) !=null){
                original.append("\n").append(read);
            }
            br2.close();
            fr2.close();
            
            original.insert(0, output);
            
            FileWriter fw2 = new FileWriter(filepath2);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            bw2.flush();
            bw2.write(original.toString());
            bw2.close();
            fw2.close();
            OrderHistory(line);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void OrderHistory(String newline){
        try{
            String line;
            StringBuilder original = new StringBuilder();
            
            FileReader fr = new FileReader(filepath3);
            BufferedReader br = new BufferedReader(fr);
            
            while((line = br.readLine()) !=null){
                original.append(line).append("\n");
            }
            br.close();
            fr.close();
            newline = newline.replace("DELIVERED", "DELIVERED:NO");
            
            original.append(newline).append("\n");
            
            FileWriter fw = new FileWriter(filepath3);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(original.toString());
            bw.close();
            fw.close();
            br.close();
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void Reject(String userid, String orderid){
        try{
            String availablerunner = null;
            StringBuilder original = new StringBuilder();
            FileReader fr = new FileReader(filepath2);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                StringTokenizer tokens = new StringTokenizer(line);
                String id = tokens.nextToken();
                String status = tokens.nextToken();
                if(status.equals("Busy")){
                    if(id.equals(userid)){
                        String replace = line.replace("Busy", "Available");
                        original.append(replace).append("\n");
                    }
                    else{
                        original.append(line).append("\n");
                        continue;
                    }
                }
                else if(status.equals("Available")){
                    if(availablerunner == null){
                        String newline = line.replace("Available", "Busy");
                        original.append(newline).append("\n");
                        availablerunner = id;
                    }
                    else{
                        original.append(line).append("\n");
                    }
                }
            }
            FileWriter fw = new FileWriter(filepath2);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.flush();
            bw.write(original.toString());
            bw.close();
            fw.close();
            br.close();
            fr.close();
            
            StringBuilder original2 = new StringBuilder();
            FileReader fr2 = new FileReader(filepath);
            BufferedReader br2 = new BufferedReader(fr2);
            String[] split = null;
            while((line = br2.readLine()) != null){
                split = line.split(":");
                if(split[2].equals(orderid)){         
                    if(availablerunner != null){
                        String replace = line.replace(userid, availablerunner);
                        original2.append(replace).append("\n");
                        ModifyStatus(orderid, userid, availablerunner);
                    }
                    else{
                        ModifyStatus(orderid, userid, availablerunner);
                    }
                }
                else{
                    original2.append(line).append("\n");
                }

            }
            
            FileWriter fw2 = new FileWriter(filepath);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            bw2.flush();
            bw2.write(original2.toString());
            bw2.close();
            fw2.close();
            
            br2.close();
            fr2.close();
            
            StringBuilder ori = new StringBuilder();
            FileReader fr3 = new FileReader(filepath4);
            BufferedReader br3 = new BufferedReader(fr3);
            String line2;
            String[] split2 = null;
            while((line2 = br3.readLine()) != null){
                split2 = line2.split(":");
                if(availablerunner!=null){
                    if(split2[1].equals(orderid)){
                        String replace = line2.replace(userid, availablerunner);
                        ori.append(replace).append("\n");
                    }
                    else{
                        ori.append(line2).append("\n");
                    }
                }
            }
            br3.close();
            fr3.close();
            FileWriter fw3 = new FileWriter(filepath4);
            BufferedWriter bw3 = new BufferedWriter(fw3);
            bw3.flush();
            bw3.write(ori.toString());
            bw3.close();
            fw3.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void ModifyStatus(String orderid, String userid, String runner){
        try{
            StringBuilder original = new StringBuilder();
            FileReader fr = new FileReader(filepath3);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String[] split;
            while((line = br.readLine())!= null){
                split = line.split(":");
                if(split[2].equals(orderid)){
                    if(runner == null){
                        String replace = line.replace("ASSIGNED", "UNAVAILABLE");
                        String replace2 = replace.replace(userid, "NONE");
                        String newline = replace2;
                        original.append(newline).append("\n");
                    }
                    else{
                        String replace = line.replace(userid, runner);
                        String newline = replace;
                        original.append(newline).append("\n");
                    }
                }
                else{
                    original.append(line).append("\n");
                }
            }
            br.close();
            fr.close();
            FileWriter fw = new FileWriter(filepath3);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.flush();
            bw.write(original.toString());
            bw.close();
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}