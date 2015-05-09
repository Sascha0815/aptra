package git_aptra.EditApplicant;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import git_aptra.Oberflaeche;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogEditWarning {

	private static JDialog dialogEditWarning = new JDialog(Oberflaeche.frame);
	private static JPanel panelEditWarning = new JPanel();
	private static JLabel labelEditWarning = new JLabel("Sie haben keinen Bewerber ausgew‰hlt");
	private static JButton buttonEditWarning = new JButton("Schlieﬂen");
	private static Font fontWarning = new Font("Arial", Font.BOLD, 16);
	private static GridBagConstraints gbc = new GridBagConstraints();

	public static void selectOnlyOne() {
		dialogEditWarning.setVisible(true);
		dialogEditWarning.setSize(325, 90);
		dialogEditWarning.setLocationRelativeTo(null);
		dialogEditWarning.setResizable(false);
		dialogEditWarning.setTitle("Fehler");
		dialogEditWarning.add(panelEditWarning);
		gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.weighty = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    labelEditWarning.setFont(fontWarning);
	    panelEditWarning.add(labelEditWarning,gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    panelEditWarning.add(buttonEditWarning,gbc);
		buttonEditWarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogEditWarning.dispose();
			}
		});
	}
}
