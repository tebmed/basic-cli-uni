package fr.pantheonsorbonne.ufr27.action;

import java.util.Collection;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.entity.Teacher;

public class SetTeacherTeachesCourseAction implements EducationAction {

	
	private String name;
	private String courseName;
	@Inject
	private Collection<Course> courses;
	@Inject
	private Collection<Teacher> teachers;

	@Inject
	public SetTeacherTeachesCourseAction(@Assisted ("teacherName") String teacherName, @Assisted("courseName") String courseName) {
		this.name = teacherName;
		this.courseName = courseName;

	}

	public void perform() {
		courses.stream().filter((Course c) -> c.getName().equals(courseName)).forEach((Course c) -> teachers.stream()
				.filter((Teacher t) -> t.getName().equals(this.name)).forEach((Teacher t) -> t.addCourse(c)));
	}

}
