package au.edu.unimelb.benz.projc.v0_1;

public class NimGame {

	private int initialStones;
	private int upperBound;
	private NimPlayer playerOne;
	private NimPlayer playerTwo;
	private String playerOneName;
	private String playerTwoName;
	private String result;
	private int leftStones;
	private int maxRemove;
	
	public NimGame() {
		initialStones = 0;
		upperBound = 0;
		leftStones = 0;
		playerOne = new NimHumanPlayer();
		playerTwo = new NimAIPlayer();
		playerOneName = playerOne.getGivenName();
		playerTwoName = playerTwo.getGivenName();
		result = "first player wins";
	}

	public NimGame(int initialStones, int upperBound, NimPlayer playerOne,
			NimPlayer playerTwo) {
		this();
		this.initialStones = initialStones;
		leftStones = initialStones;
		this.upperBound = upperBound;
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		playerOneName = playerOne.getGivenName();
		playerTwoName = playerTwo.getGivenName();
	}
	
	/**
	 * This method launches the game and return the result.
	 * @return	The result of the game.
	 */
	public String gameLauncher() {
		System.out.println();
		System.out.println("Initial stone count: " + initialStones);
		System.out.println("Maximum stone removal: " + upperBound);
		System.out.println("Player 1: " + playerOne.getGivenName() + " " + playerOne.getFamilyName());
		System.out.println("Player 2: " + playerTwo.getGivenName() + " " + playerTwo.getFamilyName());
		
		String winner = nimGame();
		if (winner.equals(playerOneName)) {
			return result;
		} else if (winner.equals(playerTwoName)) {
			result = "second player wins";
		}
		return result;
	}
	
	/**
	 * This method displays starts.
	 */
	public void displayStars() {
		for (int i = leftStones; i > 0; i--) {
			System.out.print(" *");
		}
		
		System.out.println();
	}
	
	/**
	 * This method a player remove stones.
	 * 
	 * @param player of the turn.
	 * @return The player of next turn.
	 * @throws InvalidMoveException
	 */
	public NimPlayer remove(NimPlayer player) 
			throws InvalidMoveException {
		int remove = 0;
		
		System.out.println(player.getGivenName() + "'s turn - remove how many?");
		maxRemove = Math.min(upperBound, leftStones);
		remove = player.removeStones(leftStones, maxRemove);
		if ((remove >= 1) && (remove <= maxRemove)) {
			leftStones -= remove;
			if (player.equals(playerOne)) {
				return playerTwo;
			} else {
				return playerOne;
			}
		} else {
			throw new InvalidMoveException(maxRemove);
		}
	}
	
	/**
	 * This method is the game.
	 * 
	 * @return The game result.
	 */
	public String nimGame() {
		NimPlayer turn = playerOne;
		String winner = playerOneName;
		
		while (leftStones > 0) {
			System.out.println();
			System.out.print(leftStones + " stones left:");
			displayStars();
			try {
				turn = remove(turn);
			} catch (InvalidMoveException e){
				System.out.println();
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.println("Invalid move. You must remove between 1 and " + maxRemove + " stones.");
			}
		}
		
		System.out.println();
		System.out.println("Game Over");
		if (turn.equals(playerOne)) {
			System.out.println(playerOne.getGivenName() + " " + playerOne.getFamilyName() + " wins!");
			return winner;
		} else {
			System.out.println(playerTwo.getGivenName() + " " + playerTwo.getFamilyName() + " wins!");
			winner = playerTwoName;
			return winner;
		}
	}


}
