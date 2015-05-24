package git_aptra.InfoVacancy;

import git_aptra.MenuBar.MenuBarPanelVacancy;

public class InfoVacancy {
	private static String dataSetVacancyID;
	private static String dataSetPosition;
	private static String dataSetArea;
	private static String dataSetRequirementLevel;
	private static String dataSetTermsOfEmployment;
	private static String dataSetVacancyStatus;
	private static String dataSetEducationalAchievement;
	private static String dataSetLevel;
	private static String dataSetDate;

	public static void getVacancyInfo(){
		dataSetVacancyID = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 0);
		dataSetPosition = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 1);
		dataSetArea = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 2);
		dataSetRequirementLevel = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 3);
		dataSetTermsOfEmployment = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 4);
		dataSetVacancyStatus = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 5);
		dataSetEducationalAchievement = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 6);
		dataSetLevel = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 7);
		dataSetDate = (String) MenuBarPanelVacancy.tableJob.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 8);
	}
	
	public static String getDataSetVacancyID() {
		return dataSetVacancyID;
	}
	
	public static String getDataSetPosition() {
		return dataSetPosition;
	}

	public static String getDataSetArea() {
		return dataSetArea;
	}

	public static String getDataSetRequirementLevel() {
		return dataSetRequirementLevel;
	}

	public static String getDataSetTermsOfEmployment() {
		return dataSetTermsOfEmployment;
	}

	public static String getDataSetVacancyStatus() {
		return dataSetVacancyStatus;
	}

	public static String getDataSetEducationalAchievement() {
		return dataSetEducationalAchievement;
	}

	public static String getDataSetLevel() {
		return dataSetLevel;
	}

	public static String getDataSetDate() {
		return dataSetDate;
	}
}
