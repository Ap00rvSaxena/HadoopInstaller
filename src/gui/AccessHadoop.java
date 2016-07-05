package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.awt.Cursor;
import java.awt.Desktop;

public class AccessHadoop extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessHadoop frame = new AccessHadoop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AccessHadoop() {
		
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        }
		catch (Exception e) 
		{
		e.printStackTrace();	
		}
		
		setTitle("Access Hadoop Services in Browser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNamenode = new JLabel("Access Hadoop Services in Browser");
		lblNamenode.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblNamenode.setBounds(12, 28, 290, 24);
		contentPane.add(lblNamenode);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 65, 600, 2);
		contentPane.add(separator);
		
		JLabel lblHadoopNamenode = new JLabel("Hadoop NameNode");
		lblHadoopNamenode.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblHadoopNamenode.setBounds(237, 90, 132, 24);
		contentPane.add(lblHadoopNamenode);
		
		JLabel lblNewLabel = new JLabel("http://localhost:50070/");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = "http://localhost:50070/";
				open_browser(url);
			}
		});
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(237, 127, 154, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblAllApplications = new JLabel(" All Applications");
		lblAllApplications.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblAllApplications.setBounds(247, 156, 110, 24);
		contentPane.add(lblAllApplications);
		
		JLabel lblHttplocalhost = new JLabel("http://localhost:8088/");
		lblHttplocalhost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = "http://localhost:8088/";
				open_browser(url);
			}
		});
		lblHttplocalhost.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHttplocalhost.setForeground(Color.BLUE);
		lblHttplocalhost.setBounds(237, 193, 181, 16);
		contentPane.add(lblHttplocalhost);
		
		JLabel lblSecondaryNamenode = new JLabel("Secondary Namenode");
		lblSecondaryNamenode.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblSecondaryNamenode.setBounds(237, 222, 141, 24);
		contentPane.add(lblSecondaryNamenode);
		
		JLabel lblHttplocalhost_1 = new JLabel("http://localhost:50090/");
		lblHttplocalhost_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = "http://localhost:50090/";
				open_browser(url);
			}
		});
		lblHttplocalhost_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHttplocalhost_1.setForeground(Color.BLUE);
		lblHttplocalhost_1.setBounds(237, 256, 181, 16);
		contentPane.add(lblHttplocalhost_1);
		
		JLabel lblDatanode = new JLabel("DataNode");
		lblDatanode.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		lblDatanode.setBounds(266, 285, 110, 24);
		contentPane.add(lblDatanode);
		
		JLabel lblHttplocalhost_2 = new JLabel("http://localhost:50075/");
		lblHttplocalhost_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String url = "http://localhost:50075/";
				open_browser(url);
			}
		});
		lblHttplocalhost_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHttplocalhost_2.setForeground(Color.BLUE);
		lblHttplocalhost_2.setBounds(237, 322, 181, 16);
		contentPane.add(lblHttplocalhost_2);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(260, 376, 97, 25);
		contentPane.add(btnExit);
	}
	
	public void open_browser(String url)
	{
		try {
		if(Desktop.isDesktopSupported())
		{
		  Desktop.getDesktop().browse(new URI(url));
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
