package fr.pantheonsorbonne.ufr27.action;

import com.google.inject.assistedinject.Assisted;

public interface EducationActionFactory {

	public AddTeacherAction createTeacherAction(@Assisted("teacherName") String teacherName);

	public AddStudentAction createStudentAction(@Assisted("studentName") String studentName);

	public AddCourseAction createCourseAction(@Assisted("courseName") String courseName);

	public SetTeacherTeachesCourseAction registerCourseForTeacherAction(@Assisted("teacherName") String teacherName,
			@Assisted("courseName") String courseName);

	public SetStudentLearnCourseAction registerCourseForStudentAction(@Assisted("studentName") String studentName,
			@Assisted("courseName") String courseName);

	public StartCourseAction startCourse(@Assisted("courseName") String courseName);

	public KnowledgePrinterAction consoleKnowledgePrinterAction(@Assisted("entityName") String entityName,
			@Assisted("courseName") String courseName);

	public StudentPassCourseAction StudentPassCourseAction(@Assisted("studentName") String studentName,
			@Assisted("courseName") String courseName);

	public ShowEntitiesAction consoleEntityPrinterAction(@Assisted("category") String category);
}
