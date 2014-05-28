package au.edu.unimelb.benz.projc.v0_1;

/**
 * This type of exceptions are thrown when a player enter an invalid number of move.
 * 
 * @author Tonny
 *
 */
public class InvalidMoveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7699788635609861485L;

	public InvalidMoveException(int maxRemove) {
		super("Invalid move. You must remove between 1 and " + maxRemove + " stones.");
	}
}
