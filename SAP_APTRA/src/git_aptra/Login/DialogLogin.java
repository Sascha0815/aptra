package git_aptra.Login;

import git_aptra.Oberflaeche;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DialogLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public JFrame frameLogin = new JFrame();
	
	private JPanel panelLogin = new JPanel(new GridBagLayout());
	
	private JLabel labelInstruction = new JLabel("Bitte geben sie ihre Zugangsdaten ein.");
	private JLabel labelUsername = new JLabel("Benutzername:");
	private JLabel labelPassword = new JLabel("Passwort:");
	private JLabel labelWarning = new JLabel("Die Zugangsdaten sind nicht korrekt!");
	
	private JTextField fieldUsername = new JTextField(20);
	private JPasswordField fieldPassword = new JPasswordField(20);
	
	private JButton buttonLogin = new JButton("Einloggen");
	private JButton buttonAbort = new JButton("Abbrechen");
	
	private JCheckBox checkRemember = new JCheckBox("Login-Daten merken?");
	
	private Font fontLogin = new Font("Arial", Font.BOLD, 12);
	
	private String username;
	private String password;
	private int entitlement = 0;
	
	private GridBagConstraints gbc = new GridBagConstraints();

	public DialogLogin() {
		frameLogin.setSize(250, 230);
		frameLogin.setTitle("Login");
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.setResizable(false);
		frameLogin.setLocationRelativeTo(null);
		frameLogin.getRootPane().setDefaultButton(buttonLogin);
		frameLogin.add(panelLogin);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.weighty = 1;
	    panelLogin.add(labelInstruction,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    panelLogin.add(labelUsername,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    panelLogin.add(fieldUsername,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    panelLogin.add(labelPassword,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    panelLogin.add(fieldPassword,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    gbc.weighty = 1;
	    panelLogin.add(checkRemember,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.fill = GridBagConstraints.NONE;
	    panelLogin.add(buttonLogin,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    gbc.anchor = GridBagConstraints.EAST;
	    panelLogin.add(buttonAbort,gbc);
	    labelWarning.setVisible(false);
		labelWarning.setFont(fontLogin);
		labelWarning.setForeground(Color.red);
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    gbc.gridy = 8;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    panelLogin.add(labelWarning,gbc);
	    labelWarning.setVisible(false);
		labelWarning.setFont(fontLogin);
		labelWarning.setForeground(Color.red);
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    gbc.gridy = 8;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    panelLogin.add(labelWarning,gbc);
			
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				password = String.valueOf(fieldPassword.getPassword());
				username = fieldUsername.getText();
				entitlement = Login.login(username, password);
				switch (entitlement) {
				case 0:
					labelWarning.setVisible(true);
					break;

				case 1:
					new Oberflaeche();
					frameLogin.dispose();
					break;
				
				case 2:
					new Oberflaeche();
					frameLogin.dispose();
					System.out.println("Eingeschränkter Zugriff auf das Programm");
					break;
				}
			}
		});
		
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frameLogin.dispose();
			}
		});
		
		frameLogin.setVisible(true);
	}	
}
