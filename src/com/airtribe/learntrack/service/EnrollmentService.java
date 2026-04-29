package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import java.util.ArrayList;
import com.airtribe.learntrack.util.IdGenerator;

public class EnrollmentService {
  private ArrayList<Enrollment> enrollments;

  public EnrollmentService() {
    this.enrollments = new ArrayList<>();
  }

  public void enrollStudent(int studentId, int courseId, String enrollmentDate) {
    int id = IdGenerator.getNextEnrollmentId();
    Enrollment enrollment = new Enrollment(id, studentId, courseId, enrollmentDate);
    enrollments.add(enrollment);
  }

  public ArrayList<Enrollment> getEnrollmentsByStudentId(int studentId) {
    ArrayList<Enrollment> studentEnrollments = new ArrayList<>();
    for (Enrollment enrollment : enrollments) {
      if (enrollment.getStudentId() == studentId) {
        studentEnrollments.add(enrollment);
      }
    }
    return studentEnrollments;
  }

  public Enrollment getEnrollmentById(int id) {
    for (Enrollment enrollment : enrollments) {
      if (enrollment.getId() == id) {
        return enrollment;
      }
    }
    return null;
  }

  public void updateStatus(int enrollmentId, String status) {
    Enrollment enrollment = getEnrollmentById(enrollmentId);
    if (enrollment != null) {
      enrollment.setStatus(status);
    }
  }

  

}
