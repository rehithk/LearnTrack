package com.airtribe.learntrack.service;

import java.util.ArrayList;
import java.util.List;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.util.IdGenerator;

public class CourseService {

  private List<Course> courses;

  public CourseService() {
    this.courses = new ArrayList<>();
  }

  public void addCourse(String courseName, String description, int durationInWeeks) {
    int id = IdGenerator.getNextCourseId();
    Course course = new Course(id, courseName, description, durationInWeeks);
    courses.add(course);
  }

  public List<Course> getAllCourses() {
    return new ArrayList<>(courses);
  }

  public Course getCourseById(int id) {
    for (Course course : courses) {
      if (course.getId() == id) {
        return course;
      }
    }
    return null;
  }

  public void setActive(int id, boolean active) {
    Course course = getCourseById(id);
    if (course != null) {
      course.setActive(active);
    }
  }
}
