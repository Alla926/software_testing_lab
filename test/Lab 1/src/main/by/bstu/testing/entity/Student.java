package main.by.bstu.testing.entity;

import java.time.LocalDate;
import java.util.List;

public class Student {
    public Student() {
    }

    public Student(String name, String surname, int age, String phone, LocalDate birthDate, List<Assessment> assessments) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.birthDate = birthDate;
        this.assessments = assessments;
    }

    private String name;
    private String surname;
    private int age;
    private String phone;
    private LocalDate birthDate;
    private List<Assessment> assessments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
        if (phone != null ? !phone.equals(student.phone) : student.phone != null) return false;
        if (birthDate != null ? !birthDate.equals(student.birthDate) : student.birthDate != null) return false;
        return assessments != null ? assessments.equals(student.assessments) : student.assessments == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (assessments != null ? assessments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                ", notes=" + assessments +
                '}';
    }
}
