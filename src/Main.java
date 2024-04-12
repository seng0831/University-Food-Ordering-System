public class Main {
    public static void main(String[] args) {
        LoginView view = new LoginView();
        LoginController controller = new LoginController(view);
        controller.startApplication();
    }
}
