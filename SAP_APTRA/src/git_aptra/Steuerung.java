package git_aptra;

import javax.swing.UnsupportedLookAndFeelException;


import git_aptra.Login.DialogLogin;

//Startklasse
public class Steuerung {
	//METHODE: main
	public static void main(String[] args) {	
		try {
			Design.aluminiumLook();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new DialogLogin();
	}	
}

