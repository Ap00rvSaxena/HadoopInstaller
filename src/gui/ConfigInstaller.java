package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import scripts.Basic;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import java.awt.ComponentOrientation;
import java.awt.DisplayMode;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ConfigInstaller extends JFrame  {

	private JPanel contentPane;
	private JTextField txtHadoop;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField pwdHadoop;
	private JPasswordField pwdHadoop_1;
	private SelectTar selecttar;
	public int Mode;
	private Basic b;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ConfigInstaller(SelectTar selctar) {
		
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        }
		catch (Exception e) 
		{
		e.printStackTrace();	
		}
		
		selecttar = selctar;
		setTitle("Installing....");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(selctar);
		
		JLabel lblNewUser = new JLabel("New User");
		lblNewUser.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblNewUser.setBounds(25, 13, 159, 24);
		contentPane.add(lblNewUser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 242, 636, 250);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setCaretColor(Color.WHITE);
		textArea.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(new Color(0, 255, 0));
		scrollPane.setViewportView(textArea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 38, 631, 2);
		contentPane.add(separator);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblUserName.setBounds(25, 63, 84, 24);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblPassword.setBounds(313, 63, 119, 24);
		contentPane.add(lblPassword);
		
		JLabel lblRetypePassword = new JLabel("Retype Password");
		lblRetypePassword.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblRetypePassword.setBounds(313, 100, 126, 24);
		contentPane.add(lblRetypePassword);
		
		JLabel lblMasterIp = new JLabel("Master IP");
		lblMasterIp.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblMasterIp.setBounds(25, 110, 73, 24);
		contentPane.add(lblMasterIp);
		
		JLabel lblSlaveIp = new JLabel("Slave IP");
		lblSlaveIp.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblSlaveIp.setBounds(25, 147, 73, 24);
		contentPane.add(lblSlaveIp);
		
		txtHadoop = new JTextField();
		txtHadoop.setText("hadoop");
		txtHadoop.setBounds(117, 63, 172, 25);
		contentPane.add(txtHadoop);
		txtHadoop.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("192.168.1.200");
		textField_1.setColumns(10);
		textField_1.setBounds(117, 109, 172, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("192.168.1.201");
		textField_2.setColumns(10);
		textField_2.setBounds(117, 146, 172, 25);
		contentPane.add(textField_2);
		
		pwdHadoop = new JPasswordField();
		pwdHadoop.setText("hadoop");
		pwdHadoop.setBounds(444, 64, 172, 24);
		contentPane.add(pwdHadoop);
		
		pwdHadoop_1 = new JPasswordField();
		pwdHadoop_1.setText("hadoop");
		pwdHadoop_1.setBounds(444, 103, 172, 24);
		contentPane.add(pwdHadoop_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 185, 631, 2);
		contentPane.add(separator_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				selecttar.setVisible(true);
			}
		});
		btnBack.setBounds(117, 200, 97, 25);
		contentPane.add(btnBack);
		
		JButton btnNext = new JButton("Next>>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new StartHadoop().setVisible(true);
			}
		});
		btnNext.setEnabled(false);
		btnNext.setBounds(291, 505, 97, 25);
		contentPane.add(btnNext);
		
		JButton btnEditConfiguration = new JButton("Edit Configuration");
		btnEditConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.edit_config();
				btnEditConfiguration.setEnabled(false);
			}
		});
		btnEditConfiguration.setBounds(482, 200, 97, 25);
		contentPane.add(btnEditConfiguration);
		
		JCheckBox chckbxCreateNewUser = new JCheckBox("Create New User");
		chckbxCreateNewUser.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				pwdHadoop.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
				pwdHadoop_1.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		chckbxCreateNewUser.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		chckbxCreateNewUser.setBounds(444, 147, 172, 25);
		contentPane.add(chckbxCreateNewUser);
		
		
		
		JButton btnInstall = new JButton("Install");
		btnInstall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("***********************************Starting*******************************************\n");
				if(Mode==0)
				{
					textArea.append("Selected Basic\n");
					b = new Basic(textArea,txtHadoop.getText());
					if(chckbxCreateNewUser.isSelected())
						{
							if(pwdHadoop.equals(pwdHadoop_1))
							{
								String pass = String.valueOf(pwdHadoop.getPassword());
								b.create_user(pass);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Both Password should match", "Password Incorrect",JOptionPane.ERROR_MESSAGE);
								
							}
						}
						b.ssh_services();
						b.install_hadoop(selctar.tarpath, selctar.filename,selctar.parpath);						
						b.setup_env();
						JOptionPane.showMessageDialog(null, "Hadoop Installed Successfully", "Installaion Finished", JOptionPane.INFORMATION_MESSAGE);
						btnNext.setEnabled(true);
						btnEditConfiguration.setEnabled(true);
						btnInstall.setText("Installed");
						btnInstall.setEnabled(false);
				}
				else
				{
					System.out.println("Selected Advance");
				}				
			}
		});
		btnInstall.setBounds(291, 200, 97, 25);
		contentPane.add(btnInstall);
		
		
	}
	
	public void check_prevframe()
	{
		if(Mode==0)
		{
			textField_1.setEnabled(false);
			textField_2.setEnabled(false);
			pwdHadoop.setEnabled(false);
			pwdHadoop_1.setEnabled(false);
		}
		else
		{
			
		}
	}
}
