package se.iths;

import java.sql.Connection;

public class Constants {
    public final static String JDBC_Connection = "jdbc:mysql://localhost:3306/iths";
    public final static String JDBC_User = "iths";
    public final static String JDBC_PASSWORD = "iths";
    public final static String SQL_SELECT_ALL_STUDENTS = "SELECT StudentId, FirstName, LastName FROM Student";
    public final static String SQL_COL_STUDENT_ID = "StudentId";
    public final static String SQL_COL_STUDENT_FIRSTNAME = "FirstName";
    public final static String SQL_COL_STUDENT_LASTNAME = "LastName";
    public final static String SQL_SELECT_SCHOOL_FOR_STUDENTS = "SELECT SchoolId, Name, City,FirstName, LastName FROM StudentSchool JOIN Student USING (StudentId) JOIN School USING (SchoolId) WHERE StudentId = ?";
    public final static String SQL_COL_SCHOOL_NAME = "Name";
    public final static String SQL_COL_SCHOOL_ID = "SchoolId";
    public final static String SQL_COL_SCHOOL_CITY = "City";
    public static Connection con = null;

}
