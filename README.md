# LearnTrack

LearnTrack is a console based java project where you can manage students, courses and enrollments. You can add students, enroll them in courses and track their status. Everything runs in the terminal.

---

## How to run

Make sure you have JDK installed. Then from the project root:

```bash
find src -name "*.java" | xargs javac -d out
java -cp out com.airtribe.learntrack.Main
```

Or just open it in VS Code and hit the run button on Main.java.

---

## What you can do

- Add students, view them, search by ID, deactivate them
- Add courses, view them, toggle active/inactive
- Enroll a student into a course, view their enrollments, mark as completed or cancelled

---

## Project structure

```
src/com/airtribe/learntrack/
├── Main.java
├── entity/
│   ├── Person.java
│   ├── Student.java
│   ├── Trainer.java
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
        +addStudent()
        +getAllStudents()
        +getStudentById(int)
        +deactivateStudent(int)
        +updateStudent()
    }

    class CourseService {
        -ArrayList~Course~ courses
        +addCourse()
        +getAllCourses()
        +getCourseById(int)
        +setActive(int, boolean)
    }

    class EnrollmentService {
        -ArrayList~Enrollment~ enrollments
        +enrollStudent()
        +getEnrollmentsByStudentId(int)
        +getEnrollmentById(int)
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

## Docs

- [Setup Instructions](docs/Setup_Instructions.md)
- [JVM Basics](docs/JVM_Basics.md)
- [Design Notes](docs/Design_Notes.md)
