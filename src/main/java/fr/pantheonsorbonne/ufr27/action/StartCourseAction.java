package fr.pantheonsorbonne.ufr27.action;

import java.util.Collection;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.entity.Student;
import fr.pantheonsorbonne.ufr27.entity.Teacher;
import fr.pantheonsorbonne.ufr27.exception.EducationException;

public class StartCourseAction implements EducationAction {

	@Inject
	private Collection<Teacher> teacher;

	@Inject
	private Collection<Student> students;

	@Inject
	private Collection<Course> courses;

	@Inject
	private EducationActionFactory factory;

	private String courseName;

	@Inject
	public StartCourseAction(@Assisted("courseName") String courseName) {

		this.courseName = courseName;
	}

	public final static Logger LOG = Logger.getLogger("StartCourseAction");

	private static void unsafeActionPerform(EducationAction ea) {
		try {
			ea.perform();
		} catch (EducationException e) {
			LOG.log(Level.WARNING, "failed to perform action");
		}
	}

	public void perform() throws EducationException {

		Random rand = new Random();

		Optional<Course> course = courses.stream().filter((Course c) -> c.getName().equals(this.courseName))
				.findFirst();

		if (!course.isPresent()) {
			throw new EducationException("unable to find course " + this.courseName);
		}
		course.get().starts();

		students.stream().filter((Student s) -> s.isEnrolled(course.get()))
				.filter((Student s) -> !s.isKnown(course.get().getName()))
				.filter((Student s) -> rand.nextDouble() < 0.8)
				.map((Student s) -> factory.StudentPassCourseAction(s.getName(), course.get().getName()))
				.forEach(StartCourseAction::unsafeActionPerform);

	}

}
