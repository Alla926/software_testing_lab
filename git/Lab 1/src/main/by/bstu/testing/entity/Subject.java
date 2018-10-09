package main.by.bstu.testing.entity;

public class Subject {
    public Subject() {
    }

    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;
        return description != null ? description.equals(subject.description) : subject.description == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
