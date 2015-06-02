package git_aptra.AddEmployee;

import git_aptra.Oberflaeche;
import git_aptra.MenuBar.MenuBar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class DialogAddEmployee {
	public static JDialog dialogNewEmployee = new JDialog(Oberflaeche.frame, true);
	
	private static JLabel labelName = new JLabel("Name:");
	private static JLabel labelFirstName = new JLabel("Vorname:");
	private static JLabel labelLoginName = new JLabel("Login-Name:");
	private static JLabel labelPassword = new JLabel("Passwort:");
	private static JLabel labelPasswordRepeat = new JLabel("Passwort wiederholen:");
	private static JLabel labelEntitlement = new JLabel("Sicherheitsstufe:");
	private static JLabel labelInstruction = new JLabel("Bitte tragen Sie alle erforderlichen Daten ein!");
	private static JLabel labelWarning = new JLabel("Die Passwörter stimmen nicht überein!");
	private static JLabel labelDivision = new JLabel("Abteilung:");

	public static JPanel panelDialogEmployeeMain = new JPanel();
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	private static JTextField fieldName = new JTextField();
	private static JTextField fieldFirstName = new JTextField();
	private static JTextField fieldLoginName = new JTextField();
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static JComboBox boxDivision = new JComboBox(MenuBar.getDivision());
	
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
	private static int divisionID;

	public static void addEmployee() {
		fieldName.setText("");
		fieldFirstName.setText("");
		fieldLoginName.setText("");
		fieldPassword.setText("");
		fieldPasswordRepeat.setText("");
		boxEntitlement.setSelectedIndex(0);
		boxDivision.setSelectedIndex(0);
		dialogNewEmployee.setLocationRelativeTo(null);
		dialogNewEmployee.setSize(435, 450);
		dialogNewEmployee.setResizable(false);
		dialogNewEmployee.setTitle("Neuer Mitarbeiter");
		SwingUtilities.updateComponentTreeUI(dialogNewEmployee);
		dialogNewEmployee.setLocationRelativeTo(Oberflaeche.frame);
		dialogNewEmployee.add(panelDialogEmployeeMain);
		labelInstruction.setFont(fontHeadline);
		labelName.setFont(fontSubHeadline);
		labelFirstName.setFont(fontSubHeadline);
		labelLoginName.setFont(fontSubHeadline);
		labelPassword.setFont(fontSubHeadline);
		labelPasswordRepeat.setFont(fontSubHeadline);
		labelEntitlement.setFont(fontSubHeadline);
		labelWarning.setFont(fontSubHeadline);
		labelWarning.setForeground(Color.RED);
		fieldName.setFont(fontText);
		fieldFirstName.setFont(fontText);
		fieldLoginName.setFont(fontText);
		fieldPassword.setFont(fontText);
		fieldPasswordRepeat.setFont(fontText);
		panelDialogEmployeeMain.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][][][][][][][][]15[]"));
		panelDialogEmployeeMain.add(labelInstruction, "cell 0 0 2 1,alignx center");
		panelDialogEmployeeMain.add(labelName, "cell 0 1,alignx left");
		panelDialogEmployeeMain.add(fieldName, "cell 0 2 2 1,growx");
		panelDialogEmployeeMain.add(labelFirstName, "cell 0 3,alignx left");
		panelDialogEmployeeMain.add(fieldFirstName, "cell 0 4 2 1,growx");
		panelDialogEmployeeMain.add(labelLoginName, "cell 0 5,alignx left");
		panelDialogEmployeeMain.add(fieldLoginName, "cell 0 6 2 1,growx");
		panelDialogEmployeeMain.add(labelPassword, "cell 0 7,alignx left");
		panelDialogEmployeeMain.add(fieldPassword, "cell 0 8 32 1,growx");
		panelDialogEmployeeMain.add(labelPasswordRepeat, "cell 0 9,alignx left");
		panelDialogEmployeeMain.add(fieldPasswordRepeat, "cell 0 10 2 1,growx");
		panelDialogEmployeeMain.add(labelDivision, "cell 0 11 2 1, alignx left");
		panelDialogEmployeeMain.add(boxDivision, "cell 0 12 2 1, growx");
		panelDialogEmployeeMain.add(labelEntitlement, "cell 0 13,alignx left");
		panelDialogEmployeeMain.add(boxEntitlement, "cell 0 14 2 1,growx");
		panelDialogEmployeeMain.add(buttonSave, "cell 0 15,alignx left");
		panelDialogEmployeeMain.add(buttonAbort, "cell 1 15,alignx right");
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
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
				char[] passwordChar1 = fieldPassword.getPassword();
				String passwordString1 = String.valueOf(passwordChar1);
				char[] passwordChar2 = fieldPasswordRepeat.getPassword();
				String passwordString2 = String.valueOf(passwordChar2);
				if (passwordString1.equals(passwordString2)){
					
				String division = (String) boxDivision.getSelectedItem();
				String[] part = division.split(" - ");
				divisionID = Integer.parseInt(part[0]);	
				
				try {
					dialogNewEmployee.dispose();
					InsertEmployeeDataIntoDatabase.insertEmployeeData(name,firstName,loginName,password,entitlement, divisionID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				} else {
					labelWarning.setVisible(true);
				}
			}
		});
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogNewEmployee.dispose();
			}
		});
		dialogNewEmployee.setVisible(true);
		
	}
	

}
	

