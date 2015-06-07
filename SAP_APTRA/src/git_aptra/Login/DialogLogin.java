package git_aptra.Login;

import git_aptra.Oberflaeche;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	
	private JTextField fieldUsername = new JTextField();
	private JPasswordField fieldPassword = new JPasswordField();
	
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
		try {
			Image job = ImageIO.read(DialogLogin.class
					.getResource("FrameIcon.gif"));
			frameLogin.setIconImage(job);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		panelLogin.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][]"));
		panelLogin.add(labelInstruction, "cell 0 0 2 1,alignx left");
		panelLogin.add(labelUsername, "cell 0 1,alignx left");
	    panelLogin.add(fieldUsername, "cell 0 2 2 1,growx");
	    panelLogin.add(labelPassword, "cell 0 3,alignx left");
	    panelLogin.add(fieldPassword, "cell 0 4 2 1,growx");
	    panelLogin.add(checkRemember,"cell 0 5 2 1,alignx left");
	    panelLogin.add(labelWarning, "cell 0 6 2 1,growx");
	    panelLogin.add(buttonLogin, "cell 0 7 ,alignx left");
	    panelLogin.add(buttonAbort, "cell 1 7,alignx right");
	    
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				password = String.valueOf(fieldPassword.getPassword());
				username = fieldUsername.getText();
				entitlement = Login.login(username, password);
				if (entitlement==0) {
					labelWarning.setVisible(true);					
				}
				else {
					new Oberflaeche();
					frameLogin.dispose();
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
