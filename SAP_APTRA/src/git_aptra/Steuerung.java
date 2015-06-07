package git_aptra;

import javax.swing.UnsupportedLookAndFeelException;


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
		new Oberflaeche();
	}	
}

