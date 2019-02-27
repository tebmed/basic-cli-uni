package fr.pantheonsorbonne.ufr27.action;

import com.google.inject.assistedinject.Assisted;

public interface EducationActionFactory {

	public AddTeacherAction createTeacherAction(@Assisted("teacherName") String teacherName);



}