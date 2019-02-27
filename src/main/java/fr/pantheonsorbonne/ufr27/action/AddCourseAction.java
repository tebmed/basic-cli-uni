package fr.pantheonsorbonne.ufr27.action;

import java.util.Collection;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import fr.pantheonsorbonne.ufr27.entity.Course;

public class AddCourseAction implements EducationAction {

	@Inject
	private Collection<Course> courses;

	private String courseName;

	@Inject
	public AddCourseAction(@Assisted("courseName") String studentName) {
		this.courseName = studentName;
	}

	public void perform() {
		courses.add(new Course(this.courseName));

	}

}
