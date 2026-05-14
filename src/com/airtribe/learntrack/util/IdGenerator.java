package com.airtribe.learntrack.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

    private static final AtomicInteger studentIdCounter = new AtomicInteger(0);
    private static final AtomicInteger courseIdCounter = new AtomicInteger(0);
    private static final AtomicInteger enrollmentIdCounter = new AtomicInteger(0);

    public static int getNextStudentId() {
        return studentIdCounter.incrementAndGet();
    }

    public static int getNextCourseId() {
        return courseIdCounter.incrementAndGet();
    }

    public static int getNextEnrollmentId() {
        return enrollmentIdCounter.incrementAndGet();
    }
}
