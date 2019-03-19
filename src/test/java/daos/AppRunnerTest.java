package daos;

import models.Exam;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AppRunnerTest {
    AppRunner appRunner;
    @Before
    public void setUp() throws Exception {
        appRunner = new AppRunner();
        Exam.setCurrentID(20);
    }

    @After
    public void tearDown() throws Exception {
        List<Exam> exams = appRunner.findAll();
        if (exams.size() > 19) {
            for (Exam exam : exams) {
                if (exam.getId() > 19) {
                    appRunner.delete(exam.getId());
                }
            }
        }
    }

    @Test
    public void findById() {
        String expected = "Exam{studentName='student1', testName='test1', score=10, id=1}";
        Exam exam = appRunner.findById(1);
        String actual = exam.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findById12() {
        String expected = "Exam{studentName='student12', testName='test12', score=120, id=12}";
        Exam exam = appRunner.findById(12);
        String actual = exam.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        int expected = 20;
        int actual = appRunner.findAll().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void create() {
        int expectedBefore = 20;
        int actualBefore = appRunner.findAll().size();
        appRunner.create(new Exam());
        int expectedAfter = 21;
        int actualAfter = appRunner.findAll().size();
        Assert.assertEquals(expectedBefore, actualBefore);
        Assert.assertEquals(expectedAfter, actualAfter);
    }

    @Test
    public void update() {
        String expectedBefore = "student0";
        String nameBefore = appRunner.findById(0).getStudentName();
        Exam.setCurrentID(0);
        Exam newExam = new Exam();
        newExam.setStudentName("newName");
        appRunner.update(newExam);
        String nameAfter = appRunner.findById(0).getStudentName();
        String expectedAfter = "newName";
        Exam.setCurrentID(0);
        newExam = new Exam("student0", "test0", 0);
        appRunner.update(newExam);
        Assert.assertEquals(expectedBefore, nameBefore);
        Assert.assertEquals(expectedAfter, nameAfter);
    }

    @Test
    public void delete() {
        int expectedBefore = 20;
        int actualBefore = appRunner.findAll().size();
        appRunner.delete(0);
        int expectedAfter = 19;
        int actualAfter = appRunner.findAll().size();
        Exam.setCurrentID(0);
        appRunner.create(new Exam("student0", "test0", 0));
        //appRunner.findAll().forEach(System.out::println);
        Assert.assertEquals(expectedBefore, actualBefore);
        Assert.assertEquals(expectedAfter, actualAfter);
    }
}