package main.by.bstu.testing.entity;

import java.util.List;

public class StudentGroup {
    public StudentGroup() {
    }

    public StudentGroup(int number, List<Student> students, Student head) {
        this.number = number;
        this.students = students;
        this.head = head;
    }
    private int number;
    private List<Student> students;
    private Student head;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getHead() {
        return head;
    }

    public void setHead(Student head) {
        this.head = head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentGroup that = (StudentGroup) o;

        if (number != that.number) return false;
        if (students != null ? !students.equals(that.students) : that.students != null) return false;
        return head != null ? head.equals(that.head) : that.head == null;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (students != null ? students.hashCode() : 0);
        result = 31 * result + (head != null ? head.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "number=" + number +
                ", students=" + students +
                ", head=" + head +
                '}';
    }
}
