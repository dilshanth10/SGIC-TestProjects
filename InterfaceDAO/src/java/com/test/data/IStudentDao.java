package com.test.data;

import com.test.model.Student;
import java.util.List;

public interface IStudentDao {

    public List<Student> getAllStudents();

    public Student getStudent(int rollNo);

    public void updateStudent(Student student);

    public void deleteStudent(Student student);
}
