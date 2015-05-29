package git_aptra.EditVacancyManagement;


import git_aptra.Login.Login;
import git_aptra.VacancyManagement.DialogOpenVacancy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

import net.miginfocom.swing.MigLayout;

public class DialogEditVacancyManagementMatrix {
	
	
	public static JPanel panelDialogEditVacancyManagementMatrix = new JPanel();
	private static JScrollPane scrollpaneMatrix = new JScrollPane(panelDialogEditVacancyManagementMatrix);
	public static JPanel panelMatrix = new JPanel();
	private static JButton saveRating = new JButton("Speichern");
	private static int amount = 0;
	@SuppressWarnings("rawtypes")
	private static Vector notations = new Vector();
	@SuppressWarnings("rawtypes")
	private static Vector scores = new Vector();
	private static JSlider[] slider;
	@SuppressWarnings("unchecked")
	public static void editVacancyManagementMatrix() throws InstantiationException, IllegalAccessException, ClassNotFoundException {		
		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Bewertung",
				panelMatrix);
		panelMatrix.setLayout(new MigLayout("", "[]","[400][]"));
		panelMatrix.add(scrollpaneMatrix, "cell 0 0");
		scrollpaneMatrix.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpaneMatrix.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		try {
			Connection con =  Login.getConnection();
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("select count(*) from vacancyevaluation where vacancyID = " + DialogOpenVacancy.getID());
		    while (rs.next()) {
		        amount = rs.getInt(1);
		       }
		} catch (Exception e) {
			System.out.println("Fehler auslesen der Anzahl Kriterien" +e.getMessage());
		}
		try {
			Connection con =  Login.getConnection();
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("select notation from vacancyevaluation where vacancyID = " + DialogOpenVacancy.getID());
		    while (rs.next()) {
		        notations.add(rs.getString(1));
		       }
		} catch (Exception e) {
			System.out.println("Fehler auslesen der Kriterien" +e.getMessage());
		}
		try {
			Connection con =  Login.getConnection();
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("select score from rating where applicantID = " + EditVacancyManagement.getDataSetApplicantID());
		    while (rs.next()) {
		        scores.add(rs.getInt(1));
		       }
		} catch (Exception e) {
			System.out.println("Fehler auslesen der Scores" +e.getMessage());
		}

		String columns = "";
		String cell = "";
		slider = new JSlider[amount];
		JLabel[] labels = new JLabel[amount]; 
		for (int i = 0; i < amount; i++) {
			columns = columns+ "[][]";
		}
		columns = columns + "[]";
		panelDialogEditVacancyManagementMatrix.setLayout(new MigLayout("", "[grow,left][grow,right]" + columns));	
		for (int i = 0; i < amount; i++) {
			slider[i] = new JSlider();
			labels[i] = new JLabel();
		}
		for(int i = 0; i < amount; i++){
			cell = "cell 0 " + i*2 + "2, growx";
			panelDialogEditVacancyManagementMatrix.add(labels[i], cell);
			labels[i].setText((String) notations.elementAt(i));
		}
		for (int i = 0; i < amount; i++) {
			cell = "cell 0 " + ((i*2)+1) + "2, growx";
			panelDialogEditVacancyManagementMatrix.add(slider[i], cell);
			slider[i].setMinimum(0);
			slider[i].setMaximum(5);
			slider[i].setMajorTickSpacing(1);
			slider[i].createStandardLabels(1);
			slider[i].setPaintTicks(true);
			slider[i].setPaintLabels(true);
			slider[i].setValue((int) scores.elementAt(i));
		}
		
		panelMatrix.add(saveRating, "cell 0 1");	
		
		saveRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {					
				SaveDataEditVacancyManagement.save();
				InsertEditVacancyManagementDataIntoDatabase.insertEditVacancyManagementDataMatrix(amount, notations);	
				panelDialogEditVacancyManagementMatrix.removeAll();
				resetScore();
				
			}
		});
		
	}	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Vector getScore(){
		Vector newScores = new Vector();
		for (int i = 0; i < amount; i++) {
			newScores.add(slider[i].getValue());
		}
		return newScores;
	}
	
	public static void resetScore(){
		scores.removeAllElements();				
	}

		
}

