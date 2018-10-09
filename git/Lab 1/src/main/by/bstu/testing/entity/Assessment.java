package main.by.bstu.testing.entity;

public class Assessment {
    public Assessment() {
    }

    public Assessment(Subject subject, int note) {
        this.subject = subject;
        this.value = note;
    }

    private Subject subject;
    private int value;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assessment note1 = (Assessment) o;

        if (value != note1.value) return false;
        return subject != null ? subject.equals(note1.subject) : note1.subject == null;
    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "subject=" + subject +
                ", note=" + value +
                '}';
    }
}
