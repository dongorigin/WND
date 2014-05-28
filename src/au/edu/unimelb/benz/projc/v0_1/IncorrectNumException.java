package au.edu.unimelb.benz.projc.v0_1;

/**
 * The user enters a valid Nimsys command, but does not provide
 * the correct number of arguments.
 *
 * @author Tonny
 *
 */
public class IncorrectNumException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4318441925871775698L;
	
	public IncorrectNumException() {
		super("Incorrect number of arguments supplied to command.");
	}

}
