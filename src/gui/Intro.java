package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Intro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public Intro() {
		
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        }
		catch (Exception e) 
		{
		e.printStackTrace();	
		}
		
		setTitle("Welcome to Apache\u2122 Hadoop\u00AE!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Intro.class.getResource("/img/Hadoop.png")));
		label.setBounds(12, 13, 225, 449);
		contentPane.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(249, 13, 1, 462);
		contentPane.add(separator);
		
		JLabel label_1 = new JLabel("Apache Hadoop");
		label_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		label_1.setBounds(271, 13, 187, 24);
		contentPane.add(label_1);
		
		JButton button = new JButton("Next>>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SelectTar(Intro.this).setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(554, 437, 97, 25);
		contentPane.add(button);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setText("The Apache\u2122 Hadoop\u00AE project develops open-source software for reliable, scalable, distributed computing.\r\nThe Apache Hadoop software library is a framework that allows for the distributed processing of large data sets across clusters of computers using simple programming models. It is designed to scale up from single servers to thousands of machines, each offering local computation and storage. Rather than rely on hardware to deliver high-availability, the library itself is designed to detect and handle failures at the application layer, so delivering a highly-available service on top of a cluster of computers, each of which may be prone to failures.\r\n\r\nThe project includes these modules:\r\nHadoop Common: The common utilities that support the other Hadoop modules.\r\nHadoop Distributed File System (HDFS\u2122): A distributed file system that provides high-throughput access to application data.\r\nHadoop YARN: A framework for job scheduling and cluster resource management.\r\nHadoop MapReduce: A YARN-based system for parallel processing of large data sets.");
		textArea.setOpaque(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		textArea.setEditable(false);
		textArea.setBounds(269, 50, 386, 425);
		contentPane.add(textArea);
	}

}
