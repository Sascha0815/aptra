package git_aptra.EditVacancy;

import git_aptra.MenuBar.MenuBarPanelVacancy;

public class EditVacancy {
	private static String DataSetVacancyID;
	private static String DataSetPosition;
	private static String DataSetArea;
	private static String DataSetRequirementLevel;
	private static String DataSetTermsOfEmployment;
	private static String DataSetVacancyStatus;
	private static String DataSetEducationalAchievement;
	private static String DataSetLevel;
	private static String DataSetDate;
	private static int DataSetDay;
	private static int DataSetMonth;
	private static int DataSetYear;

	public static void getSelectedRow() {
		//DataSetVacancyID = (String) MenuBarPanelWorkplace.tableJob.getValueAt(
		//		MenuBarPanelWorkplace.tableJob.getSelectedRow(), ...);
		DataSetPosition = (String) MenuBarPanelVacancy.tableJob.getValueAt(
				MenuBarPanelVacancy.tableJob.getSelectedRow(), 1);
		DataSetArea = (String) MenuBarPanelVacancy.tableJob.getValueAt(
				MenuBarPanelVacancy.tableJob.getSelectedRow(), 2);
		DataSetRequirementLevel = (String) MenuBarPanelVacancy.tableJob
				.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 3);
		DataSetTermsOfEmployment = (String) MenuBarPanelVacancy.tableJob
				.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 4);
		DataSetVacancyStatus = (String) MenuBarPanelVacancy.tableJob
				.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 5);
		DataSetEducationalAchievement = (String) MenuBarPanelVacancy.tableJob
				.getValueAt(MenuBarPanelVacancy.tableJob.getSelectedRow(), 6);
		DataSetLevel = (String) MenuBarPanelVacancy.tableJob.getValueAt(
				MenuBarPanelVacancy.tableJob.getSelectedRow(), 7);
		DataSetDate = (String) MenuBarPanelVacancy.tableJob.getValueAt(
				MenuBarPanelVacancy.tableJob.getSelectedRow(), 8);
		String[] split = DataSetDate.split("-");
		DataSetYear = Integer.parseInt(split[0].toString());
		DataSetMonth = Integer.parseInt(split[1].toString());
		DataSetDay = Integer.parseInt(split[2].toString());
	}
	public static String getDataSetVacancyID(){
		return DataSetVacancyID;
	}

	public static String getDataSetPosition() {
		return DataSetPosition;
	}

	public static String getDataSetArea() {
		return DataSetArea;
	}

	public static String getDataSetRequirementLevel() {
		return DataSetRequirementLevel;
	}

	public static String getDataSetTermsOfEmployment() {
		return DataSetTermsOfEmployment;
	}

	public static String getDataSetVacancyStatus() {
		return DataSetVacancyStatus;
	}

	public static String getDataSetLevel() {
		return DataSetLevel;
	}

	public static String getDataSetEducationalAchievement() {
		return DataSetEducationalAchievement;
	}

	public static int getDataSetYear() {
		return DataSetYear;
	}

	public static int getDataSetMonth() {
		return DataSetMonth;
	}

	public static int getDataSetDay() {
		return DataSetDay;
	}
}
