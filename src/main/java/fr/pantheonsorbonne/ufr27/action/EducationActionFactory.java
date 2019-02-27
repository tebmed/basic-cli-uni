package fr.pantheonsorbonne.ufr27.action;

import com.google.inject.assistedinject.Assisted;

public interface EducationActionFactory {

	public AddTeacherAction createTeacherAction(@Assisted("teacherName") String teacherName);

	public AddStudentAction createStudentAction(@Assisted("studentName") String studentName);

	public AddCourseAction createCourseAction(@Assisted("courseName") String courseName);
}
