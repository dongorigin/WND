package au.edu.unimelb.benz.projb.v1_0;

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
		return result;
	}
	
	private boolean remove(String playerName) {
		int remove = 0;
		int maxRemove = 0;
		System.out.println(playerName + "'s turn - remove how many?");
		remove = IOInterface.userInput.nextInt();
		maxRemove = Math.min(upperBound, leftStones);
		if ((remove >= 1) && (remove <= maxRemove)) {
			leftStones -= remove;
			return true;
		} else {
			System.out.println();
			System.out.println("Invalid move. You must remove between 1 and " + maxRemove + " stones.");
			return false;
		}
	}
	
	private void displayStars() {
		for (int i = leftStones; i > 0; i--) {
			System.out.print(" *");
		}
		
		System.out.println();
	}
	
	private String nimGame() {
		String turn = playerOneName;
		String winner = playerOneName;
		
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
