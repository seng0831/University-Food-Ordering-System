import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Customer implements ActionListener {
	JFrame frame = new JFrame("Customer");
	JButton notificationBtn = new JButton("Notification");
	String user;

	public Customer(String user) {
		this.user = user;
		
		notificationBtn.addActionListener(this);
		
		frame.add(notificationBtn);
		
		frame.setVisible(true);
        frame.setSize(675, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == notificationBtn)
		{
			new Notifications(user);
		}
	}

}
