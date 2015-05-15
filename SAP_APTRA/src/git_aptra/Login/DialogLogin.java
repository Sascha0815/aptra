package git_aptra.Login;

import git_aptra.Oberflaeche;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class DialogLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public JFrame frameLogin = new JFrame();
	
	private JPanel panelLogin = new JPanel();
	
	private JLabel labelInstruction = new JLabel("Bitte geben sie Ihre Zugangsdaten ein");
	private JLabel labelUsername = new JLabel("Benutzername:");
	private JLabel labelPassword = new JLabel("Passwort:");
	private JLabel labelWarning = new JLabel("Die Zugangsdaten sind leider nicht korrekt!");
	
	private JTextField fieldUsername = new JTextField(20);
	private JPasswordField fieldPassword = new JPasswordField(20);
	
	private JButton buttonLogin = new JButton("Einloggen");
	private JButton buttonAbort = new JButton("Abbrechen");
	
	private JCheckBox checkRemember = new JCheckBox("Login-Daten merken?");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	private String username;
	private String password;
	private int entitlement = 0;
	

	public DialogLogin() {
		frameLogin.setSize(285, 230);
		frameLogin.setTitle("Login");
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.setResizable(false);
		frameLogin.setLocationRelativeTo(null);
		frameLogin.getRootPane().setDefaultButton(buttonLogin);
		frameLogin.add(panelLogin);
		labelInstruction.setFont(fontHeadline);
		labelUsername.setFont(fontSubHeadline);
		labelPassword.setFont(fontSubHeadline);
		labelWarning.setFont(fontSubHeadline);
	    labelWarning.setVisible(false);
		labelWarning.setForeground(Color.red);
		fieldUsername.setFont(fontText);
		fieldPassword.setFont(fontText);
		panelLogin.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][][][][][][][][][][]"));
		panelLogin.add(labelInstruction, "cell 0 0,alignx left");
		panelLogin.add(labelUsername, "cell 0 1,alignx left");
	    panelLogin.add(fieldUsername, "cell 0 2 3 1,growx");
	    panelLogin.add(labelPassword, "cell 0 3,alignx left");
	    panelLogin.add(fieldPassword, "cell 0 4 3 1,growx");
	    panelLogin.add(checkRemember,"cell 0 5,alignx left");
	    panelLogin.add(labelWarning, "cell 0 6 3 1,growx");
	    panelLogin.add(buttonLogin, "cell 0 7 ,alignx left");
	    panelLogin.add(buttonAbort, "cell 0 7 ,alignx right");
	    
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
