import java.util.ArrayList;
import java.util.Scanner;

// Class to represent a Student
class Student {
    private int id; // Unique student ID
    private String name; // Student name
    private int age; // Student age
    private String course; // Student's course of study

    // Constructor to initialize student properties
    public Student(int id, String name, int age, String course) {
        this.id = id; // Set student ID
        this.name = name; // Set student name
        this.age = age; // Set student age
        this.course = course; // Set student course
    }

    // Getter for student ID
    public int getId() {
        return id;
    }

    // Getter for student name
    public String getName() {
        return name;
    }

    // Setter for student name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for student age
    public int getAge() {
        return age;
    }

    // Setter for student age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for student course
    public String getCourse() {
        return course;
    }

    // Setter for student course
    public void setCourse(String course) {
        this.course = course;
    }

    // Method to display student details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course);
    }
}

// Main class for the Student Management System
public class StudentManagementSystem {

    // List to store student objects
    private static ArrayList<Student> studentList = new ArrayList<>();
    // Scanner object to get user input
    private static Scanner sc = new Scanner(System.in);

    // Main method to run the program
    public static void main(String[] args) {
        // Infinite loop for displaying menu options repeatedly
        while (true) {
            // Display the menu
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Get user input for menu choice
            int choice = sc.nextInt();

            // Perform different actions based on user choice
            switch (choice) {
                case 1:
                    addStudent(); // Call method to add a student
                    break;
                case 2:
                    viewStudents(); // Call method to view all students
                    break;
                case 3:
                    updateStudent(); // Call method to update a student
                    break;
                case 4:
                    deleteStudent(); // Call method to delete a student
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0); // Exit the program
                    break;
                default:
                    // Handle invalid choice
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to add a new student
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt(); // Get student ID from user
        sc.nextLine(); // Consume newline character after nextInt()

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine(); // Get student name from user

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt(); // Get student age from user

        sc.nextLine(); // Consume newline character after nextInt()
        System.out.print("Enter Student Course: ");
        String course = sc.nextLine(); // Get student course from user

        // Create a new student object and add it to the list
        Student student = new Student(id, name, age, course);
        studentList.add(student); // Add student to the list
        System.out.println("Student added successfully!");
    }

    // Method to view all students
    public static void viewStudents() {
        // Check if the student list is empty
        if (studentList.isEmpty()) {
            System.out.println("No students to display."); // If no students, show message
        } else {
            // Loop through each student and display their details
            for (Student student : studentList) {
                student.display(); // Display student information
            }
        }
    }

    // Method to update a student's information
    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt(); // Get the ID of the student to update

        // Loop through the student list to find the student with the matching ID
        for (Student student : studentList) {
            if (student.getId() == id) {
                // If found, prompt user for updated information
                System.out.print("Enter new name: ");
                sc.nextLine(); // Consume newline character
                student.setName(sc.nextLine()); // Update name

                System.out.print("Enter new age: ");
                student.setAge(sc.nextInt()); // Update age

                System.out.print("Enter new course: ");
                sc.nextLine(); // Consume newline character
                student.setCourse(sc.nextLine()); // Update course

                System.out.println("Student updated successfully!"); // Confirmation message
                return; // Exit the method once student is updated
            }
        }
        // If student not found, show a message
        System.out.println("Student not found!");
    }

    // Method to delete a student
    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt(); // Get the ID of the student to delete

        // Loop through the student list to find the student with the matching ID
        for (Student student : studentList) {
            if (student.getId() == id) {
                // If found, remove the student from the list
                studentList.remove(student);
                System.out.println("Student deleted successfully!"); // Confirmation message
                return; // Exit the method once student is deleted
            }
        }
        // If student not found, show a message
        System.out.println("Student not found!");
    }
}
