package au.edu.unimelb.benz.projc.v0_1;

import java.util.*;


/**
 * This class deals with all the operations about inputs (the command lines) and outputs.
 * It contains a static scanner that is used in both this class and the NimGame class,
 * since there should be no more than two scanners.
 * 
 * @author Tonny
 *
 */
public class IOInterface {
	
	public static Scanner userInput;
	private NimPlayerCenter playerCenter;
	private String[] command;
	/**
	 * The parameters in a user's input.
	 */
	private String[] parameters;
	private int index;
	
	static {
		userInput = new Scanner(System.in);
	}
	
	/**
	 * The sole constructor.
	 */
	public IOInterface() {
		playerCenter = new NimPlayerCenter();
		index = 0;
		System.out.println("Welcome to Nim");
		System.out.println();
		playerCenter.readData();
	}
	
	/**
	 * This method split a parameter into certain size.
	 * 
	 * @param size of parameters.
	 * @throws IncorrectNumException When the number of parameter less than it should be.
	 */
	public void splitParameter(int size) 
			throws IncorrectNumException{
		if (command.length < 2) {
			throw new IncorrectNumException();
		}
		String[] temp = command[1].split(",", size + 1);
		if (temp.length < size) {
			throw new IncorrectNumException();
		}
		parameters = new String[size];
		for (int i = 0; i < size; i++) {
			parameters[i] = temp[i];
		}
	}
	
	/**
	 * This method first check if there is a player with the same username
	 * by invoking {@link NimPlayerCenter#checkPosition(String)}; if there isn't,
	 * invokes {@link NimPlayerCenter#addPlayer(String, String, String)} to add a new player.
	 * If there is, prints out an error.
	 */
	public void comAddplayer(boolean type) throws IncorrectNumException{
		splitParameter(3);
		index = playerCenter.checkPosition(parameters[0]);
		if (index == -1) {
			if (type) {
				playerCenter.addPlayer(parameters[0], parameters[2], parameters[1]);
			} else {
				playerCenter.addAIPlayer(parameters[0], parameters[2], parameters[1]);
			}
		} else {
			System.out.println("The player already exists.");
		}
		System.out.println();
	}
	
	/**
	 * This method removes player(s). If the command line is with parameters, 
	 * invokes {@link NimPlayerCenter#checkPosition(String)} to find out the index,
	 * then invokes {@link NimPlayerCenter#removePlayer(int)} to remove the player;
	 * if the command is without parameters, then invokes {@link NimPlayerCenter#removePlayer()}
	 * to remove all players after acknowledging the user.
	 * @throws IncorrectNumException 
	 */
	public void comRemoveplayer() 
			throws IncorrectNumException {
		// if the command has parameters
		if (command.length == 2) {
			splitParameter(2);
			index = playerCenter.checkPosition(parameters[0]);
			// check valid player
			if (index != -1) {
				playerCenter.removePlayer(index);
			} else {
				System.out.println("The player does not exist.");
			}
		} else {
			System.out.println("Are you sure you want to remove all players? (y/n)");
			if (userInput.nextLine().equals("y")) {
				playerCenter.removePlayer();
			}
		}
		System.out.println();
	}
	
	/**
	 * This method display the data of a player.
	 * 
	 * @param player
	 */
	public void showPlayer(NimPlayer player) {
		System.out.println(player.getUserName() + "," + player.getGivenName() + "," + player.getFamilyName() + ","
				+ player.getPlayedNumber() + " games" + "," + player.getWonNumber() + " wins");
	}
	
	/**
	 * This method display player(s). If the command line is without parameters,
	 * then the method display the list of players by invoking {@link NimPlayerCenter#displayAll()};
	 * if the command line is with parameters, the method check for the player with the same username
	 * by invoking {@link NimPlayerCenter#checkPosition(String)}; if there is not, print out an error;
	 * if there is, display it.
	 */
	public void comDisplayplayer() {
		if (command.length == 2) {
			String username = command[1];
			index = playerCenter.checkPosition(username);
			if (index != -1) {
				showPlayer(playerCenter.getPlayer(index));
			}else {
				System.out.println("The player does not exist.");
			}
		} else {
			int[] displayIndex = playerCenter.displayAll();
			// display all players
			for (int i = 0; i < displayIndex.length; i ++) {
				showPlayer(playerCenter.getPlayer(displayIndex[i]));
			}
		}
		System.out.println();
	}
	
	/**
	 * System out.
	 */
	public void comExit() {
		userInput.close();
		playerCenter.saveData();
		System.out.println();
		System.exit(0);
	}
	
	/**
	 * This method edits an existing player's family name and given name.
	 * First invokes {@link NimPlayerCenter#checkPosition(String)} to check the
	 * index, then invokes {@link NimPlayerCenter#editPlayer(int, String, String, String)}
	 * to edit the names if there is an existing player with the same user; If there is not, print
	 * out an error.
	 * @throws IncorrectNumException
	 */
	public void comEditplayer() 
			throws IncorrectNumException {
		splitParameter(3);
		index = playerCenter.checkPosition(parameters[0]);
		if (index != -1) {
			playerCenter.editPlayer(index, parameters[0], parameters[1], parameters[2]);
		} else {
			System.out.println("The player does not exist.");
		}
		System.out.println();
	}
	
