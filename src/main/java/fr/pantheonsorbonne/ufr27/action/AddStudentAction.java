package fr.pantheonsorbonne.ufr27.action;

import java.util.Collection;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import fr.pantheonsorbonne.ufr27.entity.Student;

public class AddStudentAction implements EducationAction {

	
	@Inject
	private Collection<Student> students;

	private String studentName;
	
	@Inject
	public AddStudentAction(@Assisted("studentName") String studentName) {
		this.studentName = studentName;
	}

	public void perform() {
		students.add(new Student(this.studentName));

	}

}
