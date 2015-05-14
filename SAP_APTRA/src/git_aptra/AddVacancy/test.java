package git_aptra.AddVacancy;

import javax.swing.JPanel;
import java.awt.SystemColor;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JTable;

public class test extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public test() {
		setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[][grow][][][][][][][][][][][]"));
		setBackground(SystemColor.control);
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel, "cell 0 0");
		
		table = new JTable();
		add(table, "cell 0 1 4 12,grow");

	}

}
