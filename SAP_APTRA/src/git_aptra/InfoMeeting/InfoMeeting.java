package git_aptra.InfoMeeting;

import git_aptra.MenuBar.MenuBarPanelMeeting;


public class InfoMeeting {
	private static String dataSetPosition;
	private static String dataSetArea;
	private static String dataSetMeetingID;
	private static String dataSetApplicantID;
	private static String dataSetName;
	private static String dataSetFirstName;
	private static String dataSetTypeMeeting;
	private static String dataSetLocation;
	private static String dataSetDate;
	private static String dataSetTime;
	
	public static void getMeetingInfo(){
		dataSetPosition = (String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(), 0);
		dataSetArea = (String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(), 1);
		dataSetMeetingID = (String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(),2);
		dataSetApplicantID = (String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(),3);
		dataSetName = (String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(),4);
		dataSetFirstName = (String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(),5);
		dataSetTypeMeeting = (String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(), 6);
		dataSetLocation = (String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(),7);
		dataSetDate = (String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(),8);
		dataSetTime = (String) MenuBarPanelMeeting.tableEmployeeMeeting.getValueAt(MenuBarPanelMeeting.tableEmployeeMeeting.getSelectedRow(),9);
	}
	
	public static String getDataSetApplicantID() {
		return dataSetApplicantID;
	}
	
	public static String getDataSetName() {
		return dataSetName;
	}

	public static String getDataSetFirstName() {
		return dataSetFirstName;
	}

	public static String getDataSetPosition() {
		return dataSetPosition;
	}

	public static String getDataSetArea() {
		return dataSetArea;
	}

	public static String getDataSetMeetingID() {
		return dataSetMeetingID;
	}

	public static String getDataSetTypeMeeting() {
		return dataSetTypeMeeting;
	}

	public static String getDataSetDate() {
		return dataSetDate;
	}

	public static String getDataSetTime() {
		return dataSetTime;
	}	
	
	public static String getDataSetLocation() {
		return dataSetLocation;
	}	
}
