package git_aptra.MenuBar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import git_aptra.Oberflaeche;
import git_aptra.AddApplicant.DialogAddApplicant;
import git_aptra.AddMeeting.DialogAddMeeting;
import git_aptra.AddVacancy.DialogAddVacancy;
import git_aptra.EditVacancy.DialogEditVacancy;
import git_aptra.Overview.EditApplicant.DialogLoadApplicantEditSelection;
import git_aptra.Overview.EditMeeting.DialogOverviewEditMeetingData;
import git_aptra.Overview.EditVacancy.DialogOverviewEditVacancyData;
import git_aptra.Overview.ShowApplicantInfo.DialogLoadApplicantData;
import git_aptra.Overview.ShowMeetingInfo.DialogLoadMeetingData;
import git_aptra.Overview.ShowVacancyInfo.DialogLoadVacancyData;
import git_aptra.SearchApplicant.DialogSearchApplicant;
import git_aptra.SearchMeeting.DialogSearchMeeting;
import git_aptra.SearchVacancy.DialogSearchVacancy;
import git_aptra.VacancyManagement.DialogOpenVacancy;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;

public class MenuBarPanelOverview {
	private static JPanel panelOverview = new JPanel();
	
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
	
	private static JButton buttonSearchManagement = new JButton("Stelle öffnen");
	private static JButton buttonEditManagement = new JButton("Bewerber bearbeiten");
	
	private static JButton buttonAddMeeting = new JButton("Termin hinzufügen");
	private static JButton buttonEditMeeting = new JButton("Termin bearbeiten");
	private static JButton buttonSearchMeeting = new JButton("Termin suchen");
	private static JButton buttonInfoMeeting = new JButton("Termin anzeigen");
	
	private static JPanel panelApplicant = new JPanel();
	private static JPanel panelVacancy = new JPanel();
	private static JPanel panelManagement = new JPanel();
	private static JPanel panelMeeting = new JPanel();
	private static Font fontButton = new Font("Calibri", Font.PLAIN, 16);
	
	private static String[] vacancyID;
	@SuppressWarnings("unused")
	private static String[] division;
	private static String[] divisionData;
	
