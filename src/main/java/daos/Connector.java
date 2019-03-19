package daos;

import com.mysql.jdbc.Driver;
import models.Exam;

import java.sql.*;
import java.util.List;

/**
 * Connect to Database
 * @author hany.said
 */
public class Connector {
    public static final String URL = "jdbc:mysql://localhost:3306/test_db?useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String USER = "test_user";
    public static final String PASS = "password123";
    /**
     * Get a connection to database
     * @return Connection object
     */
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
    /**
     * Exam Connection
     */
    public static void main(String[] args) throws SQLException {
        AppRunner appRunner = new AppRunner();
//        Exam.setCurrentID(0);
//        for (int i = 0; i < 2; i++) {
//            appRunner.create(new Exam("student" + i, "test" + i, i*10));
//        }
        System.out.println("first test" + appRunner.findById(0));
        List<Exam> allExams = appRunner.findAll();
        for (Exam exam : allExams) {
            System.out.println(exam);
        }
    }
//
//    Connection connection = null;
//    Statement stmt = null;
//    ResultSet rs = null;
//        try {
//        connection = DriverManager.getConnection(URL, USER, PASS);
//        stmt = connection.createStatement();
//        rs = stmt.executeQuery("SELECT * FROM tests");
//        //rs.last();
//        while (rs.next()) {
//            System.out.println(rs.getString("student_name") +
//                    rs.getString("test_name") +
//                    rs.getInt("score") +
//                    rs.getLong("id"));
//        }
//        System.out.println("Connection established to database");
//    } catch (SQLException ex) {
//        throw new RuntimeException("Error connecting to the database", ex);
//    } finally {
//        if (connection != null) {
//            connection.close();
//        }
//    }

}