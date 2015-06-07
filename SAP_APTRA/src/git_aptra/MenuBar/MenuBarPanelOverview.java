package git_aptra.MenuBar;

import java.awt.Color;
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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

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
	
	private static JPanel panelApplicant = new JPanel();
	private static JPanel panelVacancy = new JPanel();
	private static JPanel panelManagement = new JPanel();
	private static JPanel panelMeeting = new JPanel();

	// SWING: Übersicht-Panel
	public static void addPanelOverview() {
		panelOverview.setLayout(new MigLayout("", "8%![15%!]8%![15%!]8%![15%!]8%![15%!]8%!", "[]"));
		Border border = new LineBorder(Color.gray, 2);
		panelApplicant.setLayout(new MigLayout("", "[90%!]","[]5%![]5%![]5%![]"));
		panelVacancy.setLayout(new MigLayout("", "[90%!]","[]5%![]5%![]5%![]"));
		panelManagement.setLayout(new MigLayout("", "[90%!]","[]5%![]5%![]5%![]"));
		panelMeeting.setLayout(new MigLayout("", "[90%!]","[]5%![]5%![]5%![]"));
		
		panelOverview.add(panelApplicant, "cell 0 0, growx, h 98%!");
		panelOverview.add(panelVacancy, "cell 1 0,  growx, h 98%!");
		panelOverview.add(panelManagement, "cell 2 0,  growx, h 98%!");
		panelOverview.add(panelMeeting, "cell 3 0, growx, h 98%!");
		panelApplicant.setBorder(border);
		panelVacancy.setBorder(border);
		panelMeeting.setBorder(border);
		panelManagement.setBorder(border);
		
		
		buttonNullApplicant.setToolTipText("Bewerber");
		panelApplicant.add(buttonNullApplicant, "cell 0 0, alignx center");
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
		panelApplicant.add(buttonAddApplicant, "cell 0 1, alignx center");
		panelApplicant.add(buttonEditApplicant, "cell 0 2, alignx center");
		panelApplicant.add(buttonSearchApplicant, "cell 0 3, alignx center");
		panelApplicant.add(buttonInfoApplicant, "cell 0 4, alignx center");
		
		
		
		buttonNullVacancy.setToolTipText("Arbeitsstellen");
		panelVacancy.add(buttonNullVacancy, "cell 0 0, alignx center");
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
		
		panelVacancy.add(buttonAddVacancy, "cell 0 1, alignx center");
		panelVacancy.add(buttonEditVacancy, "cell 0 2, alignx center");
		panelVacancy.add(buttonSearchVacancy, "cell 0 3, alignx center");
		panelVacancy.add(buttonInfoVacancy, "cell 0 4, alignx center");
		
		
		
		buttonNullManagement.setToolTipText("Stellenmanagement");
		panelManagement.add(buttonNullManagement, "cell 0 0, alignx center");
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
		panelManagement.add(buttonEditManagement, "cell 0 1, alignx center");
		panelManagement.add(buttonSearchManagement, "cell 0 2, alignx center");
		
		
		
			
		buttonNullMeeting.setToolTipText("Termine");
		panelMeeting.add(buttonNullMeeting, "cell 0 0, alignx center");
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
		panelMeeting.add(buttonAddMeeting, "cell 0 1 ,alignx center");
		panelMeeting.add(buttonEditMeeting, "cell 0 2 ,alignx center");
		panelMeeting.add(buttonSearchMeeting, "cell 0 3 ,alignx center");
		panelMeeting.add(buttonInfoMeeting, "cell 0 4 ,alignx center");
		
		
		Oberflaeche.tabBar.addTab("Übersicht", panelOverview);

	}

}
