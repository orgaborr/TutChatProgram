package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ClientWindow {

	private JFrame frame;
	private JTextField messageField;
	private static JTextArea textArea = new JTextArea();
	
	private Client client;
	private String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ClientWindow window = new ClientWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientWindow() {
		initialize();
		
		name = JOptionPane.showInputDialog("Enter Name");
		client = new Client(name, "localhost", 52864);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Chat Program");
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		messageField = new JTextField();
		panel.add(messageField);
		messageField.setColumns(50);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(e -> {
			client.send(name + ": " + messageField.getText());
			messageField.setText("");
		});
		panel.add(btnNewButton);
		
		frame.setLocationRelativeTo(null);	
	}
	
	public static void printToConsole(String message) {
		textArea.setText(textArea.getText() + message + "\n");
	}

}
