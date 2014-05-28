package au.edu.unimelb.benz.projc.v0_1;

/**
 * 
 * @author Tonny
 *
 */
public class NimHumanPlayer extends NimPlayer {

	/**
	 * Data for human players.
	 */
	private static final long serialVersionUID = 7966697496920669606L;
	
	public NimHumanPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NimHumanPlayer(String userName, String givenName, String familyName) {
		super(userName, givenName, familyName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int removeStones(int leftStones, int upperBound) {
		// TODO Auto-generated method stub
		return Integer.parseInt(IOInterface.userInput.nextLine());
	}

}