	/**
	 * This method rest player(s)' played number and won number.
	 * If the command line is with parameters, the method invokes 
	 * {@link NimPlayerCenter#checkPosition(String)} to check the
	 * index, then invokes {@link NimPlayerCenter#resetStats(int)}
	 * to reset the player's numbers if there is an existing player with the same username;
	 * if all the username is not same to the parameter, print out an error;
	 * if the command line is without parameters, then reset all players' numbers
	 * by invoking {@link NimPlayerCenter#resetStats()} after acknowledging the user.
	 * 
	 * @throws IncorrectNumException
	 */
	public void comResetstats() 
			throws IncorrectNumException {
		if (command.length == 2) {
			splitParameter(1);
			index = playerCenter.checkPosition(parameters[0]);
			if (index != -1) {
				playerCenter.resetStats(index);
			} else {
				System.out.println("The player does not exist.");
			}
		} else {
			System.out.println("Are you sure you want to reset all player statistics? (y/n)");
			if (userInput.nextLine().equals("y")) {
				playerCenter.resetStats();
			}
		}
		System.out.println();
	}
	
	
	/**
	 * This method shows the ranking of the players in the list. By invoking
	 * {@link NimPlayerCenter#rank()} to get the order and displays the list in that
	 * order, in certain format.
	 */
	private void comRankings() {
		int[] rankingIndex = playerCenter.rank();
		NimPlayer player;
		int index = 0;
		String playedNum = "";
		String rate = "";
		// check boundaries
		for (int i = 0; i < Math.min(10, rankingIndex.length); i ++) {
			index = rankingIndex[i];
			player = playerCenter.getPlayer(index);
			rate = Integer.toString(player.getRate()) + "%";
			playedNum = Integer.toString(player.getPlayedNumber());
			// format
			if (player.getPlayedNumber() < 10) {
				playedNum = "0" + playedNum;
			}
			System.out.printf("%-5s| %-3sgames | %s %s%n", rate, playedNum, player.getGivenName(), player.getFamilyName());
		}
		System.out.println();
	}
	
	/**
	 * This method start a Nim game, and alter the players' data by the result of the game.
	 * It check the user's input by invoking {@link NimPlayerCenter#checkPosition(String)}, if it
	 * is valid, then start a game by create a new object of the NimGame class. At last, it changes
	 * the players' data by invoking {@link NimPlayerCenter#playerWin(int)} and {@link NimPlayerCenter#playerLose(int)}.
	 * 
	 * @see NimGame
	 * @throws IncorrectNumException
	 */
	private void comStartgame() 
			throws IncorrectNumException {
		int playerOneIndex = 0;
		int playerTwoIndex = 0;
		splitParameter(4);
		playerOneIndex = playerCenter.checkPosition(parameters[2]);
		playerTwoIndex = playerCenter.checkPosition(parameters[3]);
		// start game
		if ((playerOneIndex != -1) && (playerTwoIndex != -1)) {
			NimPlayer playerOne = playerCenter.getPlayer(playerOneIndex);
			NimPlayer playerTwo = playerCenter.getPlayer(playerTwoIndex);
			String result = null;
			int initialStones = Integer.parseInt(parameters[0]);
			int upperBound = Integer.parseInt(parameters[1]);
			NimGame game = new NimGame(initialStones, upperBound, playerOne, playerTwo);
			result = game.gameLauncher();
			// set players' data
			if (result.equals("first player wins")) {
				playerOne.setNumbers(1, 1);
				playerTwo.setNumbers(1, 0);
			} else if (result.equals("second player wins")) {
				playerOne.setNumbers(1, 0);
				playerTwo.setNumbers(1, 1);
			}
		} else {
			System.out.println("One of the players does not exist.");
		}
		System.out.println();
	}
	
	/**
	 * This method runs a user's input.
	 * The command lines are:
	 * <li><code>addplayer</code>
	 * <li><code>removeplayer</code>
	 * <li><code>editplayer</code>
	 * <li><code>resetstats</code>
	 * <li><code>displayplayer</code>
	 * <li><code>rankings</code>
	 * <li><code>startgame</code>
	 * <li><code>addaiplayer</code>
	 * <li><code>exit</code>
	 */
	public void readCommand() 
			throws InvalidComException, IncorrectNumException{
		if (command[0].equals("addplayer")) {
			comAddplayer(true);
		} else if (command[0].equals("removeplayer")) {
			comRemoveplayer();
		} else if (command[0].equals("editplayer")) {
			comEditplayer();
		} else if (command[0].equals("resetstats")) {
			comResetstats();
		} else if (command[0].equals("displayplayer")) {
			comDisplayplayer();
		} else if (command[0].equals("rankings")) {
			comRankings();
		} else if (command[0].equals("startgame")) {
			comStartgame();
		} else if (command[0].equals("exit")) {
			comExit();
		} else if (command[0].equals("addaiplayer")){
			comAddplayer(false);
		} else {
			throw new InvalidComException();
		}
	}
	
	
	/**
	 * This method takes a user's input.
	 */
	public void commandLine() {
		while (true) {
			System.out.print(">");
			command = userInput.nextLine().split(" ");
			try {
				readCommand();
			} catch (InvalidComException e) {
				System.out.println("'" + command[0] + "' " + e.getMessage());
				System.out.println();
			} catch (IncorrectNumException e){
				System.out.println(e.getMessage());
				System.out.println();
			}
			
		}// end loop
	}// end method
	
	
	
	
	
	
	
}
