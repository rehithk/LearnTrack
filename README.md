# LearnTrack

A console-based Student & Course Management System built using Core Java. It allows admins to manage students, courses, and enrollments through a menu-driven interface.

---

## How to Compile and Run

**Requirements:** JDK 21+

```bash
# From the project root, compile all files
find src -name "*.java" | xargs javac -d out

# Run the application
java -cp out com.airtribe.learntrack.Main
```

---

## Features

**Student Management**
- Add a new student (with or without email)
- View all students
- Search student by ID
- Deactivate a student

**Course Management**
- Add a new course
- View all courses
- Activate / Deactivate a course

**Enrollment Management**
- Enroll a student in a course
- View enrollments for a student
- Update enrollment status (ACTIVE / COMPLETED / CANCELLED)

---

## Package Structure

```
src/com/airtribe/learntrack/
├── Main.java                  # Entry point, menu-driven UI
├── entity/
│   ├── Person.java            # Base class
│   ├── Student.java           # Extends Person
│   ├── Trainer.java           # Extends Person
│   ├── Course.java
│   └── Enrollment.java
├── service/
│   ├── StudentService.java
│   ├── CourseService.java
│   └── EnrollmentService.java
├── exception/
│   └── EntityNotFoundException.java
└── util/
    └── IdGenerator.java
```

---

## Class Diagram

```mermaid
classDiagram
    class Person {
        -int id
        -String firstName
        -String lastName
        -String email
        +getId() int
        +getFirstName() String
        +getLastName() String
        +getEmail() String
        +setFirstName(String)
        +setLastName(String)
        +setEmail(String)
        +getDisplayName() String
    }

    class Student {
        -String batch
        -boolean active
        +getBatch() String
        +isActive() boolean
        +setBatch(String)
        +setActive(boolean)
        +getDisplayName() String
    }

    class Trainer {
        -String expertise
        +getExpertise() String
        +setExpertise(String)
        +getDisplayName() String
    }

    class Course {
        -int id
        -String courseName
        -String description
        -int durationInWeeks
        -boolean active
        +getId() int
        +getCourseName() String
        +isActive() boolean
        +setActive(boolean)
    }

    class Enrollment {
        -int id
        -int studentId
        -int courseId
        -String enrollmentDate
        -String status
        +getId() int
        +getStatus() String
        +setStatus(String)
    }

    class StudentService {
        -ArrayList~Student~ students
        +addStudent(String, String, String, String)
        +getAllStudents() ArrayList
        +getStudentById(int) Student
        +deactivateStudent(int)
        +updateStudent(int, String, String, String, String)
    }

    class CourseService {
        -ArrayList~Course~ courses
        +addCourse(String, String, int)
        +getAllCourses() ArrayList
        +getCourseById(int) Course
        +setActive(int, boolean)
    }

    class EnrollmentService {
        -ArrayList~Enrollment~ enrollments
        +enrollStudent(int, int, String)
        +getEnrollmentsByStudentId(int) ArrayList
        +getEnrollmentById(int) Enrollment
        +updateStatus(int, String)
    }

    class IdGenerator {
        -static int studentIdCounter
        -static int courseIdCounter
        -static int enrollmentIdCounter
        +getNextStudentId() int
        +getNextCourseId() int
        +getNextEnrollmentId() int
    }

    class EntityNotFoundException {
        +EntityNotFoundException(String)
    }

    Person <|-- Student
    Person <|-- Trainer
    StudentService --> Student
    CourseService --> Course
    EnrollmentService --> Enrollment
    StudentService --> IdGenerator
    CourseService --> IdGenerator
    EnrollmentService --> IdGenerator
    RuntimeException <|-- EntityNotFoundException
```

---

## Documentation

- [Setup Instructions](docs/Setup_Instructions.md)
- [JVM Basics](docs/JVM_Basics.md)
- [Design Notes](docs/Design_Notes.md)
