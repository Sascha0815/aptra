package git_aptra.AddApplicant;

import git_aptra.Oberflaeche;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogWarningNoVacancy {
	private static JDialog dialogWarning = new JDialog(Oberflaeche.frame);
	private static JPanel panelWarning = new JPanel();
	private static JLabel labelWarning = new JLabel("Es ist aktuell keine freigegebene Stelle verfügbar.");
	private static JLabel labelWarning2 = new JLabel("Bitte legen sie zunächst eine an, bevor sie weitere Bewerber hinzufügen.");
	private static JButton buttonClose = new JButton("Schließen");
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	
	public static void show(){
		panelWarning.removeAll();
		dialogWarning.setVisible(true);
		dialogWarning.setSize(415, 120);
		dialogWarning.setLocationRelativeTo(Oberflaeche.frame);
		dialogWarning.setResizable(false);
		dialogWarning.setTitle("Fehler");
		dialogWarning.add(panelWarning);
		labelWarning.setFont(fontSubHeadline);
		buttonClose.setFont(fontSubHeadline);
		panelWarning.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][]push[]"));
		panelWarning.add(labelWarning, "cell 0 0 2 1,alignx center");
		panelWarning.add(labelWarning2, "cell 0 1 2 1,alignx center");
		panelWarning.add(buttonClose, "cell 0 2 2 1, alignx center");
		
		buttonClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogWarning.dispose();
			}
		});	
	}
}
