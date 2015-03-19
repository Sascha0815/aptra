package git_aptra.DialogEditApplicant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import git_aptra.Oberflaeche;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.api.Component;

public class DialogEditWarning {

	private static JDialog dialogEditWarning = new JDialog(Oberflaeche.frame);
	private static JPanel panelEditWarning = new JPanel();
	private static JLabel labelEditWarning = new JLabel();
	private static JButton buttonEditWarning = new JButton();
	private static Font fontWarning = new Font("Arial", Font.BOLD, 16);

	public static void selectOnlyOne() {
		dialogEditWarning.setVisible(true);
		dialogEditWarning.setSize(400, 100);
		dialogEditWarning.setLocationRelativeTo(null);
		dialogEditWarning.setResizable(false);
		dialogEditWarning.setTitle("Fehler");
		dialogEditWarning.add(panelEditWarning);
		panelEditWarning.setLayout(new BoxLayout(panelEditWarning, BoxLayout.Y_AXIS));
		panelEditWarning.add(Box.createRigidArea(new Dimension(0, 5)));
		panelEditWarning.add(labelEditWarning);
		panelEditWarning.setBackground(Color.LIGHT_GRAY);
		labelEditWarning.setSize(400, 50);
		labelEditWarning.setText("Bitte nur einen Bewerber ausw�hlen!");
		labelEditWarning.setAlignmentX(labelEditWarning.CENTER_ALIGNMENT);
		labelEditWarning.setFont(fontWarning);
		panelEditWarning.add(Box.createRigidArea(new Dimension(0, 15)));
		panelEditWarning.add(buttonEditWarning);
		buttonEditWarning.setBounds(0, 50, 400, 55);
		buttonEditWarning.setText("Schlie�en");
		buttonEditWarning.setAlignmentX(buttonEditWarning.CENTER_ALIGNMENT);
		buttonEditWarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogEditWarning.dispose();
			}
		});
	}
}