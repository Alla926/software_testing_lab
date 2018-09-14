package main.by.bstu.testing.service;

import main.by.bstu.testing.entity.Student;
import main.by.bstu.testing.entity.StudentGroup;

public interface StudentService {
    double getStudentAverageAssessment(Student student);

    double getStudentGroupAverageAssessment(StudentGroup studentGroup);
}
