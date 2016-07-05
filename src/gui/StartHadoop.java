package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;

public class StartHadoop extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartHadoop frame = new StartHadoop();
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
	public StartHadoop() {
		setTitle("Start Hadoop");
		
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        }
		catch (Exception e) 
		{
		e.printStackTrace();	
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStartServices = new JLabel("Start Services:-");
		lblStartServices.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblStartServices.setBounds(12, 27, 136, 24);
		contentPane.add(lblStartServices);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 64, 636, 2);
		contentPane.add(separator);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setForeground(Color.GREEN);
		textArea.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		textArea.setCaretColor(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(12, 295, 636, 171);
		contentPane.add(textArea);
		
		JButton btnStartDfs = new JButton("Start DFS ");
		btnStartDfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd1 = "start-dfs.sh";
				textArea.append(executeCommand(cmd1));
				textArea.append("\n");
			}
		});
		btnStartDfs.setBounds(12, 79, 97, 25);
		contentPane.add(btnStartDfs);
		
		JTextPane txtpnStartsTheHadoop = new JTextPane();
		txtpnStartsTheHadoop.setBackground(UIManager.getColor("Label.background"));
		txtpnStartsTheHadoop.setText("Starts the Hadoop DFS daemons, the namenode and datanodes. Use this before start-mapred.sh");
		txtpnStartsTheHadoop.setBounds(12, 117, 575, 24);
		contentPane.add(txtpnStartsTheHadoop);
		
		JButton btnStartYarn = new JButton("Start Yarn");
		btnStartYarn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd1 = "start-yarn.sh";
				textArea.append(executeCommand(cmd1));
				textArea.append("\n");
			}
		});
		btnStartYarn.setBounds(12, 154, 97, 25);
		contentPane.add(btnStartYarn);
		
		JTextPane txtpnStartsTheHadoop_1 = new JTextPane();
		txtpnStartsTheHadoop_1.setBackground(UIManager.getColor("Label.background"));
		txtpnStartsTheHadoop_1.setText("Starts the Hadoop Map/Reduce daemons, the jobtracker and tasktrackers.");
		txtpnStartsTheHadoop_1.setBounds(12, 191, 575, 24);
		contentPane.add(txtpnStartsTheHadoop_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 280, 636, 2);
		contentPane.add(separator_1);
		
		JButton btnCheckRunningServices = new JButton("Check Running Services");
		btnCheckRunningServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd1 = "jps";
				textArea.append(executeCommand(cmd1));
				textArea.append("\n");
			}
		});
		btnCheckRunningServices.setBounds(83, 228, 199, 25);
		contentPane.add(btnCheckRunningServices);
		
		JButton btnAccessHadoopServices = new JButton("Access Hadoop Services");
		btnAccessHadoopServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AccessHadoop().setVisible(true);
			}
		});
		btnAccessHadoopServices.setBounds(382, 228, 199, 25);
		contentPane.add(btnAccessHadoopServices);
		
	}
	
	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			ProcessBuilder processBuilder = new ProcessBuilder("su", "hadoop", "-c", command);
			output.append("su hadoop -c "+command+"\n");
			p = processBuilder.start();
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
			output.append(e+"\n");
		}

		return output.toString();

	}
}
