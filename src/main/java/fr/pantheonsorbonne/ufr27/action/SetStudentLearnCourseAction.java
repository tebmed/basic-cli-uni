package fr.pantheonsorbonne.ufr27.action;

import java.util.Collection;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.entity.Student;
import fr.pantheonsorbonne.ufr27.exception.EducationException;

public class SetStudentLearnCourseAction implements EducationAction {

	private String name;
	private String courseName;
	@Inject
	private Collection<Course> courses;
	@Inject
	private Collection<Student> students;

	@Inject
	public SetStudentLearnCourseAction(@Assisted("studentName") String studentName,
			@Assisted("courseName") String courseName) {
		this.name = studentName;
		this.courseName = courseName;

	}

	public void perform() throws EducationException {

		Optional<Course> course = courses.stream().filter((Course c) -> c.getName().startsWith(this.courseName))
				.findFirst();
		Optional<Student> student = this.students.stream().filter((Student s) -> s.getName().equals(this.name))
				.findFirst();

		if (course.isPresent() && student.isPresent() && !student.get().isEnrolled(course.get())) {
			student.get().enroll(course.get());
			return;
		}

		throw new EducationException("failed to find course, student or student already enrolled");

	}
}
