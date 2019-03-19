package models;

import daos.DTOInterface;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exam implements DTOInterface {
    private String studentName;
    private String testName;
    private int score;
    @Id
    @GeneratedValue
    private Integer id;
    private static int currentID;

    public Exam(String studentName, String testName, int score) {
        this.studentName = studentName;
        this.testName = testName;
        this.score = score;
        this.id = currentID++;
    }

    public Exam() {
        this.id = currentID++;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getTestName() {
        return testName;
    }

    public int getScore() {
        return score;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }
    public static void setCurrentID(int currentID) {
        Exam.currentID = currentID;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "studentName='" + studentName + '\'' +
                ", testName='" + testName + '\'' +
                ", score=" + score +
                ", id=" + id +
                '}';
    }

}
