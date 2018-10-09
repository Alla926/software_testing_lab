package main.by.bstu.testing.service.impl;

import main.by.bstu.testing.entity.Assessment;
import main.by.bstu.testing.entity.Student;
import main.by.bstu.testing.entity.StudentGroup;
import main.by.bstu.testing.service.StudentService;

public class StudentServiceImpl implements StudentService {
    @Override
    public double getStudentAverageAssessment(Student student) {
        double average = 0;
        int sum = 0;
        for (Assessment assessment: student.getAssessments()){
            sum += assessment.getValue();
        }
        average = sum / student.getAssessments().size();
        return average;
    }

    @Override
    public double getStudentGroupAverageAssessment(StudentGroup studentGroup) {
        double average = 0;
        double sum = 0;
        for (Student student: studentGroup.getStudents()){
            sum += getStudentAverageAssessment(student);
        }
        average = sum / studentGroup.getStudents().size();
        return average;
    }
}
