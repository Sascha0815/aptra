package git_aptra.EditVacancy;

import git_aptra.Oberflaeche;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogEditVacancyWarning {
	
	private static JDialog dialogEditWarning = new JDialog(Oberflaeche.frame);
	private static JPanel panelEditWarning = new JPanel();
	private static JLabel labelEditWarningNothingSelected = new JLabel("Sie haben keine Arbeitsstelle ausgew‰hlt");
	private static JLabel labelEditWarningTooManySelected = new JLabel("Sie haben mehr als eine Arbeitsstelle ausgew‰hlt");
	private static JButton buttonEditWarning = new JButton("Schlieﬂen");
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	
	public static void nothingSelected() {
		dialogEditWarning.setVisible(true);
		dialogEditWarning.setSize(325, 100);
		dialogEditWarning.setLocationRelativeTo(null);
		dialogEditWarning.setResizable(false);
		dialogEditWarning.setTitle("Fehler");
		dialogEditWarning.add(panelEditWarning);
		labelEditWarningNothingSelected.setFont(fontSubHeadline);
		buttonEditWarning.setFont(fontSubHeadline);
		panelEditWarning.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]push[]"));
		panelEditWarning.add(labelEditWarningNothingSelected, "cell 0 0 2 1,alignx center");
		panelEditWarning.add(buttonEditWarning, "cell 0 1 2 1, alignx center");
		
		buttonEditWarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogEditWarning.dispose();
			}
		});	
	}
	
	public static void tooManySelected(){
		dialogEditWarning.setVisible(true);
		dialogEditWarning.setSize(325, 100);
		dialogEditWarning.setLocationRelativeTo(null);
		dialogEditWarning.setResizable(false);
		dialogEditWarning.setTitle("Fehler");
		dialogEditWarning.add(panelEditWarning);
		labelEditWarningTooManySelected.setFont(fontSubHeadline);
		buttonEditWarning.setFont(fontSubHeadline);
		panelEditWarning.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]push[]"));
		panelEditWarning.add(labelEditWarningTooManySelected, "cell 0 0 2 1,alignx center");
		panelEditWarning.add(buttonEditWarning, "cell 0 1 2 1, alignx center");
		
		buttonEditWarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogEditWarning.dispose();
			}
		});	
	}
}
