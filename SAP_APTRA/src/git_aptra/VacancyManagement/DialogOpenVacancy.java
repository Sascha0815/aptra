package git_aptra.VacancyManagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import git_aptra.Oberflaeche;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class DialogOpenVacancy {
	
	private static JDialog dialogAddVacancyManagement  = new JDialog(Oberflaeche.frame);
	
	private static JPanel panelAddVacancyManagement = new JPanel();
	
	private static JLabel labelInstruction = new JLabel("Bitte die gewünschte Stellen-ID eingeben");
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	
	private static JButton buttonSearch = new JButton("Suchen");
	private static JButton buttonAbort = new JButton("Abbrechen");
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox boxID = new JComboBox(MenuBarPanelVacancyManagement.getResult());
	
	private static int id;
	
	public static void addVacancyManagement() {
		dialogAddVacancyManagement.setVisible(true);
		dialogAddVacancyManagement.setSize(420, 130);
		dialogAddVacancyManagement.setResizable(false);	
		dialogAddVacancyManagement.setTitle("Ausschreibung verwalten");
		dialogAddVacancyManagement.add(panelAddVacancyManagement);
		labelInstruction.setFont(fontHeadline);
		boxID.setFont(fontSubHeadline);
		buttonSearch.setFont(fontSubHeadline);
		buttonAbort.setFont(fontSubHeadline);
		panelAddVacancyManagement.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][][]"));
		panelAddVacancyManagement.add(labelInstruction, "cell 0 0,alignx center");
		panelAddVacancyManagement.add(boxID, "cell 0 1 3 1,growx");
		panelAddVacancyManagement.add(buttonSearch, "cell 0 3 ,alignx left");
		panelAddVacancyManagement.add(buttonAbort, "cell 1 3  ,alignx right");
		SwingUtilities.updateComponentTreeUI(dialogAddVacancyManagement);		
		
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String IDSplit = ((String) boxID.getSelectedItem());
				String[] IDParts = IDSplit.split(" - ");
				id = Integer.parseInt(IDParts[0]);
				@SuppressWarnings("rawtypes")
				Vector resultsVacancy = OpenVacancy.openVacancy(id);						
				MenuBarPanelVacancyManagement.modelVacancyManagement.setDataVector(resultsVacancy, MenuBarPanelVacancyManagement.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
				boxID.setSelectedIndex(0); 					
				dialogAddVacancyManagement.dispose();
				OpenVacancy.insertInfo(id);
			}
		});
		
		buttonAbort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dialogAddVacancyManagement.dispose();
			}
		});
		dialogAddVacancyManagement.setLocationRelativeTo(Oberflaeche.frame);
		
	}
	
	public static int getID(){
		return id;
	}
	
}
