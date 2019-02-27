package fr.pantheonsorbonne.ufr27.exception;

public class InvalidCommandException extends EducationException {

	public InvalidCommandException(String string) {
		super("invalid command " + string);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1325328949912173920L;

}
