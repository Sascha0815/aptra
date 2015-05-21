package git_aptra.EditVacancyManagement;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

import net.miginfocom.swing.MigLayout;

public class DialogEditVacancyManagementMatrix {
	

	private static JPanel panelDialogEditVacancyManagementMatrix = new JPanel();
	private static JScrollPane scrollpaneMatrix = new JScrollPane(panelDialogEditVacancyManagementMatrix);
	private static JButton saveRating = new JButton("Speichern");
	public static void editVacancyManagementMatrix() {		
		DialogEditVacancyManagement.tabEditVacancyManagment.addTab("Bewertung",
				scrollpaneMatrix);
		scrollpaneMatrix.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpaneMatrix.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		/*try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://185.28.20.242:3306/u474396146_db",
					"u474396146_aptra", "aptraDB");
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT name, firstName from employee where employeeID = " +  IDEmployee );
		    while (rs.next()) {
		        name = rs.getString(1);
		        firstName = rs.getString(2);
		        fullName = firstName + " " +name;
		    }
		} catch (Exception e) {
			System.out.println("Fehler auslesen der Anzahl Kriterien" +e.getMessage());
		}
*/
		
		/*sliderImpression.setMinimum(0);
		sliderImpression.setMaximum(5);
		sliderImpression.setMajorTickSpacing(1);
		sliderImpression.createStandardLabels(1);
		sliderImpression.setPaintTicks(true);
		sliderImpression.setPaintLabels(true);
		sliderImpression.setValue(EditVacancyManagement.getDataSetScoreImpression());*/
		int max = 20;
		String columns = "";
		String cell = "";
		for (int i = 0; max < 3; i++) {
			columns = columns+ "[][]";
		}
		panelDialogEditVacancyManagementMatrix.setLayout(new MigLayout("", "[grow,left][grow,right]" + columns));
				
		
		
		for(int i = 0; i < 2*max; i++){
			cell = "cell 0 " + i + "2, growx";
			if (i%2==0) {
				panelDialogEditVacancyManagementMatrix.add(new JLabel("test"+(i/2)), cell);
			}
			else {
				panelDialogEditVacancyManagementMatrix.add(new JSlider(), cell);
			}
			
			}

		
		
		
		
		saveRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SaveDataEditVacancyManagement.save();
				InsertEditVacancyManagementDataIntoDatabase.insertEditVacancyManagementDataMatrix();
				
			}
		});
	}
		
		

		

}

