package com.esercizio_11;

import java.sql.SQLException;
import java.time.LocalDate;

import DB_Connections.Database;

public class MainProject {

	public static void main(String[] args) {
		try {
			Database db = new Database();
			
			Student s1 = new Student("Marco", "Nos", Gender.MALE, LocalDate.of(1993, 4, 6), 7.0, 7.0, 4.0);
			Student s2 = new Student("Giulia", "Accro", Gender.FEMALE, LocalDate.of(1999, 4, 4), 9.0, 6.0, 4.0);
			
			db.insertStudent(s1);
			db.insertStudent(s2);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
