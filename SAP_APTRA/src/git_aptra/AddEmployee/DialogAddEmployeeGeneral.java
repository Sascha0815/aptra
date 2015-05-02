package git_aptra.AddEmployee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DialogAddEmployeeGeneral {
	
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelLoginName = new JLabel("Login-Name:");
	private static JLabel labelPassword = new JLabel("Passwort:");
	private static JLabel labelPasswordRepeat = new JLabel("Passwort wiederholen:");
	private static JLabel labelEntitlement = new JLabel("Sicherheitsstufe:");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelWarning= new JLabel("Die Passwörter stimmen nicht überein!");

	public static JPanel panelDialogEmployeeMain = new JPanel();
	
	private static Font fontHeadline = new Font("Arial", Font.BOLD, 18);
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
	private static JTextField fieldLoginName = new JTextField();
	
	private static Integer[] boxListEntitlement = { 1, 2, 3};
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox boxEntitlement = new JComboBox(boxListEntitlement);
	
	private static JPasswordField fieldPassword = new JPasswordField();
	private static JPasswordField fieldPasswordRepeat = new JPasswordField();
	
	private static JButton save = new JButton("Speichern");
	
	private static String name;
	private static String firstName;
	private static String loginName;
	private static int entitlement;
	private static String password;
	
	public static void addEmployeeGeneral() {
		panelDialogEmployeeMain.setBackground(Color.LIGHT_GRAY);
		panelDialogEmployeeMain.setLayout(new BoxLayout(panelDialogEmployeeMain, BoxLayout.Y_AXIS));
		panelDialogEmployeeMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogEmployeeMain.add(labelInstruction);
		labelInstruction.setFont(fontHeadline);
		panelDialogEmployeeMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogEmployeeMain.add(labelName);
		panelDialogEmployeeMain.add(fieldName);
		panelDialogEmployeeMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldName.setFont(fontTextField);
		panelDialogEmployeeMain.add(labelFirstName);
		panelDialogEmployeeMain.add(fieldFirstName);
		panelDialogEmployeeMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldFirstName.setFont(fontTextField);
		panelDialogEmployeeMain.add(labelLoginName);
		panelDialogEmployeeMain.add(fieldLoginName);
		panelDialogEmployeeMain.add(Box.createRigidArea(new Dimension(0, 10)));
		fieldLoginName.setFont(fontTextField);
		panelDialogEmployeeMain.add(labelPassword);
		panelDialogEmployeeMain.add(fieldPassword);
		panelDialogEmployeeMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogEmployeeMain.add(labelPasswordRepeat);
		panelDialogEmployeeMain.add(fieldPasswordRepeat);
		panelDialogEmployeeMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogEmployeeMain.add(labelEntitlement);
		panelDialogEmployeeMain.add(boxEntitlement);
		panelDialogEmployeeMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogEmployeeMain.add(labelWarning);
		labelWarning.setVisible(false);
		panelDialogEmployeeMain.add(Box.createRigidArea(new Dimension(0, 10)));
		panelDialogEmployeeMain.add(save);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				char[] passwordChar1 = fieldPassword.getPassword();
				String passwordString1 = String.valueOf(passwordChar1);
				char[] passwordChar2 = fieldPasswordRepeat.getPassword();
				String passwordString2 = String.valueOf(passwordChar2);
				if (passwordString1.equalsIgnoreCase(passwordString2)){
				try {
					SaveDataNewEmployee.save();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				} else {
					labelWarning.setVisible(true);
				}
			}
		});
		DialogAddEmployee.tabAdd.addTab("Allgemein", panelDialogEmployeeMain);
	}
	
	public static void getGeneral() {
		
		try {
			name = fieldName.getText();
		} catch (Exception e) {
		}
		try {
			firstName = fieldFirstName.getText();
		} catch (Exception e) {
		}
		try {
			loginName = fieldLoginName.getText();
		} catch (Exception e) {
		}
		try {
			char[] passwordChar = fieldPassword.getPassword();
			password = String.valueOf(passwordChar);
			password.replace('"', '^');
		} catch (Exception e) {
		}
		try {
			entitlement = (int) boxEntitlement.getSelectedItem();
		} catch (Exception e) {
		}

	}

	public static void reset() {
		fieldName.setText("");
		fieldFirstName.setText("");
		fieldLoginName.setText("");
		fieldPassword.setText("");
		fieldPasswordRepeat.setText("");
		panelDialogEmployeeMain.removeAll();
		ActionListener[] al = save.getActionListeners();
		save.removeActionListener(al[0]);
	}

	public static String getName() {
		return name;
	}

	public static String getFirstName() {
		return firstName;
	}

	public static String getLoginName() {
		return loginName;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static int getEntitlement() {
		return entitlement;
	}
}
