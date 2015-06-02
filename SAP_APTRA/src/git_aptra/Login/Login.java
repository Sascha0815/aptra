package git_aptra.Login;

import git_aptra.AddApplicant.InsertApplicantDataIntoTable;
import git_aptra.AddVacancy.InsertVacancyDataIntoTable;
import git_aptra.Meeting.InsertMeetingDataIntoTable;
import git_aptra.MenuBar.MenuBarPanelApplicant;
import git_aptra.MenuBar.MenuBarPanelMeeting;
import git_aptra.MenuBar.MenuBarPanelVacancy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


public class Login {
	private static int entitlement;
	private static int ID;
	private static int divisionID;
	private static Connection con;
	
	@SuppressWarnings("rawtypes")
	public static int login(String username, String password) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/aptra", "aptra", "bermudadreieck");
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT entitlement, employeeID, divisionID from employee where BINARY loginName = '" +  username + "' AND BINARY password = '" +  password +"'" );
		    while (rs.next()) {
		        entitlement = rs.getInt(1);
		        ID = rs.getInt(2);
		        divisionID = rs.getInt(3);
				Vector resultsApplicant = InsertApplicantDataIntoTable.insertApplicantDataIntoTable();
				MenuBarPanelApplicant.modelPool.setDataVector(resultsApplicant,MenuBarPanelApplicant.COLUMN_IDENTIFIERS_APPLICANT);
				MenuBarPanelApplicant.modelPool.fireTableDataChanged();
				Vector resultsVacancy = InsertVacancyDataIntoTable.insertVacancyDataIntoTable();
				MenuBarPanelVacancy.modelJob.setDataVector(resultsVacancy,MenuBarPanelVacancy.COLUMN_IDENTIFIERS_JOB);
				MenuBarPanelVacancy.modelJob.fireTableDataChanged();		
				Vector resultsMeeting = InsertMeetingDataIntoTable.insertMeetingDataIntoTable();
				MenuBarPanelMeeting.modelEmployeeMeeting.setDataVector(resultsMeeting,MenuBarPanelMeeting.COLUMN_IDENTIFIERS_VACANCYMANAGEMENT);
				MenuBarPanelMeeting.modelEmployeeMeeting.fireTableDataChanged();
		        return entitlement;
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public static int getID(){
		return ID;
	}
	
	public static int getEntitlement(){
		return entitlement;
	}
	
	public static Connection getConnection(){
		return con;
	}
	
	public static int getDivisionID(){
		return divisionID;
	}
	

}
