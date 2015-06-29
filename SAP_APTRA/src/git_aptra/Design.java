package git_aptra;

import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;

//Stellt das Design zur Verfügung
public class Design {
	public static void aluminiumLook() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		SwingUtilities.updateComponentTreeUI(Oberflaeche.frame);
	}
}
