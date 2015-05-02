package git_aptra.EditVacancyManagement;

import git_aptra.Oberflaeche;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class DialogDetailsMeeting {
	public static JDialog dialogMeeting = new JDialog(Oberflaeche.frame);
	public static JPanel panelMeeting = new JPanel();
	public static JLabel labelInstruction = new JLabel("Bitte geben Sie die benötigten Daten ein.");
	public static JLabel labelMeeting = new JLabel("Art des Termins:");
	public static JLabel labelLocation = new JLabel("Ort:");
	public static JLabel labelDate = new JLabel("Datum:");
	public static JLabel labelTime = new JLabel("Uhrzeit:");
	
		public static void detailsMeeting(){		
			dialogMeeting.setVisible(true);
			dialogMeeting.setSize(400, 400);
			dialogMeeting.setLocationRelativeTo(null);
			panelMeeting.setBackground(Color.LIGHT_GRAY);
			dialogMeeting.setResizable(false);
			dialogMeeting.setTitle("Meeting Details");
			dialogMeeting.add(panelMeeting);
			panelMeeting.add(labelInstruction);
			panelMeeting.add(labelMeeting);
			panelMeeting.add(labelLocation);
			panelMeeting.add(labelDate);
			panelMeeting.add(labelTime);
		}
		
	}


