package git_aptra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Steuerung {
	final private static Steuerung steuerung = new Steuerung();
	final private static SaveDataNewApplicant saveDataNewApplication = new SaveDataNewApplicant();
	final private static InsertApplicationData insertApplicationData = new InsertApplicationData();
	final private static InsertApplicantDataIntoTable insertApplicantDataIntoTable = new InsertApplicantDataIntoTable();
	final private static DeleteApplicant deleteApplicant = new DeleteApplicant();
		

	public static Steuerung getSteuerung() {
		return steuerung;
	}
	public static SaveDataNewApplicant getSaveDataNewApplicant() {
		return saveDataNewApplication;
	}
	public static InsertApplicationData getInsertApplicationData() {
		return insertApplicationData;
	}
	public static InsertApplicantDataIntoTable getInsertApplicantDataIntoTable() {
		return insertApplicantDataIntoTable;
	}
	public static DeleteApplicant getDeleteApplicant() {
		return deleteApplicant;
	}	

	public static void main(String[] args) {
		
		new Oberflaeche("Bewerberverwaltung");
		Vector resultsApplicant = insertApplicantDataIntoTable
				.insertApplicantDataIntoTable();
		MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,
				MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
		MenuBarPanelApplicant.modelPool.fireTableDataChanged();
	}

}
