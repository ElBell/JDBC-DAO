package daos;

import models.Exam;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("All")
public class AppRunner implements TestDao {
    private static final String FIND_BY_ID = "SELECT * FROM tests WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM tests ORDER BY id";
    private static final String UPDATE = "UPDATE tests SET student_name=?, test_name=?, score=? WHERE id=?";
    private static final String CREATE = "INSERT INTO tests (student_name, test_name, score, id) VALUES (?, ?, ?, ?)";
    private static final String DELETE = "DELETE FROM tests WHERE id=?";

    public Exam findById(Integer id) {
        Connection connection = Connector.getConnection();
        Exam exam = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultStatment = preparedStatement.executeQuery();
            if (resultStatment.next()) {
                exam = new Exam();
                exam.setStudentName(resultStatment.getString("student_name"));
                exam.setTestName(resultStatment.getString("test_name"));
                exam.setScore(resultStatment.getInt("score"));
                exam.setId(resultStatment.getInt("id"));
            }
            resultStatment.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exam;
    }

    public List<Exam> findAll() {
        List<Exam> exams = new LinkedList<>();
        Connection connection = Connector.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultStatment = statement.executeQuery(FIND_ALL);
            Exam exam = null;
            while (resultStatment.next()) {
                exam = new Exam();
                exam.setStudentName(resultStatment.getString("student_name"));
                exam.setTestName(resultStatment.getString("test_name"));
                exam.setScore(resultStatment.getInt("score"));
                exam.setId(resultStatment.getInt("id"));

                exams.add(exam);
            }
            resultStatment.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exams;
    }

    @SuppressWarnings("Duplicates")
    public boolean create(Exam exam) {
        Connection connection = Connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, exam.getStudentName());
            preparedStatement.setString(2, exam.getTestName());
            preparedStatement.setInt(3, exam.getScore());
            preparedStatement.setInt(4, exam.getId());
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @SuppressWarnings("Duplicates")
    public boolean update(Exam exam) {
        Connection connection = Connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, exam.getStudentName());
            preparedStatement.setString(2, exam.getTestName());
            preparedStatement.setInt(3, exam.getScore());
            preparedStatement.setInt(4, exam.getId());
            int i = preparedStatement.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean delete(Integer id) {
        Connection connection = Connector.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            int i = preparedStatement.executeUpdate();
            preparedStatement.close();
            if(i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
