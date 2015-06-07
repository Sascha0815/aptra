package git_aptra;

import java.sql.Time;

import javax.swing.UnsupportedLookAndFeelException;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

import git_aptra.Login.DialogLogin;

public class Steuerung {
	//METHODE: main
	public static void main(String[] args) {	
		try {
			Design.aluminiumLook();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new DialogLogin();
	}	
}

