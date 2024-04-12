import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class Admin implements ActionListener {
    private JFrame frame;
    private JLabel welcomeLbl;
    private JButton registerBtn;
    private JButton detailsBtn;
    private JButton logoutBtn;
	private String user;

    public Admin(String user) {
    	this.user = user;
        initializeComponents();
        configureLayout();
    }

    private void initializeComponents() {
        frame = new JFrame("Admin");
        welcomeLbl = new JLabel("Welcome, " + user);
        welcomeLbl.setBounds(215, 20, 300, 35);
        welcomeLbl.setFont(new Font("Segoe UI", Font.BOLD, 28));

        registerBtn = new JButton("Register New User");
        registerBtn.setBounds(80, 100, 500, 40);
        registerBtn.setFocusable(false);
        registerBtn.addActionListener(this);

        detailsBtn = new JButton("Update Details");
        detailsBtn.setBounds(80, 150, 500, 40);
        detailsBtn.setFocusable(false);
        detailsBtn.addActionListener(this);

        logoutBtn = new JButton("Log Out");
        logoutBtn.setBounds(80, 200, 500, 40);
        logoutBtn.setFocusable(false);
        logoutBtn.addActionListener(this);
        logoutBtn.setForeground(Color.RED);
    }

    private void configureLayout() {
        frame.setLayout(null);
        frame.add(welcomeLbl);
        frame.add(registerBtn);
        frame.add(detailsBtn);
        frame.add(logoutBtn);

        frame.setSize(675, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logoutBtn) {
            handleLogout();
        } else if (e.getSource() == registerBtn) {
            handleRegister();
        } else if (e.getSource() == detailsBtn) {
            handleDetails();
        }
    }

    private void handleLogout() {
        int confirmLogout = JOptionPane.showConfirmDialog(frame, "Are you sure you want to log out?", "Log Out",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmLogout == JOptionPane.YES_OPTION) {
            LoginView view = new LoginView();
            LoginController controller = new LoginController(view);
            controller.startApplication();
            frame.dispose();
        }
    }

    private void handleRegister() {
    	AdminRegisterView view = new AdminRegisterView();
    	new AdminRegisterController(view, user);
    	frame.dispose();
    }

    private void handleDetails() {
        new Details(user);
        frame.dispose();
    }
}
