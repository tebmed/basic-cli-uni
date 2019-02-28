package fr.pantheonsorbonne.ufr27.exception;

public class NoSuchEducationEntityException extends EducationException {

	public NoSuchEducationEntityException(String category) {
		super("I don't know how to show this entities: " + category);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3584597764403425454L;

}
