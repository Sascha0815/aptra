package git_aptra.Instruction;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogInstructionVacancy {
	
	private static JPanel panelInstructionVacancy = new JPanel();
	
	private static JLabel labelRefreshVacancyHeadline = new JLabel("Arbeitsstellen aktualisieren");
	private static JLabel labelAddVacancyHeadline = new JLabel("Arbeitsstellen anlegen");
	private static JLabel labelEditVacancyHeadline = new JLabel("Arbeitsstellen bearbeiten");
	private static JLabel labelDeleteVacancyHeadline = new JLabel("Arbeitsstellen l�schen");
	private static JLabel labelSearchVacancyHeadline = new JLabel("Arbeitsstellen suchen");
	private static JLabel labelInfoVacancyHeadline = new JLabel("Arbeitsstelleninformationen");
	
	private static JLabel labelRefreshVacancyContent = new JLabel("<html>Mit einem Klick auf Arbeitstelle aktualisieren wird die   <p/> "+                  
																	"Arbeitstellentabelle aktualisiert und es werden die neusten Arbeitstellen angezeigt.</html>");
	private static JLabel labelAddVacancyContent = new JLabel("<html>Mit einem Klick auf Arbeitstelle hinzuf�gen k�nnen Sie einen <p/> "+                  
																"neue Arbeitstelle hinzuf�gen. Nach dem Speichern wird diese   <p/> "+
																"sofort in die Datenbank �bernommen und in der Arbeitstellentabelle angezeigt.</html>");
	private static JLabel labelEditVacancyContent = new JLabel("<html>Mit einem Klick auf Arbeitstelle bearbeiten k�nnen Sie die Daten <p/> "+                  
																"einer bestehenden Arbeitstelle bearbeiten. Um eine Arbeitstelle  <p/> "+
																"bearbeiten zu k�nnen m�ssen Sie erst eine Arbeitstelle in der <p/> "+
																"Arbeitstellentabelle ausw�hlen.</html>");
	private static JLabel labelDeleteVacancyContent = new JLabel("<html>Mit einem Klick auf Arbeitstelle l�schen k�nnen Sie eine <p/> "+                  
																"bestehenden Arbeitstelle l�schen. Um einen Arbeitstelle l�schen  <p/> "+
																"zu k�nnen m�ssen Sie erst eine Arbeitstelle in der Arbeitstellentabelle <p/> "+
																" ausw�hlen.</html>");
	private static JLabel labelSearchVacancyContent = new JLabel("<html>Mit einem Klick auf Arbeitstelle suchen k�nnen Sie einen <p/> "+                  
																	"bestehende Arbeitstelle suchen. Um einen Arbeitstelle zu suchen  <p/> "+
																	"geben Sie einfach die zu suchenden Daten in den Suchdialog ein.</html>");
	private static JLabel labelInfoVacancyContent = new JLabel("<html>Mit einem Klick auf Arbeitsstelleninformationen k�nnen Sie alle  <p/> "+                  
																"Daten von einer bestehenden Arbeitstelle einsehen. Um die   <p/> "+
																"Arbeitsstelleninformationen einzusehen m�ssen Sie erst eine   <p/> "+
																"Arbeitstelle in der Arbeitstellentabelle ausw�hlen.</html>");
	
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	public static void addInstructionVacancy(){
		labelRefreshVacancyHeadline.setFont(fontHeadline);
		labelAddVacancyHeadline.setFont(fontHeadline);
		labelEditVacancyHeadline.setFont(fontHeadline);
		labelDeleteVacancyHeadline.setFont(fontHeadline);
		labelSearchVacancyHeadline.setFont(fontHeadline);
		labelInfoVacancyHeadline.setFont(fontHeadline);
		labelRefreshVacancyContent.setFont(fontText);
		labelAddVacancyContent.setFont(fontText);
		labelEditVacancyContent.setFont(fontText);
		labelDeleteVacancyContent.setFont(fontText);
		labelSearchVacancyContent.setFont(fontText);
		labelInfoVacancyContent.setFont(fontText);
		panelInstructionVacancy.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]"));
		panelInstructionVacancy.add(labelRefreshVacancyHeadline, "cell 0 0 2 1,alignx left");
		panelInstructionVacancy.add(labelRefreshVacancyContent, "cell 0 1,alignx left");
		panelInstructionVacancy.add(labelAddVacancyHeadline, "cell 0 2 2 1,alignx left");
		panelInstructionVacancy.add(labelAddVacancyContent, "cell 0 3,alignx left");
		panelInstructionVacancy.add(labelEditVacancyHeadline, "cell 0 4 2 1,alignx left");
		panelInstructionVacancy.add(labelEditVacancyContent, "cell 0 5,alignx left");
		panelInstructionVacancy.add(labelDeleteVacancyHeadline, "cell 0 6 2 1,alignx left");
		panelInstructionVacancy.add(labelDeleteVacancyContent, "cell 0 7,alignx left");
		panelInstructionVacancy.add(labelSearchVacancyHeadline, "cell 0 8 2 1,alignx left");
		panelInstructionVacancy.add(labelSearchVacancyContent, "cell 0 9,alignx left");
		panelInstructionVacancy.add(labelInfoVacancyHeadline, "cell 0 10 2 1,alignx left");
		panelInstructionVacancy.add(labelInfoVacancyContent, "cell 0 11,alignx left");
		DialogInstruction.tabInstruction.addTab("Arbeitsstellen",panelInstructionVacancy);
	}
}
