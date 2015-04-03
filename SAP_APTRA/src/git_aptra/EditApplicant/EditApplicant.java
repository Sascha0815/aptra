package git_aptra.EditApplicant;

import git_aptra.MenuBar.MenuBarPanelApplicant;

public class EditApplicant {
	private static String DataSetApplicantID;
	private static String DataSetName;
	private static String DataSetFirstName;
	private static String DataSetStreet;
	private static String DataSetHouseNr;
	private static String DataSetPostalCode;
	private static String DataSetCity;
	private static String DataSetTelefonHome;
	private static String DataSetTelefonMobil;
	private static String DataSetEmail;
	private static String DataSetVacancy;
	private static String DataSetDate;
	private static int DataSetDay;
	private static int DataSetMonth;
	private static int DataSetYear;
	private static String DataSetEducationalAchievement;

	public static void getSelectedRow() {
		DataSetName = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(
				MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 1);

		DataSetFirstName = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						2);
		DataSetStreet = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						3);
		DataSetHouseNr = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						4);
		DataSetPostalCode = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						5);
		DataSetCity = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(
				MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 6);

		DataSetTelefonHome = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						7);
		DataSetTelefonMobil = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						8);
		DataSetEmail = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						9);
		DataSetVacancy = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						10);
		DataSetDate = (String) MenuBarPanelApplicant.tableApplicant.getValueAt(
				MenuBarPanelApplicant.tableApplicant.getSelectedRow(), 11);
		String[] split = DataSetDate.split("-");
		DataSetYear = Integer.parseInt(split[0].toString());
		DataSetMonth = Integer.parseInt(split[1].toString());
		DataSetDay = Integer.parseInt(split[2].toString());
		DataSetEducationalAchievement = (String) MenuBarPanelApplicant.tableApplicant
				.getValueAt(
						MenuBarPanelApplicant.tableApplicant.getSelectedRow(),
						12);
	}

	public static String getDataSetVacancyID(){
		return DataSetApplicantID;
	}
	public static String getDataSetName() {
		return DataSetName;
	}

	public static String getDataSetFirstName() {
		return DataSetFirstName;
	}

	public static String getDataSetStreet() {
		return DataSetStreet;
	}

	public static String getDataSetHouseNr() {
		return DataSetHouseNr;
	}

	public static String getDataSetPostalCode() {
		return DataSetPostalCode;
	}

	public static String getDataSetCity() {
		return DataSetCity;
	}

	public static String getDataSetTelefonHome() {
		return DataSetTelefonHome;
	}

	public static String getDataSetTelefonMobil() {
		return DataSetTelefonMobil;
	}

	public static String getDataSetEmail() {
		return DataSetEmail;
	}

	public static String getDataSetVacancy() {
		return DataSetVacancy;
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

	public static String getDataSetApplicantID() {
		return null;
	}

}
