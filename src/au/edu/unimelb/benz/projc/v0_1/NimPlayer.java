package au.edu.unimelb.benz.projc.v0_1;

import java.io.Serializable;

/**
 * This class defines a player. It contains all the player data.
 * 
 * @author Tonny
 * @version v0.1, 13/5/2014
 * @see NimGame
 */
public abstract class NimPlayer implements Comparable<NimPlayer>, Serializable{
	/**
	 * Player data.
	 */
	private static final long serialVersionUID = 7226510870847763238L;
	private String userName;
	private String givenName;
	private String familyName;
	private int playedNumber;
	private int wonNumber;
	private int rate;
	
	/**
	 * The sole constructor.
	 */
	public NimPlayer() {
		super();
		userName = "nimplayer";
		givenName = "John";
		familyName = "Smith";
		playedNumber = 0;
		wonNumber = 0;
		rate = 0;
	}
	
	/**
	 * The constructor with initial player data.
	 * 
	 * @param userName
	 * @param givenName
	 * @param familyName
	 */
	public NimPlayer(String userName, String givenName, String familyName) {
		this();
		this.userName = userName;
		this.givenName = givenName;
		this.familyName = familyName;
	}

	/**
	 * The getter of the user name.
	 * 
	 * @return The user name in String.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * The setter of the user name.
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * The getter of the given name.
	 * 
	 * @return The given name in String.
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * The setter of the given name.
	 * 
	 * @param givenName
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 * The getter of the family name.
	 * 
	 * @return The family name in String.
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * The setter of the family name.
	 * 
	 * @param familyName
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	/**
	 * The getter of the played number.
	 * 
	 * @return The played number in int.
	 */
	public int getPlayedNumber() {
		return playedNumber;
	}

	/**
	 * The getter of the won number.
	 * 
	 * @return The won number in int.
	 */
	public int getWonNumber() {
		return wonNumber;
	}

	/**
	 * The setter of the two numbers. Each time the numbers are
	 * altered, the method also changes the rate.
	 * 
	 * @param playedNumber
	 * @param wonNumber
	 * @see NimPlayer#doRate()
	 */
	public void setNumbers(int playedNumber, int wonNumber) {
		this.playedNumber += playedNumber;
		this.wonNumber += wonNumber;
		doRate();
	}

	/**
	 * The getter of the rate.
	 * 
	 * @return The rate in int.
	 */
	public int getRate() {
		return rate;
	}
	
	/**
	 * This method calculates the rate.
	 */
	public void doRate() {
		rate = (int) Math.round((float) wonNumber / (float) playedNumber * 100.0);
	}
	
	/* (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(NimPlayer r) {
		int result = 0;
		result = userName.compareTo(r.getUserName());
		return result;
	}

	/**
	 * This method removes stones in the {@link NimGame}.
	 * For AI Players, they always try to win.
	 */
	abstract public int removeStones(int leftStones, int upperBound);
}
