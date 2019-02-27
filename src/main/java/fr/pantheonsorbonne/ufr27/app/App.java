package fr.pantheonsorbonne.ufr27.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import com.google.inject.Guice;
import com.google.inject.Injector;

import fr.pantheonsorbonne.ufr27.configuration.AppConfiguration;
import fr.pantheonsorbonne.ufr27.console.ConsoleEventParser;


/**
 * Hello world!
 *
 */
public class App {

	private static final Logger LOG = Logger.getLogger("App");

	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new AppConfiguration());
		Scanner scanner = new Scanner(System.in);
		String line = "";
		ConsoleEventParser parser = injector.getInstance(ConsoleEventParser.class);

		while (!(line = scanner.nextLine()).isEmpty()) {
			
			 parser.parse(line);
			

		}
		scanner.close();

	}
}
