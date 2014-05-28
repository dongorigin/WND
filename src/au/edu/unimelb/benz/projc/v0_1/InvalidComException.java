package au.edu.unimelb.benz.projc.v0_1;

/**
 * The user enters a command which is not a valid Nimsys command.
 * 
 * @author Tonny
 *
 */
public class InvalidComException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4318441925871775698L;
	
	public InvalidComException() {
		super("is not a valid command.");
	}

}
