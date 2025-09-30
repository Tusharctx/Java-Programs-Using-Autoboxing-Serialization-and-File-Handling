//Serialization and Deserialization
import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    String grade;

    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
}

public class PartB {
    public static void main(String[] args) throws Exception {
        String file = "student.ser";

        Student s1 = new Student(101, "Tushar", "A");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(s1);
        out.close();
        System.out.println("Student object serialized.");

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Student s2 = (Student) in.readObject();
        in.close();
        System.out.println("Student object deserialized:");
        s2.display();
    }
}
