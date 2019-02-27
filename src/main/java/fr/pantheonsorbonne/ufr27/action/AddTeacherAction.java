package fr.pantheonsorbonne.ufr27.action;

import java.util.Collection;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.google.inject.assistedinject.Assisted;

import fr.pantheonsorbonne.ufr27.entity.Teacher;

public class AddTeacherAction implements EducationAction {

	@Inject
	private Collection<Teacher> teachers;
	private String teacherName;

	@Inject
	public AddTeacherAction(@Assisted("teacherName") String teacherName) {

		this.teacherName = teacherName;
	}

	public void perform() {
		teachers.add(new Teacher(this.teacherName));

	}

}
