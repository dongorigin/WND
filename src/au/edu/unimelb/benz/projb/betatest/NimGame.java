package au.edu.unimelb.benz.projb.betatest;

/**
 * This it the class of Nim game.
 * <p>
 * Most methods are the same to the project A, except this class takes
 * two players' data, and after the game it decides which player wins.
 * <p>
 * Only the differences between the new methods and the ones from project A 
 * will be annotated.
 * 
 * @author Tonny
 * @version v1.0, 1/5/2014
 */
public class NimGame {
	
	private int initialStones;
	private int upperBound;
	private String[] playerOneData;
	private String[] playerTwoData;
	private String playerOneName;
	private String playerTwoName;
	private String result;
	private int leftStones;
	
	public NimGame() {
		initialStones = 0;
		upperBound = 0;
		leftStones = 0;
		playerOneData = null;
		playerTwoData = null;
		playerOneName = null;
		playerTwoName = null;
		result = "first player wins";
	}
	
	/**
	 * This constructor is different from project A, where it takes
	 * two players' data and the upper bound of the number of removing
	 * stones.
	 * 
	 * @param initial the initial number of stones.
	 * @param upper the upper bound of removing stones.
	 * @param playerOne the first player's data.
	 * @param playerTwo the second player's data.
	 */
	public NimGame(int initial, int upper, String[] playerOne, String[] playerTwo) {
		this();
		initialStones = initial;
		upperBound = upper;
		leftStones = initial;
		playerOneData = playerOne;
		playerTwoData = playerTwo;
		playerOneName = playerOne[2];
		playerTwoName = playerTwo[2];
	}
	
	/**
	 * This method is slightly different from the project A, where
	 * it will print the two players' data.
	 * 
	 * @return		<code>"first player wins"</code> if the first player wins;
	 *				<code>"second player wins"</code> otherwise.			
	 */
	public String gameLauncher() {
		System.out.println();
		System.out.println("Initial stone count: " + initialStones);
		System.out.println("Maximum stone removal: " + upperBound);
		System.out.println("Player 1: " + playerOneData[2] + " " + playerOneData[1]);
		System.out.println("Player 2: " + playerTwoData[2] + " " + playerTwoData[1]);
		
		String winner = nimGame();
		if (winner.equals(playerOneName)) {
			return result;
		} else if (winner.equals(playerTwoName)) {
			result = "second player wins";
		}
		String result = this.result;
		return result;
	}
	
	/**
	 * This method is slightly different from the project A
	 * where it let one player to remove the number of stones 
	 * within a certain boundary.
	 * 
	 * @param playerName the player's names.
	 * @return			 <code>true</code> if it is a valid move;
	 * 					 <code>false</code> otherwise.
	 */
	public boolean remove(String playerName) {
		int remove = 0;
		int maxRemove = 0;
		System.out.println(playerName + "'s turn - remove how many?");
		remove = IOInterface.userInput.nextInt();
		maxRemove = Math.min(upperBound, leftStones);
		// boundary check.
		if ((remove >= 1) && (remove <= maxRemove)) {
			leftStones -= remove;
			return true;
		} else {
			System.out.println();
			System.out.println("Invalid move. You must remove between 1 and " + maxRemove + " stones.");
			return false;
		}
	}
	
	public void displayStars() {
		for (int i = leftStones; i > 0; i--) {
			System.out.print(" *");
		}
		
		System.out.println();
	}
	
	/**
	 * This method is slightly different from project A, where it
	 * also decides the winner.
	 * 
	 * @return		the winner's names.
	 */
	public String nimGame() {
		String turn = playerOneName;
		String winner = playerOneName;
		// game starts
		while (leftStones > 0) {
			System.out.println();
			System.out.print(leftStones + " stones left:");
			displayStars();
			if (turn.equals(playerOneName)) {
				if (remove(playerOneName)) {
					turn = playerTwoName;
				}
			} else {
				if (remove(playerTwoName)) {
					turn = playerOneName;
				}
			}
		}
		
		System.out.println();
		System.out.println("Game Over");
		@SuppressWarnings("unused")
		String junk = IOInterface.userInput.nextLine();
		// decide the winner
		if (turn.equals(playerOneName)) {
			System.out.println(playerOneData[2] + " " + playerOneData[1] + " wins!");
			return winner;
		} else {
			System.out.println(playerTwoData[2] + " " + playerTwoData[1] + " wins!");
			winner = playerTwoName;
			return winner;
		}
	}














}
