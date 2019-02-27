package fr.pantheonsorbonne.ufr27.configuration;

import java.util.Collection;
import java.util.HashSet;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.multibindings.Multibinder;

import fr.pantheonsorbonne.ufr27.action.AddStudentAction;
import fr.pantheonsorbonne.ufr27.action.EducationAction;
import fr.pantheonsorbonne.ufr27.action.EducationActionFactory;
import fr.pantheonsorbonne.ufr27.entity.Course;
import fr.pantheonsorbonne.ufr27.entity.Student;
import fr.pantheonsorbonne.ufr27.entity.Teacher;

public class AppConfiguration extends AbstractModule {

	@Override
	protected void configure() {
		install(new FactoryModuleBuilder().implement(EducationAction.class, AddStudentAction.class)
				.build(EducationActionFactory.class));

	}

	@Singleton
	@Provides
	public Collection<Teacher> getTeachers() {
		return new HashSet<Teacher>();
	}

	@Singleton
	@Provides
	public Collection<Course> getCourses() {
		return new HashSet<Course>();
	}

	@Singleton
	@Provides
	public Collection<Student> getStudents() {
		return new HashSet<Student>();
	}

}
