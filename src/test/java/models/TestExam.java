package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestExam {

    @Before
    public void setUp() {
        Exam.setCurrentID(0);
    }

    @Test
    public void test_getStudentName() {
        Exam exam = new Exam();
        exam.setStudentName("test1");
        String expected = "test1";
        String actual = exam.getStudentName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_getTestName() {
        Exam exam = new Exam();
        exam.setTestName("test1");
        String expected = "test1";
        String actual = exam.getTestName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_getScore() {
        Exam exam = new Exam();
        exam.setScore(10);
        int expected = 10;
        int actual = exam.getScore();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_getId() {
        Exam exam = new Exam();
        Exam exam1 = new Exam();
        Exam exam2 = new Exam();
        int expected = 2;
        int actual = exam2.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_getCurrentID() {
        Exam exam = new Exam();
        Exam exam1 = new Exam();
        Exam exam2 = new Exam();
        int expected = 3;
        int actual = Exam.getCurrentID();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_toString() {
        Exam exam = new Exam("student", "name", 10);
        String expected = "Exam{studentName='student', testName='name', score=10, id=0}";
        String actual = exam.toString();
        Assert.assertEquals(expected, actual);
    }
}