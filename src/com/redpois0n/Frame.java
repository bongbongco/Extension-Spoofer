package com.redpois0n;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtIn;
	private JComboBox<String> comboBox;
	private JCheckBox chckbxBackupInputFile;

	public Frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/com/redpois0n/icons/rocket-fly.png")));
		setTitle(Main.getTitle());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblInputFile = new JLabel("Input file");
		lblInputFile.setBounds(23, 20, 43, 14);
		
		txtIn = new JTextField();
		txtIn.setBounds(77, 17, 170, 20);
		txtIn.setEditable(false);
		txtIn.setColumns(10);
		
		JButton btnBrowse = new JButton("...");
		btnBrowse.setBounds(262, 16, 45, 23);
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser c = new JFileChooser();
				c.showOpenDialog(null);
				File file = c.getSelectedFile();
				if (file != null) {
					txtIn.setText(file.getAbsolutePath());
				}
			}
		});
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(77, 45, 66, 20);
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"mp3", "exe", "gif", "png", "jpg", "jpeg", "tif", "bmp", "wmv"}));
		comboBox.setEditable(true);
		
		JButton btnSpoof = new JButton("Spoof");
		btnSpoof.setIcon(new ImageIcon(Frame.class.getResource("/com/redpois0n/icons/rocket--arrow.png")));
		btnSpoof.setBounds(226, 110, 81, 25);
		btnSpoof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spoofer.spoof(new File(txtIn.getText()), comboBox.getSelectedItem().toString(), chckbxBackupInputFile.isSelected());
			}
		});
		
		JLabel lblExtension = new JLabel("Extension");
		lblExtension.setBounds(20, 48, 47, 14);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 99, 317, 2);
		contentPane.setLayout(null);
		contentPane.add(lblInputFile);
		contentPane.add(lblExtension);
		contentPane.add(comboBox);
		contentPane.add(txtIn);
		contentPane.add(btnBrowse);
		contentPane.add(btnSpoof);
		contentPane.add(separator);
		
		chckbxBackupInputFile = new JCheckBox("Backup input file (.bak)");
		chckbxBackupInputFile.setBounds(23, 69, 155, 23);
		contentPane.add(chckbxBackupInputFile);
		
		JLabel lblHttpredpoisncom = new JLabel("http://redpois0n.com");
		lblHttpredpoisncom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URI("http://redpois0n.com"));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		lblHttpredpoisncom.setForeground(Color.BLUE);
		lblHttpredpoisncom.setBounds(106, 115, 110, 14);
		contentPane.add(lblHttpredpoisncom);
	}
}
