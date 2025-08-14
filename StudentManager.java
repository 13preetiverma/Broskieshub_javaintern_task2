import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    private int id;
    private String name;
    private double grade;

    // Constructor
    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    // toString() method to display student info
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}

// Main class
public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Add new student
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Grade: ");
        double grade = scanner.nextDouble();

        students.add(new Student(id, name, grade));
        System.out.println("Student added successfully!");
    }

    // Remove student by ID
    public static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();

        boolean removed = students.removeIf(student -> student.getId() == id);
        if (removed) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Display all students
    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display!");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Menu-driven program
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: removeStudent(); break;
                case 3: displayStudents(); break;
                case 4: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

