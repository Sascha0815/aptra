package git_aptra.VacancyManagement;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import git_aptra.Oberflaeche;
import git_aptra.MenuBar.MenuBarPanelVacancyManagement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DialogOpenVacancy {
	
	private static JDialog dialogAddVacancyManagement  = new JDialog(Oberflaeche.frame);
	private static JPanel panelAddCacancyManagement = new JPanel();
	private static JLabel instruction = new JLabel("Bitte gewünschte Stellenidentifikationsnummer eingeben.");
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JTextField fieldID = new JTextField();
	private static JButton searchVacancy = new JButton("Suchen");
	
	@SuppressWarnings("static-access")
	public static void addVacancyManagement() {
		dialogAddVacancyManagement.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent arg0) {
				panelAddCacancyManagement.removeAll();
				fieldID.setText("");				
				ActionListener[] al = searchVacancy.getActionListeners();
				searchVacancy.removeActionListener(al[0]);
				dialogAddVacancyManagement.dispose();
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	
		dialogAddVacancyManagement.setVisible(true);
		dialogAddVacancyManagement.setSize(450, 200);
		dialogAddVacancyManagement.setLocationRelativeTo(null);
		dialogAddVacancyManagement.setResizable(false);
		dialogAddVacancyManagement.setTitle("Ausschreibung verwalten");
		dialogAddVacancyManagement.setDefaultCloseOperation(dialogAddVacancyManagement.DO_NOTHING_ON_CLOSE);
		dialogAddVacancyManagement.add(panelAddCacancyManagement);
		panelAddCacancyManagement.setLayout(new BoxLayout(panelAddCacancyManagement,
				BoxLayout.Y_AXIS));
		panelAddCacancyManagement.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddCacancyManagement.setBackground(Color.LIGHT_GRAY);
		panelAddCacancyManagement.add(instruction);
		instruction.setAlignmentX(instruction.CENTER_ALIGNMENT);
		instruction.setFont(fontTextField);
		panelAddCacancyManagement.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddCacancyManagement.add(fieldID);
		panelAddCacancyManagement.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddCacancyManagement.add(searchVacancy);
		searchVacancy.setAlignmentX(searchVacancy.CENTER_ALIGNMENT);
		panelAddCacancyManagement.add(Box.createRigidArea(new Dimension(0, 10)));
		SwingUtilities.updateComponentTreeUI(dialogAddVacancyManagement);		
		searchVacancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int id= Integer.parseInt(fieldID.getText());
				@SuppressWarnings("rawtypes")
				Vector resultsVacancy = OpenVancancy.openVacancy(id);						
				MenuBarPanelVacancyManagement.modelVacancyManagement.setDataVector(resultsVacancy, MenuBarPanelVacancyManagement.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
				panelAddCacancyManagement.removeAll();
				fieldID.setText("");				
				ActionListener[] al = searchVacancy.getActionListeners();
				searchVacancy.removeActionListener(al[0]);
				dialogAddVacancyManagement.dispose();
				MenuBarPanelVacancyManagement.fieldManagementCount.setText(String.valueOf(MenuBarPanelVacancyManagement.tableVacancyManagement.getRowCount()));
			}
		});
	}
}
