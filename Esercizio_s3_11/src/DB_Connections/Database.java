package DB_Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.esercizio_11.Student;

public class Database {
	String url = "jdbc:postgresql://localhost:5432/";
    String dbName = "db_s3g2";
    String user = "postgres";
    String pass = "root";
    Statement st;

    public Database() throws SQLException {
        Connection conn = DriverManager.getConnection(url+dbName, user, pass);
        Statement st = conn.createStatement();
        createTable();
        System.out.println("Connected to DATABASE");
    }
    
    
    
    public void createTable() throws SQLException {
		String sql =  " CREATE TABLE IF NOT EXISTS students ("
					+ "		id SERIAL PRIMARY KEY,"
					+ " 	name VARCHAR NOT NULL,"
					+ "		lastname VARCHAR NOT NULL,"
					+ "     gender VARCHAR NOT NULL,"
					+ "		birthdate DATE NOT NULL,"
					+ "		avg DECIMAL,"
					+ "     min_vote DECIMAL,"
					+ "     max_vote DECIMAL,"
					+ " );" ;
		st.executeUpdate(sql);
		System.out.println("Table utenti created!!!");
	}
    
    
    public void insertStudent(Student studente) throws SQLException {
		String sql = " INSERT INTO studenti (name, lastname, gender, birthdate, avg, min_vote, max_vote) "
				   + "VALUES ('"
				   + studente.getName()+"', '"
				   + studente.getLastname()+"', "
				   + studente.getBirthdate()+"', "
				   + studente.getGender()+"', "
				   + studente.getAvg()+"', "
				   + studente.getMin_vote()+"', "
				   + studente.getMin_vote()+"');" ;
		st.executeUpdate(sql);
		System.out.println(studente.getName() + " " + studente.getLastname() + " created!!!");
	}
    
    
    public void updateStudent(Student studente) throws SQLException {
		String sql = "UPDATE studenti SET "
				   + " nome = '" + studente.getName() + "', "
				   + " cognome = '" + studente.getLastname() + "', "
				   + " anni = " + studente.getBirthdate() + "', "
				   + " gender = '" + studente.getGender() + "', "
				   + " average = '" + studente.getAvg() + "', "
				   + " min_vote = '" + studente.getMin_vote() + "', "
				   + " max_vote = '" + studente.getMax_vote() + "', "
				   + " WHERE id = " + studente.getId() + "'; ";
		st.executeUpdate(sql);
		System.out.println(studente.getName() + " " + studente.getLastname() + " udpate!!!");
	}
    
    public void deleteStudent(Student studente) throws SQLException {
		String sql = "DELETE FROM Students WHERE id = " 
					+ studente.getId();
		st.executeUpdate(sql);
		System.out.println(studente.getName() + " " + studente.getLastname() + " deleted!!!");
	}
    
    
    
    
    
    
    
}
