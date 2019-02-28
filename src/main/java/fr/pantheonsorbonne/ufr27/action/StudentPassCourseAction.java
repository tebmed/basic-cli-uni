package fr.pantheonsorbonne.ufr27.action;

import java.util.Collection;
import java.util.Optional;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.entity.Student;
import fr.pantheonsorbonne.ufr27.exception.EducationException;

public class StudentPassCourseAction implements EducationAction {

	@Inject
	Collection<Course> courses;

	@Inject
	Collection<Student> students;

	private String studentName;
	private String courseName;

	@Inject
	public StudentPassCourseAction(@Assisted("studentName") String studentName,
			@Assisted("courseName") String courseName) {
		this.courseName = courseName;
		this.studentName = studentName;

	}

	@Override
	public void perform() throws EducationException {
		Optional<Student> student = this.students.stream().filter((Student s) -> s.getName().equals(this.studentName))
				.findFirst();
		Optional<Course> course = this.courses.stream().filter((Course c) -> c.getName().equals(this.courseName))
				.findFirst();

		if (student.isPresent() && course.isPresent() && student.get().isEnrolled(course.get())) {
			student.get().pass(course.get());
			return;
		}

		throw new EducationException("failed to find course or student");

	}

}
