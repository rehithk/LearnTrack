package com.airtribe.learntrack.service;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class StudentService {
  
  private ArrayList<Student> students;

  public StudentService() {
    this.students = new ArrayList<>();
  }

  public void addStudent(String firstName, String lastName, String email, String batch) {
    int id = IdGenerator.getNextStudentId();
    Student student = new Student(id, firstName, lastName, email, batch);
    students.add(student);
  }

  public ArrayList<Student> getAllStudents() {
    return students;
  }

  public Student getStudentById(int id) {
    for (Student student : students) {
      if (student.getId() == id) {
        return student;
      }
    }
    return null;
  }

  public void deactivateStudent(int id) {
    Student student = getStudentById(id);
    if (student != null) {
      student.setActive(false);
    }
  }

  public void updateStudent(int id, String firstName, String lastName, String email, String batch) {
    Student student = getStudentById(id);
    if (student != null) {
      student.setFirstName(firstName);
      student.setLastName(lastName);
      student.setEmail(email);
      student.setBatch(batch);
    }
  }
}
