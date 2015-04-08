package git_aptra.EditVacancyManagement;

import git_aptra.MenuBar.MenuBarPanelVacancyManagement;
import git_aptra.ResponsePDF.Rejection;

public class ResponseControl {
	
	public static void control(String type, int id){
		System.out.println(id);
		switch (type) {
		case "absage":
			//Rejection.rejection(id);
			break;

		default:
			break;
		}
	}

}
