package git_aptra.Instruction;

import git_aptra.MenuBar.MenuBarPanelApplicant;

import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class DialogInstructionApplicant {
	
	private static JPanel panelInstructionApplicant = new JPanel();
	
	private static JLabel labelRefreshApplicant = new JLabel();
	private static JLabel labelAddApplicant = new JLabel();
	private static JLabel labelEditApplicant = new JLabel();
	private static JLabel labelDeleteApplicant= new JLabel();
	private static JLabel labelSearchApplicant = new JLabel();
	private static JLabel labelInfoApplicant = new JLabel();
	
	private static Font fontHeadline = new Font("Calibri", Font.BOLD, 16);
	private static Font fontSubHeadline = new Font("Calibri", Font.BOLD, 14);
	private static Font fontText = new Font("Calibri", Font.PLAIN, 14);
	
	public static void addInstructionApplicant(){
		try {
			Image refreshApplicant = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_refresh.png"));
			labelRefreshApplicant.setIcon(new ImageIcon(refreshApplicant));
		} catch (IOException ex) {
		}
		try {
			Image add = ImageIO.read(MenuBarPanelApplicant.class
					.getResource("resources/applicant_add.png"));   
			labelAddApplicant.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		panelInstructionApplicant.setLayout(new MigLayout("", "[grow,left][grow,right]", "[][][][][][]"));
		panelInstructionApplicant.add(labelRefreshApplicant, "cell 0 1,alignx left");
		panelInstructionApplicant.add(labelAddApplicant, "cell 0 2,alignx left");
		panelInstructionApplicant.add(labelEditApplicant, "cell 0 3,alignx left");
		panelInstructionApplicant.add(labelDeleteApplicant, "cell 0 4,alignx left");
		panelInstructionApplicant.add(labelSearchApplicant, "cell 0 5,alignx left");
		panelInstructionApplicant.add(labelInfoApplicant, "cell 0 6,alignx left");
	}
}
