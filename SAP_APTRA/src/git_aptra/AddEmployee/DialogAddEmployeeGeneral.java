package git_aptra.AddEmployee;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

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
	
	private static JButton buttonSave = new JButton("Speichern");
	private static JButton buttonAbort = new JButton("Abbrechen");
	
	private static String name;
	private static String firstName;
	private static String loginName;
	private static int entitlement;
	private static String password;
	
	public static void addEmployeeGeneral() {
		MigLayout layout = new MigLayout();		
		panelDialogEmployeeMain.setLayout(layout);
		layout.setLayoutConstraints("wrap");
		panelDialogEmployeeMain.add(labelInstruction, "wrap");
		labelInstruction.setFont(fontHeadline);
		panelDialogEmployeeMain.add(labelName, "wrap");		
		panelDialogEmployeeMain.add(fieldName, "growx");
		fieldName.setFont(fontTextField);
		panelDialogEmployeeMain.add(labelFirstName, "wrap");
		panelDialogEmployeeMain.add(fieldFirstName, "growx");
		fieldFirstName.setFont(fontTextField);
		panelDialogEmployeeMain.add(labelLoginName, "wrap");
		panelDialogEmployeeMain.add(fieldLoginName, "growx");
		fieldLoginName.setFont(fontTextField);
		panelDialogEmployeeMain.add(labelPassword, "wrap");
		panelDialogEmployeeMain.add(fieldPassword, "growx");
		panelDialogEmployeeMain.add(labelPasswordRepeat, "wrap");
		panelDialogEmployeeMain.add(fieldPasswordRepeat, "growx");
		panelDialogEmployeeMain.add(labelEntitlement, "wrap");
		panelDialogEmployeeMain.add(boxEntitlement, "growx");
		panelDialogEmployeeMain.add(labelWarning, "wrap");
		labelWarning.setVisible(false);
		panelDialogEmployeeMain.add(buttonSave, "align left");
		panelDialogEmployeeMain.add(buttonAbort, "align right");
		buttonSave.addActionListener(new ActionListener() {
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
		ActionListener[] al = buttonSave.getActionListeners();
		buttonSave.removeActionListener(al[0]);
		ActionListener[] al1 = buttonAbort.getActionListeners();
		buttonAbort.removeActionListener(al[0]);
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
