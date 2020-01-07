package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientWindow {

	private JFrame frame;
	private JTextField messageField;
	private JTextArea textArea = new JTextArea();

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
			
		});
		panel.add(btnNewButton);
		
		frame.setLocationRelativeTo(null);	
	}
	
	public static void printToConsole(String message) {
		
	}

}