	// SWING: Übersicht-Panel
	public static void addPanelOverview() {
		panelOverview.setLayout(new MigLayout("", "[]1%![]1%![]1%![]", "[]"));
		Border border = new LineBorder(Color.gray, 2);
		Border panelBorder = new LineBorder(Color.LIGHT_GRAY,2);
		Border line =  new MatteBorder(0,0,2,0, Color.gray);
		
		buttonNullApplicant.setToolTipText("Bewerber");
		buttonNullVacancy.setToolTipText("Arbeitsstellen");
		buttonNullManagement.setToolTipText("Bewerbermanagement");
		buttonNullMeeting.setToolTipText("Meeting");
		
		panelApplicant.setLayout(new MigLayout("", "[90%!]","15px![]5%![]5%![]5%![]"));
		panelVacancy.setLayout(new MigLayout("", "[90%!]","15px![]5%![]5%![]5%![]"));
		panelManagement.setLayout(new MigLayout("", "[90%!]","15px![]5%![]5%![]5%![]"));
		panelMeeting.setLayout(new MigLayout("", "[90%!]","15px![]5%![]5%![]5%![]"));
		
		panelOverview.add(panelApplicant, "cell 0 0, w 24%!, h 98%!");
		panelOverview.add(panelVacancy, "cell 1 0,  w 24%!, h 98%!");
		panelOverview.add(panelManagement, "cell 2 0,  w 24%!, h 98%!");
		panelOverview.add(panelMeeting, "cell 3 0, w 24%!, h 98%!");
		panelApplicant.setBorder(panelBorder);
		panelVacancy.setBorder(panelBorder);
		panelMeeting.setBorder(panelBorder);
		panelManagement.setBorder(panelBorder);		
		
		buttonNullApplicant.setToolTipText("Bewerber");
		panelApplicant.add(buttonNullApplicant, "cell 0 0, alignx center, w 95%!, h 170px");
		buttonNullApplicant.setBorder(line);
		buttonNullApplicant.setOpaque(false);
		buttonNullApplicant.setContentAreaFilled(false);
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
		panelApplicant.add(buttonAddApplicant, "cell 0 1, alignx center, w 95%!, h 5%!");
		buttonAddApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				DialogAddApplicant.newApplicant();
			}
		});
		panelApplicant.add(buttonEditApplicant, "cell 0 2, alignx center, w 95%!, h 5%!");
		
		buttonEditApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogLoadApplicantEditSelection.loadApplicantData();
			}
		});
		panelApplicant.add(buttonSearchApplicant, "cell 0 3, alignx center, w 95%!, h 5%!");
		
		buttonSearchApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oberflaeche.tabBar.setSelectedIndex(1);
				DialogSearchApplicant.searchApplicant();
			}
		});
		
		panelApplicant.add(buttonInfoApplicant, "cell 0 4, alignx center, w 95%!, h 5%!");
		
		buttonInfoApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogLoadApplicantData.loadApplicantData();
			}
		});
		
		buttonAddApplicant.setBorder(border);
		buttonAddApplicant.setFont(fontButton);
		buttonEditApplicant.setBorder(border);
		buttonEditApplicant.setFont(fontButton);
		buttonSearchApplicant.setBorder(border);
		buttonSearchApplicant.setFont(fontButton);
		buttonInfoApplicant.setBorder(border);
		buttonInfoApplicant.setFont(fontButton);
		
		buttonNullVacancy.setToolTipText("Arbeitsstellen");
		buttonNullVacancy.setBorder(line);
		panelVacancy.add(buttonNullVacancy, "cell 0 0, alignx center, w 95%!, h 170px");
		buttonNullVacancy.setOpaque(false);
		buttonNullVacancy.setContentAreaFilled(false);
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
		
		panelVacancy.add(buttonAddVacancy, "cell 0 1, alignx center, w 95%!, h 5%!");
		buttonAddVacancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogAddVacancy.newVacancy();
			}
		});
		
		panelVacancy.add(buttonEditVacancy, "cell 0 2, alignx center, w 95%!, h 5%!");
		buttonEditVacancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogOverviewEditVacancyData.loadVacancyData();
			}
		});
		
		panelVacancy.add(buttonSearchVacancy, "cell 0 3, alignx center, w 95%!, h 5%!");
		buttonSearchVacancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oberflaeche.tabBar.setSelectedIndex(2);
				DialogSearchVacancy.searchVacancy();
			}
		});
		
		panelVacancy.add(buttonInfoVacancy, "cell 0 4, alignx center, w 95%!, h 5%!");	
		buttonInfoVacancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogLoadVacancyData.loadVacancyData();
			}
		});
		
		buttonAddVacancy.setBorder(border);
		buttonAddVacancy.setFont(fontButton);
		buttonEditVacancy.setBorder(border);
		buttonEditVacancy.setFont(fontButton);
		buttonSearchVacancy.setBorder(border);
		buttonSearchVacancy.setFont(fontButton);
		buttonInfoVacancy.setBorder(border);
		buttonInfoVacancy.setFont(fontButton);
		
		buttonNullManagement.setToolTipText("Stellenmanagement");
		buttonNullManagement.setBorder(line);
		panelManagement.add(buttonNullManagement, "cell 0 0, alignx center, w 95%!, h 170px");
		buttonNullManagement.setOpaque(false);
		buttonNullManagement.setContentAreaFilled(false);
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
		panelManagement.add(buttonEditManagement, "cell 0 2, alignx center, w 95%!, h 5%!");
		buttonEditManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oberflaeche.tabBar.setSelectedIndex(3);
			}
		});
		
		panelManagement.add(buttonSearchManagement, "cell 0 1, alignx center, w 95%!, h 5%!");
		buttonSearchManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oberflaeche.tabBar.setSelectedIndex(3);
				DialogOpenVacancy.addVacancyManagement();
			}
		});
		
		
		
		buttonEditManagement.setBorder(border);
		buttonEditManagement.setFont(fontButton);
		buttonSearchManagement.setBorder(border);
		buttonSearchManagement.setFont(fontButton);
			
		buttonNullMeeting.setToolTipText("Termine");
		buttonNullMeeting.setBorder(line);
		panelMeeting.add(buttonNullMeeting, "cell 0 0, alignx center, w 95%!, h 170px");
		buttonNullMeeting.setOpaque(false);
		buttonNullMeeting.setContentAreaFilled(false);
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
		panelMeeting.add(buttonAddMeeting, "cell 0 1 ,alignx center, w 95%!, h 5%!");
		buttonAddMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogAddMeeting.newMeeting();
			}
		});
		
		panelMeeting.add(buttonEditMeeting, "cell 0 2 ,alignx center, w 95%!, h 5%!");
		buttonEditMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogOverviewEditMeetingData.loadMeetingData();

			}
		});
		
		panelMeeting.add(buttonSearchMeeting, "cell 0 3 ,alignx center, w 95%!, h 5%!");
		buttonSearchMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Oberflaeche.tabBar.setSelectedIndex(4);
				DialogSearchMeeting.searchMeeting();
			}
		});
		
		panelMeeting.add(buttonInfoMeeting, "cell 0 4 ,alignx center, w 95%!, h 5%!");
		buttonInfoMeeting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogLoadMeetingData.loadMeetingData();
			}
		});
		
		buttonAddMeeting.setBorder(border);
		buttonAddMeeting.setFont(fontButton);
		buttonEditMeeting.setBorder(border);
		buttonEditMeeting.setFont(fontButton);
		buttonSearchMeeting.setBorder(border);
		buttonSearchMeeting.setFont(fontButton);
		buttonInfoMeeting.setBorder(border);
		buttonInfoMeeting.setFont(fontButton);
		Oberflaeche.tabBar.addTab("Übersicht", panelOverview);

	}
	public static String[] getVacancyID(){
		return vacancyID;
	}
	public static String[] getDivision(){
		return divisionData;
	}
}
