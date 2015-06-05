package git_aptra.MenuBar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import git_aptra.Loading;
import git_aptra.Oberflaeche;
import git_aptra.AddApplicant.DialogAddApplicant;
import git_aptra.AddVacancy.DialogAddVacancy;
import git_aptra.Login.Login;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MenuBarPanelOverview {
	private static JPanel panelOverview = new JPanel();
	private static JPanel panelContentOverview = new JPanel();
	
	private static JButton buttonNullApplicant = new JButton();
	private static JButton buttonNullVacancy = new JButton();
	private static JButton buttonNullManagement = new JButton();
	private static JButton buttonNullMeeting = new JButton();
	
	private static JButton buttonAddApplicant = new JButton("Bewerber hinzufügen");
	private static JButton buttonEditApplicant = new JButton("Bewerber bearbeiten");
	private static JButton buttonSearchApplicant = new JButton("Bewerber suchen");
	private static JButton buttonInfoApplicant = new JButton("Bewerber anzeigen");
	
	private static JButton buttonAddVacancy = new JButton("Arbeitsstelle hinzufügen");
	private static JButton buttonEditVacancy = new JButton("Arbeitsstelle bearbeiten");
	private static JButton buttonSearchVacancy = new JButton("Arbeitsstelle suchen");
	private static JButton buttonInfoVacancy = new JButton("Arbeitsstelle anzeigen");
	
	private static JButton buttonSearchManagement = new JButton("Stellenmanagement wählen");
	private static JButton buttonEditManagement = new JButton("Stellenmanagement bearbeiten");
	
	private static JButton buttonAddMeeting = new JButton("Termin hinzufügen");
	private static JButton buttonEditMeeting = new JButton("Termin bearbeiten");
	private static JButton buttonSearchMeeting = new JButton("Termin suchen");
	private static JButton buttonInfoMeeting = new JButton("Termin anzeigen");

	// SWING: Übersicht-Panel
	public static void addPanelOverview() {
		panelOverview.setLayout(new MigLayout("", "[grow,left][grow,right]", "[]60[]30[]30[]30[]30[]30[]"));
		panelOverview.add(panelContentOverview,	"cell 0 0 2");
		
		buttonNullApplicant.setToolTipText("Bewerber");
		panelOverview.add(buttonNullApplicant, "cell 1 1 2,alignx left");
		buttonNullApplicant.setOpaque(false);
		buttonNullApplicant.setContentAreaFilled(false);
		buttonNullApplicant.setBorder(null);
		try {
			Image add = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_null.png"));   
			buttonNullApplicant.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonNullApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Oberflaeche.tabBar.setSelectedIndex(1);
			}
		});
		panelOverview.add(buttonAddApplicant, "cell 1 2 2,alignx left");
		panelOverview.add(buttonEditApplicant, "cell 1 3 2,alignx left");
		panelOverview.add(buttonSearchApplicant, "cell 1 4 2,alignx left");
		panelOverview.add(buttonInfoApplicant, "cell 1 5 2,alignx left");
		
		buttonNullVacancy.setToolTipText("Arbeitsstellen");
		panelOverview.add(buttonNullVacancy, "cell 2 1 2, alignx left");
		buttonNullVacancy.setOpaque(false);
		buttonNullVacancy.setContentAreaFilled(false);
		buttonNullVacancy.setBorder(null);
		try {
			Image add = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/vacancy_null.png"));   
			buttonNullVacancy.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonNullVacancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Oberflaeche.tabBar.setSelectedIndex(2);
			}
		});
		panelOverview.add(buttonAddVacancy, "cell 2 2 2,alignx left");
		
		buttonAddVacancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			}
		});
		panelOverview.add(buttonEditVacancy, "cell 2 3 2,alignx left");
		panelOverview.add(buttonSearchVacancy, "cell 2 4 2,alignx left");
		panelOverview.add(buttonInfoVacancy, "cell 2 5 2,alignx left");
		
		buttonNullManagement.setToolTipText("Stellenmanagement");
		panelOverview.add(buttonNullManagement, "cell 3 1 2, alignx left");
		buttonNullManagement.setOpaque(false);
		buttonNullManagement.setContentAreaFilled(false);
		buttonNullManagement.setBorder(null);
		try {
			Image add = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/management_null.png"));   
			buttonNullManagement.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonNullManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Oberflaeche.tabBar.setSelectedIndex(3);
			}
		});
		panelOverview.add(buttonSearchManagement, "cell 3 2 2,alignx left");
		panelOverview.add(buttonEditManagement, "cell 3 3 2,alignx left");
		
		buttonNullMeeting.setToolTipText("Termine");
		panelOverview.add(buttonNullMeeting, "cell 4 1 2, alignx left");
		buttonNullMeeting.setOpaque(false);
		buttonNullMeeting.setContentAreaFilled(false);
		buttonNullMeeting.setBorder(null);
		try {
			Image add = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/meeting_null.png"));   
			buttonNullMeeting.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonNullMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Oberflaeche.tabBar.setSelectedIndex(4);
			}
		});
		panelOverview.add(buttonAddMeeting, "cell 4 2 2,alignx left");
		panelOverview.add(buttonEditMeeting, "cell 4 3 2,alignx left");
		panelOverview.add(buttonSearchMeeting, "cell 4 4 2,alignx left");
		panelOverview.add(buttonInfoMeeting, "cell 4 5 2,alignx left");
		
		
		Oberflaeche.tabBar.addTab("Übersicht", panelOverview);

	}

}
