package fr.pantheonsorbonne.ufr27.console;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.google.inject.Injector;

import fr.pantheonsorbonne.ufr27.action.EducationAction;
import fr.pantheonsorbonne.ufr27.action.EducationActionFactory;
import fr.pantheonsorbonne.ufr27.exception.EducationException;
import fr.pantheonsorbonne.ufr27.exception.InvalidCommandException;

public class ConsoleEventParser {

	@Inject
	private EducationActionFactory factory;

	public EducationAction parse(String command) throws EducationException {

		Matcher matcher = null;
		{
			Pattern pattern = Pattern.compile("^add teacher (.*)$");
			if ((matcher = pattern.matcher(command)).matches()) {
				return factory.createTeacherAction(matcher.group(1));
			}
		}

		{
			Pattern pattern = Pattern.compile("^add student (.*)$");

			if ((matcher = pattern.matcher(command)).matches()) {
				return factory.createStudentAction(matcher.group(1));
			}
		}

		{
			Pattern pattern = Pattern.compile("^add course (.*)$");

			if ((matcher = pattern.matcher(command)).matches()) {
				return factory.createCourseAction(matcher.group(1));
			}
		}

		{
			Pattern pattern = Pattern.compile("^([^ ]*) teaches ([^ ]*)$");

			if ((matcher = pattern.matcher(command)).matches()) {
				return factory.registerCourseForTeacherAction(matcher.group(1), matcher.group(2));
			}
		}

		throw new InvalidCommandException(command);

	}

}
