package git_aptra.EditVacancy;

import git_aptra.Oberflaeche;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogEditVacancyWarning {

	private static JDialog dialogEditWarning = new JDialog(Oberflaeche.frame);
	private static JPanel panelEditWarning = new JPanel();
	private static JLabel labelEditWarning = new JLabel();
	private static JButton buttonEditWarning = new JButton();
	private static Font fontWarning = new Font("Arial", Font.BOLD, 16);

	public static void selectOnlyOne() {
		dialogEditWarning.setVisible(true);
		dialogEditWarning.setSize(400, 100);
		dialogEditWarning.setLocationRelativeTo(Oberflaeche.frame);
		dialogEditWarning.setResizable(false);
		dialogEditWarning.setTitle("Fehler");
		dialogEditWarning.add(panelEditWarning);
		panelEditWarning.setLayout(new MigLayout("", "[]", "[][]"));
		panelEditWarning.add(labelEditWarning, "cell 0 0");
		labelEditWarning.setSize(400, 50);
		labelEditWarning.setText("Bitte eine Arbeitstelle ausw‰hlen!");
		labelEditWarning.setFont(fontWarning);
		panelEditWarning.add(buttonEditWarning, "cell 0 1 ");
		buttonEditWarning.setText("Schlieﬂen");
		buttonEditWarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogEditWarning.dispose();
			}
		});
	}
}
