package au.edu.unimelb.benz.projb.v1_0;

/**
 * This is a class that defines the data of a player.
 * An object of class PlayerData contains all the variables
 * like names and game numbers.
 * Additionally, I create a variable rate to store the player's rate.
 * 
 * @author Tonny
 * @version 1.0, 1/5/2014
 */
public class PlayerData implements Comparable<PlayerData>{
	
	private String username;
	private String familyName;
	private String givenName;
	private int playedNum;
	private int wonNum;
	private int rate;
	
	/**
	 * The sole constructor.
	 */
	public PlayerData() {
		username = "nimUser";
		familyName = "Smith";
		givenName = "John";
		playedNum = 0;
		wonNum = 0;
		rate = 0;
	}
	
	/**
	 * This constructor allows other classes to create new objects
	 * with initial names.
	 * 
	 * @param userN a username.
	 * @param familyN a family name.
	 * @param givenN a given name.
	 */
	public PlayerData(String userN, String familyN, String givenN) {
		this();
		username = userN;
		familyName = familyN;
		givenName = givenN;
	}
	

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(PlayerData r) {
		Integer rate = this.rate;
		// sort by rate first
		int firstResult = rate.compareTo(r.getRate());
		int finalResult = 0;
		// sort by username if there is a tie on rate
		if (firstResult == 0) {
			finalResult = username.compareTo(r.getUsername());
		} else {
			finalResult = -firstResult;
		}
		return finalResult;
	}
	
	/**
	 * This method is the setter of the three names.
	 * 
	 * @param userN a username.
	 * @param familyN a family name.
	 * @param givenN a given name.
	 */
	public void setNames(String userN, String familyN, String givenN) {
		username = userN;
		familyName = familyN;
		givenName = givenN;
	}
	
	/**
	 * This method is an accumulator of the two numbers and change the rate
	 * by invoking {@link PlayerData#doRate()}.
	 * 
	 * @param playedN a number of played games.
	 * @param wonN a number of won games
	 */
	public void editNumbers(int playedN, int wonN) {
		playedNum += playedN;
		wonNum += wonN;
		doRate();
	}
	
	/**
	 * This method reset the two numbers to 0 and change the rate
	 * by invoking {@link PlayerData#doRate()}.
	 */
	public void resetNumbers() {
		playedNum = 0;
		wonNum = 0;
		doRate();
	}

	/**
	 * This method is the getter of all the player's data
	 * besides the variable rate.
	 * 
	 * @return 		a string array stores the player's data:
	 * <li> <code>player[0]</code>, the username;
	 * <li> <code>player[1]</code>, the familyName;
	 * <li> <code>player[2]</code>, the givenName;
	 * <li> <code>player[3]</code>, the number of played games;
	 * <li> <code>player[4]</code>, the number of won games.
	 */
	public String[] getData() {
		String[] player = new String[5];
		player[0] = username;
		player[1] = familyName;
		player[2] = givenName;
		player[3] = Integer.toString(playedNum);
		player[4] = Integer.toString(wonNum);
		return player;
	}
	
	/**
	 * This method is the getter of the username.
	 * 
	 * @return 		the username.
	 */
	public String getUsername() {
		String userN = username;
		return userN;
	}
	
	/**
	 * This method is the getter of the rate.
	 * 
	 * @return 		the rate.
	 */
	public int getRate() {
		int rate = this.rate;
		return rate;
	}
	
	/**
	 * This method calculates the rate.
	 */
	public void doRate() {
		rate = (int) Math.round((float) wonNum / (float) playedNum * 100.0);
	}
}
