package git_aptra.EditVacancyManagement;


import git_aptra.VacancyManagement.DialogOpenVacancy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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
	

	private static JPanel panelDialogEditVacancyManagementMatrix = new JPanel();
	private static JScrollPane scrollpaneMatrix = new JScrollPane(panelDialogEditVacancyManagementMatrix);
	private static JButton saveRating = new JButton("Speichern");
	private static int amount = 0;
	@SuppressWarnings("rawtypes")
	private static Vector notations = new Vector();
	
	@SuppressWarnings("unchecked")
	public static void editVacancyManagementMatrix() throws InstantiationException, IllegalAccessException, ClassNotFoundException {		
		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Bewertung",
				scrollpaneMatrix);
		scrollpaneMatrix.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpaneMatrix.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("select count(*) from rating where vacancyID = " + DialogOpenVacancy.getID());
		    while (rs.next()) {
		        amount = rs.getInt(1);
		       }
		} catch (Exception e) {
			System.out.println("Fehler auslesen der Anzahl Kriterien" +e.getMessage());
		}
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("select notation from rating where vacancyID = " + DialogOpenVacancy.getID());
		    while (rs.next()) {
		        notations.add(rs.getString(1));
		       }
		} catch (Exception e) {
			System.out.println("Fehler auslesen der Kriterien" +e.getMessage());
		}

		
		
		String columns = "";
		String cell = "";
		JSlider[] slider = new JSlider[amount];
		JLabel[] labels = new JLabel[amount]; // Name der Kategorien f�r Labelbeschriftung muss noch aus DB abgerufen werden
		for (@SuppressWarnings("unused")
		int i = 0; amount < 3; i++) {
			columns = columns+ "[][]";
		}
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
			slider[i].setValue(EditVacancyManagement.getDataSetScoreImpression());
		}
		
		

		
		
		
		
		saveRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataEditVacancyManagement.save();
				InsertEditVacancyManagementDataIntoDatabase.insertEditVacancyManagementDataMatrix();
				
			}
		});
	}
		
		

		

}

