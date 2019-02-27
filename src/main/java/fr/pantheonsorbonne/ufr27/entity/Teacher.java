package fr.pantheonsorbonne.ufr27.entity;

import java.util.Collection;
import java.util.HashSet;

public class Teacher extends EducationEntity {

	public Teacher(String name) {
		super(name);
	}

	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

	private Collection<Course> courses = new HashSet<Course>();

	public void addCourse(Course c) {
		courses.add(c);
	}

}
