import main.by.bstu.testing.entity.Assessment;
import main.by.bstu.testing.entity.Student;
import main.by.bstu.testing.entity.StudentGroup;
import main.by.bstu.testing.entity.Subject;
import main.by.bstu.testing.service.StudentService;
import main.by.bstu.testing.service.impl.StudentServiceImpl;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImplTest {
    private StudentService studentService = new StudentServiceImpl();

    @Test
    public void getStudentAverageAssessmentTest() {
        List<Assessment> assessments = new ArrayList<>();
        assessments.add(new Assessment(new Subject("math", "some description"), 10));
        assessments.add(new Assessment(new Subject("geography", "some description"), 6));
        assessments.add(new Assessment(new Subject("literature", "some description"), 5));
        assessments.add(new Assessment(new Subject("biology", "some description"), 8));
        Student student = new Student("Veronika", "Fedorets", 22, "+375444563231", LocalDate.of(1995, 10, 3), assessments);
        double average = studentService.getStudentAverageAssessment(student);
        System.out.println(average);
        Assert.assertEquals(average, 7.0, 8.0);
    }

    @Test
    public void getStudentGroupAverageAssessmentTest() {
        List<Assessment> veronikaAssessments = new ArrayList<>();
        veronikaAssessments.add(new Assessment(new Subject("math", "some description"), 10));
        veronikaAssessments.add(new Assessment(new Subject("geography", "some description"), 6));
        veronikaAssessments.add(new Assessment(new Subject("literature", "some description"), 5));
        veronikaAssessments.add(new Assessment(new Subject("biology", "some description"), 8));
        Student veronika = new Student("Veronika", "Fedorets", 22, "+375444563231", LocalDate.of(1995, 10, 3), veronikaAssessments);


        List<Assessment> alexAssessments = new ArrayList<>();
        alexAssessments.add(new Assessment(new Subject("math", "some description"), 10));
        alexAssessments.add(new Assessment(new Subject("geography", "some description"), 6));
        alexAssessments.add(new Assessment(new Subject("literature", "some description"), 5));
        alexAssessments.add(new Assessment(new Subject("biology", "some description"), 8));
        Student alex = new Student("Veronika", "Fedorets", 22, "+375444563231", LocalDate.of(1995, 10, 3), alexAssessments);


        StudentGroup group =new StudentGroup();
        List<Student> students = new ArrayList<>();
        students.add(veronika);
        students.add(alex);
        group.setStudents(students);
        double average = studentService.getStudentGroupAverageAssessment(group);
        System.out.println(average);
        Assert.assertEquals(average, 7.0, 8.0);
    }

	//commit1 - branch master
	//commit2 - branch master
	//commit3 - branch master
	
	//commit1 - branch develop
    //commit2 - branch develop
	
	//develop changes
	
}
