package git_aptra.Login;

import git_aptra.Oberflaeche;
import git_aptra.AddApplicant.SaveDataNewApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DialogLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	public JFrame frameLogin = new JFrame();
	private JPanel panelLogin = new JPanel();
	private JLabel labelInstruction = new JLabel(
			"Bitte geben sie ihre Zugangsdaten ein.");
	private JLabel labelUsername = new JLabel("Benutzername:");
	private JLabel labelPassword = new JLabel("Passwort:");
	private JLabel labelWarning = new JLabel("Die eingegebenen Zugangsdaten sind nicht korrekt!");
	private JTextField fieldUsername = new JTextField();
	private JPasswordField fieldPassword = new JPasswordField();
	private JButton buttonLogin = new JButton("Einloggen");
	private Font fontLogin = new Font("Arial", Font.BOLD, 12);
	private Font fontInstruction = new Font("Arial", Font.BOLD, 14);
	private String username;
	private String password;
	private int entitlement = 0;

	public DialogLogin() {
		frameLogin.setSize(400, 250);
		frameLogin.setTitle("Login");
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.setResizable(false);
		frameLogin.setLocationRelativeTo(null);
		frameLogin.add(panelLogin);
		panelLogin.setLayout(new BoxLayout(panelLogin, BoxLayout.Y_AXIS));
		panelLogin.setBackground(Color.LIGHT_GRAY);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLogin.add(labelInstruction);
		labelInstruction.setFont(fontInstruction);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 15)));
		panelLogin.add(labelUsername);
		labelUsername.setFont(fontLogin);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLogin.add(fieldUsername);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLogin.add(labelPassword);
		labelPassword.setFont(fontLogin);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLogin.add(fieldPassword);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 10)));
		panelLogin.add(buttonLogin);
		panelLogin.add(Box.createRigidArea(new Dimension(0, 15)));
		panelLogin.add(labelWarning);
		labelWarning.setVisible(false);
		labelWarning.setFont(fontLogin);
		labelWarning.setForeground(Color.red);
		
		
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				password = String.valueOf(fieldPassword.getPassword());
				password.replace('"', '^');
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
					
					break;
				}
			}
		});
		
		frameLogin.setVisible(true);
	}
	
	
}
