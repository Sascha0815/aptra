package git_aptra.Instruction;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JLabel;

public class test extends JPanel {

	/**
	 * Create the panel.
	 */
	public test() {
		setLayout(new MigLayout("", "[][]", "[][]"));
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton, "cell 0 0");
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel, "cell 1 0");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		add(lblNewLabel_1, "cell 1 1");

	}

}
