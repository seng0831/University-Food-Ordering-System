import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminRegisterView {
    private JFrame frame;
    private JLabel registerLbl;
    private JLabel nameLbl;
    private JLabel passwordLbl;
    private JLabel confirmLbl;
    private JLabel roleLbl;
    private JLabel creditLbl;
    private JTextField nameTxt;
    private JTextField creditTxt;
    private JPasswordField passwordTxt;
    private JPasswordField confirmTxt;
    private String roles[] = {"Vendor", "Customer", "Runner"};
    private JComboBox<String> roleCb;
    private JButton registerBtn;
    private JButton backBtn;

    public AdminRegisterView() {
        initializeComponents();
        configureLayout();
    }

    private void initializeComponents() {
        frame = new JFrame("Register");

        registerLbl = new JLabel("User Registration");
        registerLbl.setBounds(50, 20, 300, 35);
        registerLbl.setFont(new Font("Arial", Font.BOLD, 30));

        nameLbl = new JLabel("Username:");
        nameLbl.setBounds(50, 100, 100, 20);
        nameLbl.setFont(new Font("Arial", Font.PLAIN, 20));

        passwordLbl = new JLabel("Password:");
        passwordLbl.setBounds(50, 200, 100, 20);
        passwordLbl.setFont(new Font("Arial", Font.PLAIN, 20));

        confirmLbl = new JLabel("Confirm password:");
        confirmLbl.setBounds(50, 300, 200, 20);
        confirmLbl.setFont(new Font("Arial", Font.PLAIN, 20));

        creditLbl = new JLabel("Credits:");
        creditLbl.setBounds(400, 100, 200, 20);
        creditLbl.setFont(new Font("Arial", Font.PLAIN, 20));

        roleLbl = new JLabel("Select role:");
        roleLbl.setBounds(400, 200, 200, 20);
        roleLbl.setFont(new Font("Arial", Font.PLAIN, 20));

        roleCb = new JComboBox<>(roles);
        roleCb.setBounds(400, 230, 150, 30);
        roleCb.setFont(new Font("Arial", Font.PLAIN, 20));

        nameTxt = new JTextField();
        nameTxt.setBounds(50, 130, 250, 30);

        passwordTxt = new JPasswordField();
        passwordTxt.setBounds(50, 230, 250, 30);

        confirmTxt = new JPasswordField();
        confirmTxt.setBounds(50, 330, 250, 30);

        creditTxt = new JTextField();
        creditTxt.setBounds(400, 130, 75, 30);

        registerBtn = new JButton("Register");
        registerBtn.setBounds(380, 300, 100, 50);
        registerBtn.setFocusable(false);

        backBtn = new JButton("Back");
        backBtn.setBounds(480, 300, 100, 50);
        backBtn.setFocusable(false);
    }

    private void configureLayout() {
        frame.setLayout(null);
        frame.add(registerLbl);
        frame.add(nameLbl);
        frame.add(passwordLbl);
        frame.add(confirmLbl);
        frame.add(roleLbl);
        frame.add(creditLbl);
        frame.add(nameTxt);
        frame.add(passwordTxt);
        frame.add(confirmTxt);
        frame.add(creditTxt);
        frame.add(roleCb);
        frame.add(registerBtn);
        frame.add(backBtn);

        frame.setSize(675, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void addRegisterListener(ActionListener listener) {
        registerBtn.addActionListener(listener);
    }

    public void addBackListener(ActionListener listener) {
        backBtn.addActionListener(listener);
    }

    public JButton getRegisterBtn() {
        return registerBtn;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public JTextField getNameTxt() {
        return nameTxt;
    }

    public JTextField getCreditTxt() {
        return creditTxt;
    }

    public JPasswordField getPasswordTxt() {
        return passwordTxt;
    }

    public JPasswordField getConfirmTxt() {
        return confirmTxt;
    }

    public JComboBox<String> getRoleCb() {
        return roleCb;
    }

    public JFrame getFrame() {
        return frame;
    }
}
