package se.iths;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import static se.iths.Constants.*;

public class App {
    public static void main(String[] args) throws SQLException {
        App app = new App();
        try {
            app.load();
        } catch (SQLException e) {
            System.err.printf("Något gick fel vid inläsning av databas! (%s)%n", e);
        }
    }

    private void load() throws SQLException {
        Collection<Student> students = loadStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private Collection<Student> loadStudents() throws SQLException {
        Collection<Student> students = new ArrayList<>();
        Connection con = DriverManager.getConnection(JDBC_Connection, JDBC_User, JDBC_PASSWORD);
        ResultSet rs = con.createStatement().executeQuery(SQL_SELECT_ALL_STUDENTS);
        while (rs.next()) {
            int studentId = (int) rs.getLong(SQL_COL_STUDENT_ID);
            String lastName = rs.getString(SQL_COL_STUDENT_FIRSTNAME);
            String firstName = rs.getString(SQL_COL_STUDENT_LASTNAME);
            Student student = new Student(studentId, firstName, lastName);
            students.add(student);
            Collection<School> schools = loadSchools(student.getStudentId());
            for (School school : schools) {
                student.add(school);
            }
        }
        rs.close();
        con.close();
        return students;
    }

    private Collection<School> loadSchools(long studentId) throws SQLException {
        Connection con = DriverManager.getConnection(JDBC_Connection, JDBC_User, JDBC_PASSWORD);
        Collection<School> schools = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement(SQL_SELECT_SCHOOL_FOR_STUDENTS);
        stmt.setLong(1, studentId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int schoolId = (int) rs.getLong(SQL_COL_SCHOOL_ID);
            String name = rs.getString(SQL_COL_SCHOOL_NAME);
            String city = rs.getString(SQL_COL_SCHOOL_CITY);
            School school = new School(schoolId, name, city);
            schools.add(school);
        }
        rs.close();
        stmt.close();
        con.close();
        return schools;
    }


}