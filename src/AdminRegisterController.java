import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdminRegisterController implements ActionListener {
    private AdminRegisterView view;
    File newFile;
    String user;

    public AdminRegisterController(AdminRegisterView view, String user) {
        this.view = view;
        this.user = user;
        view.addRegisterListener(this);
        view.addBackListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getRegisterBtn()) {
            handleRegistration();
        } else if (e.getSource() == view.getBackBtn()) {
            navigateBack();
        }
    }

    private void handleRegistration() {
        String username = view.getNameTxt().getText();
        char[] passwordChars = view.getPasswordTxt().getPassword();
        char[] confirmChars = view.getConfirmTxt().getPassword();
        String password = new String(passwordChars);
        String confirm = new String(confirmChars);
        String credits = view.getCreditTxt().getText();

        if (username.isEmpty() || password.isEmpty() || confirm.isEmpty() || credits.isEmpty()) {
            JOptionPane.showMessageDialog(view.getFrame(), "Please fill in all the fields.");
        } else if (!password.equals(confirm)) {
            JOptionPane.showMessageDialog(view.getFrame(), "Passwords do not match, try again.");
        } else {
            String selectedRole = view.getRoleCb().getSelectedItem() != null ? view.getRoleCb().getSelectedItem().toString() : null;

            if (selectedRole != null) {
                String filename = selectedRole.toLowerCase() + ".txt";
                
                if (userExists(filename, username))
                {
                	JOptionPane.showMessageDialog(view.getFrame(), "This user already exists, please choose a different username.");
                	view.getNameTxt().setText(null);
                }
                else
                {
	                String credentials = username + ":" + password + ":" + credits;
	
	                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
	                    writer.newLine();
	                    writer.write(credentials);

	                    view.getNameTxt().setText(null);
	                    view.getPasswordTxt().setText(null);
	                    view.getConfirmTxt().setText(null);
	                    view.getCreditTxt().setText(null);

	                    JOptionPane.showMessageDialog(view.getFrame(), "Account created successfully.");
	                    
	                    if ("Vendor".equalsIgnoreCase(selectedRole))
	                    {
	                    	newFile = new File("Menu" + username + ".txt");
	                    	newFile.createNewFile();
	                    	newFile = new File("Order" + username + ".txt");
	                    	newFile.createNewFile();
	                    	newFile = new File("Revenue" + username + ".txt");
	                    	newFile.createNewFile();
	                    }
	                    else if ("Runner".equalsIgnoreCase(selectedRole))
	                    {
	                    	newFile = new File(username + ".txt");
	                    	newFile.createNewFile();
	                    }
	                    
	                } catch (IOException e1) {
	                    e1.printStackTrace();
	                    JOptionPane.showMessageDialog(view.getFrame(), "Unable to create account, please try again.");
	                }
                }
            }
        }
    }

    private boolean userExists(String filename, String username) {
    	try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
    	{
    		String line;
    		
    		while ((line = reader.readLine()) != null)
    		{
    			String[] parts = line.split(":");
    			
    			if (parts.length > 0 && parts[0].trim().equals(username))
    			{
    				return true;
    			}
    		}
    		
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return false;
	}

	private void navigateBack() {
        new Admin(user);
        view.getFrame().dispose();
    }
}
