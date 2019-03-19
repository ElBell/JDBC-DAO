package daos;

import models.Exam;

import java.util.List;

public interface TestDao {
    Exam findById(Integer id);
    List<Exam> findAll();
    boolean create(Exam exam);
    boolean update(Exam exam);
    boolean delete(Integer id);
}
