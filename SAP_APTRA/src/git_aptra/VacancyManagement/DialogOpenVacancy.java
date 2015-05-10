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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DialogOpenVacancy {
	private static int id;
	private static JDialog dialogAddVacancyManagement  = new JDialog(Oberflaeche.frame);
	private static JPanel panelAddVacancyManagement = new JPanel();
	private static JLabel instruction = new JLabel("Bitte gewŁnschte Stellenidentifikationsnummer eingeben.");
	private static Font fontTextField = new Font("Arial", Font.BOLD, 14);
	private static JButton searchVacancy = new JButton("Suchen");
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static JComboBox boxID = new JComboBox(MenuBarPanelVacancyManagement.getResult());
	
	
	@SuppressWarnings("static-access")
	public static void addVacancyManagement() {
		dialogAddVacancyManagement.addWindowListener(new WindowListener() {
			public void windowClosing(WindowEvent arg0) {
				panelAddVacancyManagement.removeAll();		
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
		dialogAddVacancyManagement.setSize(420, 150);
		dialogAddVacancyManagement.setLocationRelativeTo(null);
		dialogAddVacancyManagement.setResizable(false);
		dialogAddVacancyManagement.setTitle("Ausschreibung verwalten");
		dialogAddVacancyManagement.setDefaultCloseOperation(dialogAddVacancyManagement.DO_NOTHING_ON_CLOSE);
		dialogAddVacancyManagement.add(panelAddVacancyManagement);
		panelAddVacancyManagement.setLayout(new BoxLayout(panelAddVacancyManagement,
				BoxLayout.Y_AXIS));
		panelAddVacancyManagement.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddVacancyManagement.setBackground(Color.LIGHT_GRAY);
		panelAddVacancyManagement.add(instruction);
		instruction.setAlignmentX(instruction.CENTER_ALIGNMENT);
		instruction.setFont(fontTextField);
		panelAddVacancyManagement.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddVacancyManagement.add(boxID);
		panelAddVacancyManagement.add(Box.createRigidArea(new Dimension(0, 10)));
		panelAddVacancyManagement.add(searchVacancy);
		searchVacancy.setAlignmentX(searchVacancy.CENTER_ALIGNMENT);
		panelAddVacancyManagement.add(Box.createRigidArea(new Dimension(0, 10)));
		SwingUtilities.updateComponentTreeUI(dialogAddVacancyManagement);		
		searchVacancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String IDSplit = ((String) boxID.getSelectedItem());
				String[] IDParts = IDSplit.split(" - ");
				id = Integer.parseInt(IDParts[0]);
				@SuppressWarnings("rawtypes")
				Vector resultsVacancy = OpenVacancy.openVacancy(id);						
				MenuBarPanelVacancyManagement.modelVacancyManagement.setDataVector(resultsVacancy, MenuBarPanelVacancyManagement.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
				panelAddVacancyManagement.removeAll();
				boxID.setSelectedIndex(0); 					
				ActionListener[] al = searchVacancy.getActionListeners();
				searchVacancy.removeActionListener(al[0]);
				dialogAddVacancyManagement.dispose();
				OpenVacancy.insertInfo(id);
			}
		});
		dialogAddVacancyManagement.setLocationRelativeTo(Oberflaeche.frame);
	}
	
	public static int getID(){
		return id;
	}
}
