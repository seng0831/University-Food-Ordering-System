import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Details implements ActionListener, TableModelListener {
	JFrame frame = new JFrame("User Details");
	String roles[] = {"Vendor","Customer","Runner"};
	JComboBox<String> roleCb = new JComboBox<>(roles);
	DefaultTableModel tableModel = new DefaultTableModel();	
	JTable table = new JTable(tableModel);
	JScrollPane scrollPane = new JScrollPane(table);
	JButton loadBtn = new JButton("Load");
	JButton deleteBtn = new JButton("Delete");
	JButton saveBtn = new JButton("Save");
	JButton backBtn = new JButton("Back");
	Vector<Vector<Object>> creditHistory = new Vector<>();
	String user;

	Details(String user) {
		this.user = user;
		
		roleCb.setBounds(20,25,150,30);
		roleCb.setFont(new Font("Arial", Font.PLAIN, 20));
		roleCb.addActionListener(this);
		
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		
		scrollPane.setBounds(20,100,620,300);
		
		loadBtn.setBounds(240,25,100,30);
		loadBtn.setFocusable(false);
		loadBtn.addActionListener(this);		
		
		deleteBtn.setBounds(340,25,100,30);
		deleteBtn.setFocusable(false);
		deleteBtn.addActionListener(this);
		
		saveBtn.setBounds(240,410,100,30);
		saveBtn.setFocusable(false);
		saveBtn.addActionListener(this);
		
		backBtn.setBounds(340,410,100,30);
		backBtn.setFocusable(false);
		backBtn.addActionListener(this);
		
		tableModel.addTableModelListener(this);
		
		frame.add(roleCb);
		frame.add(scrollPane);
		frame.add(loadBtn);		
		frame.add(deleteBtn);
		frame.add(saveBtn);
		frame.add(backBtn);

		frame.setSize(675,500);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
	}

	@Override	
	public void actionPerformed(ActionEvent e) {
		String selectedRole = (String) roleCb.getSelectedItem();
		
		if (e.getSource() == loadBtn)
		{
			generateTable(selectedRole);
		}	
		
		if (e.getSource() == deleteBtn)
		{
			deleteSelectedUser();
		}
		
		if (e.getSource() == saveBtn)
		{
			saveData();
		}
			
		if (e.getSource() == backBtn)
		{
			new Admin(user);
			frame.dispose();
		}
	}

	private void deleteSelectedUser() {
		int selectedRow = table.getSelectedRow();
		
		if (selectedRow >= 0)
		{
			int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete the selected row?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION)
			{
				tableModel.removeRow(selectedRow);
				saveData();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(frame, "Please select a row to be deleted.");
		}		
	}

	private void generateTable(String role) {
	    tableModel.setRowCount(0);
		tableModel.setColumnIdentifiers(new String[] {"Username","Password","Credit Balance"});

	    String fileName = role + ".txt";
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	    	
	        String line;
	        
	        while ((line = br.readLine()) != null) {
	            String[] parts = line.split(":");
	            
	            if (parts.length == 3) {
	                String username = parts[0].trim();
	                String password = parts[1].trim();
	                String credits = parts[2].trim();

	                Vector<Object> row = new Vector<>();
	                row.add(username);
	                row.add(password);
	                row.add(credits);
	                tableModel.addRow(row);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    JTableHeader header = table.getTableHeader();
	    header.setFont(new Font("Arial", Font.PLAIN, 20));
	}
	
	private void saveData() {
	    String selectedRole = (String) roleCb.getSelectedItem();
	    String filename = selectedRole + ".txt";

	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
	    	
	        for (int row = 0; row < tableModel.getRowCount(); row++) {
	        	
	            String username = (String) tableModel.getValueAt(row, 0);
	            String password = (String) tableModel.getValueAt(row, 1);
	            String credits = (String) tableModel.getValueAt(row, 2);

	            if (username.isEmpty() || password.isEmpty() || credits.isEmpty())
	            {
	            	JOptionPane.showMessageDialog(frame, "Please fill in all the details.");
	            }
	            
	            else if (isDouble(credits))
	            {
		            bw.write(username + ":" + password + ":" + credits);
		            bw.newLine();	            	
	            }
	            
	            else
	            {
	            	JOptionPane.showMessageDialog(frame, "Invalid credit value.");
	            }

	        }
	        bw.close();
	        
	        updateCredits();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	private void updateCredits() {
		CurrentDate date = new CurrentDate();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("creditsNotifications.txt", true)))
		{
			for (Vector<Object> creditUpdate : creditHistory)
			{
				String username = (String) creditUpdate.get(0);
				String newCredit = (String) creditUpdate.get(1);
				
				bw.write(username+ ":" + newCredit + ":" + date.getdate());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isDouble(String value) {
		try
		{
			Double.parseDouble(value);
			return true;
		}
		
		catch (NumberFormatException e)
		{
			return false;	
		}
		
	}

	public void tableChanged(TableModelEvent e) {
	    if (e.getType() == TableModelEvent.UPDATE) {
	        int row = e.getFirstRow();
	        int column = e.getColumn();

	        if (row >= 0 && column == 2) {
	            String username = (String) tableModel.getValueAt(row, 0);
	            String newCredit = (String) tableModel.getValueAt(row, 2);

	            creditHistory.add(new Vector<>(List.of(username, newCredit)));
	        }
	    }
	}
}