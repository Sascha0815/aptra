package git_aptra.DialogEditVacancy;

import git_aptra.MenuBar.MenuBarPanelWorkplace;

public class EditVacancy {
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
		DataSetPosition = (String) MenuBarPanelWorkplace.tableJob.getValueAt(
				MenuBarPanelWorkplace.tableJob.getSelectedRow(), 1);
		DataSetArea = (String) MenuBarPanelWorkplace.tableJob.getValueAt(
				MenuBarPanelWorkplace.tableJob.getSelectedRow(), 2);
		DataSetRequirementLevel = (String) MenuBarPanelWorkplace.tableJob
				.getValueAt(MenuBarPanelWorkplace.tableJob.getSelectedRow(), 3);
		DataSetTermsOfEmployment = (String) MenuBarPanelWorkplace.tableJob
				.getValueAt(MenuBarPanelWorkplace.tableJob.getSelectedRow(), 4);
		DataSetVacancyStatus = (String) MenuBarPanelWorkplace.tableJob
				.getValueAt(MenuBarPanelWorkplace.tableJob.getSelectedRow(), 5);
		DataSetEducationalAchievement = (String) MenuBarPanelWorkplace.tableJob
				.getValueAt(MenuBarPanelWorkplace.tableJob.getSelectedRow(), 6);
		DataSetLevel = (String) MenuBarPanelWorkplace.tableJob.getValueAt(
				MenuBarPanelWorkplace.tableJob.getSelectedRow(), 7);
		DataSetDate = (String) MenuBarPanelWorkplace.tableJob.getValueAt(
				MenuBarPanelWorkplace.tableJob.getSelectedRow(), 8);
		String[] split = DataSetDate.split("-");
		DataSetYear = Integer.parseInt(split[0].toString());
		DataSetMonth = Integer.parseInt(split[1].toString());
		DataSetDay = Integer.parseInt(split[2].toString());
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
