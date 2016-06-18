package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginMain {

	private JFrame frame;
	private JTextField userid_textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMain window = new LoginMain();
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
	public LoginMain() {
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        }
		catch (Exception e) 
		{
		e.printStackTrace();	
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("UserId");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblNewLabel.setBounds(29, 81, 100, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblPassword.setBounds(29, 142, 100, 24);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Yu Gothic UI", Font.BOLD, 26));
		lblLogin.setBounds(181, 13, 88, 36);
		frame.getContentPane().add(lblLogin);
		
		userid_textField = new JTextField();
		userid_textField.setBounds(171, 81, 203, 26);
		frame.getContentPane().add(userid_textField);
		userid_textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userid_textField.getText().equals("redhat") && String.valueOf(passwordField.getPassword()).equals("redhat"))
					{
					JOptionPane.showMessageDialog(frame, "Login Successfull", "Login Dialog",JOptionPane.INFORMATION_MESSAGE);
					new Intro().setVisible(true);
					//new SelectTar().setVisible(true);
					frame.setVisible(false);
					}
				else
					{
					JOptionPane.showMessageDialog(frame, "UserId or Password is Incorrect", "Login Dialog",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnLogin.setBounds(92, 199, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userid_textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnReset.setBounds(247, 199, 97, 25);
		frame.getContentPane().add(btnReset);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 142, 203, 26);
		frame.getContentPane().add(passwordField);
	}
}
