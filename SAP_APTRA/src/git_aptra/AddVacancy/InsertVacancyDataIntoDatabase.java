package git_aptra.AddVacancy;

import git_aptra.Login.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertVacancyDataIntoDatabase {
	public static void insertVacancyData() throws SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO vacancy"
				+ "(position, area, requirementLevel, termsOfEmployment, educationalAchievement, level, date) VALUES"
				+ "(?,?,?,?,?,?,?)";
		try {
			dbConnection = Login.getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, DialogAddVacancyGeneral.getPosition());
			preparedStatement.setString(2, DialogAddVacancyGeneral.getArea());
			preparedStatement.setString(3, DialogAddVacancyGeneral.getRequirementLevel());
			preparedStatement.setString(4, DialogAddVacancyGeneral.getTermsOfEmployment());
			preparedStatement.setString(5, DialogAddVacancyGeneral.getEducationalAchievementVacancy());
			preparedStatement.setString(6, DialogAddVacancySpecification.getLevel());
			preparedStatement.setDate(7, new java.sql.Date(DialogAddVacancySpecification.getCalVacancy().getTimeInMillis()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Datenbank - insert VacancyData"
					+ e.getMessage());
		}
	}
	
	public static void insertVacancyevaluationData(){
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		int number = DialogAddVacancySelection.tableSelection.getSelectedRowCount();
		int VID = 0;
		int  rows[] = DialogAddVacancySelection.tableSelection.getSelectedRows();
		try {
			Connection con =  Login.getConnection();
			Statement stmt =  con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT max(vacancyID) from vacancy" );
		    while (rs.next()) {
		        VID = rs.getInt(1);
		    }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		for (int i = 0; i < number; i++) {
			String query = "INSERT INTO vacancyevaluation"
					+ "(evaluationID, vacancyID, weighting, notation) VALUES"
					+ "(?,?,?,?)";
			
			Object objectSeid = DialogAddVacancySelection.tableSelection.getValueAt(rows[i], 0);
			String seid = String.valueOf(objectSeid);
			int eid = Integer.parseInt(seid);
			int weighting = 0;
			Object objectSweighting;
			objectSweighting = DialogAddVacancySelection.tableSelection.getValueAt(rows[i], 2);
			weighting = Integer.parseInt((String) objectSweighting);
			Object objectNotation;
			objectNotation = DialogAddVacancySelection.tableSelection.getValueAt(rows[i], 1);
			String notation = String.valueOf(objectNotation);
			
			
			try {
				dbConnection = Login.getConnection();
				preparedStatement = dbConnection.prepareStatement(query);
				preparedStatement.setInt(1, eid); 
				preparedStatement.setInt(2, VID);
				preparedStatement.setInt(3, weighting);
				preparedStatement.setString(4, notation);
						
				
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Datenbank - insert rating data"
						+ e.getMessage());
			}
		}

	}
	}
		    
