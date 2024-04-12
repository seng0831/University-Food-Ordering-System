import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class LoginView {
    private JFrame frame = new JFrame("Login");
    private JLabel nameLbl = new JLabel("University Food Ordering System");
    private JLabel loginLbl = new JLabel("Login");
    private JLabel usernameLbl = new JLabel("Username:");
    private JLabel passwordLbl = new JLabel("Password:");
    private JTextField usernameTxt = new JTextField();
    private JPasswordField passwordTxt = new JPasswordField();
    private JButton loginBtn = new JButton("Login");
    private JButton clearBtn = new JButton("Clear");

    public LoginView() {
        initializeView();
        addComponentsToView();
    }
    
    public void disposeFrame() {
    	frame.dispose();
    }

    private void initializeView() {
        frame.setSize(675, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    private void addComponentsToView() {
    	nameLbl.setBounds(0, 0, 675, 80);
    	nameLbl.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
    	nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
    	nameLbl.setBorder(new MatteBorder(0, 0, 3, 0, java.awt.Color.BLACK));
    	
    	loginLbl.setBounds(300, 90, 75, 25);
    	loginLbl.setFont(new Font("Arial", Font.PLAIN, 20));
    	
        usernameLbl.setBounds(150, 150, 100, 25);
        usernameLbl.setFont(new Font("Arial", Font.PLAIN, 20));

        passwordLbl.setBounds(150, 250, 100, 25);
        passwordLbl.setFont(new Font("Arial", Font.PLAIN, 20));

        usernameTxt.setBounds(150, 180, 350, 35);
        usernameTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        
        passwordTxt.setBounds(150, 280, 350, 35);
        passwordTxt.setFont(new Font("Arial", Font.PLAIN, 20));

        loginBtn.setBounds(210, 375, 120, 40);
        loginBtn.setFocusable(false);
        loginBtn.setFont(new Font("Arial", Font.BOLD, 20));

        clearBtn.setBounds(330, 375, 120, 40);
        clearBtn.setFocusable(false);
        clearBtn.setFont(new Font("Arial", Font.BOLD, 20));

        frame.add(nameLbl);
        frame.add(loginLbl);
        frame.add(usernameLbl);
        frame.add(passwordLbl);
        frame.add(usernameTxt);
        frame.add(passwordTxt);
        frame.add(loginBtn);
        frame.add(clearBtn);
    }

    public void setLoginButtonActionListener(ActionListener listener) {
        loginBtn.addActionListener(listener);
    }

    public void setClearButtonActionListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }

    public String getUsername() {
        return usernameTxt.getText();
    }

    public String getPassword() {
        char[] passwordChar = passwordTxt.getPassword();
        return new String(passwordChar);
    }

    public void clearFields() {
        usernameTxt.setText("");
        passwordTxt.setText("");
    }

    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public void showView() {
        frame.setVisible(true);
    }
}
