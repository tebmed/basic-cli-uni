package fr.pantheonsorbonne.ufr27.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Student extends EducationEntity {

	private Collection<Course> enrolledCourses = new HashSet<>();
	public Student(String studentName) {
		super(studentName);
	}
	

	public void enroll(Course... courses) {
		Arrays.stream(courses).forEach((Course c) -> this.enrolledCourses.add(c));

	}
	
	public boolean isEnrolled(Course course) {
		return this.enrolledCourses.contains(course);
	}

}
