package git_aptra.DialogEditApplicant;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import git_aptra.Oberflaeche;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogEditWarning {

	public static JDialog dialogEditWarning = new JDialog(Oberflaeche.frame);
	public static JPanel panelEditWarning = new JPanel();
	public static JLabel labelEditWarning = new JLabel();
	public static JButton buttonEditWarning = new JButton();

	public static void selectOnlyOne() {
		dialogEditWarning.setVisible(true);
		dialogEditWarning.setSize(400, 100);
		dialogEditWarning.setLocationRelativeTo(null);
		dialogEditWarning.setResizable(false);
		dialogEditWarning.setTitle("‹ber");
		dialogEditWarning.add(panelEditWarning);
		panelEditWarning.add(labelEditWarning);
		panelEditWarning.setBackground(Color.LIGHT_GRAY);
		labelEditWarning.setSize(400, 50);
		labelEditWarning
				.setText("Fehler: Es kann nur ein Eintrag zum Bearbeiten ausgew‰hlt werden!");
		panelEditWarning.add(buttonEditWarning);
		buttonEditWarning.setBounds(0, 50, 400, 50);
		buttonEditWarning.setText("Schlieﬂen");
		buttonEditWarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogEditWarning.dispose();
			}
		});
	}
}
