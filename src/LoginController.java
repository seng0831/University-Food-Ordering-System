import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginController extends LoginView {
    private LoginView view;
    String errorStatus;
    String user;

    public LoginController(LoginView view) {
        this.view = view;
        view.setLoginButtonActionListener(new LoginButtonListener());
        view.setClearButtonActionListener(new ClearButtonListener());
    }

    public void startApplication() {
        view.showView();
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            if (username.isEmpty() || password.isEmpty()) {
                view.displayErrorMessage("Please fill in all the details.");
            } else {
                String role = checkUser(username, password);

                if ("unavailable".equals(role)) {
                    view.displayErrorMessage("This account does not exist. Contact an administrator to create one.");
                } else if ("incorrect".equals(role)) {
                    view.displayErrorMessage("The password you entered is incorrect. Please try again.");
                } else {
                	user = username;
                    openRoleClass(role);
                    view.clearFields();
                    view.disposeFrame();
                }
            }
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.clearFields();
        }
    }

    private String checkUser(String username, String password) {
        String[] roleList = {"admin", "vendor", "runner", "customer"};

        for (String role : roleList) {
            String fileName = role + ".txt";

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 3) {
                        String storedUsername = parts[0].trim();
                        String storedPassword = parts[1].trim();

                        if (username.equals(storedUsername)) {
                            if (password.equals(storedPassword)) {
                                return role;
                            } else {
                                return errorStatus = "incorrect";
                            }
                        }
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return errorStatus = "unavailable";
    }

    private void openRoleClass(String role) {
        switch (role) {
            case "admin":
                new Admin(user);
                break;

            case "vendor":
                new MainMenuVendorForm(user);
                break;

            case "runner":
                new DR_Menu(user);
                break;

            case "customer":
                new Customer_Homepage(user);
                break;
        }
    }
    
}
