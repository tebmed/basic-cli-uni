package fr.pantheonsorbonne.ufr27.action;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.entity.Student;
import fr.pantheonsorbonne.ufr27.entity.Teacher;
import fr.pantheonsorbonne.ufr27.exception.EducationException;

public class KnowledgePrinterAction implements EducationAction {

	@Inject
	private Collection<Course> courses;

	@Inject
	private Collection<Teacher> teachers;

	@Inject
	private Collection<Student> students;

	private String entityName;

	private String courseName;

	@Inject
	public KnowledgePrinterAction(@Assisted("entityName") String entityName,
			@Assisted("courseName") String courseName) {
		this.entityName = entityName;
		this.courseName = courseName;
	}

	public void perform() throws EducationException {

		Optional<Course> course = this.courses.stream().filter((Course c) -> c.getName().startsWith(this.courseName))
				.findFirst();
		if (!course.isPresent()) {
			System.out.println("No");
			return;
		}

		

		Optional<Teacher> teacher = this.teachers.stream().filter((Teacher s) -> s.getName().equals(this.entityName))
				.findFirst();
		if (teacher.isPresent() && teacher.get().getCourses().contains(course.get())) {
			System.out.println("Yes, teacher " + teacher.get().getName() + " knows about " + this.courseName);
			return;
		}

		System.out.println("no");
	}

}
