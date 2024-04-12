import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class Notifications {
    JFrame frame = new JFrame("Notifications");
    JLabel notificationsLbl = new JLabel("Notifications");
    JButton backBtn = new JButton("Back");
    DefaultTableModel tableModel = new DefaultTableModel();
    JTable table = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(table);
    private Map<Integer, NotificationDetails> notificationDetailsMap = new HashMap<>();
    String user, type;

    Notifications(String user) {
        this.user = user;

        frame.setLayout(new BorderLayout());

        notificationsLbl.setFont(new Font("Arial", Font.BOLD, 20));
        notificationsLbl.setBorder(new EmptyBorder(10, 10, 10, 275));
        
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = notificationDetailsMap.get(notificationDetailsMap.size() - 1).getType();

            	if ("Order".equals(type)) {
            		new Customer_Homepage(user);
            		frame.dispose();
            	} else if ("Credit".equals(type)) {
            		new Customer_Homepage(user);
            		frame.dispose();
            	} else if ("Delivery".equals(type)) {
            		new DR_Menu(user);
            		frame.dispose();
            	} else if ("Vendor".equals(type)) {
            		new MainMenuVendorForm(user);
            		frame.dispose();
            	}   
            }
        });


        table.setRowHeight(40);
        table.setFont(new Font("Arial", Font.PLAIN, 15));
        table.setPreferredScrollableViewportSize(new Dimension(390, 300));
        table.setDefaultEditor(Object.class, null);
        table.setCellSelectionEnabled(true);

        LineBorder border = new LineBorder(Color.BLACK, 2);
        scrollPane.setBorder(border);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(notificationsLbl);
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(backBtn);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(525, 475);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        loadNotifications();
        detectDoubleClick();
    }

    private void detectDoubleClick() {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = table.getSelectedRow();

                    if (notificationDetailsMap.containsKey(selectedRow)) {
                        NotificationDetails details = notificationDetailsMap.get(selectedRow);
                        showNotification(details);
                    }
                }
            }
        });
    }

    private void showNotification(NotificationDetails details) {
        String notification = details.getNotificationContent();
        JOptionPane.showMessageDialog(frame, notification, details.getType(), 1, null);
    }

    private void loadNotifications() {
        tableModel.setColumnIdentifiers(new String[]{"Notifications"});
        notificationDetailsMap.clear();

        try (BufferedReader ordersReader = new BufferedReader(new FileReader("ordersNotifications.txt"));
             BufferedReader creditsReader = new BufferedReader(new FileReader("creditsNotifications.txt"));
                BufferedReader runnersReader = new BufferedReader(new FileReader("runnersNotifications.txt"));
        			BufferedReader vendorReader = new BufferedReader(new FileReader("vendorsNotifications.txt"))) {

            loadNotificationsFromFile(ordersReader, "Order");
            loadNotificationsFromFile(creditsReader, "Credit");
            loadNotificationsFromFile(runnersReader, "Delivery");
            loadNotificationsFromFile(vendorReader, "Vendor");

        } catch (IOException e) {
            e.printStackTrace();
        }

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    private void loadNotificationsFromFile(BufferedReader reader, String type) throws IOException {
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(":");

            if (parts.length == 6 && user.equals(parts[0].trim())) { //Customer order notifications
                String customer = parts[0].trim();
                String items = parts[1].trim();
                String price = parts[2].trim();
                String vendor = parts[3].trim();
                String total = parts[4].trim();
                String date = parts[5].trim();
                
                String notificationTitle = "\t Your order from " + vendor + " has been confirmed. | " + date;

                Vector<Object> row = new Vector<>();
                row.add(notificationTitle);
                tableModel.addRow(row);

                notificationDetailsMap.put(tableModel.getRowCount() - 1, new NotificationDetails(type, customer, items, price, vendor, total, date));
            } else if (parts.length == 3 && user.equals(parts[0].trim())) { //Credit notifications
                String user = parts[0].trim();
                String newCredits = parts[1].trim();
                String date = parts[2].trim();

                String notificationTitle = "\t Your credit balance has been updated successfully. | " + date;

                Vector<Object> row = new Vector<>();
                row.add(notificationTitle);
                tableModel.addRow(row);

                notificationDetailsMap.put(tableModel.getRowCount() - 1, new NotificationDetails(type, user, newCredits, date));
            } else if (parts.length == 4 && user.equals(parts[0].trim())){ //Runner status notifications
                String user = parts[0].trim();
                String orderid = parts[1].trim();
                String status = parts[2].trim();
                String date = parts[3].trim();
                
                String notificationTitle = "\t Delivery status of order " + orderid + " has been updated | " + date;

                Vector<Object> row = new Vector<>();
                row.add(notificationTitle);
                tableModel.addRow(row);

                notificationDetailsMap.put(tableModel.getRowCount() - 1, new NotificationDetails(type, user, orderid, status, date));
            } else if (parts.length == 5 && user.equals(parts[0].trim())) {
            	String user = parts[0].trim();
            	String details = parts[1].trim();
            	String choice = parts[2].trim();
            	String customer = parts[3].trim();
            	String date = parts[4].trim();
            	
            	String notificationTitle = "\t You received an order from " + customer + ".";
            	
            	Vector<Object> row = new Vector<>();
                row.add(notificationTitle);
                tableModel.addRow(row);

                notificationDetailsMap.put(tableModel.getRowCount() - 1, new NotificationDetails(type, user, details, choice, customer, date));
            }
            
        }
    }

    private static class NotificationDetails {
        private final String type;
        private final String customer;
        private final String items;
        private final String price;
        private final String vendor;
        private final String total;
        private final String newCredits;
        private final String orderid;
        private final String status;
        private final String date;
		private final String details;
		private final String choice;

        public NotificationDetails(String type, String customer, String items, String price, String vendor, String total, String date) {
            this.type = type;
            this.customer = customer;
            this.items = items;
            this.price = price;
            this.vendor = vendor;
            this.total = total;
            this.newCredits = null;
            this.orderid = null;
            this.status = null;
            this.date = date;
            this.details = null;
            this.choice = null;
        }

        public NotificationDetails(String type, String user, String newCredits, String date) {
            this.type = type;
            this.customer = user;
            this.items = null;
            this.price = null;
            this.vendor = null;
            this.total = null;
            this.newCredits = newCredits;
            this.orderid = null;
            this.status = null;
            this.date = date;
            this.details = null;
            this.choice = null;
        }
        
        public NotificationDetails(String type, String user, String orderid, String status, String date) {
            this.type = type;
            this.customer = user;
            this.items = null;
            this.price = null;
            this.vendor = null;
            this.total = null;
            this.newCredits = null;
            this.orderid = orderid;
            this.status = status;
            this.date = date;
            this.details = null;
            this.choice = null;
        }
        
        public NotificationDetails(String type, String user, String details, String choice, String customer, String date) {
            this.type = type;
            this.customer = user;
            this.items = null;
            this.price = null;
            this.vendor = null;
            this.total = null;
            this.newCredits = null;
            this.orderid = null;
            this.status = null;
            this.date = date;
            this.details = details;
            this.choice = choice;
        }
        

        public String getType() {
            return type;
        }

        public String getNotificationContent() {
            if ("Order".equals(type)) {
                return buildOrderNotificationContent();
            } else if ("Credit".equals(type)) {
                return buildCreditNotificationContent();
            } else if("Delivery".equals(type)){
                return buildDeliveryNotificationContent();
            } else if ("Vendor".equals(type)) {
            	return buildVendorNotificationContent();
            }
            return "";
        }

        private String buildOrderNotificationContent() {
            StringBuilder content = new StringBuilder("<html>");
            content.append("<div style='text-align: center; font-size: 25px; font-style: bold;'>").append(vendor).append("</div><br>");

            String[] itemsArray = items.split(",");
            String[] pricesArray = price.split(",");

            int maxItemLength = 0;
            for (String item : itemsArray) {
                maxItemLength = Math.max(maxItemLength, item.length());
            }

            for (int i = 0; i < itemsArray.length; i++) {
                String item = itemsArray[i];
                String itemPrice = (i < pricesArray.length) ? pricesArray[i] : "";

                int spacesCount = maxItemLength - item.length() + 3;

                content.append(item);
                for (int j = 0; j < spacesCount; j++) {
                    content.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                }
                content.append(itemPrice);
                content.append("<br>");
            }

            content.append("<br><div style='font-size: 10px; text-align: center'>Net total: ").append(total).append("</div></html>");
            return content.toString();
        }

        private String buildCreditNotificationContent() {
            return "<html>Your credit balance has been updated, you now have RM " + newCredits + ".</html>";
        }
        
        private String buildDeliveryNotificationContent(){
            return "<html>The delivery status is now "+ status + ".</html>";
        }
        
        private String buildVendorNotificationContent(){
            return "<html>Customer: " + customer + "\nOrder Detail: " + details + ".</html>";
        }
    }
}
