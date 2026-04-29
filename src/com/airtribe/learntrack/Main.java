package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static StudentService studentService = new StudentService();
    static CourseService courseService = new CourseService();
    static EnrollmentService enrollmentService = new EnrollmentService();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n=== LearnTrack Menu ===");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice == 1) {
                    studentMenu();
                } else if (choice == 2) {
                    courseMenu();
                } else if (choice == 3) {
                    enrollmentMenu();
                } else if (choice == 0) {
                    System.out.println("Exiting LearnTrack. Goodbye!");
                    running = false;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // ==================== STUDENT MENU ====================

    static void studentMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n-- Student Management --");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice == 1) {
                    addStudent();
                } else if (choice == 2) {
                    viewAllStudents();
                } else if (choice == 3) {
                    searchStudentById();
                } else if (choice == 4) {
                    deactivateStudent();
                } else if (choice == 0) {
                    back = true;
                } else {
                    System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Enter email (press Enter to skip): ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter batch: ");
        String batch = scanner.nextLine().trim();

        if (email.isEmpty()) {
            studentService.addStudent(firstName, lastName, null, batch);
        } else {
            studentService.addStudent(firstName, lastName, email, batch);
        }

        System.out.println("Student added successfully!");
    }

    static void viewAllStudents() {
        ArrayList<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nAll Students:");
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + " | Name: " + s.getDisplayName()
                    + " | Batch: " + s.getBatch() + " | Active: " + s.isActive());
        }
    }

    static void searchStudentById() {
        System.out.print("Enter student ID: ");

        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Student s = studentService.getStudentById(id);

            if (s == null) {
                throw new EntityNotFoundException("Student with ID " + id + " not found.");
            }

            System.out.println("Student Found:");
            System.out.println("ID: " + s.getId());
            System.out.println("Name: " + s.getDisplayName());
            System.out.println("Email: " + s.getEmail());
            System.out.println("Batch: " + s.getBatch());
            System.out.println("Active: " + s.isActive());

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered.");
        }
    }

    static void deactivateStudent() {
        System.out.print("Enter student ID to deactivate: ");

        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Student s = studentService.getStudentById(id);

            if (s == null) {
                throw new EntityNotFoundException("Student with ID " + id + " not found.");
            }

            studentService.deactivateStudent(id);
            System.out.println("Student with ID " + id + " has been deactivated.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered.");
        }
    }

    // ==================== COURSE MENU ====================

    static void courseMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n-- Course Management --");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Activate / Deactivate Course");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice == 1) {
                    addCourse();
                } else if (choice == 2) {
                    viewAllCourses();
                } else if (choice == 3) {
                    toggleCourseStatus();
                } else if (choice == 0) {
                    back = true;
                } else {
                    System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void addCourse() {
        System.out.print("Enter course name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter description: ");
        String description = scanner.nextLine().trim();

        System.out.print("Enter duration in weeks: ");

        try {
            int duration = Integer.parseInt(scanner.nextLine().trim());
            courseService.addCourse(name, description, duration);
            System.out.println("Course added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid duration. Please enter a number.");
        }
    }

    static void viewAllCourses() {
        ArrayList<Course> courses = courseService.getAllCourses();

        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }

        System.out.println("\nAll Courses:");
        for (Course c : courses) {
            System.out.println("ID: " + c.getId() + " | Name: " + c.getCourseName()
                    + " | Duration: " + c.getDurationInWeeks() + " weeks | Active: " + c.isActive());
        }
    }

    static void toggleCourseStatus() {
        System.out.print("Enter course ID: ");

        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Course c = courseService.getCourseById(id);

            if (c == null) {
                throw new EntityNotFoundException("Course with ID " + id + " not found.");
            }

            boolean newStatus = !c.isActive();
            courseService.setActive(id, newStatus);

            if (newStatus) {
                System.out.println("Course is now ACTIVE.");
            } else {
                System.out.println("Course is now INACTIVE.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered.");
        }
    }

    // ==================== ENROLLMENT MENU ====================

    static void enrollmentMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n-- Enrollment Management --");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View Enrollments for a Student");
            System.out.println("3. Update Enrollment Status");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice == 1) {
                    enrollStudent();
                } else if (choice == 2) {
                    viewStudentEnrollments();
                } else if (choice == 3) {
                    updateEnrollmentStatus();
                } else if (choice == 0) {
                    back = true;
                } else {
                    System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    static void enrollStudent() {
        System.out.print("Enter student ID: ");

        try {
            int studentId = Integer.parseInt(scanner.nextLine().trim());
            Student s = studentService.getStudentById(studentId);
            if (s == null) {
                throw new EntityNotFoundException("Student with ID " + studentId + " not found.");
            }

            System.out.print("Enter course ID: ");
            int courseId = Integer.parseInt(scanner.nextLine().trim());
            Course c = courseService.getCourseById(courseId);
            if (c == null) {
                throw new EntityNotFoundException("Course with ID " + courseId + " not found.");
            }

            System.out.print("Enter enrollment date (YYYY-MM-DD): ");
            String date = scanner.nextLine().trim();

            enrollmentService.enrollStudent(studentId, courseId, date);
            System.out.println("Student enrolled successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered.");
        }
    }

    static void viewStudentEnrollments() {
        System.out.print("Enter student ID: ");

        try {
            int studentId = Integer.parseInt(scanner.nextLine().trim());
            ArrayList<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);

            if (enrollments.isEmpty()) {
                System.out.println("No enrollments found for student ID " + studentId + ".");
                return;
            }

            System.out.println("\nEnrollments for Student ID " + studentId + ":");
            for (Enrollment e : enrollments) {
                System.out.println("Enrollment ID: " + e.getId()
                        + " | Course ID: " + e.getCourseId()
                        + " | Date: " + e.getEnrollmentDate()
                        + " | Status: " + e.getStatus());
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered.");
        }
    }

    static void updateEnrollmentStatus() {
        System.out.print("Enter enrollment ID: ");

        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            Enrollment e = enrollmentService.getEnrollmentById(id);

            if (e == null) {
                throw new EntityNotFoundException("Enrollment with ID " + id + " not found.");
            }

            System.out.println("Select new status:");
            System.out.println("1. ACTIVE");
            System.out.println("2. COMPLETED");
            System.out.println("3. CANCELLED");
            System.out.print("Enter your choice: ");

            int statusChoice = Integer.parseInt(scanner.nextLine().trim());
            String newStatus = "";

            if (statusChoice == 1) {
                newStatus = "ACTIVE";
            } else if (statusChoice == 2) {
                newStatus = "COMPLETED";
            } else if (statusChoice == 3) {
                newStatus = "CANCELLED";
            } else {
                System.out.println("Invalid choice.");
                return;
            }

            enrollmentService.updateStatus(id, newStatus);
            System.out.println("Enrollment status updated to " + newStatus + ".");

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID entered.");
        }
    }
}
