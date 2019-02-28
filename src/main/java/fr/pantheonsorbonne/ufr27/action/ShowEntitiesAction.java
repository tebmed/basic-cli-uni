package fr.pantheonsorbonne.ufr27.action;

import java.util.Collection;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.entity.Student;
import fr.pantheonsorbonne.ufr27.entity.Teacher;
import fr.pantheonsorbonne.ufr27.exception.EducationException;
import fr.pantheonsorbonne.ufr27.exception.NoSuchEducationEntityException;

public class ShowEntitiesAction implements EducationAction {

	private final String category;

	@Inject
	private Collection<Student> students;
	@Inject
	private Collection<Teacher> teachers;
	@Inject
	private Collection<Course> courses;

	@Inject
	public ShowEntitiesAction(@Assisted("category") String category) {
		this.category = category;
	}

	@Override
	public void perform() throws EducationException {
		switch (this.category) {
		case "student":
			students.stream().forEach((Student s) -> System.out.println(s.getName()));
			break;
		case "teacher":
			teachers.stream().forEach((Teacher s) -> System.out.println(s.getName()));
			break;
		case "course":
			courses.stream().forEach((Course s) -> System.out.println(s.getName()));
			break;
		default:
			throw new NoSuchEducationEntityException(this.category);

		}

	}

}
