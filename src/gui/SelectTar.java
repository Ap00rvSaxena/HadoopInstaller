package gui;

import gui.ConfigInstaller;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;

public class SelectTar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JFileChooser fileChooser;
	public String tarpath;
	public String filename;
	private Intro intro;
	public String parpath;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SelectTar(Intro introframe) {
		setTitle("tar Chooser");
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        }
		catch (Exception e) {}
		
		intro = introframe;
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblTararchieve = new JLabel("Tar/Archieve");
		lblTararchieve.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lblTararchieve.setBounds(12, 73, 121, 26);
		contentPane.add(lblTararchieve);
		
		JLabel lblChooseHadoopTar = new JLabel("Choose Hadoop tar");
		lblChooseHadoopTar.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseHadoopTar.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		lblChooseHadoopTar.setBounds(36, 13, 342, 36);
		contentPane.add(lblChooseHadoopTar);
		
		textField = new JTextField();
		textField.setBounds(137, 73, 241, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Open");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser.showOpenDialog(null);
				tarpath = fileChooser.getSelectedFile().getAbsolutePath();
				filename = fileChooser.getSelectedFile().getName().replaceAll(".tar.gz", "");
				parpath = fileChooser.getSelectedFile().getParent();
				System.out.println(tarpath);
				System.out.println(filename);
				System.out.println(parpath);
				System.out.println(parpath+"/"+filename);
				textField.setText(tarpath);
			}
		});
		btnNewButton.setBounds(166, 120, 97, 25);
		contentPane.add(btnNewButton);
		
		fileChooser = new JFileChooser();
		fileChooser.setBounds(94, 110, -64, 51);
		contentPane.add(fileChooser);
		
		JButton btnBasic = new JButton("Basic");
		btnBasic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ConfigInstaller conin = new ConfigInstaller(SelectTar.this);
				conin.setVisible(true);
				conin.Mode = 0;
				conin.check_prevframe();
			}
		});
		btnBasic.setBounds(166, 175, 97, 25);
		contentPane.add(btnBasic);
		
		JButton btnAdvance = new JButton("Advance");
		btnAdvance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ConfigInstaller conin = new ConfigInstaller(SelectTar.this);
				conin.setVisible(true);
				conin.Mode = 1;
				conin.check_prevframe();
			}
		});
		btnAdvance.setBounds(289, 175, 97, 25);
		contentPane.add(btnAdvance);
		
		JButton button = new JButton("<<Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introframe.setVisible(true);
				setVisible(false);
			}
		});
		button.setBounds(36, 175, 97, 25);
		contentPane.add(button);
	}
}
