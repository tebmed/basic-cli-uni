package fr.pantheonsorbonne.ufr27.action;

import java.util.Collection;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.entity.Teacher;

public class StartCourseAction implements EducationAction {

	

	@Inject
	private Collection<Teacher> teacher;
	private String courseName;

	@Inject
	public StartCourseAction(@Assisted("courseName") String courseName) {

		this.courseName = courseName;
	}

	public void perform() {
		teacher.stream().forEach((Teacher t) -> t.getCourses().stream()
				.filter((Course c) -> c.getName().equals(this.courseName)).forEach(Course::starts));

	}

}
