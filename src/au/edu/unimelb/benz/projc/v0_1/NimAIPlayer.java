package au.edu.unimelb.benz.projc.v0_1;

/**
 * 
 * @author Tonny
 *
 */
public class NimAIPlayer extends NimPlayer {

	/**
	 * Data for AI players.
	 */
	private static final long serialVersionUID = 6950090479554162123L;

	public NimAIPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NimAIPlayer(String userName, String givenName, String familyName) {
		super(userName, givenName, familyName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int removeStones(int leftStones, int upperBound) {
		// TODO Auto-generated method stub
		int magicNumber = ((leftStones - 1) % (upperBound + 1));
		if (magicNumber == 0) {
			return (int) Math.round(Math.random() * (upperBound - 1) + 1);
		} else {
			return magicNumber;
		}
	}
	
	
}
