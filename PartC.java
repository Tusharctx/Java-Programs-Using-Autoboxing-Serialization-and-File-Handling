import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int id;
    String designation;
    double salary;

    Employee(String name, int id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }

    void display() {
        System.out.println(id + " " + name + " " + designation + " " + salary);
    }
}

public class PartC {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String file = "employees.ser";

        while (true) {
            System.out.println("1. Add Employee  2. Display All  3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Designation: ");
                String desig = sc.nextLine();
                System.out.print("Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                Employee emp = new Employee(name, id, desig, salary);

                try (FileOutputStream fos = new FileOutputStream(file, true);
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(emp);
                }

            } else if (choice == 2) {
                try (FileInputStream fis = new FileInputStream(file);
                     ObjectInputStream ois = new ObjectInputStream(fis)) {

                    while (true) {
                        try {
                            Employee emp = (Employee) ois.readObject();
                            emp.display();
                        } catch (EOFException e) {
                            break;
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("No records found.");
                }

            } else if (choice == 3) {
                break;
            }
        }
        sc.close();
    }
}
